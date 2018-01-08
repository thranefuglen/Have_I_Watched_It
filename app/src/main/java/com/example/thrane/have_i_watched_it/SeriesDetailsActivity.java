package com.example.thrane.have_i_watched_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.thrane.have_i_watched_it.R.id.textView;

public class SeriesDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_details);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_DETAILS);

        // Capture the layout's TextView and set the string as its text
        TextView txtSeriesDetailsName = (TextView) findViewById(R.id.txtSeriesDetailsName);
        txtSeriesDetailsName.setText(message);
    }
}
