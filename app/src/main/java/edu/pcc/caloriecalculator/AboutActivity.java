package edu.pcc.caloriecalculator;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_about);
    }

    public void dismiss(View view) {
        this.finish();
    }
}
