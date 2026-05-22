package edu.pcc.caloriecalculator;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import edu.pcc.caloriecalculator.databinding.ActivityOutputBinding;

public class OutputActivity extends AppCompatActivity {
    private ActivityOutputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityOutputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        float weightLb = intent.getFloatExtra(MainActivity.EXTRA_WEIGHT, 0.0f);
        float met = intent.getFloatExtra(MainActivity.EXTRA_MET, 0);

        if (weightLb == 0f || met == 0f) {
            finish();
            return;
        }

        float weightKg = weightLb * 0.454f;
        float burnRate = weightKg * met;

        String result = String.format(Locale.US, "%.2f", burnRate);
        binding.calorieBurnRate.setText(result);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
