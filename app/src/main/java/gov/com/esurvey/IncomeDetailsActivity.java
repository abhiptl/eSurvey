package gov.com.esurvey;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import gov.com.esurvey.domain.EntrepreneurDto;

public class IncomeDetailsActivity extends AppCompatActivity {

	EntrepreneurDto entrepreneurDto;

	Button buttonBackIncomeDetails;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income_details);

		entrepreneurDto = (EntrepreneurDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		buttonBackIncomeDetails = (Button) findViewById(R.id.buttonBackIncomeDetails);

		buttonBackIncomeDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), EntrepreneurActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, entrepreneurDto);
				startActivity(intent);
			}
		});
	}
}
