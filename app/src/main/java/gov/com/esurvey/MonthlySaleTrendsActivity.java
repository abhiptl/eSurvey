package gov.com.esurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MonthlySaleTrendsActivity extends AppCompatActivity {

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

	public void initializeComponents() {}

	public void initializeValues() {}

	public void addListeners() {}
}
