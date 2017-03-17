package gov.com.esurvey.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 3/14/2017.
 */
public class SurveyDto implements Serializable {


	/* Entrepreneur details */

	private String state;
	private String district;
	private String block;
	private String village;

	private String name;
	private String phoneNumber;
	private String startYearOfBusiness;

	private String roadType;
	private String marketType;
	private String shopType;
	private String businessSize;
	private String religion;
	private String caste;

	private List<String> businessTypes = new ArrayList<>();
	private String competitorCount;

	/* Income details */
	private String noOfMonthsNormalSeason;
	private String noOfMonthsHighSeason;

	private String totalSalesCreditNormalSeason;
	private String totalSalesCreditHighSeason;

	private String totalSalesCashNormalSeason;
	private String totalSalesCashHighSeason;

	private String costRawMaterialCashNormalSeason;
	private String costRawMaterialCashHighSeason;


	private String costRawMaterialCreditNormalSeason;
	private String costRawMaterialCreditHighSeason;

	private String purchaseFrequencyNormalSeason;
	private String purchaseFrequencyHighSeason;

	private String wagesWithdrawnNormalSeason;
	private String wagesWithdrawnHighSeason;

	private String rentNormalSeason;
	private String rentHighSeason;

	private String electricityCostNormalSeason;
	private String electricityCostHighSeason;

	private String transportationCostNormalSeason;
	private String transportationHighSeason;

	private String packagingCostNormalSeason;
	private String packagingCostHighSeason;

	private String fuelCostNormalSeason;
	private String fuelCostHighSeason;

	private String commissionNormalSeason;
	private String commissionHighSeason;

	private String wastageCostNormalSeason;
	private String wastageCostHighSeason;

	private String wagesPaidNormalSeason;
	private String wagesPaidHighSeason;

	private String promotionCostNormalSeason;
	private String promotionCostHighSeason;

	private String communicationCostNormalSeason;
	private String communicationCostHighSeason;

	private String machineRepairCostNormalSeason;
	private String machineRepairCostHighSeason;

	private String otherCostNormalSeason;
	private String otherCostHighSeason;

	/* Capital details activity inputs*/
	private String amountReceivedFromCustomer;
	private String amountPaidToSupplied;

	private String amountInvestedInStart;
	private String amountInvestedAfterStart;

	private String operationMonthsInYear;
	private String operationDaysPerWeek;
	private String operationHoursPerWeek;

	private String entrepreneurInvolved;
	private String entrepreneurInvolvedMonths;
	private String familyMembersInvolved;
	private String familyMembersInvolvedMonths;
	private String externalLabourersInvolved;
	private String externalLabourersInvolvedMonths;

	/* Monthly sale trends*/
	private String monthlySaleTrendJanuary;
	private String monthlySaleTrendFebruary;
	private String monthlySaleTrendMarch;
	private String monthlySaleTrendApril;
	private String monthlySaleTrendMay;
	private String monthlySaleTrendJune;
	private String monthlySaleTrendJuly;
	private String monthlySaleTrendAugust;
	private String monthlySaleTrendSeptember;
	private String monthlySaleTrendOctober;
	private String monthlySaleTrendNovember;
	private String monthlySaleTrendDecember;


	private String saleToExternalCustomer;
	private String purchaseByEntrepreneur;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStartYearOfBusiness() {
		return startYearOfBusiness;
	}

	public void setStartYearOfBusiness(String startYearOfBusiness) {
		this.startYearOfBusiness = startYearOfBusiness;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getBusinessSize() {
		return businessSize;
	}

	public void setBusinessSize(String businessSize) {
		this.businessSize = businessSize;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public List<String> getBusinessTypes() {
		return businessTypes;
	}

	public void setBusinessTypes(List<String> businessTypes) {
		this.businessTypes = businessTypes;
	}

	public String getCompetitorCount() {
		return competitorCount;
	}

	public void setCompetitorCount(String competitorCount) {
		this.competitorCount = competitorCount;
	}

	public String getNoOfMonthsNormalSeason() {
		return noOfMonthsNormalSeason;
	}

	public void setNoOfMonthsNormalSeason(String noOfMonthsNormalSeason) {
		this.noOfMonthsNormalSeason = noOfMonthsNormalSeason;
	}

	public String getNoOfMonthsHighSeason() {
		return noOfMonthsHighSeason;
	}

	public void setNoOfMonthsHighSeason(String noOfMonthsHighSeason) {
		this.noOfMonthsHighSeason = noOfMonthsHighSeason;
	}

	public String getTotalSalesCreditNormalSeason() {
		return totalSalesCreditNormalSeason;
	}

	public void setTotalSalesCreditNormalSeason(String totalSalesCreditNormalSeason) {
		this.totalSalesCreditNormalSeason = totalSalesCreditNormalSeason;
	}

	public String getTotalSalesCreditHighSeason() {
		return totalSalesCreditHighSeason;
	}

	public void setTotalSalesCreditHighSeason(String totalSalesCreditHighSeason) {
		this.totalSalesCreditHighSeason = totalSalesCreditHighSeason;
	}

	public String getTotalSalesCashNormalSeason() {
		return totalSalesCashNormalSeason;
	}

	public void setTotalSalesCashNormalSeason(String totalSalesCashNormalSeason) {
		this.totalSalesCashNormalSeason = totalSalesCashNormalSeason;
	}

	public String getTotalSalesCashHighSeason() {
		return totalSalesCashHighSeason;
	}

	public void setTotalSalesCashHighSeason(String totalSalesCashHighSeason) {
		this.totalSalesCashHighSeason = totalSalesCashHighSeason;
	}

	public String getCostRawMaterialCashNormalSeason() {
		return costRawMaterialCashNormalSeason;
	}

	public void setCostRawMaterialCashNormalSeason(String costRawMaterialCashNormalSeason) {
		this.costRawMaterialCashNormalSeason = costRawMaterialCashNormalSeason;
	}

	public String getCostRawMaterialCashHighSeason() {
		return costRawMaterialCashHighSeason;
	}

	public void setCostRawMaterialCashHighSeason(String costRawMaterialCashHighSeason) {
		this.costRawMaterialCashHighSeason = costRawMaterialCashHighSeason;
	}

	public String getCostRawMaterialCreditNormalSeason() {
		return costRawMaterialCreditNormalSeason;
	}

	public void setCostRawMaterialCreditNormalSeason(String costRawMaterialCreditNormalSeason) {
		this.costRawMaterialCreditNormalSeason = costRawMaterialCreditNormalSeason;
	}

	public String getCostRawMaterialCreditHighSeason() {
		return costRawMaterialCreditHighSeason;
	}

	public void setCostRawMaterialCreditHighSeason(String costRawMaterialCreditHighSeason) {
		this.costRawMaterialCreditHighSeason = costRawMaterialCreditHighSeason;
	}

	public String getPurchaseFrequencyNormalSeason() {
		return purchaseFrequencyNormalSeason;
	}

	public void setPurchaseFrequencyNormalSeason(String purchaseFrequencyNormalSeason) {
		this.purchaseFrequencyNormalSeason = purchaseFrequencyNormalSeason;
	}

	public String getPurchaseFrequencyHighSeason() {
		return purchaseFrequencyHighSeason;
	}

	public void setPurchaseFrequencyHighSeason(String purchaseFrequencyHighSeason) {
		this.purchaseFrequencyHighSeason = purchaseFrequencyHighSeason;
	}

	public String getWagesWithdrawnNormalSeason() {
		return wagesWithdrawnNormalSeason;
	}

	public void setWagesWithdrawnNormalSeason(String wagesWithdrawnNormalSeason) {
		this.wagesWithdrawnNormalSeason = wagesWithdrawnNormalSeason;
	}

	public String getWagesWithdrawnHighSeason() {
		return wagesWithdrawnHighSeason;
	}

	public void setWagesWithdrawnHighSeason(String wagesWithdrawnHighSeason) {
		this.wagesWithdrawnHighSeason = wagesWithdrawnHighSeason;
	}

	public String getRentNormalSeason() {
		return rentNormalSeason;
	}

	public void setRentNormalSeason(String rentNormalSeason) {
		this.rentNormalSeason = rentNormalSeason;
	}

	public String getRentHighSeason() {
		return rentHighSeason;
	}

	public void setRentHighSeason(String rentHighSeason) {
		this.rentHighSeason = rentHighSeason;
	}

	public String getElectricityCostNormalSeason() {
		return electricityCostNormalSeason;
	}

	public void setElectricityCostNormalSeason(String electricityCostNormalSeason) {
		this.electricityCostNormalSeason = electricityCostNormalSeason;
	}

	public String getElectricityCostHighSeason() {
		return electricityCostHighSeason;
	}

	public void setElectricityCostHighSeason(String electricityCostHighSeason) {
		this.electricityCostHighSeason = electricityCostHighSeason;
	}

	public String getTransportationCostNormalSeason() {
		return transportationCostNormalSeason;
	}

	public void setTransportationCostNormalSeason(String transportationCostNormalSeason) {
		this.transportationCostNormalSeason = transportationCostNormalSeason;
	}

	public String getTransportationHighSeason() {
		return transportationHighSeason;
	}

	public void setTransportationHighSeason(String transportationHighSeason) {
		this.transportationHighSeason = transportationHighSeason;
	}

	public String getPackagingCostNormalSeason() {
		return packagingCostNormalSeason;
	}

	public void setPackagingCostNormalSeason(String packagingCostNormalSeason) {
		this.packagingCostNormalSeason = packagingCostNormalSeason;
	}

	public String getPackagingCostHighSeason() {
		return packagingCostHighSeason;
	}

	public void setPackagingCostHighSeason(String packagingCostHighSeason) {
		this.packagingCostHighSeason = packagingCostHighSeason;
	}

	public String getFuelCostNormalSeason() {
		return fuelCostNormalSeason;
	}

	public void setFuelCostNormalSeason(String fuelCostNormalSeason) {
		this.fuelCostNormalSeason = fuelCostNormalSeason;
	}

	public String getFuelCostHighSeason() {
		return fuelCostHighSeason;
	}

	public void setFuelCostHighSeason(String fuelCostHighSeason) {
		this.fuelCostHighSeason = fuelCostHighSeason;
	}

	public String getCommissionNormalSeason() {
		return commissionNormalSeason;
	}

	public void setCommissionNormalSeason(String commissionNormalSeason) {
		this.commissionNormalSeason = commissionNormalSeason;
	}

	public String getCommissionHighSeason() {
		return commissionHighSeason;
	}

	public void setCommissionHighSeason(String commissionHighSeason) {
		this.commissionHighSeason = commissionHighSeason;
	}

	public String getWastageCostNormalSeason() {
		return wastageCostNormalSeason;
	}

	public void setWastageCostNormalSeason(String wastageCostNormalSeason) {
		this.wastageCostNormalSeason = wastageCostNormalSeason;
	}

	public String getWastageCostHighSeason() {
		return wastageCostHighSeason;
	}

	public void setWastageCostHighSeason(String wastageCostHighSeason) {
		this.wastageCostHighSeason = wastageCostHighSeason;
	}

	public String getWagesPaidNormalSeason() {
		return wagesPaidNormalSeason;
	}

	public void setWagesPaidNormalSeason(String wagesPaidNormalSeason) {
		this.wagesPaidNormalSeason = wagesPaidNormalSeason;
	}

	public String getWagesPaidHighSeason() {
		return wagesPaidHighSeason;
	}

	public void setWagesPaidHighSeason(String wagesPaidHighSeason) {
		this.wagesPaidHighSeason = wagesPaidHighSeason;
	}

	public String getPromotionCostNormalSeason() {
		return promotionCostNormalSeason;
	}

	public void setPromotionCostNormalSeason(String promotionCostNormalSeason) {
		this.promotionCostNormalSeason = promotionCostNormalSeason;
	}

	public String getPromotionCostHighSeason() {
		return promotionCostHighSeason;
	}

	public void setPromotionCostHighSeason(String promotionCostHighSeason) {
		this.promotionCostHighSeason = promotionCostHighSeason;
	}

	public String getCommunicationCostNormalSeason() {
		return communicationCostNormalSeason;
	}

	public void setCommunicationCostNormalSeason(String communicationCostNormalSeason) {
		this.communicationCostNormalSeason = communicationCostNormalSeason;
	}

	public String getCommunicationCostHighSeason() {
		return communicationCostHighSeason;
	}

	public void setCommunicationCostHighSeason(String communicationCostHighSeason) {
		this.communicationCostHighSeason = communicationCostHighSeason;
	}

	public String getMachineRepairCostNormalSeason() {
		return machineRepairCostNormalSeason;
	}

	public void setMachineRepairCostNormalSeason(String machineRepairCostNormalSeason) {
		this.machineRepairCostNormalSeason = machineRepairCostNormalSeason;
	}

	public String getMachineRepairCostHighSeason() {
		return machineRepairCostHighSeason;
	}

	public void setMachineRepairCostHighSeason(String machineRepairCostHighSeason) {
		this.machineRepairCostHighSeason = machineRepairCostHighSeason;
	}

	public String getOtherCostNormalSeason() {
		return otherCostNormalSeason;
	}

	public void setOtherCostNormalSeason(String otherCostNormalSeason) {
		this.otherCostNormalSeason = otherCostNormalSeason;
	}

	public String getOtherCostHighSeason() {
		return otherCostHighSeason;
	}

	public void setOtherCostHighSeason(String otherCostHighSeason) {
		this.otherCostHighSeason = otherCostHighSeason;
	}

	public String getAmountReceivedFromCustomer() {
		return amountReceivedFromCustomer;
	}

	public void setAmountReceivedFromCustomer(String amountReceivedFromCustomer) {
		this.amountReceivedFromCustomer = amountReceivedFromCustomer;
	}

	public String getAmountPaidToSupplied() {
		return amountPaidToSupplied;
	}

	public void setAmountPaidToSupplied(String amountPaidToSupplied) {
		this.amountPaidToSupplied = amountPaidToSupplied;
	}

	public String getAmountInvestedInStart() {
		return amountInvestedInStart;
	}

	public void setAmountInvestedInStart(String amountInvestedInStart) {
		this.amountInvestedInStart = amountInvestedInStart;
	}

	public String getAmountInvestedAfterStart() {
		return amountInvestedAfterStart;
	}

	public void setAmountInvestedAfterStart(String amountInvestedAfterStart) {
		this.amountInvestedAfterStart = amountInvestedAfterStart;
	}

	public String getOperationMonthsInYear() {
		return operationMonthsInYear;
	}

	public void setOperationMonthsInYear(String operationMonthsInYear) {
		this.operationMonthsInYear = operationMonthsInYear;
	}

	public String getOperationDaysPerWeek() {
		return operationDaysPerWeek;
	}

	public void setOperationDaysPerWeek(String operationDaysPerWeek) {
		this.operationDaysPerWeek = operationDaysPerWeek;
	}

	public String getOperationHoursPerWeek() {
		return operationHoursPerWeek;
	}

	public void setOperationHoursPerWeek(String operationHoursPerWeek) {
		this.operationHoursPerWeek = operationHoursPerWeek;
	}

	public String getEntrepreneurInvolved() {
		return entrepreneurInvolved;
	}

	public void setEntrepreneurInvolved(String entrepreneurInvolved) {
		this.entrepreneurInvolved = entrepreneurInvolved;
	}

	public String getEntrepreneurInvolvedMonths() {
		return entrepreneurInvolvedMonths;
	}

	public void setEntrepreneurInvolvedMonths(String entrepreneurInvolvedMonths) {
		this.entrepreneurInvolvedMonths = entrepreneurInvolvedMonths;
	}

	public String getFamilyMembersInvolved() {
		return familyMembersInvolved;
	}

	public void setFamilyMembersInvolved(String familyMembersInvolved) {
		this.familyMembersInvolved = familyMembersInvolved;
	}

	public String getFamilyMembersInvolvedMonths() {
		return familyMembersInvolvedMonths;
	}

	public void setFamilyMembersInvolvedMonths(String familyMembersInvolvedMonths) {
		this.familyMembersInvolvedMonths = familyMembersInvolvedMonths;
	}

	public String getExternalLabourersInvolved() {
		return externalLabourersInvolved;
	}

	public void setExternalLabourersInvolved(String externalLabourersInvolved) {
		this.externalLabourersInvolved = externalLabourersInvolved;
	}

	public String getExternalLabourersInvolvedMonths() {
		return externalLabourersInvolvedMonths;
	}

	public void setExternalLabourersInvolvedMonths(String externalLabourersInvolvedMonths) {
		this.externalLabourersInvolvedMonths = externalLabourersInvolvedMonths;
	}

	public String getMonthlySaleTrendJanuary() {
		return monthlySaleTrendJanuary;
	}

	public void setMonthlySaleTrendJanuary(String monthlySaleTrendJanuary) {
		this.monthlySaleTrendJanuary = monthlySaleTrendJanuary;
	}

	public String getMonthlySaleTrendFebruary() {
		return monthlySaleTrendFebruary;
	}

	public void setMonthlySaleTrendFebruary(String monthlySaleTrendFebruary) {
		this.monthlySaleTrendFebruary = monthlySaleTrendFebruary;
	}

	public String getMonthlySaleTrendMarch() {
		return monthlySaleTrendMarch;
	}

	public void setMonthlySaleTrendMarch(String monthlySaleTrendMarch) {
		this.monthlySaleTrendMarch = monthlySaleTrendMarch;
	}

	public String getMonthlySaleTrendApril() {
		return monthlySaleTrendApril;
	}

	public void setMonthlySaleTrendApril(String monthlySaleTrendApril) {
		this.monthlySaleTrendApril = monthlySaleTrendApril;
	}

	public String getMonthlySaleTrendMay() {
		return monthlySaleTrendMay;
	}

	public void setMonthlySaleTrendMay(String monthlySaleTrendMay) {
		this.monthlySaleTrendMay = monthlySaleTrendMay;
	}

	public String getMonthlySaleTrendJune() {
		return monthlySaleTrendJune;
	}

	public void setMonthlySaleTrendJune(String monthlySaleTrendJune) {
		this.monthlySaleTrendJune = monthlySaleTrendJune;
	}

	public String getMonthlySaleTrendJuly() {
		return monthlySaleTrendJuly;
	}

	public void setMonthlySaleTrendJuly(String monthlySaleTrendJuly) {
		this.monthlySaleTrendJuly = monthlySaleTrendJuly;
	}

	public String getMonthlySaleTrendAugust() {
		return monthlySaleTrendAugust;
	}

	public void setMonthlySaleTrendAugust(String monthlySaleTrendAugust) {
		this.monthlySaleTrendAugust = monthlySaleTrendAugust;
	}

	public String getMonthlySaleTrendSeptember() {
		return monthlySaleTrendSeptember;
	}

	public void setMonthlySaleTrendSeptember(String monthlySaleTrendSeptember) {
		this.monthlySaleTrendSeptember = monthlySaleTrendSeptember;
	}

	public String getMonthlySaleTrendOctober() {
		return monthlySaleTrendOctober;
	}

	public void setMonthlySaleTrendOctober(String monthlySaleTrendOctober) {
		this.monthlySaleTrendOctober = monthlySaleTrendOctober;
	}

	public String getMonthlySaleTrendNovember() {
		return monthlySaleTrendNovember;
	}

	public void setMonthlySaleTrendNovember(String monthlySaleTrendNovember) {
		this.monthlySaleTrendNovember = monthlySaleTrendNovember;
	}

	public String getMonthlySaleTrendDecember() {
		return monthlySaleTrendDecember;
	}

	public void setMonthlySaleTrendDecember(String monthlySaleTrendDecember) {
		this.monthlySaleTrendDecember = monthlySaleTrendDecember;
	}

	public String getSaleToExternalCustomer() {
		return saleToExternalCustomer;
	}

	public void setSaleToExternalCustomer(String saleToExternalCustomer) {
		this.saleToExternalCustomer = saleToExternalCustomer;
	}

	public String getPurchaseByEntrepreneur() {
		return purchaseByEntrepreneur;
	}

	public void setPurchaseByEntrepreneur(String purchaseByEntrepreneur) {
		this.purchaseByEntrepreneur = purchaseByEntrepreneur;
	}

	@Override
	public String toString() {
		return "SurveyDto{" + "state='" + state + '\'' + ", district='" + district + '\'' + ", block='" + block + '\'' + ", village='"
				+ village + '\'' + ", name='" + name + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", startYearOfBusiness='"
				+ startYearOfBusiness + '\'' + ", roadType='" + roadType + '\'' + ", marketType='" + marketType + '\'' + ", shopType='"
				+ shopType + '\'' + ", businessSize='" + businessSize + '\'' + ", religion='" + religion + '\'' + ", caste='" + caste + '\''
				+ ", businessTypes=" + businessTypes + ", competitorCount='" + competitorCount + '\'' + ", noOfMonthsNormalSeason='"
				+ noOfMonthsNormalSeason + '\'' + ", noOfMonthsHighSeason='" + noOfMonthsHighSeason + '\''
				+ ", totalSalesCreditNormalSeason='" + totalSalesCreditNormalSeason + '\'' + ", totalSalesCreditHighSeason='"
				+ totalSalesCreditHighSeason + '\'' + ", totalSalesCashNormalSeason='" + totalSalesCashNormalSeason + '\''
				+ ", totalSalesCashHighSeason='" + totalSalesCashHighSeason + '\'' + ", costRawMaterialCashNormalSeason='"
				+ costRawMaterialCashNormalSeason + '\'' + ", costRawMaterialCashHighSeason='" + costRawMaterialCashHighSeason + '\''
				+ ", costRawMaterialCreditNormalSeason='" + costRawMaterialCreditNormalSeason + '\'' + ", costRawMaterialCreditHighSeason='"
				+ costRawMaterialCreditHighSeason + '\'' + ", purchaseFrequencyNormalSeason='" + purchaseFrequencyNormalSeason + '\''
				+ ", purchaseFrequencyHighSeason='" + purchaseFrequencyHighSeason + '\'' + ", wagesWithdrawnNormalSeason='"
				+ wagesWithdrawnNormalSeason + '\'' + ", wagesWithdrawnHighSeason='" + wagesWithdrawnHighSeason + '\''
				+ ", rentNormalSeason='" + rentNormalSeason + '\'' + ", rentHighSeason='" + rentHighSeason + '\''
				+ ", electricityCostNormalSeason='" + electricityCostNormalSeason + '\'' + ", electricityCostHighSeason='"
				+ electricityCostHighSeason + '\'' + ", transportationCostNormalSeason='" + transportationCostNormalSeason + '\''
				+ ", transportationHighSeason='" + transportationHighSeason + '\'' + ", packagingCostNormalSeason='"
				+ packagingCostNormalSeason + '\'' + ", packagingCostHighSeason='" + packagingCostHighSeason + '\''
				+ ", fuelCostNormalSeason='" + fuelCostNormalSeason + '\'' + ", fuelCostHighSeason='" + fuelCostHighSeason + '\''
				+ ", commissionNormalSeason='" + commissionNormalSeason + '\'' + ", commissionHighSeason='" + commissionHighSeason + '\''
				+ ", wastageCostNormalSeason='" + wastageCostNormalSeason + '\'' + ", wastageCostHighSeason='" + wastageCostHighSeason
				+ '\'' + ", wagesPaidNormalSeason='" + wagesPaidNormalSeason + '\'' + ", wagesPaidHighSeason='" + wagesPaidHighSeason + '\''
				+ ", promotionCostNormalSeason='" + promotionCostNormalSeason + '\'' + ", promotionCostHighSeason='"
				+ promotionCostHighSeason + '\'' + ", communicationCostNormalSeason='" + communicationCostNormalSeason + '\''
				+ ", communicationCostHighSeason='" + communicationCostHighSeason + '\'' + ", machineRepairCostNormalSeason='"
				+ machineRepairCostNormalSeason + '\'' + ", machineRepairCostHighSeason='" + machineRepairCostHighSeason + '\''
				+ ", otherCostNormalSeason='" + otherCostNormalSeason + '\'' + ", otherCostHighSeason='" + otherCostHighSeason + '\''
				+ ", amountReceivedFromCustomer='" + amountReceivedFromCustomer + '\'' + ", amountPaidToSupplied='" + amountPaidToSupplied
				+ '\'' + ", amountInvestedInStart='" + amountInvestedInStart + '\'' + ", amountInvestedAfterStart='"
				+ amountInvestedAfterStart + '\'' + ", operationMonthsInYear='" + operationMonthsInYear + '\'' + ", operationDaysPerWeek='"
				+ operationDaysPerWeek + '\'' + ", operationHoursPerWeek='" + operationHoursPerWeek + '\'' + ", entrepreneurInvolved='"
				+ entrepreneurInvolved + '\'' + ", entrepreneurInvolvedMonths='" + entrepreneurInvolvedMonths + '\''
				+ ", familyMembersInvolved='" + familyMembersInvolved + '\'' + ", familyMembersInvolvedMonths='"
				+ familyMembersInvolvedMonths + '\'' + ", externalLabourersInvolved='" + externalLabourersInvolved + '\''
				+ ", externalLabourersInvolvedMonths='" + externalLabourersInvolvedMonths + '\'' + ", monthlySaleTrendJanuary='"
				+ monthlySaleTrendJanuary + '\'' + ", monthlySaleTrendFebruary='" + monthlySaleTrendFebruary + '\''
				+ ", monthlySaleTrendMarch='" + monthlySaleTrendMarch + '\'' + ", monthlySaleTrendApril='" + monthlySaleTrendApril + '\''
				+ ", monthlySaleTrendMay='" + monthlySaleTrendMay + '\'' + ", monthlySaleTrendJune='" + monthlySaleTrendJune + '\''
				+ ", monthlySaleTrendJuly='" + monthlySaleTrendJuly + '\'' + ", monthlySaleTrendAugust='" + monthlySaleTrendAugust + '\''
				+ ", monthlySaleTrendSeptember='" + monthlySaleTrendSeptember + '\'' + ", monthlySaleTrendOctober='"
				+ monthlySaleTrendOctober + '\'' + ", monthlySaleTrendNovember='" + monthlySaleTrendNovember + '\''
				+ ", monthlySaleTrendDecember='" + monthlySaleTrendDecember + '\'' + ", saleToExternalCustomer='" + saleToExternalCustomer
				+ '\'' + ", purchaseByEntrepreneur='" + purchaseByEntrepreneur + '\'' + '}';
	}
}
