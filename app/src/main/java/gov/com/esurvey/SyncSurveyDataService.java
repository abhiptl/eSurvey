package gov.com.esurvey;


import java.io.File;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import gov.com.esurvey.database.SurveyDAOManager;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 */
public class SyncSurveyDataService extends IntentService {

	private static final String TAG = SyncSurveyDataService.class.getSimpleName();

	public SyncSurveyDataService() {
		super("SyncSurveyDataService");
	}

	//File fileToUpload = new File("/storage/emulated/0/DCIM/Profile.jpg");
	File fileToUpload = null;
	//File fileToDownload = new File("/storage/sdcard0/Pictures/MY");

	AmazonS3 s3;
	TransferUtility transferUtility;

	SurveyDAOManager surveyDAOManager;

	private long[] surveyIds;

	private static final String BUCKET_NAME = "e-surveydata";

	private static final String IDENTITY_POOL_ID = "eu-west-1:cd7e1c2b-c7af-4054-828f-c77661e35cd8";

	private String bucketKeyName;


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "SyncSurveyDataService onStartCommand");
		super.onStartCommand(intent, flags, startId);
		return START_STICKY;
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		surveyDAOManager = new SurveyDAOManager(this);

		String filepath = intent.getStringExtra("filepath");
		fileToUpload = new File(filepath);

		bucketKeyName = intent.getStringExtra("filename");

		surveyIds = intent.getLongArrayExtra("ids");

		// callback method to call credentialsProvider method.
		credentialsProvider();

		// callback method to call the setTransferUtility method
		setTransferUtility();

		// Upload file
		setFileToUpload();

	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "SyncSurveyDataService onDestroy");
		super.onDestroy();

	}

	public void credentialsProvider(){

		// Initialize the Amazon Cognito credentials provider
		CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
				getApplicationContext(),
				IDENTITY_POOL_ID, // Identity Pool ID
				Regions.EU_WEST_1 // Region
		);

		setAmazonS3Client(credentialsProvider);
	}

	/**
	 *  Create a AmazonS3Client constructor and pass the credentialsProvider.
	 * @param credentialsProvider
	 */
	public void setAmazonS3Client(CognitoCachingCredentialsProvider credentialsProvider){

		// Create an S3 client
		s3 = new AmazonS3Client(credentialsProvider);

		// Set the region of your S3 bucket
		s3.setRegion(Region.getRegion(Regions.EU_WEST_1));

	}

	public void setTransferUtility(){

		transferUtility = new TransferUtility(s3, getApplicationContext());
	}

	/**
	 * This method is used to upload the file to S3 by using TransferUtility class
	 *
	 */
	public void setFileToUpload(){

		TransferObserver transferObserver = transferUtility.upload(
				BUCKET_NAME,     /* The bucket to upload to */
				bucketKeyName,    /* The key for the uploaded object */
				fileToUpload       /* The file where the data to upload exists */
		);

		transferObserverListener(transferObserver);

	}


	/**
	 *  This method is used to Download the file to S3 by using transferUtility class
	 * @param view
	 **/
	public void setFileToDownload(View view){

		/*TransferObserver transferObserver = transferUtility.download(
				"test.numetric",     *//* The bucket to download from *//*
				"MY",    *//* The key for the object to download *//*
				fileToDownload        *//* The file to download the object to *//*
		);

		transferObserverListener(transferObserver);*/

	}

	/**
	 * This is listener method of the TransferObserver
	 * Within this listener method, we got status of uploading and downloading file,
	 * to diaplay percentage of the part of file to be uploaded or downloaded to S3
	 * It display error, when there is problem to upload and download file to S3.
	 * @param transferObserver
	 */

	public void transferObserverListener(TransferObserver transferObserver){

		transferObserver.setTransferListener(new TransferListener(){

			@Override
			public void onStateChanged(int id, TransferState state) {
				Log.e("statechange", state+"");

				if(state == TransferState.IN_PROGRESS) {
					Toast.makeText(getApplicationContext(), "Syncing is in progress", Toast.LENGTH_LONG).show();
				}
				if(state == TransferState.COMPLETED) {
					surveyDAOManager.open();
					surveyDAOManager.updateSyncStatus(surveyIds, SurveyDAOManager.SYNC_STATUS_SYNCED);
					surveyDAOManager.close();
					Toast.makeText(getApplicationContext(), "Syncing completed successfully", Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
				int percentage = (int) (bytesCurrent/bytesTotal * 100);
				Log.e("percentage",percentage +"");
			}

			@Override
			public void onError(int id, Exception ex) {
				Log.e("error","error");
			}

		});
	}


}
