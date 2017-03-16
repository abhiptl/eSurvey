package gov.com.esurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import gov.com.esurvey.domain.EntrepreneurDto;

public class CapitalDetailActivity extends AppCompatActivity {

	private EntrepreneurDto entrepreneurDto;

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
		entrepreneurDto = (EntrepreneurDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		if (entrepreneurDto.getAmountReceivedFromCustomer() != null) {
			eTextAmountReceivedFromCustomer.setText(entrepreneurDto.getAmountReceivedFromCustomer());
		}
		if (entrepreneurDto.getAmountPaidToSupplied() != null) {
			eTextAmountPaidToSupplied.setText(entrepreneurDto.getAmountPaidToSupplied());
		}

		if (eTextAmountInvestedInStart.getText() != null) {
			entrepreneurDto.setAmountInvestedInStart(eTextAmountInvestedInStart.getText().toString());
		}
		if (entrepreneurDto.getAmountInvestedAfterStart() != null) {
			eTextAmountInvestedAfterStart.setText(entrepreneurDto.getAmountInvestedAfterStart());
		}


		if (entrepreneurDto.getOperationMonthsInYear() != null) {
			eTextOperationMonthsInYear.setText(entrepreneurDto.getOperationMonthsInYear());
		}
		if (entrepreneurDto.getOperationDaysPerWeek() != null) {
			eTextOperationDaysPerWeek.setText(entrepreneurDto.getOperationDaysPerWeek());
		}
		if (entrepreneurDto.getOperationHoursPerWeek() != null) {
			eTextOperationHoursPerWeek.setText(entrepreneurDto.getOperationHoursPerWeek());
		}


		if (entrepreneurDto.getEntrepreneurInvolved() != null) {
			eTextEntrepreneurInvolved.setText(entrepreneurDto.getEntrepreneurInvolved());
		}
		if (entrepreneurDto.getEntrepreneurInvolvedMonths() != null) {
			eTextEntrepreneurInvolvedMonths.setText(entrepreneurDto.getEntrepreneurInvolvedMonths());
		}
		if (entrepreneurDto.getFamilyMembersInvolved() != null) {
			eTextFamilyMembersInvolved.setText(entrepreneurDto.getFamilyMembersInvolved());
		}
		if (entrepreneurDto.getFamilyMembersInvolvedMonths() != null) {
			eTextFamilyMembersInvolvedMonths.setText(entrepreneurDto.getFamilyMembersInvolvedMonths());
		}
		if (entrepreneurDto.getExternalLabourersInvolved() != null) {
			eTextExternalLabourersInvolved.setText(entrepreneurDto.getExternalLabourersInvolved());
		}
		if (entrepreneurDto.getExternalLabourersInvolvedMonths() != null) {
			eTextExternalLabourersInvolvedMonths.setText(entrepreneurDto.getExternalLabourersInvolvedMonths());
		}
	}

	public void buildEntrepreneurDto() {

		if (eTextAmountReceivedFromCustomer.getText() != null) {
			entrepreneurDto.setAmountReceivedFromCustomer(eTextAmountReceivedFromCustomer.getText().toString());
		}
		if (eTextAmountPaidToSupplied.getText() != null) {
			entrepreneurDto.setAmountPaidToSupplied(eTextAmountPaidToSupplied.getText().toString());
		}

		if (eTextAmountInvestedInStart.getText() != null) {
			entrepreneurDto.setAmountInvestedInStart(eTextAmountInvestedInStart.getText().toString());
		}
		if (eTextAmountInvestedAfterStart.getText() != null) {
			entrepreneurDto.setAmountInvestedAfterStart(eTextAmountInvestedAfterStart.getText().toString());
		}


		if (eTextOperationMonthsInYear.getText() != null) {
			entrepreneurDto.setOperationMonthsInYear(eTextOperationMonthsInYear.getText().toString());
		}
		if (eTextOperationDaysPerWeek.getText() != null) {
			entrepreneurDto.setOperationDaysPerWeek(eTextOperationDaysPerWeek.getText().toString());
		}
		if (eTextOperationHoursPerWeek.getText() != null) {
			entrepreneurDto.setOperationHoursPerWeek(eTextOperationHoursPerWeek.getText().toString());
		}


		if (eTextEntrepreneurInvolved.getText() != null) {
			entrepreneurDto.setEntrepreneurInvolved(eTextEntrepreneurInvolved.getText().toString());
		}
		if (eTextEntrepreneurInvolvedMonths.getText() != null) {
			entrepreneurDto.setEntrepreneurInvolvedMonths(eTextEntrepreneurInvolvedMonths.getText().toString());
		}
		if (eTextFamilyMembersInvolved.getText() != null) {
			entrepreneurDto.setFamilyMembersInvolved(eTextFamilyMembersInvolved.getText().toString());
		}
		if (eTextFamilyMembersInvolvedMonths.getText() != null) {
			entrepreneurDto.setFamilyMembersInvolvedMonths(eTextFamilyMembersInvolvedMonths.getText().toString());
		}
		if (eTextExternalLabourersInvolved.getText() != null) {
			entrepreneurDto.setExternalLabourersInvolved(eTextExternalLabourersInvolved.getText().toString());
		}
		if (eTextExternalLabourersInvolvedMonths.getText() != null) {
			entrepreneurDto.setExternalLabourersInvolvedMonths(eTextExternalLabourersInvolvedMonths.getText().toString());
		}
	}

	public void addListeners() {
		buttonBackCapitalDetails = (Button) findViewById(R.id.buttonBackCapitalDetails);

		buttonBackCapitalDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, entrepreneurDto);
				startActivity(intent);
			}
		});


		buttonNextCapitalDetails = (Button) findViewById(R.id.buttonNextCapitalDetails);

		buttonNextCapitalDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();

				Intent intent = new Intent(getApplicationContext(), MonthlySaleTrendsActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, entrepreneurDto);
				startActivity(intent);
			}
		});
	}
}
