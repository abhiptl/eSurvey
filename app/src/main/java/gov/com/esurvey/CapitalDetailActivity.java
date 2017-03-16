package gov.com.esurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import gov.com.esurvey.domain.SurveyDto;

public class CapitalDetailActivity extends AppCompatActivity {

	private SurveyDto surveyDto;

	private EditText eTextAmountReceivedFromCustomer;
	private EditText eTextAmountPaidToSupplied;

	private EditText eTextAmountInvestedInStart;
	private EditText eTextAmountInvestedAfterStart;

	private EditText eTextOperationMonthsInYear;
	private EditText eTextOperationDaysPerWeek;
	private EditText eTextOperationHoursPerWeek;

	private EditText eTextEntrepreneurInvolved;
	private EditText eTextEntrepreneurInvolvedMonths;
	private EditText eTextFamilyMembersInvolved;
	private EditText eTextFamilyMembersInvolvedMonths;
	private EditText eTextExternalLabourersInvolved;
	private EditText eTextExternalLabourersInvolvedMonths;

	private Button buttonBackCapitalDetails;
	private Button buttonNextCapitalDetails;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capital_detaial);

		init();
	}

	public void init() {
		initializeComponents();
		initializeValues();
		addListeners();
	}

	public void initializeComponents() {
		eTextAmountReceivedFromCustomer = (EditText) findViewById(R.id.eTextAmountReceivedFromCustomer);
		eTextAmountPaidToSupplied = (EditText) findViewById(R.id.eTextAmountPaidToSupplied);

		eTextAmountInvestedInStart = (EditText) findViewById(R.id.eTextAmountInvestedInStart);
		eTextAmountInvestedAfterStart = (EditText) findViewById(R.id.eTextAmountInvestedAfterStart);

		eTextOperationMonthsInYear = (EditText) findViewById(R.id.eTextOperationMonthsInYear);
		eTextOperationDaysPerWeek = (EditText) findViewById(R.id.eTextOperationDaysPerWeek);
		eTextOperationHoursPerWeek = (EditText) findViewById(R.id.eTextOperationHoursPerWeek);

		eTextEntrepreneurInvolved = (EditText) findViewById(R.id.eTextEntrepreneurInvolved);
		eTextEntrepreneurInvolvedMonths = (EditText) findViewById(R.id.eTextEntrepreneurInvolvedMonths);
		eTextFamilyMembersInvolved = (EditText) findViewById(R.id.eTextFamilyMembersInvolved);
		eTextFamilyMembersInvolvedMonths = (EditText) findViewById(R.id.eTextFamilyMembersInvolvedMonths);
		eTextExternalLabourersInvolved = (EditText) findViewById(R.id.eTextExternalLabourersInvolved);
		eTextExternalLabourersInvolvedMonths = (EditText) findViewById(R.id.eTextExternalLabourersInvolvedMonths);
	}

	public void initializeValues() {
		surveyDto = (SurveyDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		if (surveyDto.getAmountReceivedFromCustomer() != null) {
			eTextAmountReceivedFromCustomer.setText(surveyDto.getAmountReceivedFromCustomer());
		}
		if (surveyDto.getAmountPaidToSupplied() != null) {
			eTextAmountPaidToSupplied.setText(surveyDto.getAmountPaidToSupplied());
		}

		if (eTextAmountInvestedInStart.getText() != null) {
			surveyDto.setAmountInvestedInStart(eTextAmountInvestedInStart.getText().toString());
		}
		if (surveyDto.getAmountInvestedAfterStart() != null) {
			eTextAmountInvestedAfterStart.setText(surveyDto.getAmountInvestedAfterStart());
		}


		if (surveyDto.getOperationMonthsInYear() != null) {
			eTextOperationMonthsInYear.setText(surveyDto.getOperationMonthsInYear());
		}
		if (surveyDto.getOperationDaysPerWeek() != null) {
			eTextOperationDaysPerWeek.setText(surveyDto.getOperationDaysPerWeek());
		}
		if (surveyDto.getOperationHoursPerWeek() != null) {
			eTextOperationHoursPerWeek.setText(surveyDto.getOperationHoursPerWeek());
		}


		if (surveyDto.getEntrepreneurInvolved() != null) {
			eTextEntrepreneurInvolved.setText(surveyDto.getEntrepreneurInvolved());
		}
		if (surveyDto.getEntrepreneurInvolvedMonths() != null) {
			eTextEntrepreneurInvolvedMonths.setText(surveyDto.getEntrepreneurInvolvedMonths());
		}
		if (surveyDto.getFamilyMembersInvolved() != null) {
			eTextFamilyMembersInvolved.setText(surveyDto.getFamilyMembersInvolved());
		}
		if (surveyDto.getFamilyMembersInvolvedMonths() != null) {
			eTextFamilyMembersInvolvedMonths.setText(surveyDto.getFamilyMembersInvolvedMonths());
		}
		if (surveyDto.getExternalLabourersInvolved() != null) {
			eTextExternalLabourersInvolved.setText(surveyDto.getExternalLabourersInvolved());
		}
		if (surveyDto.getExternalLabourersInvolvedMonths() != null) {
			eTextExternalLabourersInvolvedMonths.setText(surveyDto.getExternalLabourersInvolvedMonths());
		}
	}

	public void buildEntrepreneurDto() {

		if (eTextAmountReceivedFromCustomer.getText() != null) {
			surveyDto.setAmountReceivedFromCustomer(eTextAmountReceivedFromCustomer.getText().toString());
		}
		if (eTextAmountPaidToSupplied.getText() != null) {
			surveyDto.setAmountPaidToSupplied(eTextAmountPaidToSupplied.getText().toString());
		}

		if (eTextAmountInvestedInStart.getText() != null) {
			surveyDto.setAmountInvestedInStart(eTextAmountInvestedInStart.getText().toString());
		}
		if (eTextAmountInvestedAfterStart.getText() != null) {
			surveyDto.setAmountInvestedAfterStart(eTextAmountInvestedAfterStart.getText().toString());
		}


		if (eTextOperationMonthsInYear.getText() != null) {
			surveyDto.setOperationMonthsInYear(eTextOperationMonthsInYear.getText().toString());
		}
		if (eTextOperationDaysPerWeek.getText() != null) {
			surveyDto.setOperationDaysPerWeek(eTextOperationDaysPerWeek.getText().toString());
		}
		if (eTextOperationHoursPerWeek.getText() != null) {
			surveyDto.setOperationHoursPerWeek(eTextOperationHoursPerWeek.getText().toString());
		}


		if (eTextEntrepreneurInvolved.getText() != null) {
			surveyDto.setEntrepreneurInvolved(eTextEntrepreneurInvolved.getText().toString());
		}
		if (eTextEntrepreneurInvolvedMonths.getText() != null) {
			surveyDto.setEntrepreneurInvolvedMonths(eTextEntrepreneurInvolvedMonths.getText().toString());
		}
		if (eTextFamilyMembersInvolved.getText() != null) {
			surveyDto.setFamilyMembersInvolved(eTextFamilyMembersInvolved.getText().toString());
		}
		if (eTextFamilyMembersInvolvedMonths.getText() != null) {
			surveyDto.setFamilyMembersInvolvedMonths(eTextFamilyMembersInvolvedMonths.getText().toString());
		}
		if (eTextExternalLabourersInvolved.getText() != null) {
			surveyDto.setExternalLabourersInvolved(eTextExternalLabourersInvolved.getText().toString());
		}
		if (eTextExternalLabourersInvolvedMonths.getText() != null) {
			surveyDto.setExternalLabourersInvolvedMonths(eTextExternalLabourersInvolvedMonths.getText().toString());
		}
	}

	public void addListeners() {
		buttonBackCapitalDetails = (Button) findViewById(R.id.buttonBackCapitalDetails);

		buttonBackCapitalDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, surveyDto);
				startActivity(intent);
			}
		});


		buttonNextCapitalDetails = (Button) findViewById(R.id.buttonNextCapitalDetails);

		buttonNextCapitalDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();

				Intent intent = new Intent(getApplicationContext(), MonthlySaleTrendsActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, surveyDto);
				startActivity(intent);
			}
		});
	}
}
