package gov.com.esurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import gov.com.esurvey.domain.EntrepreneurDto;

public class MainActivity extends AppCompatActivity {

	public static final String ENTREPRENEUR_DTO = "ENTREPRENEUR_DTO";
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnStartSurvey = (Button) findViewById(R.id.startSurvey);
		btnStartSurvey.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent startSurveyIntent = new Intent(getApplicationContext(), EntrepreneurActivity.class);
				startSurveyIntent.putExtra(MainActivity.ENTREPRENEUR_DTO, new EntrepreneurDto());
				startActivity(startSurveyIntent);
			}
		});
	}
}
