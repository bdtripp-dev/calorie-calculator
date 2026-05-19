package edu.pcc.caloriecalculator;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import edu.pcc.caloriecalculator.databinding.ActivityOutputBinding;

public class OutputActivity extends AppCompatActivity {
    private ActivityOutputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent intent = getIntent();

        float weightLb = intent.getFloatExtra(MainActivity.EXTRA_WEIGHT, 0.0f);
        float met = intent.getFloatExtra(MainActivity.EXTRA_MET, 0);

        // Log.d(TAG, "metValue: " + metValue);

        float weightKg = weightLb * 0.454f;
        float burnRate = weightKg * met;

        // Log.d(TAG, "weightLb: " + weightAsLb);
        // Log.d(TAG, "weightKg: " + weightAsKg);

        TextView calorieBurnRate = (TextView) findViewById(R.id.calorieBurnRate);

        DecimalFormat format = new DecimalFormat("#.##");
        calorieBurnRate.setText(format.format(burnRate));
    }
}
