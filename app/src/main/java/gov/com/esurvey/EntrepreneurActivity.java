package gov.com.esurvey;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import gov.com.esurvey.domain.EntrepreneurDto;

public class EntrepreneurActivity extends AppCompatActivity {

	private Button buttonNext;

	EntrepreneurDto entrepreneurDto;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrepreneur);

		initBusinessTypes();

		buttonNext = (Button) findViewById(R.id.buttonNext);

		buttonNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean valid = validate();
				if(valid) {
					next();
				} else {
					//TODO
				}
			}
		});

		Parcelable parcelableExtra = getIntent().getParcelableExtra(MainActivity.ENTREPRENEUR_DTO);

		if(parcelableExtra != null) {
			entrepreneurDto = (EntrepreneurDto) parcelableExtra;
		}
	}

	public boolean validate() {


		return true;
	}

	public void next() {


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
}
