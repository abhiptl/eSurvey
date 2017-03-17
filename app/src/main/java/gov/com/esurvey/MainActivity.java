package gov.com.esurvey;

import java.net.URISyntaxException;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();

	}

	public void init() {
		initializeComponents();
		initializeValues();
		addListeners();
	}

	public void initializeComponents() {
		btnStartSurvey = (Button) findViewById(R.id.btnStartSurvey);
		btnSyncSurveyData = (Button) findViewById(R.id.btnSyncSurveyData);

	}

	public void initializeValues() {
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

				if(checkPermission()) {
					Intent pushIntent = new Intent(getApplicationContext(), SyncSurveyDataService.class);
					startService(pushIntent);
				} else {
					askPermission();
				}

				Toast.makeText(getApplicationContext(), "Syncing started...", Toast.LENGTH_LONG).show();
			}
		});


	}

	// Check for permission to access External storage
	private boolean checkPermission() {
		Log.d(TAG, "checkPermission()");
		// Ask for permission if it wasn't granted yet
		return (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
	}

	// Asks for permission
	private void askPermission() {
		Log.d(TAG, "askPermission()");
		ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
	}

	// Verify user's response of the permission requested
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		Log.d(TAG, "onRequestPermissionsResult()");
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode) {
			case 999: {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					// Permission granted
					Intent pushIntent = new Intent(getApplicationContext(), SyncSurveyDataService.class);
					startService(pushIntent);

				} else {

				}
				break;
			}
		}
	}


	/*@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			Uri uri = data.getData();

			try {
				String path = getPath(uri);

				Log.i(TAG, "Path is Main :"+path);
				//beginUpload(path);
				Intent pushIntent = new Intent(getApplicationContext(), SyncSurveyDataService.class);
				pushIntent.putExtra("PATH", path);
				startService(pushIntent);

			} catch (URISyntaxException e) {
				Toast.makeText(this,
						"Unable to get the file from the given URI.  See error log for details",
						Toast.LENGTH_LONG).show();
				Log.e(TAG, "Unable to upload file from the given uri", e);
			}
		}
	}

	*//*
     * Gets the file path of the given Uri.
     *//*
	@SuppressLint("NewApi")
	private String getPath(Uri uri) throws URISyntaxException {
		final boolean needToCheckUri = Build.VERSION.SDK_INT >= 19;
		String selection = null;
		String[] selectionArgs = null;
		// Uri is different in versions after KITKAT (Android 4.4), we need to
		// deal with different Uris.
		if (needToCheckUri && DocumentsContract.isDocumentUri(getApplicationContext(), uri)) {
			if (isExternalStorageDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				return Environment.getExternalStorageDirectory() + "/" + split[1];
			} else if (isDownloadsDocument(uri)) {
				final String id = DocumentsContract.getDocumentId(uri);
				uri = ContentUris.withAppendedId(
						Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
			} else if (isMediaDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];
				if ("image".equals(type)) {
					uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
				} else if ("video".equals(type)) {
					uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
				} else if ("audio".equals(type)) {
					uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
				}
				selection = "_id=?";
				selectionArgs = new String[] {
						split[1]
				};
			}
		}
		if ("content".equalsIgnoreCase(uri.getScheme())) {
			String[] projection = {
					MediaStore.Images.Media.DATA
			};
			Cursor cursor = null;
			try {
				cursor = getContentResolver()
						.query(uri, projection, selection, selectionArgs, null);
				int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				if (cursor.moveToFirst()) {
					return cursor.getString(column_index);
				}
			} catch (Exception e) {
			}
		} else if ("file".equalsIgnoreCase(uri.getScheme())) {
			return uri.getPath();
		}
		return null;
	}

	*//**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is ExternalStorageProvider.
	 *//*
	public static boolean isExternalStorageDocument(Uri uri) {
		return "com.android.externalstorage.documents".equals(uri.getAuthority());
	}

	*//**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is DownloadsProvider.
	 *//*
	public static boolean isDownloadsDocument(Uri uri) {
		return "com.android.providers.downloads.documents".equals(uri.getAuthority());
	}

	*//**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is MediaProvider.
	 *//*
	public static boolean isMediaDocument(Uri uri) {
		return "com.android.providers.media.documents".equals(uri.getAuthority());
	}*/



}
