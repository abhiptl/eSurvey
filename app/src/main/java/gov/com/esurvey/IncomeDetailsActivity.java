package gov.com.esurvey;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import gov.com.esurvey.domain.EntrepreneurDto;

public class IncomeDetailsActivity extends AppCompatActivity {

	private EntrepreneurDto entrepreneurDto;

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

		entrepreneurDto = (EntrepreneurDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));


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
		entrepreneurDto = (EntrepreneurDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		if(entrepreneurDto.getNoOfMonthsNormalSeason() != null) {
			noOfMonthsNormalSeason.setText(entrepreneurDto.getNoOfMonthsNormalSeason());
		}

		if(entrepreneurDto.getNoOfMonthsHighSeason() != null) {
			noOfMonthsHighSeason.setText(entrepreneurDto.getNoOfMonthsHighSeason());
		}

		if(entrepreneurDto.getTotalSalesCreditNormalSeason() != null) {
			totalSalesCreditNormalSeason.setText(entrepreneurDto.getTotalSalesCreditNormalSeason());
		}

		if(entrepreneurDto.getTotalSalesCreditHighSeason() != null) {
			totalSalesCreditHighSeason.setText(entrepreneurDto.getTotalSalesCreditHighSeason() );
		}

		if(entrepreneurDto.getTotalSalesCashNormalSeason() != null) {
			totalSalesCashNormalSeason.setText(entrepreneurDto.getTotalSalesCashNormalSeason());
		}

		if(entrepreneurDto.getTotalSalesCashHighSeason() != null) {
			totalSalesCashHighSeason.setText(entrepreneurDto.getTotalSalesCashHighSeason());
		}

		if(entrepreneurDto.getCostRawMaterialCashNormalSeason() != null) {
			costRawMaterialCashNormalSeason.setText(entrepreneurDto.getCostRawMaterialCashNormalSeason());
		}

		if(entrepreneurDto.getCostRawMaterialCashHighSeason() != null) {
			costRawMaterialCashHighSeason.setText(entrepreneurDto.getCostRawMaterialCashHighSeason());
		}

		if(entrepreneurDto.getCostRawMaterialCreditNormalSeason() != null) {
			costRawMaterialCreditNormalSeason.setText(entrepreneurDto.getCostRawMaterialCreditNormalSeason() );
		}

		if(entrepreneurDto.getCostRawMaterialCreditHighSeason() != null) {
			costRawMaterialCreditHighSeason.setText(entrepreneurDto.getCostRawMaterialCreditHighSeason());
		}

		if(entrepreneurDto.getPurchaseFrequencyNormalSeason() != null) {
			purchaseFrequencyNormalSeason.setText(entrepreneurDto.getPurchaseFrequencyNormalSeason().toString());
		}

		if(entrepreneurDto.getPurchaseFrequencyHighSeason() != null) {
			purchaseFrequencyHighSeason.setText(entrepreneurDto.getPurchaseFrequencyHighSeason());
		}

		if(entrepreneurDto.getWagesWithdrawnNormalSeason() != null) {
			wagesWithdrawnNormalSeason.setText(entrepreneurDto.getWagesWithdrawnNormalSeason());
		}

		if(entrepreneurDto.getWagesWithdrawnHighSeason() != null) {
			wagesWithdrawnHighSeason.setText(entrepreneurDto.getWagesWithdrawnHighSeason());
		}

		if(entrepreneurDto.getRentNormalSeason() != null) {
			rentNormalSeason.setText(entrepreneurDto.getRentNormalSeason());
		}

		if(entrepreneurDto.getRentHighSeason() != null) {
			rentHighSeason.setText(entrepreneurDto.getRentHighSeason());
		}

		if(entrepreneurDto.getElectricityCostNormalSeason() != null) {
			electricityCostNormalSeason.setText(entrepreneurDto.getElectricityCostNormalSeason());
		}

		if(entrepreneurDto.getElectricityCostHighSeason() != null) {
			electricityCostHighSeason.setText(entrepreneurDto.getElectricityCostHighSeason());
		}

		if(entrepreneurDto.getTransportationCostNormalSeason() != null) {
			transportationCostNormalSeason.setText(entrepreneurDto.getTransportationCostNormalSeason());
		}

		if(entrepreneurDto.getTransportationHighSeason() != null) {
			transportationHighSeason.setText(entrepreneurDto.getTransportationHighSeason());
		}

		if(entrepreneurDto.getPackagingCostNormalSeason() != null) {
			packagingCostNormalSeason.setText(entrepreneurDto.getPackagingCostNormalSeason());
		}

		if(entrepreneurDto.getPackagingCostHighSeason() != null) {
			packagingCostHighSeason.setText(entrepreneurDto.getPackagingCostHighSeason());
		}

		if(entrepreneurDto.getFuelCostNormalSeason() != null) {
			fuelCostNormalSeason.setText(entrepreneurDto.getFuelCostNormalSeason());
		}

		if(entrepreneurDto.getFuelCostHighSeason() != null) {
			fuelCostHighSeason.setText(entrepreneurDto.getFuelCostHighSeason());
		}

		if(entrepreneurDto.getCommissionNormalSeason() != null) {
			commissionNormalSeason.setText(entrepreneurDto.getCommissionNormalSeason());
		}

		if(entrepreneurDto.getCommissionHighSeason() != null) {
			commissionHighSeason.setText(entrepreneurDto.getCommissionHighSeason());
		}

		if(entrepreneurDto.getWastageCostNormalSeason() != null) {
			wastageCostNormalSeason.setText(entrepreneurDto.getWastageCostNormalSeason());
		}

		if(entrepreneurDto.getWastageCostHighSeason() != null) {
			wastageCostHighSeason.setText(entrepreneurDto.getWastageCostHighSeason());
		}

		if(entrepreneurDto.getWagesPaidNormalSeason() != null) {
			wagesPaidNormalSeason.setText(entrepreneurDto.getWagesPaidNormalSeason());
		}

		if(entrepreneurDto.getWagesPaidHighSeason() != null) {
			wagesPaidHighSeason.setText(entrepreneurDto.getWagesPaidHighSeason());
		}

		if(entrepreneurDto.getPromotionCostNormalSeason() != null) {
			promotionCostNormalSeason.setText(entrepreneurDto.getPromotionCostNormalSeason());
		}

		if(entrepreneurDto.getPromotionCostHighSeason() != null) {
			promotionCostHighSeason.setText(entrepreneurDto.getPromotionCostHighSeason());
		}

		if(entrepreneurDto.getCommunicationCostNormalSeason() != null) {
			communicationCostNormalSeason.setText(entrepreneurDto.getCommunicationCostNormalSeason());
		}

		if(entrepreneurDto.getCommunicationCostHighSeason() != null) {
			communicationCostHighSeason.setText(entrepreneurDto.getCommunicationCostHighSeason());
		}

		if(entrepreneurDto.getMachineRepairCostNormalSeason() != null) {
			machineRepairCostNormalSeason.setText(entrepreneurDto.getMachineRepairCostNormalSeason());
		}

		if(entrepreneurDto.getMachineRepairCostHighSeason() != null) {
			machineRepairCostHighSeason.setText(entrepreneurDto.getMachineRepairCostHighSeason());
		}

		if(entrepreneurDto.getOtherCostNormalSeason() != null) {
			otherCostNormalSeason.setText(entrepreneurDto.getOtherCostNormalSeason());
		}

		if(entrepreneurDto.getOtherCostHighSeason() != null) {
			otherCostHighSeason.setText(entrepreneurDto.getOtherCostHighSeason());
		}
	}

	public void addListeners() {
		buttonBackIncomeDetails = (Button) findViewById(R.id.buttonBackIncomeDetails);

		buttonBackIncomeDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				Intent intent = new Intent(getApplicationContext(), EntrepreneurActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, entrepreneurDto);
				startActivity(intent);
			}
		});


		buttonNextIncomeDetails = (Button) findViewById(R.id.buttonNextIncomeDetails);

		buttonNextIncomeDetails.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buildEntrepreneurDto();
				//TODO call next activity
				/*Intent intent = new Intent(getApplicationContext(), EntrepreneurActivity.class);
				intent.putExtra(MainActivity.ENTREPRENEUR_DTO, entrepreneurDto);
				startActivity(intent);*/
			}
		});

	}

	public void buildEntrepreneurDto() {
		if(noOfMonthsNormalSeason.getText() != null) {
			entrepreneurDto.setNoOfMonthsNormalSeason(noOfMonthsNormalSeason.getText().toString());
		}

		if(noOfMonthsHighSeason.getText() != null) {
			entrepreneurDto.setNoOfMonthsHighSeason(noOfMonthsHighSeason.getText().toString());
		}

		if(totalSalesCreditNormalSeason.getText() != null) {
			entrepreneurDto.setTotalSalesCreditNormalSeason(totalSalesCreditNormalSeason.getText().toString());
		}

		if(totalSalesCreditHighSeason.getText() != null) {
			entrepreneurDto.setTotalSalesCreditHighSeason(totalSalesCreditHighSeason.getText().toString());
		}

		if(totalSalesCashNormalSeason.getText() != null) {
			entrepreneurDto.setTotalSalesCashNormalSeason(totalSalesCashNormalSeason.getText().toString());
		}

		if(totalSalesCashHighSeason.getText() != null) {
			entrepreneurDto.setTotalSalesCashHighSeason(totalSalesCashHighSeason.getText().toString());
		}

		if(costRawMaterialCashNormalSeason.getText() != null) {
			entrepreneurDto.setCostRawMaterialCashNormalSeason(costRawMaterialCashNormalSeason.getText().toString());
		}

		if(costRawMaterialCashHighSeason.getText() != null) {
			entrepreneurDto.setCostRawMaterialCashHighSeason(costRawMaterialCashHighSeason.getText().toString());
		}

		if(costRawMaterialCreditNormalSeason.getText() != null) {
			entrepreneurDto.setCostRawMaterialCreditNormalSeason(costRawMaterialCreditNormalSeason.getText().toString());
		}

		if(costRawMaterialCreditHighSeason.getText() != null) {
			entrepreneurDto.setCostRawMaterialCreditHighSeason(costRawMaterialCreditHighSeason.getText().toString());
		}

		if(purchaseFrequencyNormalSeason.getText() != null) {
			entrepreneurDto.setPurchaseFrequencyNormalSeason(purchaseFrequencyNormalSeason.getText().toString());
		}

		if(purchaseFrequencyHighSeason.getText() != null) {
			entrepreneurDto.setPurchaseFrequencyHighSeason(purchaseFrequencyHighSeason.getText().toString());
		}

		if(wagesWithdrawnNormalSeason.getText() != null) {
			entrepreneurDto.setWagesWithdrawnNormalSeason(wagesWithdrawnNormalSeason.getText().toString());
		}

		if(wagesWithdrawnHighSeason.getText() != null) {
			entrepreneurDto.setWagesWithdrawnHighSeason(wagesWithdrawnHighSeason.getText().toString());
		}

		if(rentNormalSeason.getText() != null) {
			entrepreneurDto.setRentNormalSeason(rentNormalSeason.getText().toString());
		}

		if(rentHighSeason.getText() != null) {
			entrepreneurDto.setRentHighSeason(rentHighSeason.getText().toString());
		}

		if(electricityCostNormalSeason.getText() != null) {
			entrepreneurDto.setElectricityCostNormalSeason(electricityCostNormalSeason.getText().toString());
		}

		if(electricityCostHighSeason.getText() != null) {
			entrepreneurDto.setElectricityCostHighSeason(electricityCostHighSeason.getText().toString());
		}

		if(transportationCostNormalSeason.getText() != null) {
			entrepreneurDto.setTransportationCostNormalSeason(transportationCostNormalSeason.getText().toString());
		}

		if(transportationHighSeason.getText() != null) {
			entrepreneurDto.setTransportationHighSeason(transportationHighSeason.getText().toString());
		}

		if(packagingCostNormalSeason.getText() != null) {
			entrepreneurDto.setPackagingCostNormalSeason(packagingCostNormalSeason.getText().toString());
		}

		if(packagingCostHighSeason.getText() != null) {
			entrepreneurDto.setPackagingCostHighSeason(packagingCostHighSeason.getText().toString());
		}

		if(fuelCostNormalSeason.getText() != null) {
			entrepreneurDto.setFuelCostNormalSeason(fuelCostNormalSeason.getText().toString());
		}

		if(fuelCostHighSeason.getText() != null) {
			entrepreneurDto.setFuelCostHighSeason(fuelCostHighSeason.getText().toString());
		}

		if(commissionNormalSeason.getText() != null) {
			entrepreneurDto.setCommissionNormalSeason(commissionNormalSeason.getText().toString());
		}

		if(commissionHighSeason.getText() != null) {
			entrepreneurDto.setCommissionHighSeason(commissionHighSeason.getText().toString());
		}

		if(wastageCostNormalSeason.getText() != null) {
			entrepreneurDto.setWastageCostNormalSeason(wastageCostNormalSeason.getText().toString());
		}

		if(wastageCostHighSeason.getText() != null) {
			entrepreneurDto.setWastageCostHighSeason(wastageCostHighSeason.getText().toString());
		}

		if(wagesPaidNormalSeason.getText() != null) {
			entrepreneurDto.setWagesPaidNormalSeason(wagesPaidNormalSeason.getText().toString());
		}

		if(wagesPaidHighSeason.getText() != null) {
			entrepreneurDto.setWagesPaidHighSeason(wagesPaidHighSeason.getText().toString());
		}

		if(promotionCostNormalSeason.getText() != null) {
			entrepreneurDto.setPromotionCostNormalSeason(promotionCostNormalSeason.getText().toString());
		}

		if(promotionCostHighSeason.getText() != null) {
			entrepreneurDto.setPromotionCostHighSeason(promotionCostHighSeason.getText().toString());
		}

		if(communicationCostNormalSeason.getText() != null) {
			entrepreneurDto.setCommunicationCostNormalSeason(communicationCostNormalSeason.getText().toString());
		}

		if(communicationCostHighSeason.getText() != null) {
			entrepreneurDto.setCommunicationCostHighSeason(communicationCostHighSeason.getText().toString());
		}

		if(machineRepairCostNormalSeason.getText() != null) {
			entrepreneurDto.setMachineRepairCostNormalSeason(machineRepairCostNormalSeason.getText().toString());
		}

		if(machineRepairCostHighSeason.getText() != null) {
			entrepreneurDto.setMachineRepairCostHighSeason(machineRepairCostHighSeason.getText().toString());
		}

		if(otherCostNormalSeason.getText() != null) {
			entrepreneurDto.setOtherCostNormalSeason(otherCostNormalSeason.getText().toString());
		}

		if(otherCostHighSeason.getText() != null) {
			entrepreneurDto.setOtherCostHighSeason(otherCostHighSeason.getText().toString());
		}


	}

	public EntrepreneurDto getEntrepreneurDto() {
		return entrepreneurDto;
	}

	public void setEntrepreneurDto(EntrepreneurDto entrepreneurDto) {
		this.entrepreneurDto = entrepreneurDto;
	}
}
