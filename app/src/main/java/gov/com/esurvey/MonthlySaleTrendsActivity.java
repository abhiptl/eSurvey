package gov.com.esurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import gov.com.esurvey.database.SurveyDAOManager;
import gov.com.esurvey.domain.SurveyDto;

public class MonthlySaleTrendsActivity extends AppCompatActivity {

	private final String TAG = MonthlySaleTrendsActivity.class.getSimpleName();

	private SurveyDto surveyDto;

	private RadioGroup radioGroupJanuary;
	private RadioGroup radioGroupFebruary;
	private RadioGroup radioGroupMarch;
	private RadioGroup radioGroupApril;
	private RadioGroup radioGroupMay;
	private RadioGroup radioGroupJune;
	private RadioGroup radioGroupJuly;
	private RadioGroup radioGroupAugust;
	private RadioGroup radioGroupSeptember;
	private RadioGroup radioGroupOctober;
	private RadioGroup radioGroupNovember;
	private RadioGroup radioGroupDecember;

	private SurveyDAOManager surveyDAOManager;

	private EditText eTextSalesToExternal;
	private EditText eTextPurchaseEntrepreneur;

	private Button buttonBackMonthlySales;
	private Button buttonSubmitMonthlySales;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monthly_sale_trends);
		init();
	}

	public void init() {
		initializeComponents();
		initializeValues();
		addListeners();
	}

	public void initializeComponents() {
		radioGroupJanuary = (RadioGroup) findViewById(R.id.radioGroupJanuary);
		radioGroupFebruary = (RadioGroup) findViewById(R.id.radioGroupFebruary);
		radioGroupMarch = (RadioGroup) findViewById(R.id.radioGroupMarch);
		radioGroupApril = (RadioGroup) findViewById(R.id.radioGroupApril);
		radioGroupMay = (RadioGroup) findViewById(R.id.radioGroupMay);
		radioGroupJune = (RadioGroup) findViewById(R.id.radioGroupJune);
		radioGroupJuly = (RadioGroup) findViewById(R.id.radioGroupJuly);
		radioGroupAugust = (RadioGroup) findViewById(R.id.radioGroupAugust);
		radioGroupSeptember = (RadioGroup) findViewById(R.id.radioGroupSeptember);
		radioGroupOctober = (RadioGroup) findViewById(R.id.radioGroupOctober);
		radioGroupNovember = (RadioGroup) findViewById(R.id.radioGroupNovember);
		radioGroupDecember = (RadioGroup) findViewById(R.id.radioGroupDecember);


		eTextSalesToExternal = (EditText) findViewById(R.id.eTextSalesToExternal);
		eTextPurchaseEntrepreneur = (EditText) findViewById(R.id.eTextPurchaseEntrepreneur);

		surveyDAOManager = new SurveyDAOManager(this);

	}

	public void initializeValues() {
		surveyDto = (SurveyDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		if(surveyDto.getMonthlySaleTrendJanuary() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_january), surveyDto.getMonthlySaleTrendJanuary());
		}

		if(surveyDto.getMonthlySaleTrendFebruary() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_february), surveyDto.getMonthlySaleTrendFebruary());
		}

		if(surveyDto.getMonthlySaleTrendMarch() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_march), surveyDto.getMonthlySaleTrendMarch());
		}

		if(surveyDto.getMonthlySaleTrendApril() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_april), surveyDto.getMonthlySaleTrendApril());
		}

		if(surveyDto.getMonthlySaleTrendMay() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_may), surveyDto.getMonthlySaleTrendMay());
		}

		if(surveyDto.getMonthlySaleTrendJune() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_june), surveyDto.getMonthlySaleTrendJune());
		}

		if(surveyDto.getMonthlySaleTrendJuly() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_july), surveyDto.getMonthlySaleTrendJuly());
		}

		if(surveyDto.getMonthlySaleTrendAugust() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_august), surveyDto.getMonthlySaleTrendAugust());
		}

		if(surveyDto.getMonthlySaleTrendSeptember() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_september), surveyDto.getMonthlySaleTrendSeptember());
		}

		if(surveyDto.getMonthlySaleTrendOctober() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_october), surveyDto.getMonthlySaleTrendOctober());
		}

		if(surveyDto.getMonthlySaleTrendNovember() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_november), surveyDto.getMonthlySaleTrendNovember());
		}

		if(surveyDto.getMonthlySaleTrendDecember() != null) {
			checkMonthlyTrendRadio(getResources().getString(R.string.salemonth_december), surveyDto.getMonthlySaleTrendDecember());
		}



	}
	public void checkMonthlyTrendRadio(final String month, final String trend) {
		RadioButton selectedSaleTrendRadio = null;
		selectedSaleTrendRadio = getSaleTrendRadioButtonByMonthAndTrend(month, trend);
		selectedSaleTrendRadio.setChecked(true);
	}

	public RadioButton getSaleTrendRadioButtonByMonthAndTrend(String month, String trend) {
		String monthlyTrendRadioButtonKey = month + trend;
		RadioButton monthlyTrendRadioButton = null;
		switch (monthlyTrendRadioButtonKey) {
			case "JanuaryHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJanuaryHigh);
				break;
			case "JanuaryMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJanuaryMedium);
				break;
			case "JanuaryLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJanuaryLow);
				break;

			case "FebruaryHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonFebruaryHigh);
				break;
			case "FebruaryMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonFebruaryMedium);
				break;
			case "FebruaryLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonFebruaryLow);
				break;

			case "MarchHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonMarchHigh);
				break;
			case "MarchMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonMarchMedium);
				break;
			case "MarchLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonMarchLow);
				break;

			case "AprilHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonAprilHigh);
				break;
			case "AprilMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonAprilMedium);
				break;
			case "AprilLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonAprilLow);
				break;

			case "MayHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonMayHigh);
				break;
			case "MayMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonMayMedium);
				break;
			case "MayLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonMayLow);
				break;


			case "JuneHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJuneHigh);
				break;
			case "JuneMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJuneMedium);
				break;
			case "JuneLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJuneLow);
				break;

			case "JulyHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJulyHigh);
				break;
			case "JulyMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJulyMedium);
				break;
			case "JulyLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonJulyLow);
				break;

			case "AugustHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonAugustHigh);
				break;
			case "AugustMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonAugustMedium);
				break;
			case "AugustLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonAugustLow);
				break;

			case "SeptemberHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonSeptemberHigh);
				break;
			case "SeptemberMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonSeptemberMedium);
				break;
			case "SeptemberLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonSeptemberLow);
				break;

			case "OctoberHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonOctoberHigh);
				break;
			case "OctoberMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonOctoberMedium);
				break;
			case "OctoberLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonOctoberLow);
				break;

			case "NovemberHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonNovemberHigh);
				break;
			case "NovemberMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonNovemberMedium);
				break;
			case "NovemberLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonNovemberLow);
				break;

			case "DecemberHigh" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonDecemberHigh);
				break;
			case "DecemberMedium" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonDecemberMedium);
				break;
			case "DecemberLow" :
				monthlyTrendRadioButton = (RadioButton) findViewById(R.id.radioButtonDecemberLow);
				break;

		}

		return monthlyTrendRadioButton;
	}


	public void addListeners() {
		buttonBackMonthlySales = (Button) findViewById(R.id.buttonBackMonthlySales);

		buttonBackMonthlySales.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				Intent intent = new Intent(getApplicationContext(), CapitalDetailActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, surveyDto);
				startActivity(intent);
			}
		});


		buttonSubmitMonthlySales = (Button) findViewById(R.id.buttonSubmitMonthlySales);

		buttonSubmitMonthlySales.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				Log.i(TAG, surveyDto.toString());
				long id = insertSurveyDetail();
				Toast.makeText(getApplicationContext(), "Survey has been saved. Please sync to pending surveys.", Toast
						.LENGTH_LONG)
						.show();
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});

	}

	public long insertSurveyDetail() {
		surveyDAOManager.open();
		long insertedSurveyID = surveyDAOManager.insert(surveyDto);
		surveyDAOManager.close();
		return insertedSurveyID;
	}

	public void buildEntrepreneurDto() {
		if(radioGroupJanuary.getCheckedRadioButtonId() != -1) {
			RadioButton rgJanuary = (RadioButton) findViewById(radioGroupJanuary.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendJanuary(rgJanuary.getText().toString());
		}

		if(radioGroupFebruary.getCheckedRadioButtonId() != -1) {
			RadioButton rgFebruary = (RadioButton) findViewById(radioGroupFebruary.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendFebruary(rgFebruary.getText().toString());
		}

		if(radioGroupMarch.getCheckedRadioButtonId() != -1) {
			RadioButton rgMarch = (RadioButton) findViewById(radioGroupMarch.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendMarch(rgMarch.getText().toString());
		}

		if(radioGroupApril.getCheckedRadioButtonId() != -1) {
			RadioButton rgApril = (RadioButton) findViewById(radioGroupApril.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendApril(rgApril.getText().toString());
		}

		if(radioGroupMay.getCheckedRadioButtonId() != -1) {
			RadioButton rgMay = (RadioButton) findViewById(radioGroupMay.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendMay(rgMay.getText().toString());
		}

		if(radioGroupJune.getCheckedRadioButtonId() != -1) {
			RadioButton rgJune = (RadioButton) findViewById(radioGroupJune.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendJune(rgJune.getText().toString());
		}

		if(radioGroupJuly.getCheckedRadioButtonId() != -1) {
			RadioButton rgJuly = (RadioButton) findViewById(radioGroupJuly.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendJuly(rgJuly.getText().toString());

		}

		if(radioGroupAugust.getCheckedRadioButtonId() != -1) {
			RadioButton rgAugust = (RadioButton) findViewById(radioGroupAugust.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendAugust(rgAugust.getText().toString());

		}

		if(radioGroupSeptember.getCheckedRadioButtonId() != -1) {
			RadioButton rgSeptember = (RadioButton) findViewById(radioGroupSeptember.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendSeptember(rgSeptember.getText().toString());
		}

		if(radioGroupOctober.getCheckedRadioButtonId() != -1) {
			RadioButton rgOctober = (RadioButton) findViewById(radioGroupOctober.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendOctober(rgOctober.getText().toString());
		}

		if(radioGroupNovember.getCheckedRadioButtonId() != -1) {
			RadioButton rgNovember = (RadioButton) findViewById(radioGroupNovember.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendNovember(rgNovember.getText().toString());

		}

		if(radioGroupDecember.getCheckedRadioButtonId() != -1) {
			RadioButton rgDecember = (RadioButton) findViewById(radioGroupDecember.getCheckedRadioButtonId());
			surveyDto.setMonthlySaleTrendDecember(rgDecember.getText().toString());
		}


		if(eTextSalesToExternal.getText() != null) {
			surveyDto.setSaleToExternalCustomer(eTextSalesToExternal.getText().toString());
		}

		if(eTextPurchaseEntrepreneur.getText() != null) {
			surveyDto.setPurchaseByEntrepreneur(eTextPurchaseEntrepreneur.getText().toString());
		}
	}
}
