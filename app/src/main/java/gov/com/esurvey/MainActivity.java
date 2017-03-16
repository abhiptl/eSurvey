package gov.com.esurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import gov.com.esurvey.database.SurveyDAOManager;
import gov.com.esurvey.domain.SurveyDto;

public class MainActivity extends AppCompatActivity {

	public static final String ENTREPRENEUR_DTO = "ENTREPRENEUR_DTO";

	Button btnStartSurvey;

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
		btnStartSurvey = (Button) findViewById(R.id.startSurvey);

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
	}
}
