package gov.com.esurvey.database;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import gov.com.esurvey.domain.SurveyDto;

/**
 * Created by Abhishek on 3/16/2017.
 */
public class SurveyDAOManager {

	// Table Name
	public static final String TABLE_NAME = "SURVEYS";

	// Table columns
	public static final String _ID = "_id";


	public static final String STATE = "state";
	public static final String DISTRICT = "district";
	public static final String BLOCK = "block";
	public static final String VILLAGE = "village";
	public static final String NAME = "name";
	public static final String PHONE_NUMBER = "phone_number";
	public static final String BUSINESS_START_YEAR = "business_start_year";
	public static final String ROAD_TYPE = "road_type";
	public static final String MARKET_TYPE = "market_type";
	public static final String SHOP_TYPE = "shop_type";
	public static final String BUSINESS_SIZE = "business_size";
	public static final String RELIGION = "religion";
	public static final String CASTE = "caste";
	public static final String BUSINESS_TYPES = "business_types";
	public static final String COMPETITOR_COUNT = "competitor_count";
	public static final String NO_MONTHS_NORMAL = "no_months_normal";
	public static final String NO_MONTHS_HIGH = "no_months_high";
	public static final String TOTAL_SALES_CREDIT_NORMAL = "total_sales_credit_normal";
	public static final String TOTAL_SALES_CREDIT_HIGH = "total_sales_credit_high";
	public static final String TOTAL_SALES_CASH_NORMAL = "total_sales_cash_normal";
	public static final String TOTAL_SALES_CASH_HIGH = "total_sales_cash_high";
	public static final String COST_RAW_CASH_NORMAL = "cost_raw_cash_normal";
	public static final String COST_RAW_CASH_HIGH = "cost_raw_cash_high";
	public static final String COST_RAW_CREDIT_NORMAL = "cost_raw_credit_normal";
	public static final String COST_RAW_CREDIT_HIGH = "cost_raw_credit_high";
	public static final String PURCHASE_FREQUENCY_NORMAL = "purchase_frequency_normal";
	public static final String PURCHASE_FREQUENCY_HIGH = "purchase_frequency_high";
	public static final String WAGES_WITHDRAWN_NORMAL = "wages_withdrawn_normal";
	public static final String WAGES_WITHDRAWN_HIGH = "wages_withdrawn_high";
	public static final String RENT_NORMAL = "rent_normal";
	public static final String RENT_HIGH = "rent_high";
	public static final String COST_ELECTRICITY_NORMAL = "cost_electricity_normal";
	public static final String COST_ELECTRICITY_HIGH = "cost_electricity_high";
	public static final String COST_TRANSPORTATION_NORMAL = "cost_transportation_normal";
	public static final String COST_TRANSPORTATION_HIGH = "cost_transportation_high";
	public static final String COST_PACKAGING_NORMAL = "cost_packaging_normal";
	public static final String COST_PACKAGING_HIGH = "cost_packaging_high";
	public static final String COST_FUEL_NORMAL = "cost_fuel_normal";
	public static final String COST_FUEL_HIGH = "cost_fuel_high";
	public static final String COMMISSION_NORMAL = "commission_normal";
	public static final String COMMISSION_HIGH = "commission_high";
	public static final String COST_WASTAGE_NORMAL = "cost_wastage_normal";
	public static final String COST_WASTAGE_HIGH = "cost_wastage_high";
	public static final String WAGES_PAID_NORMAL = "wages_paid_normal";
	public static final String WAGES_PAID_HIGH = "wages_paid_high";
	public static final String COST_PROMOTION_NORMAL = "cost_promotion_normal";
	public static final String COST_PROMOTION_HIGH = "cost_promotion_high";
	public static final String COST_COMMUNICATION_NORMAL = "cost_communication_normal";
	public static final String COST_COMMUNICATION_HIGH = "cost_communication_high";
	public static final String COST_MACHINE_REPAIR_NORMAL = "cost_machine_repair_normal";
	public static final String COST_MACHINE_REPAIR_HIGH = "cost_machine_repair_high";
	public static final String COST_OTHER_NORMAL = "cost_other_normal";
	public static final String COST_OTHER_HIGH = "cost_other_high";
	public static final String AMOUNT_RECEIVED_FROM_CUSTOMER = "amount_received_from_customer";
	public static final String AMOUNT_PAID_TO_SUPPLIER = "amount_paid_to_supplier";
	public static final String AMOUNT_INVESTED_IN_START = "amount_invested_in_start";
	public static final String AMOUNT_INVESTED_AFTER_START = "amount_paid_after_supplier";
	public static final String OPERATION_MONTHS_YEAR = "operation_months_year";
	public static final String OPERATION_DAYS_WEEK = "operation_days_week";
	public static final String OPERATION_HOURS_WEEK = "operation_hours_week";
	public static final String ENTREPRENEUR_INVOLVED = "entrepreneur_involved";
	public static final String ENTREPRENEUR_INVOLVED_MONTH = "entrepreneur_involved_month";
	public static final String FAMILY_MEMBERS_INVOLVED = "family_members_involved";
	public static final String FAMILY_MEMBERS_INVOLVED_MONTH = "family_members_involved_month";
	public static final String EXTERNAL_LABOURS_INVOLVED = "external_labours_involved";
	public static final String EXTERNAL_LABOURS_INVOLVED_MONTH = "external_labours_involved_month";
	public static final String SALARY_TREND_JANUARY = "salary_trend_january";
	public static final String SALARY_TREND_FEBRUARY = "salary_trend_february";
	public static final String SALARY_TREND_MARCH = "salary_trend_march";
	public static final String SALARY_TREND_APRIL = "salary_trend_april";
	public static final String SALARY_TREND_MAY = "salary_trend_may";
	public static final String SALARY_TREND_JUNE = "salary_trend_june";
	public static final String SALARY_TREND_JULY = "salary_trend_july";
	public static final String SALARY_TREND_AUGUST = "salary_trend_august";
	public static final String SALARY_TREND_SEPTEMBER = "salary_trend_september";
	public static final String SALARY_TREND_OCTOBER = "salary_trend_october";
	public static final String SALARY_TREND_NOVEMBER = "salary_trend_november";
	public static final String SALARY_TREND_DECEMBER = "salary_trend_december";
	public static final String SALE_EXTERNAL_CUSTOMER = "sale_external_customer";
	public static final String PURCHASE_BY_ENTREPRENEUR = "purchase_by_entrepreneur";


	public static final String CREATED_DATE = "created_date";
	public static final String SYNC_STATUS = "sync_status";
	public static final String SYNC_DATE = "sync_date";


	public static final String SYNC_STATUS_PENDING = "PENDING";
	public static final String SYNC_STATUS_SYNCED = "SYNCED";

	private DatabaseHelper dbHelper;

	private Context context;

	private SQLiteDatabase database;

	public static String createTableQuery() {
		StringBuilder builder = new StringBuilder();
		builder.append("create table ");
		builder.append(TABLE_NAME);
		builder.append(" ( ");
		builder.append(_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT ");
		builder.append(",").append(STATE).append(" TEXT NOT NULL ");
		builder.append(",").append(DISTRICT).append(" TEXT NOT NULL ");
		builder.append(",").append(BLOCK).append(" TEXT NOT NULL ");
		builder.append(",").append(VILLAGE).append(" TEXT NOT NULL ");
		builder.append(",").append(NAME).append(" TEXT ");
		builder.append(",").append(PHONE_NUMBER).append(" TEXT ");
		builder.append(",").append(BUSINESS_START_YEAR).append(" TEXT ");
		builder.append(",").append(ROAD_TYPE).append(" TEXT NOT NULL ");
		builder.append(",").append(MARKET_TYPE).append(" TEXT NOT NULL ");
		builder.append(",").append(SHOP_TYPE).append(" TEXT NOT NULL ");
		builder.append(",").append(BUSINESS_SIZE).append(" TEXT NOT NULL ");
		builder.append(",").append(RELIGION).append(" TEXT ");
		builder.append(",").append(CASTE).append(" TEXT ");
		builder.append(",").append(BUSINESS_TYPES).append(" TEXT ");
		builder.append(",").append(COMPETITOR_COUNT).append(" TEXT ");
		builder.append(",").append(NO_MONTHS_NORMAL).append(" TEXT ");
		builder.append(",").append(NO_MONTHS_HIGH).append(" TEXT ");
		builder.append(",").append(TOTAL_SALES_CREDIT_NORMAL).append(" TEXT ");
		builder.append(",").append(TOTAL_SALES_CREDIT_HIGH).append(" TEXT ");
		builder.append(",").append(TOTAL_SALES_CASH_NORMAL).append(" TEXT ");
		builder.append(",").append(TOTAL_SALES_CASH_HIGH).append(" TEXT ");
		builder.append(",").append(COST_RAW_CASH_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_RAW_CASH_HIGH).append(" TEXT ");
		builder.append(",").append(COST_RAW_CREDIT_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_RAW_CREDIT_HIGH).append(" TEXT ");
		builder.append(",").append(PURCHASE_FREQUENCY_NORMAL).append(" TEXT ");
		builder.append(",").append(PURCHASE_FREQUENCY_HIGH).append(" TEXT ");
		builder.append(",").append(WAGES_WITHDRAWN_NORMAL).append(" TEXT ");
		builder.append(",").append(WAGES_WITHDRAWN_HIGH).append(" TEXT ");
		builder.append(",").append(RENT_NORMAL).append(" TEXT ");
		builder.append(",").append(RENT_HIGH).append(" TEXT ");
		builder.append(",").append(COST_ELECTRICITY_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_ELECTRICITY_HIGH).append(" TEXT ");
		builder.append(",").append(COST_TRANSPORTATION_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_TRANSPORTATION_HIGH).append(" TEXT ");
		builder.append(",").append(COST_PACKAGING_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_PACKAGING_HIGH).append(" TEXT ");
		builder.append(",").append(COST_FUEL_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_FUEL_HIGH).append(" TEXT ");
		builder.append(",").append(COMMISSION_NORMAL).append(" TEXT ");
		builder.append(",").append(COMMISSION_HIGH).append(" TEXT ");
		builder.append(",").append(COST_WASTAGE_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_WASTAGE_HIGH).append(" TEXT ");
		builder.append(",").append(WAGES_PAID_NORMAL).append(" TEXT ");
		builder.append(",").append(WAGES_PAID_HIGH).append(" TEXT ");
		builder.append(",").append(COST_PROMOTION_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_PROMOTION_HIGH).append(" TEXT ");
		builder.append(",").append(COST_COMMUNICATION_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_COMMUNICATION_HIGH).append(" TEXT ");
		builder.append(",").append(COST_MACHINE_REPAIR_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_MACHINE_REPAIR_HIGH).append(" TEXT ");
		builder.append(",").append(COST_OTHER_NORMAL).append(" TEXT ");
		builder.append(",").append(COST_OTHER_HIGH).append(" TEXT ");
		builder.append(",").append(AMOUNT_RECEIVED_FROM_CUSTOMER).append(" TEXT ");
		builder.append(",").append(AMOUNT_PAID_TO_SUPPLIER).append(" TEXT ");
		builder.append(",").append(AMOUNT_INVESTED_IN_START).append(" TEXT ");
		builder.append(",").append(AMOUNT_INVESTED_AFTER_START).append(" TEXT ");
		builder.append(",").append(OPERATION_MONTHS_YEAR).append(" TEXT ");
		builder.append(",").append(OPERATION_DAYS_WEEK).append(" TEXT ");
		builder.append(",").append(OPERATION_HOURS_WEEK).append(" TEXT ");
		builder.append(",").append(ENTREPRENEUR_INVOLVED).append(" TEXT ");
		builder.append(",").append(ENTREPRENEUR_INVOLVED_MONTH).append(" TEXT ");
		builder.append(",").append(FAMILY_MEMBERS_INVOLVED).append(" TEXT ");
		builder.append(",").append(FAMILY_MEMBERS_INVOLVED_MONTH).append(" TEXT ");
		builder.append(",").append(EXTERNAL_LABOURS_INVOLVED).append(" TEXT ");
		builder.append(",").append(EXTERNAL_LABOURS_INVOLVED_MONTH).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_JANUARY).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_FEBRUARY).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_MARCH).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_APRIL).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_MAY).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_JUNE).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_JULY).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_AUGUST).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_SEPTEMBER).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_OCTOBER).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_NOVEMBER).append(" TEXT ");
		builder.append(",").append(SALARY_TREND_DECEMBER).append(" TEXT ");
		builder.append(",").append(SALE_EXTERNAL_CUSTOMER).append(" TEXT ");
		builder.append(",").append(PURCHASE_BY_ENTREPRENEUR).append(" TEXT ");

		builder.append(",").append(CREATED_DATE).append(" TEXT ");
		builder.append(",").append(SYNC_STATUS).append(" TEXT ");
		builder.append(",").append(SYNC_DATE).append(" TEXT ");


		builder.append(" );");

		return builder.toString();
	}

	public SurveyDAOManager(Context c) {
		context = c;
	}

	public SurveyDAOManager open() throws SQLException {
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	public long insert(final SurveyDto surveyDto) {
		ContentValues contentValue = new ContentValues();

		contentValue.put(STATE, surveyDto.getState());
		contentValue.put(DISTRICT, surveyDto.getDistrict());
		contentValue.put(BLOCK, surveyDto.getBlock());
		contentValue.put(VILLAGE, surveyDto.getVillage());
		contentValue.put(NAME, surveyDto.getName());
		contentValue.put(PHONE_NUMBER, surveyDto.getPhoneNumber());
		contentValue.put(BUSINESS_START_YEAR, surveyDto.getStartYearOfBusiness());
		contentValue.put(ROAD_TYPE, surveyDto.getRoadType());
		contentValue.put(MARKET_TYPE, surveyDto.getMarketType());
		contentValue.put(SHOP_TYPE, surveyDto.getShopType());
		contentValue.put(BUSINESS_SIZE, surveyDto.getBusinessSize());
		contentValue.put(RELIGION, surveyDto.getReligion());
		contentValue.put(CASTE, surveyDto.getCaste());
		contentValue.put(BUSINESS_TYPES, TextUtils.join(",", surveyDto.getBusinessTypes()));
		contentValue.put(COMPETITOR_COUNT, surveyDto.getCompetitorCount());
		contentValue.put(NO_MONTHS_NORMAL, surveyDto.getNoOfMonthsNormalSeason());
		contentValue.put(NO_MONTHS_HIGH, surveyDto.getNoOfMonthsHighSeason());
		contentValue.put(TOTAL_SALES_CREDIT_NORMAL, surveyDto.getTotalSalesCreditNormalSeason());
		contentValue.put(TOTAL_SALES_CREDIT_HIGH, surveyDto.getTotalSalesCreditHighSeason());
		contentValue.put(TOTAL_SALES_CASH_NORMAL, surveyDto.getTotalSalesCashNormalSeason());
		contentValue.put(TOTAL_SALES_CASH_HIGH, surveyDto.getTotalSalesCashNormalSeason());
		contentValue.put(COST_RAW_CASH_NORMAL, surveyDto.getCostRawMaterialCashNormalSeason());
		contentValue.put(COST_RAW_CASH_HIGH, surveyDto.getCostRawMaterialCashHighSeason());
		contentValue.put(COST_RAW_CREDIT_NORMAL, surveyDto.getCostRawMaterialCreditNormalSeason());
		contentValue.put(COST_RAW_CREDIT_HIGH, surveyDto.getCostRawMaterialCreditHighSeason());
		contentValue.put(PURCHASE_FREQUENCY_NORMAL, surveyDto.getPurchaseFrequencyNormalSeason());
		contentValue.put(PURCHASE_FREQUENCY_HIGH, surveyDto.getPurchaseFrequencyHighSeason());
		contentValue.put(WAGES_WITHDRAWN_NORMAL, surveyDto.getWagesWithdrawnNormalSeason());
		contentValue.put(WAGES_WITHDRAWN_HIGH, surveyDto.getWagesWithdrawnHighSeason());
		contentValue.put(RENT_NORMAL, surveyDto.getRentNormalSeason());
		contentValue.put(RENT_HIGH, surveyDto.getRentHighSeason());
		contentValue.put(COST_ELECTRICITY_NORMAL, surveyDto.getElectricityCostNormalSeason());
		contentValue.put(COST_ELECTRICITY_HIGH, surveyDto.getElectricityCostHighSeason());
		contentValue.put(COST_TRANSPORTATION_NORMAL, surveyDto.getTransportationCostNormalSeason());
		contentValue.put(COST_TRANSPORTATION_HIGH, surveyDto.getTransportationHighSeason());
		contentValue.put(COST_PACKAGING_NORMAL, surveyDto.getPackagingCostNormalSeason());
		contentValue.put(COST_PACKAGING_HIGH, surveyDto.getPackagingCostHighSeason());
		contentValue.put(COST_FUEL_NORMAL, surveyDto.getFuelCostNormalSeason());
		contentValue.put(COST_FUEL_HIGH, surveyDto.getFuelCostHighSeason());
		contentValue.put(COMMISSION_NORMAL, surveyDto.getCommissionNormalSeason());
		contentValue.put(COMMISSION_HIGH, surveyDto.getCommissionHighSeason());
		contentValue.put(COST_WASTAGE_NORMAL, surveyDto.getWastageCostNormalSeason());
		contentValue.put(COST_WASTAGE_HIGH, surveyDto.getWastageCostHighSeason());
		contentValue.put(WAGES_PAID_NORMAL, surveyDto.getWagesPaidNormalSeason());
		contentValue.put(WAGES_PAID_HIGH, surveyDto.getWagesPaidNormalSeason());
		contentValue.put(COST_PROMOTION_NORMAL, surveyDto.getPromotionCostNormalSeason());
		contentValue.put(COST_PROMOTION_HIGH, surveyDto.getPromotionCostHighSeason());
		contentValue.put(COST_COMMUNICATION_NORMAL, surveyDto.getCommunicationCostNormalSeason());
		contentValue.put(COST_COMMUNICATION_HIGH, surveyDto.getCommunicationCostHighSeason());
		contentValue.put(COST_MACHINE_REPAIR_NORMAL, surveyDto.getMachineRepairCostNormalSeason());
		contentValue.put(COST_MACHINE_REPAIR_HIGH, surveyDto.getMachineRepairCostHighSeason());
		contentValue.put(COST_OTHER_NORMAL, surveyDto.getOtherCostNormalSeason());
		contentValue.put(COST_OTHER_HIGH, surveyDto.getOtherCostHighSeason());
		contentValue.put(AMOUNT_RECEIVED_FROM_CUSTOMER, surveyDto.getAmountReceivedFromCustomer());
		contentValue.put(AMOUNT_PAID_TO_SUPPLIER, surveyDto.getAmountPaidToSupplied());
		contentValue.put(AMOUNT_INVESTED_IN_START, surveyDto.getAmountInvestedInStart());
		contentValue.put(AMOUNT_INVESTED_AFTER_START, surveyDto.getAmountInvestedAfterStart());
		contentValue.put(OPERATION_MONTHS_YEAR, surveyDto.getOperationMonthsInYear());
		contentValue.put(OPERATION_DAYS_WEEK, surveyDto.getOperationDaysPerWeek());
		contentValue.put(OPERATION_HOURS_WEEK, surveyDto.getOperationHoursPerWeek());
		contentValue.put(ENTREPRENEUR_INVOLVED, surveyDto.getEntrepreneurInvolved());
		contentValue.put(ENTREPRENEUR_INVOLVED_MONTH, surveyDto.getEntrepreneurInvolvedMonths());
		contentValue.put(FAMILY_MEMBERS_INVOLVED, surveyDto.getFamilyMembersInvolved());
		contentValue.put(FAMILY_MEMBERS_INVOLVED_MONTH, surveyDto.getFamilyMembersInvolvedMonths());
		contentValue.put(EXTERNAL_LABOURS_INVOLVED, surveyDto.getExternalLabourersInvolved());
		contentValue.put(EXTERNAL_LABOURS_INVOLVED_MONTH, surveyDto.getExternalLabourersInvolvedMonths());
		contentValue.put(SALARY_TREND_JANUARY, surveyDto.getMonthlySaleTrendJanuary());
		contentValue.put(SALARY_TREND_FEBRUARY, surveyDto.getMonthlySaleTrendFebruary());
		contentValue.put(SALARY_TREND_MARCH, surveyDto.getMonthlySaleTrendMarch());
		contentValue.put(SALARY_TREND_APRIL, surveyDto.getMonthlySaleTrendApril());
		contentValue.put(SALARY_TREND_MAY, surveyDto.getMonthlySaleTrendMay());
		contentValue.put(SALARY_TREND_JUNE, surveyDto.getMonthlySaleTrendJune());
		contentValue.put(SALARY_TREND_JULY, surveyDto.getMonthlySaleTrendJuly());
		contentValue.put(SALARY_TREND_AUGUST, surveyDto.getMonthlySaleTrendAugust());
		contentValue.put(SALARY_TREND_SEPTEMBER, surveyDto.getMonthlySaleTrendSeptember());
		contentValue.put(SALARY_TREND_OCTOBER, surveyDto.getMonthlySaleTrendOctober());
		contentValue.put(SALARY_TREND_NOVEMBER, surveyDto.getMonthlySaleTrendNovember());
		contentValue.put(SALARY_TREND_DECEMBER, surveyDto.getMonthlySaleTrendDecember());
		contentValue.put(SALE_EXTERNAL_CUSTOMER, surveyDto.getSaleToExternalCustomer());
		contentValue.put(PURCHASE_BY_ENTREPRENEUR, surveyDto.getPurchaseByEntrepreneur());


		contentValue.put(CREATED_DATE, getCurrentTimeStamp());
		contentValue.put(SYNC_STATUS, SYNC_STATUS_PENDING);
		String syncDate = null;
		contentValue.put(SYNC_DATE, syncDate);

		long id = database.insert(SurveyDAOManager.TABLE_NAME, null, contentValue);
		return id;
	}

	public long getTotalPendingSurvey() {

		/*Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM "+ TABLE_NAME + " WHERE "+SYNC_STATUS + " = ?",
				new String[] { String.valueOf(SYNC_STATUS_PENDING)});*/
		long totalPendingSurvey = DatabaseUtils.longForQuery(database, "SELECT COUNT(*) FROM "+ TABLE_NAME, null);

	/*	if (cursor != null) {
			totalPendingSurvey = cursor.getCount();
		}
*/
		return totalPendingSurvey;
	}

	/*public Cursor fetch() {
		String[] columns = new String[] { SurveyDAOManager._ID, SurveyDAOManager.SUBJECT, SurveyDAOManager.DESC };
		Cursor cursor = database.query(SurveyDAOManager.TABLE_NAME, columns, null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}

	public int update(long _id, String name, String desc) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(SurveyDAOManager.SUBJECT, name);
		contentValues.put(SurveyDAOManager.DESC, desc);
		int i = database.update(SurveyDAOManager.TABLE_NAME, contentValues, SurveyDAOManager._ID + " = " + _id, null);
		return i;
	}

	public void delete(long _id) {
		database.delete(SurveyDAOManager.TABLE_NAME, SurveyDAOManager._ID + "=" + _id, null);
	}*/

	public String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

}
