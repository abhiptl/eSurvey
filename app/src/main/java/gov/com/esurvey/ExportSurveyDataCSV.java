package gov.com.esurvey;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.database.Cursor;
import android.os.Environment;
import android.util.Log;
import au.com.bytecode.opencsv.CSVWriter;
import gov.com.esurvey.database.SurveyDAOManager;

/**
 * Created by Abhishek on 3/17/2017.
 */
public class ExportSurveyDataCSV {

	private final String TAG = ExportSurveyDataCSV.class.getSimpleName();

	private SurveyDAOManager surveyDAOManager;

	private List<Long> surveyIds = null;

	private String fileName;

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ExportSurveyDataCSV(SurveyDAOManager surveyDAOManager) {
		this.surveyDAOManager = surveyDAOManager;
	}

	public String exportSurveyDataToCSV() {
		File exportDir = new File(Environment.getExternalStorageDirectory(), "");
		if (!exportDir.exists())
		{
			exportDir.mkdirs();
		}

		String currentTimeStamp = new SimpleDateFormat("dd-MMM-yyyy:HHmmss").format(new Date());
		final String fileName = currentTimeStamp + ".csv";
		File file = new File(exportDir, fileName);
		setFileName(fileName);

		try
		{
			file.createNewFile();
			CSVWriter csvWrite = new CSVWriter(new FileWriter(file));

			surveyDAOManager.open();
			Cursor curCSV = surveyDAOManager.getPendingRecordsToSync();
			csvWrite.writeNext(curCSV.getColumnNames());

			surveyIds = new ArrayList<>();

			while(curCSV.moveToNext())
			{
				surveyIds.add(curCSV.getLong(0));

				String ID = String.valueOf(curCSV.getLong(0));

				String arrStr[] ={ ID ,curCSV.getString(1), curCSV.getString(2) ,curCSV.getString(3), curCSV.getString(4) ,curCSV
						.getString(5), curCSV.getString(6) ,curCSV.getString(7), curCSV.getString(8) ,curCSV
						.getString(9), curCSV.getString(10) ,curCSV.getString(11), curCSV.getString(12) ,curCSV
						.getString(13), curCSV.getString(14) ,curCSV.getString(15), curCSV.getString(16) ,curCSV
						.getString(17), curCSV.getString(18) ,curCSV.getString(19), curCSV.getString(20) ,curCSV
						.getString(21), curCSV.getString(22) ,curCSV.getString(23), curCSV.getString(24) ,curCSV
						.getString(25), curCSV.getString(26) ,curCSV.getString(27), curCSV.getString(28) ,curCSV
						.getString(29), curCSV.getString(30) ,curCSV.getString(32), curCSV.getString(32) ,curCSV
						.getString(33), curCSV.getString(34) ,curCSV.getString(35), curCSV.getString(36) ,curCSV
						.getString(37), curCSV.getString(38) ,curCSV.getString(39), curCSV.getString(40),curCSV
						.getString(41), curCSV.getString(42) ,curCSV.getString(43), curCSV.getString(44) ,curCSV
					.getString(45), curCSV.getString(46) ,curCSV.getString(47), curCSV.getString(48) ,curCSV
					.getString(49), curCSV.getString(50) ,curCSV.getString(51), curCSV.getString(52) ,curCSV
					.getString(53), curCSV.getString(54) ,curCSV.getString(55), curCSV.getString(56) ,curCSV
					.getString(57), curCSV.getString(58) ,curCSV.getString(59), curCSV.getString(60),
						curCSV.getString(61), curCSV.getString(62) ,curCSV.getString(63), curCSV.getString(64) ,curCSV
						.getString(65), curCSV.getString(66) ,curCSV.getString(67), curCSV.getString(68) ,curCSV
						.getString(69), curCSV.getString(70) ,curCSV.getString(71), curCSV.getString(72) ,curCSV
						.getString(73), curCSV.getString(74) ,curCSV.getString(75), curCSV.getString(76) ,curCSV
						.getString(77), curCSV.getString(78) ,curCSV.getString(79), curCSV.getString(80),curCSV.getString(81)};


				csvWrite.writeNext(arrStr);
			}
			csvWrite.close();
			curCSV.close();
			surveyDAOManager.close();
		}
		catch(Exception sqlEx)
		{
			Log.e(TAG, sqlEx.getMessage(), sqlEx);
		}


		return file.getAbsolutePath();
	}

	public List<Long> getSurveyIds() {
		return surveyIds;
	}
}
