package gov.com.esurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import gov.com.esurvey.domain.SurveyDto;

public class IncomeDetailsActivity extends AppCompatActivity {

	private SurveyDto surveyDto;

	private EditText noOfMonthsNormalSeason;
	private EditText noOfMonthsHighSeason;

	private EditText totalSalesCreditNormalSeason;
	private EditText totalSalesCreditHighSeason;

	private EditText totalSalesCashNormalSeason;
	private EditText totalSalesCashHighSeason;

	private EditText costRawMaterialCashNormalSeason;
	private EditText costRawMaterialCashHighSeason;


	private EditText costRawMaterialCreditNormalSeason;
	private EditText costRawMaterialCreditHighSeason;

	private EditText purchaseFrequencyNormalSeason;
	private EditText purchaseFrequencyHighSeason;

	private EditText wagesWithdrawnNormalSeason;
	private EditText wagesWithdrawnHighSeason;

	private EditText rentNormalSeason;
	private EditText rentHighSeason;

	private EditText electricityCostNormalSeason;
	private EditText electricityCostHighSeason;

	private EditText transportationCostNormalSeason;
	private EditText transportationHighSeason;

	private EditText packagingCostNormalSeason;
	private EditText packagingCostHighSeason;

	private EditText fuelCostNormalSeason;
	private EditText fuelCostHighSeason;

	private EditText commissionNormalSeason;
	private EditText commissionHighSeason;

	private EditText wastageCostNormalSeason;
	private EditText wastageCostHighSeason;

	private EditText wagesPaidNormalSeason;
	private EditText wagesPaidHighSeason;

	private EditText promotionCostNormalSeason;
	private EditText promotionCostHighSeason;

	private EditText communicationCostNormalSeason;
	private EditText communicationCostHighSeason;

	private EditText machineRepairCostNormalSeason;
	private EditText machineRepairCostHighSeason;

	private EditText otherCostNormalSeason;
	private EditText otherCostHighSeason;


	private Button buttonBackIncomeDetails;
	private Button buttonNextIncomeDetails;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income_details);

		init();

		surveyDto = (SurveyDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));


	}

	public void init() {
		initializeComponents();
		initializeValues();
		addListeners();
	}

	public void initializeComponents() {
		noOfMonthsNormalSeason = (EditText) findViewById(R.id.noOfMonthsNormalSeason);
		noOfMonthsHighSeason = (EditText) findViewById(R.id.noOfMonthsHighSeason);

		totalSalesCreditNormalSeason = (EditText) findViewById(R.id.totalSalesCreditNormalSeason);
		totalSalesCreditHighSeason = (EditText) findViewById(R.id.totalSalesCreditHighSeason);

		totalSalesCashNormalSeason = (EditText) findViewById(R.id.totalSalesCashNormalSeason);
		totalSalesCashHighSeason = (EditText) findViewById(R.id.totalSalesCashHighSeason);

		costRawMaterialCashNormalSeason = (EditText) findViewById(R.id.costRawMaterialCashNormalSeason);
		costRawMaterialCashHighSeason = (EditText) findViewById(R.id.costRawMaterialCashHighSeason);

		costRawMaterialCreditNormalSeason = (EditText) findViewById(R.id.costRawMaterialCreditNormalSeason);
		costRawMaterialCreditHighSeason = (EditText) findViewById(R.id.costRawMaterialCreditHighSeason);

		purchaseFrequencyNormalSeason = (EditText) findViewById(R.id.purchaseFrequencyNormalSeason);
		purchaseFrequencyHighSeason = (EditText) findViewById(R.id.purchaseFrequencyHighSeason);

		wagesWithdrawnNormalSeason = (EditText) findViewById(R.id.wagesWithdrawnNormalSeason);
		wagesWithdrawnHighSeason = (EditText) findViewById(R.id.wagesWithdrawnHighSeason);

		rentNormalSeason = (EditText) findViewById(R.id.rentNormalSeason);
		rentHighSeason = (EditText) findViewById(R.id.rentHighSeason);

		electricityCostNormalSeason = (EditText) findViewById(R.id.electricityCostNormalSeason);
		electricityCostHighSeason = (EditText) findViewById(R.id.electricityCostHighSeason);

		transportationCostNormalSeason = (EditText) findViewById(R.id.transportationCostNormalSeason);
		transportationHighSeason = (EditText) findViewById(R.id.transportationHighSeason);

		packagingCostNormalSeason = (EditText) findViewById(R.id.packagingCostNormalSeason);
		packagingCostHighSeason = (EditText) findViewById(R.id.packagingCostHighSeason);

		fuelCostNormalSeason = (EditText) findViewById(R.id.fuelCostNormalSeason);
		fuelCostHighSeason = (EditText) findViewById(R.id.fuelCostHighSeason);

		commissionNormalSeason = (EditText) findViewById(R.id.commissionNormalSeason);
		commissionHighSeason = (EditText) findViewById(R.id.commissionHighSeason);

		wastageCostNormalSeason = (EditText) findViewById(R.id.wastageCostNormalSeason);
		wastageCostHighSeason = (EditText) findViewById(R.id.wastageCostHighSeason);

		wagesPaidNormalSeason = (EditText) findViewById(R.id.wagesPaidNormalSeason);
		wagesPaidHighSeason = (EditText) findViewById(R.id.wagesPaidHighSeason);

		promotionCostNormalSeason = (EditText) findViewById(R.id.promotionCostNormalSeason);
		promotionCostHighSeason = (EditText) findViewById(R.id.promotionCostHighSeason);

		communicationCostNormalSeason = (EditText) findViewById(R.id.communicationCostNormalSeason);
		communicationCostHighSeason = (EditText) findViewById(R.id.communicationCostHighSeason);

		machineRepairCostNormalSeason = (EditText) findViewById(R.id.machineRepairCostNormalSeason);
		machineRepairCostHighSeason = (EditText) findViewById(R.id.machineRepairCostHighSeason);

		otherCostNormalSeason = (EditText) findViewById(R.id.otherCostNormalSeason);
		otherCostHighSeason = (EditText) findViewById(R.id.otherCostHighSeason);
	}

	public void initializeValues() {
		surveyDto = (SurveyDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		if(surveyDto.getNoOfMonthsNormalSeason() != null) {
			noOfMonthsNormalSeason.setText(surveyDto.getNoOfMonthsNormalSeason());
		}

		if(surveyDto.getNoOfMonthsHighSeason() != null) {
			noOfMonthsHighSeason.setText(surveyDto.getNoOfMonthsHighSeason());
		}

		if(surveyDto.getTotalSalesCreditNormalSeason() != null) {
			totalSalesCreditNormalSeason.setText(surveyDto.getTotalSalesCreditNormalSeason());
		}

		if(surveyDto.getTotalSalesCreditHighSeason() != null) {
			totalSalesCreditHighSeason.setText(surveyDto.getTotalSalesCreditHighSeason() );
		}

		if(surveyDto.getTotalSalesCashNormalSeason() != null) {
			totalSalesCashNormalSeason.setText(surveyDto.getTotalSalesCashNormalSeason());
		}

		if(surveyDto.getTotalSalesCashHighSeason() != null) {
			totalSalesCashHighSeason.setText(surveyDto.getTotalSalesCashHighSeason());
		}

		if(surveyDto.getCostRawMaterialCashNormalSeason() != null) {
			costRawMaterialCashNormalSeason.setText(surveyDto.getCostRawMaterialCashNormalSeason());
		}

		if(surveyDto.getCostRawMaterialCashHighSeason() != null) {
			costRawMaterialCashHighSeason.setText(surveyDto.getCostRawMaterialCashHighSeason());
		}

		if(surveyDto.getCostRawMaterialCreditNormalSeason() != null) {
			costRawMaterialCreditNormalSeason.setText(surveyDto.getCostRawMaterialCreditNormalSeason() );
		}

		if(surveyDto.getCostRawMaterialCreditHighSeason() != null) {
			costRawMaterialCreditHighSeason.setText(surveyDto.getCostRawMaterialCreditHighSeason());
		}

		if(surveyDto.getPurchaseFrequencyNormalSeason() != null) {
			purchaseFrequencyNormalSeason.setText(surveyDto.getPurchaseFrequencyNormalSeason().toString());
		}

		if(surveyDto.getPurchaseFrequencyHighSeason() != null) {
			purchaseFrequencyHighSeason.setText(surveyDto.getPurchaseFrequencyHighSeason());
		}

		if(surveyDto.getWagesWithdrawnNormalSeason() != null) {
			wagesWithdrawnNormalSeason.setText(surveyDto.getWagesWithdrawnNormalSeason());
		}

		if(surveyDto.getWagesWithdrawnHighSeason() != null) {
			wagesWithdrawnHighSeason.setText(surveyDto.getWagesWithdrawnHighSeason());
		}

		if(surveyDto.getRentNormalSeason() != null) {
			rentNormalSeason.setText(surveyDto.getRentNormalSeason());
		}

		if(surveyDto.getRentHighSeason() != null) {
			rentHighSeason.setText(surveyDto.getRentHighSeason());
		}

		if(surveyDto.getElectricityCostNormalSeason() != null) {
			electricityCostNormalSeason.setText(surveyDto.getElectricityCostNormalSeason());
		}

		if(surveyDto.getElectricityCostHighSeason() != null) {
			electricityCostHighSeason.setText(surveyDto.getElectricityCostHighSeason());
		}

		if(surveyDto.getTransportationCostNormalSeason() != null) {
			transportationCostNormalSeason.setText(surveyDto.getTransportationCostNormalSeason());
		}

		if(surveyDto.getTransportationHighSeason() != null) {
			transportationHighSeason.setText(surveyDto.getTransportationHighSeason());
		}

		if(surveyDto.getPackagingCostNormalSeason() != null) {
			packagingCostNormalSeason.setText(surveyDto.getPackagingCostNormalSeason());
		}

		if(surveyDto.getPackagingCostHighSeason() != null) {
			packagingCostHighSeason.setText(surveyDto.getPackagingCostHighSeason());
		}

		if(surveyDto.getFuelCostNormalSeason() != null) {
			fuelCostNormalSeason.setText(surveyDto.getFuelCostNormalSeason());
		}

		if(surveyDto.getFuelCostHighSeason() != null) {
			fuelCostHighSeason.setText(surveyDto.getFuelCostHighSeason());
		}

		if(surveyDto.getCommissionNormalSeason() != null) {
			commissionNormalSeason.setText(surveyDto.getCommissionNormalSeason());
		}

		if(surveyDto.getCommissionHighSeason() != null) {
			commissionHighSeason.setText(surveyDto.getCommissionHighSeason());
		}

		if(surveyDto.getWastageCostNormalSeason() != null) {
			wastageCostNormalSeason.setText(surveyDto.getWastageCostNormalSeason());
		}

		if(surveyDto.getWastageCostHighSeason() != null) {
			wastageCostHighSeason.setText(surveyDto.getWastageCostHighSeason());
		}

		if(surveyDto.getWagesPaidNormalSeason() != null) {
			wagesPaidNormalSeason.setText(surveyDto.getWagesPaidNormalSeason());
		}

		if(surveyDto.getWagesPaidHighSeason() != null) {
			wagesPaidHighSeason.setText(surveyDto.getWagesPaidHighSeason());
		}

		if(surveyDto.getPromotionCostNormalSeason() != null) {
			promotionCostNormalSeason.setText(surveyDto.getPromotionCostNormalSeason());
		}

		if(surveyDto.getPromotionCostHighSeason() != null) {
			promotionCostHighSeason.setText(surveyDto.getPromotionCostHighSeason());
		}

		if(surveyDto.getCommunicationCostNormalSeason() != null) {
			communicationCostNormalSeason.setText(surveyDto.getCommunicationCostNormalSeason());
		}

		if(surveyDto.getCommunicationCostHighSeason() != null) {
			communicationCostHighSeason.setText(surveyDto.getCommunicationCostHighSeason());
		}

		if(surveyDto.getMachineRepairCostNormalSeason() != null) {
			machineRepairCostNormalSeason.setText(surveyDto.getMachineRepairCostNormalSeason());
		}

		if(surveyDto.getMachineRepairCostHighSeason() != null) {
			machineRepairCostHighSeason.setText(surveyDto.getMachineRepairCostHighSeason());
		}

		if(surveyDto.getOtherCostNormalSeason() != null) {
			otherCostNormalSeason.setText(surveyDto.getOtherCostNormalSeason());
		}

		if(surveyDto.getOtherCostHighSeason() != null) {
			otherCostHighSeason.setText(surveyDto.getOtherCostHighSeason());
		}
	}

	public void addListeners() {
		buttonBackIncomeDetails = (Button) findViewById(R.id.buttonBackIncomeDetails);

		buttonBackIncomeDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				Intent intent = new Intent(getApplicationContext(), EntrepreneurActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, surveyDto);
				startActivity(intent);
			}
		});


		buttonNextIncomeDetails = (Button) findViewById(R.id.buttonNextIncomeDetails);

		buttonNextIncomeDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();

				Intent intent = new Intent(getApplicationContext(), CapitalDetailActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, surveyDto);
				startActivity(intent);
			}
		});

	}

	public void buildEntrepreneurDto() {
		if(noOfMonthsNormalSeason.getText() != null) {
			surveyDto.setNoOfMonthsNormalSeason(noOfMonthsNormalSeason.getText().toString());
		}

		if(noOfMonthsHighSeason.getText() != null) {
			surveyDto.setNoOfMonthsHighSeason(noOfMonthsHighSeason.getText().toString());
		}

		if(totalSalesCreditNormalSeason.getText() != null) {
			surveyDto.setTotalSalesCreditNormalSeason(totalSalesCreditNormalSeason.getText().toString());
		}

		if(totalSalesCreditHighSeason.getText() != null) {
			surveyDto.setTotalSalesCreditHighSeason(totalSalesCreditHighSeason.getText().toString());
		}

		if(totalSalesCashNormalSeason.getText() != null) {
			surveyDto.setTotalSalesCashNormalSeason(totalSalesCashNormalSeason.getText().toString());
		}

		if(totalSalesCashHighSeason.getText() != null) {
			surveyDto.setTotalSalesCashHighSeason(totalSalesCashHighSeason.getText().toString());
		}

		if(costRawMaterialCashNormalSeason.getText() != null) {
			surveyDto.setCostRawMaterialCashNormalSeason(costRawMaterialCashNormalSeason.getText().toString());
		}

		if(costRawMaterialCashHighSeason.getText() != null) {
			surveyDto.setCostRawMaterialCashHighSeason(costRawMaterialCashHighSeason.getText().toString());
		}

		if(costRawMaterialCreditNormalSeason.getText() != null) {
			surveyDto.setCostRawMaterialCreditNormalSeason(costRawMaterialCreditNormalSeason.getText().toString());
		}

		if(costRawMaterialCreditHighSeason.getText() != null) {
			surveyDto.setCostRawMaterialCreditHighSeason(costRawMaterialCreditHighSeason.getText().toString());
		}

		if(purchaseFrequencyNormalSeason.getText() != null) {
			surveyDto.setPurchaseFrequencyNormalSeason(purchaseFrequencyNormalSeason.getText().toString());
		}

		if(purchaseFrequencyHighSeason.getText() != null) {
			surveyDto.setPurchaseFrequencyHighSeason(purchaseFrequencyHighSeason.getText().toString());
		}

		if(wagesWithdrawnNormalSeason.getText() != null) {
			surveyDto.setWagesWithdrawnNormalSeason(wagesWithdrawnNormalSeason.getText().toString());
		}

		if(wagesWithdrawnHighSeason.getText() != null) {
			surveyDto.setWagesWithdrawnHighSeason(wagesWithdrawnHighSeason.getText().toString());
		}

		if(rentNormalSeason.getText() != null) {
			surveyDto.setRentNormalSeason(rentNormalSeason.getText().toString());
		}

		if(rentHighSeason.getText() != null) {
			surveyDto.setRentHighSeason(rentHighSeason.getText().toString());
		}

		if(electricityCostNormalSeason.getText() != null) {
			surveyDto.setElectricityCostNormalSeason(electricityCostNormalSeason.getText().toString());
		}

		if(electricityCostHighSeason.getText() != null) {
			surveyDto.setElectricityCostHighSeason(electricityCostHighSeason.getText().toString());
		}

		if(transportationCostNormalSeason.getText() != null) {
			surveyDto.setTransportationCostNormalSeason(transportationCostNormalSeason.getText().toString());
		}

		if(transportationHighSeason.getText() != null) {
			surveyDto.setTransportationHighSeason(transportationHighSeason.getText().toString());
		}

		if(packagingCostNormalSeason.getText() != null) {
			surveyDto.setPackagingCostNormalSeason(packagingCostNormalSeason.getText().toString());
		}

		if(packagingCostHighSeason.getText() != null) {
			surveyDto.setPackagingCostHighSeason(packagingCostHighSeason.getText().toString());
		}

		if(fuelCostNormalSeason.getText() != null) {
			surveyDto.setFuelCostNormalSeason(fuelCostNormalSeason.getText().toString());
		}

		if(fuelCostHighSeason.getText() != null) {
			surveyDto.setFuelCostHighSeason(fuelCostHighSeason.getText().toString());
		}

		if(commissionNormalSeason.getText() != null) {
			surveyDto.setCommissionNormalSeason(commissionNormalSeason.getText().toString());
		}

		if(commissionHighSeason.getText() != null) {
			surveyDto.setCommissionHighSeason(commissionHighSeason.getText().toString());
		}

		if(wastageCostNormalSeason.getText() != null) {
			surveyDto.setWastageCostNormalSeason(wastageCostNormalSeason.getText().toString());
		}

		if(wastageCostHighSeason.getText() != null) {
			surveyDto.setWastageCostHighSeason(wastageCostHighSeason.getText().toString());
		}

		if(wagesPaidNormalSeason.getText() != null) {
			surveyDto.setWagesPaidNormalSeason(wagesPaidNormalSeason.getText().toString());
		}

		if(wagesPaidHighSeason.getText() != null) {
			surveyDto.setWagesPaidHighSeason(wagesPaidHighSeason.getText().toString());
		}

		if(promotionCostNormalSeason.getText() != null) {
			surveyDto.setPromotionCostNormalSeason(promotionCostNormalSeason.getText().toString());
		}

		if(promotionCostHighSeason.getText() != null) {
			surveyDto.setPromotionCostHighSeason(promotionCostHighSeason.getText().toString());
		}

		if(communicationCostNormalSeason.getText() != null) {
			surveyDto.setCommunicationCostNormalSeason(communicationCostNormalSeason.getText().toString());
		}

		if(communicationCostHighSeason.getText() != null) {
			surveyDto.setCommunicationCostHighSeason(communicationCostHighSeason.getText().toString());
		}

		if(machineRepairCostNormalSeason.getText() != null) {
			surveyDto.setMachineRepairCostNormalSeason(machineRepairCostNormalSeason.getText().toString());
		}

		if(machineRepairCostHighSeason.getText() != null) {
			surveyDto.setMachineRepairCostHighSeason(machineRepairCostHighSeason.getText().toString());
		}

		if(otherCostNormalSeason.getText() != null) {
			surveyDto.setOtherCostNormalSeason(otherCostNormalSeason.getText().toString());
		}

		if(otherCostHighSeason.getText() != null) {
			surveyDto.setOtherCostHighSeason(otherCostHighSeason.getText().toString());
		}


	}

	public SurveyDto getSurveyDto() {
		return surveyDto;
	}

	public void setSurveyDto(SurveyDto surveyDto) {
		this.surveyDto = surveyDto;
	}
}
