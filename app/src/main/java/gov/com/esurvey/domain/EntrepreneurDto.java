package gov.com.esurvey.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Abhishek on 3/14/2017.
 */
public class EntrepreneurDto implements Serializable {


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

	private List<String> businessTypes;
	private String competitorCount;

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
}
