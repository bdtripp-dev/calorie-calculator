package edu.pcc.caloriecalculator;

import edu.pcc.caloriecalculator.databinding.ActivityMainBinding;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public final static String EXTRA_WEIGHT = "com.murach.caloriesburnedcalculator.WEIGHT";
    public final static String EXTRA_MET = "com.murach.caloriesburnedcalculator.MET";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String getWeightInput() {
        return binding.weightAmount.getText().toString().trim();
    }

    private String getMetInput() {
        return binding.metValue.getText().toString().trim();
    }

    private Float tryParseFloat(String string, String missingMessage) {
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            Toast.makeText(this, missingMessage, Toast.LENGTH_LONG).show();
            return null;
        }
    }
    private Float parseWeight(String input) {
        return tryParseFloat(input, getString(R.string.missingWeight));
    }

    private Float parseMet(String input) {
        return tryParseFloat(input, getString(R.string.missingMET));
    }

    public void calculate(View button) {
        String weightString = getWeightInput();
        String metString = getMetInput();
        Float weightFloat;
        Float metFloat;
        weightFloat = parseWeight(weightString);
        metFloat = parseMet(metString);

        if (weightFloat == null || metFloat == null) return;

        if (weightFloat <= 0 || weightFloat > 1400f) {
            Toast.makeText(this, R.string.invalidWeight, Toast.LENGTH_LONG).show();
            return;
        }

        if (metFloat < 0.9f || metFloat > 23f) {
            Toast.makeText(this, R.string.invalidMET, Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, OutputActivity.class);

        intent.putExtra(EXTRA_WEIGHT, weightFloat);
        intent.putExtra(EXTRA_MET, metFloat);

        startActivity(intent);
    }
}
