package gov.com.esurvey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import gov.com.esurvey.domain.SurveyDto;

public class EntrepreneurActivity extends AppCompatActivity {

	private Button buttonNext;

	SurveyDto surveyDto;

	private EditText eTextState;
	private EditText eTextDistrict;
	private EditText eTextBlock;
	private EditText eTextVillage;

	private EditText eTextName;
	private EditText eTextPhoneNumber;
	private EditText eTextYearStartBusiness;

	private RadioGroup radioGroupRoadType;
	private RadioGroup radioGroupMarketType;
	private RadioGroup radioGroupShopType;
	private RadioGroup radioGroupSizeBusiness;
	private RadioGroup radioGroupReligion;
	private RadioGroup radioGroupCaste;

	private TextView textSelectedBusinessTypes;
	private EditText eTextCompetitiorsCount;

	private Set<String> roadTypes = new HashSet<>();
	private Set<String> marketTypes = new HashSet<>();
	private Set<String> shopTypes = new HashSet<>();
	private Set<String> businessSizes = new HashSet<>();
	private Set<String> religions = new HashSet<>();
	private Set<String> casts = new HashSet<>();



	private static final String TAG = EntrepreneurActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "EntrepreneurActivity() created");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrepreneur);

		init();

	}

	public void init() {
		initializeComponents();
		initializeValues();
		addListeners();
	}

	public void initializeComponents() {
		eTextState = (EditText) findViewById(R.id.eTextState);
		eTextDistrict = (EditText) findViewById(R.id.eTextDistrict);
		eTextBlock = (EditText) findViewById(R.id.eTextBlock);
		eTextVillage = (EditText) findViewById(R.id.eTextVillage);

		eTextName = (EditText) findViewById(R.id.eTextName);
		eTextPhoneNumber = (EditText) findViewById(R.id.eTextPhoneNumber);
		eTextYearStartBusiness = (EditText) findViewById(R.id.eTextYearStartBusiness);

		radioGroupRoadType = (RadioGroup) findViewById(R.id.radioGroupRoadType);
		radioGroupMarketType = (RadioGroup) findViewById(R.id.radioGroupMarketType);
		radioGroupShopType = (RadioGroup) findViewById(R.id.radioGroupShopType);
		radioGroupSizeBusiness = (RadioGroup) findViewById(R.id.radioGroupSizeBusiness);
		radioGroupReligion = (RadioGroup) findViewById(R.id.radioGroupReligion);
		radioGroupCaste = (RadioGroup) findViewById(R.id.radioGroupCaste);

		textSelectedBusinessTypes = (TextView) findViewById(R.id.textSelectedBusinessTypes);
		eTextCompetitiorsCount =  (EditText)  findViewById(R.id.eTextCompetitiorsCount);

		buttonNext = (Button) findViewById(R.id.buttonNext);
	}

	public void initializeValues() {

		roadTypes.add(getResources().getString(R.string.roadType_NationalHighway));
		roadTypes.add(getResources().getString(R.string.roadType_StateHighway));
		roadTypes.add(getResources().getString(R.string.roadType_MajorRoad));
		roadTypes.add(getResources().getString(R.string.roadType_VillageRoad));
		roadTypes.add(getResources().getString(R.string.roadType_Lane));

		roadTypes.add(getResources().getString(R.string.marketType_large));
		roadTypes.add(getResources().getString(R.string.marketType_small));
		roadTypes.add(getResources().getString(R.string.marketType_standalone));


		shopTypes.add(getResources().getString(R.string.shopType_fixed));
		shopTypes.add(getResources().getString(R.string.shopType_fixed));
		shopTypes.add(getResources().getString(R.string.shopType_haat));

		businessSizes.add(getResources().getString(R.string.businessSize_large));
		businessSizes.add(getResources().getString(R.string.businessSize_medium));
		businessSizes.add(getResources().getString(R.string.businessSize_small));

		religions.add(getResources().getString(R.string.religion_hindu));
		religions.add(getResources().getString(R.string.religion_christian));
		religions.add(getResources().getString(R.string.religion_islam));
		religions.add(getResources().getString(R.string.religion_sikh));
		religions.add(getResources().getString(R.string.religion_other));

		casts.add(getResources().getString(R.string.caste_bc));
		casts.add(getResources().getString(R.string.caste_sc));
		casts.add(getResources().getString(R.string.caste_st));
		casts.add(getResources().getString(R.string.caste_obc));
		casts.add(getResources().getString(R.string.caste_general));

		initVillages();
		initBusinessTypes();


		surveyDto = (SurveyDto)(getIntent().getSerializableExtra(MainActivity.ENTREPRENEUR_DTO));

		if(surveyDto.getState() != null) {
			eTextState.setText(surveyDto.getState());
		}

		if(surveyDto.getDistrict() != null) {
			eTextDistrict.setText(surveyDto.getDistrict());
		}

		if(surveyDto.getBlock() != null) {
			eTextBlock.setText(surveyDto.getBlock());
		}

		if(surveyDto.getVillage() != null) {
			eTextVillage.setText(surveyDto.getVillage());
		}

		if(surveyDto.getName() != null) {
			eTextName.setText(surveyDto.getName());
		}

		if(surveyDto.getPhoneNumber() != null) {
			eTextPhoneNumber.setText(surveyDto.getPhoneNumber());
		}

		if(surveyDto.getStartYearOfBusiness() != null) {
			eTextYearStartBusiness.setText(surveyDto.getStartYearOfBusiness());
		}

		if(surveyDto.getRoadType() != null) {
			checkRoadType(surveyDto.getRoadType());
		}

		if(surveyDto.getMarketType() != null) {
			checkMarketType(surveyDto.getMarketType());
		}

		if(surveyDto.getShopType() != null) {
			checkShopType(surveyDto.getShopType());
		}

		if(surveyDto.getBusinessSize() != null) {
			checkBusinessSize(surveyDto.getBusinessSize());
		}

		if(surveyDto.getReligion() != null) {
			checkReligion(surveyDto.getReligion());
		}

		if(surveyDto.getCaste() != null) {
			checkCaste(surveyDto.getCaste());
		}

		if(surveyDto.getBusinessTypes() != null && surveyDto.getBusinessTypes().size() != 0) {
			textSelectedBusinessTypes.setText(TextUtils.join(",", surveyDto.getBusinessTypes()));
		}

		if(surveyDto.getCompetitorCount() != null) {
			eTextCompetitiorsCount.setText(surveyDto.getCompetitorCount());
		}
	}

	public void checkRoadType(final String roadType) {
		RadioButton selectedRoadTypeRadio = null;
		if(roadType.equals(getResources().getString(R.string.roadType_NationalHighway))) {
			selectedRoadTypeRadio = (RadioButton) findViewById(R.id.radioNationalHighway);
			selectedRoadTypeRadio.setChecked(true);
		} else if(roadType.equals(getResources().getString(R.string.roadType_StateHighway))) {
			selectedRoadTypeRadio = (RadioButton) findViewById(R.id.radioStateHighway);
			selectedRoadTypeRadio.setChecked(true);
		} else if(roadType.equals(getResources().getString(R.string.roadType_MajorRoad))) {
			selectedRoadTypeRadio = (RadioButton) findViewById(R.id.radioMajorRoad);
			selectedRoadTypeRadio.setChecked(true);
		} else if(roadType.equals(getResources().getString(R.string.roadType_VillageRoad))) {
			selectedRoadTypeRadio = (RadioButton) findViewById(R.id.radioVillageRoad);
			selectedRoadTypeRadio.setChecked(true);
		} else if(roadType.equals(getResources().getString(R.string.roadType_Lane))) {
			selectedRoadTypeRadio = (RadioButton) findViewById(R.id.radioLane);
			selectedRoadTypeRadio.setChecked(true);
		} else {
			selectedRoadTypeRadio = (RadioButton) findViewById(R.id.radioNationalHighway);
			selectedRoadTypeRadio.setChecked(true);
		}
	}

	public void checkMarketType(final String marketType) {
		RadioButton selectedMarketTypeRadio = null;
		if(marketType.equals(getResources().getString(R.string.marketType_large))) {
			selectedMarketTypeRadio = (RadioButton) findViewById(R.id.radioLargeMarket);
			selectedMarketTypeRadio.setChecked(true);
		} else if(marketType.equals(getResources().getString(R.string.marketType_small))) {
			selectedMarketTypeRadio = (RadioButton) findViewById(R.id.radioSmallMarket);
			selectedMarketTypeRadio.setChecked(true);
		} else if(marketType.equals(getResources().getString(R.string.marketType_standalone))) {
			selectedMarketTypeRadio = (RadioButton) findViewById(R.id.radioStandalone);
			selectedMarketTypeRadio.setChecked(true);
		} else {
			selectedMarketTypeRadio = (RadioButton) findViewById(R.id.radioLargeMarket);
			selectedMarketTypeRadio.setChecked(true);
		}
	}

	public void checkShopType(final String shopType) {
		RadioButton selectedShopTypeRadio = null;
		if(shopType.equals(getResources().getString(R.string.shopType_fixed))) {
			selectedShopTypeRadio = (RadioButton) findViewById(R.id.radioFixedShop);
			selectedShopTypeRadio.setChecked(true);
		} else if(shopType.equals(getResources().getString(R.string.shopType_mobile))) {
			selectedShopTypeRadio = (RadioButton) findViewById(R.id.radioMobileShop);
			selectedShopTypeRadio.setChecked(true);
		} else if(shopType.equals(getResources().getString(R.string.shopType_haat))) {
			selectedShopTypeRadio = (RadioButton) findViewById(R.id.radioHaat);
			selectedShopTypeRadio.setChecked(true);
		} else {
			selectedShopTypeRadio = (RadioButton) findViewById(R.id.radioFixedShop);
			selectedShopTypeRadio.setChecked(true);
		}
	}

	public void checkBusinessSize(final String businessSize) {
		RadioButton selectedBusinessSizeRadio = null;
		if(businessSize.equals(getResources().getString(R.string.businessSize_large))) {
			selectedBusinessSizeRadio = (RadioButton) findViewById(R.id.radioLargeBusiness);
			selectedBusinessSizeRadio.setChecked(true);
		} else if(businessSize.equals(getResources().getString(R.string.businessSize_medium))) {
			selectedBusinessSizeRadio = (RadioButton) findViewById(R.id.radioMediumBusiness);
			selectedBusinessSizeRadio.setChecked(true);
		} else if(businessSize.equals(getResources().getString(R.string.businessSize_small))) {
			selectedBusinessSizeRadio = (RadioButton) findViewById(R.id.radioSmallBusiness);
			selectedBusinessSizeRadio.setChecked(true);
		} else {
			selectedBusinessSizeRadio = (RadioButton) findViewById(R.id.radioLargeBusiness);
			selectedBusinessSizeRadio.setChecked(true);
		}
	}

	public void checkReligion(final String religion) {
		RadioButton selectedReligionRadio = null;
		if(religion.equals(getResources().getString(R.string.religion_hindu))) {
			selectedReligionRadio = (RadioButton) findViewById(R.id.radioHindu);
			selectedReligionRadio.setChecked(true);
		} else if(religion.equals(getResources().getString(R.string.religion_christian))) {
			selectedReligionRadio = (RadioButton) findViewById(R.id.radioChristian);
			selectedReligionRadio.setChecked(true);
		} else if(religion.equals(getResources().getString(R.string.religion_sikh))) {
			selectedReligionRadio = (RadioButton) findViewById(R.id.radioSikh);
			selectedReligionRadio.setChecked(true);
		} else if(religion.equals(getResources().getString(R.string.religion_islam))) {
			selectedReligionRadio = (RadioButton) findViewById(R.id.radioIslam);
			selectedReligionRadio.setChecked(true);
		} else if(religion.equals(getResources().getString(R.string.religion_other))) {
			selectedReligionRadio = (RadioButton) findViewById(R.id.radioOther);
			selectedReligionRadio.setChecked(true);
		} else {
			selectedReligionRadio = (RadioButton) findViewById(R.id.radioHindu);
			selectedReligionRadio.setChecked(true);
		}
	}

	public void checkCaste(final String caste) {
		RadioButton selectedCasteRadio = null;
		if(caste.equals(getResources().getString(R.string.caste_st))) {
			selectedCasteRadio = (RadioButton) findViewById(R.id.radioST);
			selectedCasteRadio.setChecked(true);
		} else if(caste.equals(getResources().getString(R.string.caste_sc))) {
			selectedCasteRadio = (RadioButton) findViewById(R.id.radioSC);
			selectedCasteRadio.setChecked(true);
		} else if(caste.equals(getResources().getString(R.string.caste_bc))) {
			selectedCasteRadio = (RadioButton) findViewById(R.id.radioBC);
			selectedCasteRadio.setChecked(true);
		} else if(caste.equals(getResources().getString(R.string.caste_obc))) {
			selectedCasteRadio = (RadioButton) findViewById(R.id.radioOBC);
			selectedCasteRadio.setChecked(true);
		} else if(caste.equals(getResources().getString(R.string.caste_general))) {
			selectedCasteRadio = (RadioButton) findViewById(R.id.radioGeneral);
			selectedCasteRadio.setChecked(true);
		} else {
			selectedCasteRadio = (RadioButton) findViewById(R.id.radioST);
			selectedCasteRadio.setChecked(true);
		}
	}
	public void addListeners() {
		buttonNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean valid = validate();
				if(valid) {
					next();
				} else {
					//Does not proceed to next action. Error field will be marked red
				}
			}
		});
	}

	public boolean validate() {
		boolean valid = true;

		/*if(eTextVillage.getText() == null || eTextVillage.getText().length() == 0) {
			eTextVillage.setError(getResources().getString(R.string.error_required));
			valid = false;
		}*/

		if(eTextName.getText() == null || eTextName.getText().length() == 0) {
			eTextName.setError(getResources().getString(R.string.error_required));
			valid = false;
		}

		if(eTextPhoneNumber.getText() == null || eTextPhoneNumber.getText().length() == 0) {
			eTextPhoneNumber.setError(getResources().getString(R.string.error_required));
			valid = false;
		}

		if(eTextYearStartBusiness.getText() == null || eTextYearStartBusiness.getText().length() == 0) {
			eTextYearStartBusiness.setError(getResources().getString(R.string.error_required));
			valid = false;
		}


		return valid;
	}

	public void next() {
		Log.i(TAG, eTextState.getText().toString());

		buildEntrepreneurDto();

		Intent intent = new Intent(this, IncomeDetailsActivity.class);
		intent.putExtra(MainActivity.ENTREPRENEUR_DTO, surveyDto);
		startActivity(intent);

	}

	public void buildEntrepreneurDto() {
		surveyDto.setState(eTextState.getText().toString());
		surveyDto.setDistrict(eTextDistrict.getText().toString());
		surveyDto.setBlock(eTextBlock.getText().toString());
		surveyDto.setVillage(eTextVillage.getText().toString());

		surveyDto.setName(eTextName.getText().toString());
		surveyDto.setPhoneNumber(eTextPhoneNumber.getText().toString());
		surveyDto.setStartYearOfBusiness(eTextYearStartBusiness.getText().toString());

		RadioButton rdRoadType = (RadioButton) findViewById(radioGroupRoadType.getCheckedRadioButtonId());
		surveyDto.setRoadType(rdRoadType.getText().toString());

		RadioButton rdMarketType = (RadioButton) findViewById(radioGroupMarketType.getCheckedRadioButtonId());
		surveyDto.setMarketType(rdMarketType.getText().toString());

		RadioButton rdShopType = (RadioButton) findViewById(radioGroupShopType.getCheckedRadioButtonId());
		surveyDto.setShopType(rdShopType.getText().toString());

		RadioButton rdBusinessSize = (RadioButton) findViewById(radioGroupSizeBusiness.getCheckedRadioButtonId());
		surveyDto.setBusinessSize(rdBusinessSize.getText().toString());

		RadioButton rdReligion = (RadioButton) findViewById(radioGroupReligion.getCheckedRadioButtonId());
		surveyDto.setReligion(rdReligion.getText().toString());

		RadioButton rdCaste = (RadioButton) findViewById(radioGroupCaste.getCheckedRadioButtonId());
		surveyDto.setCaste(rdCaste.getText().toString());

		String businessTypes = eTextYearStartBusiness.getText().toString();
		String[] types = businessTypes.split(",");
		surveyDto.setBusinessTypes(Arrays.asList(types));

		surveyDto.setCompetitorCount(eTextCompetitiorsCount.getText().toString());

	}

	public void initBusinessTypes() {
		final List<CharSequence> list = new ArrayList<CharSequence>();

		list.add("Agarbatti making and selling");
		list.add("Agricultural rentals");
		list.add("Agricultural rentals");
		list.add("Aluminium works");
		list.add("Bag making");
		list.add("Bakery");
		list.add("Bed trading – Mattress, Razai");
		list.add("Bindi making and selling");
		list.add("Book stall");


		View openDialog = (View) findViewById(R.id.textSelectedBusinessTypes);
		openDialog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Intialize  readable sequence of char values
				final CharSequence[] dialogList = list.toArray(new CharSequence[list.size()]);
				final AlertDialog.Builder builderDialog = new AlertDialog.Builder(EntrepreneurActivity.this);
				builderDialog.setTitle("Select Business Type");

				int count = dialogList.length;
				boolean[] is_checked = new boolean[count];

				// Creating multiple selection by using setMutliChoiceItem method
				builderDialog.setMultiChoiceItems(dialogList, is_checked, new DialogInterface.OnMultiChoiceClickListener() {

					public void onClick(DialogInterface dialog, int whichButton, boolean isChecked) {
					}
				});

				builderDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						ListView list = ((AlertDialog) dialog).getListView();
						// make selected item in the comma seprated string
						StringBuilder stringBuilder = new StringBuilder();
						for (int i = 0; i < list.getCount(); i++) {
							boolean checked = list.isItemChecked(i);

							if (checked) {
								if (stringBuilder.length() > 0)
									stringBuilder.append(",");
								stringBuilder.append(list.getItemAtPosition(i));

							}
						}

                        /*Check string builder is empty or not. If string builder is not empty.
						  It will display on the screen.
                         */
						if (stringBuilder.toString().trim().equals("")) {

							((TextView) findViewById(R.id.textSelectedBusinessTypes)).setText("Click here to open Dialog");
							stringBuilder.setLength(0);

						} else {
							((TextView) findViewById(R.id.textSelectedBusinessTypes)).setText(stringBuilder);
						}
					}
				});

				builderDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						((TextView) findViewById(R.id.textSelectedBusinessTypes)).setText("Click here to open Dialog");
					}
				});
				AlertDialog alert = builderDialog.create();
				alert.show();

			}
		});

	}

	public void initVillages() {
		eTextVillage = (EditText) findViewById(R.id.eTextVillage);

		final List<CharSequence> listVillages = new ArrayList<CharSequence>();

		listVillages.add("Akalgarh");
		listVillages.add("Bakhtaur Nagar");
		listVillages.add("Bakshiwala");
		listVillages.add("Bhagwanpura");
		listVillages.add("Bhaini Gandhuan");
		listVillages.add("Bharoor");

		eTextVillage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				final CharSequence[] dialogList = listVillages.toArray(new CharSequence[listVillages.size()]);
				final AlertDialog.Builder builderDialog = new AlertDialog.Builder(EntrepreneurActivity.this);
				builderDialog.setTitle("Select Village");
				final AlertDialog alert = builderDialog.create();

				builderDialog.setSingleChoiceItems(dialogList, -1,  new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface villageDialog, int selectedItemIndex) {
						eTextVillage.setText(dialogList[selectedItemIndex]);
						villageDialog.dismiss();
					}
				});

				builderDialog.show();
			}
		});
	}
}
