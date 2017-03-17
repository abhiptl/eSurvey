package gov.com.esurvey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.Manifest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import gov.com.esurvey.database.SurveyDAOManager;
import gov.com.esurvey.domain.SurveyDto;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	public static final String ENTREPRENEUR_DTO = "ENTREPRENEUR_DTO";

	Button btnStartSurvey;
	Button btnSyncSurveyData;

	TextView textTotalPendingSurveys;
	TextView textTotalSurveys;
	private SurveyDAOManager surveyDAOManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
		registerReceiver(broadcastReceiver, new IntentFilter(
				SyncSurveyDataService.SYNC_COMPLETED_BROADCAST_ACTION));

	}

	public void init() {
		initializeComponents();
		initializeValues();
		addListeners();
	}

	public void initializeComponents() {
		btnStartSurvey = (Button) findViewById(R.id.btnStartSurvey);
		btnSyncSurveyData = (Button) findViewById(R.id.btnSyncSurveyData);

		textTotalPendingSurveys = (TextView) findViewById(R.id.textTotalPendingSurveys);
		textTotalSurveys = (TextView) findViewById(R.id.textTotalSurveys);

		surveyDAOManager = new SurveyDAOManager(this);

	}

	public void initializeValues() {
		surveyDAOManager.open();

		long totalPendingSurvey = surveyDAOManager.getTotalPendingSurvey();
		Log.i(TAG , "Pending :"+totalPendingSurvey);
		long totalSurvey = surveyDAOManager.getTotalSurvey();
		Log.i(TAG , "Total :"+totalPendingSurvey);

		textTotalPendingSurveys.setText("Total Pending Surveys : " + String.valueOf(totalPendingSurvey));
		textTotalSurveys.setText("Total Surveys : " + String.valueOf(totalSurvey));

		surveyDAOManager.close();
	}

	public void addListeners() {

		btnStartSurvey.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent startSurveyIntent = new Intent(getApplicationContext(), EntrepreneurActivity.class);
				startSurveyIntent.putExtra(MainActivity.ENTREPRENEUR_DTO, new SurveyDto());
				startActivity(startSurveyIntent);
			}
		});

		btnSyncSurveyData.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (checkReadExternalStoragePermission() && checkWriteExternalStoragePermission()) {
					syncSurveyData();
				} else {
					askReadWriteExternalStoragePermission();
				}
			}
		});

	}

	public void syncSurveyData() {
		ExportSurveyDataCSV exportSurveyDataCSV = new ExportSurveyDataCSV(surveyDAOManager);
		String filePath = exportSurveyDataCSV.exportSurveyDataToCSV();
		List<Long> ids = exportSurveyDataCSV.getSurveyIds();


		if(ids.size() == 0) {
			Toast.makeText(getApplicationContext(), "No data to Sync.", Toast.LENGTH_LONG).show();
			return;
		}

		long[] idArray = new long[ids.size()];
		for (int i = 0; i < ids.size(); i++) {
			idArray[i] = ids.get(i);
		}

		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String deviceId = telephonyManager.getDeviceId();

		String currentTimeStamp = new SimpleDateFormat("ddMMyyyy-HHmmss").format(new Date());
		final String fileName = deviceId + "."+ currentTimeStamp + ".csv";

		Log.i(TAG, "CSV generate File Path :" + filePath);

		Intent syncSurveyDataIntent = new Intent(getApplicationContext(), SyncSurveyDataService.class);
		syncSurveyDataIntent.putExtra("filepath", filePath);
		syncSurveyDataIntent.putExtra("filename", fileName);
		syncSurveyDataIntent.putExtra("ids", idArray);

		startService(syncSurveyDataIntent);

	}

	// Check for permission to read External storage
	private boolean checkReadExternalStoragePermission() {
		Log.d(TAG, "checkReadExternalStoragePermission()");
		return (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
	}

	// Check for permission to write External storage
	private boolean checkWriteExternalStoragePermission() {
		Log.d(TAG, "checkWriteExternalStoragePermission()");
		return (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
	}

	// Check for permission to write External storage
	private boolean checkReadPhoneStatePermission() {
		Log.d(TAG, "checkWriteExternalStoragePermission()");
		return (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED);
	}


	// Asks for permission to read/write to external storage
	private void askReadWriteExternalStoragePermission() {
		Log.d(TAG, "askPermission()");
		ActivityCompat.requestPermissions(this,
				new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE}, 999);
	}

	// Verify user's response of the permission requested
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		Log.d(TAG, "onRequestPermissionsResult()");
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode) {
			case 999: {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
						&& grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED ) {
					syncSurveyData();
				} else {
					//Permission denied
					Toast.makeText(getApplicationContext(), "Allow read/write storage access to sync data", Toast.LENGTH_LONG).show();
				}
				break;
			}
		}
	}


	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			initializeValues();
		}
	};

	@Override
	public void onResume() {
		super.onResume();
		registerReceiver(broadcastReceiver, new IntentFilter(
				SyncSurveyDataService.SYNC_COMPLETED_BROADCAST_ACTION));
	}

}
