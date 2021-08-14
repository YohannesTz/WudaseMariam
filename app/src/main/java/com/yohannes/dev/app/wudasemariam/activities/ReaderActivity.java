package com.yohannes.dev.app.wudasemariam.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.yohannes.dev.app.wudasemariam.R;

public class ReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        String dateName = getIntent().getStringExtra("prayerDate");
        Log.e("PrayerDate", dateName);

        TextView headerTextView = findViewById(R.id.headerTextView);
        TextView contentTextView = findViewById(R.id.contentTextView);

        prepareText(headerTextView, contentTextView, dateName);
    }


    private void prepareText(TextView headerTv, TextView contentTv, String dateName){
        switch (dateName) {
            case "Daily":
                contentTv.setText(R.string.reader_prayer_daily_label);
                headerTv.setText(R.string.reader_prayer_daily_header_label);
                break;
            case "Monday":
                contentTv.setText(R.string.reader_prayer_monday_label);
                headerTv.setText(R.string.reader_prayer_monday_header_label);
                break;
            case "Tuesday":
                contentTv.setText(R.string.reader_prayer_tuesday_label);
                headerTv.setText(R.string.reader_prayer_tuesday_header_label);
                break;
            case "Wednesday":
                contentTv.setText(R.string.reader_prayer_wedensday_label);
                headerTv.setText(R.string.reader_prayer_wedensday_header_label);
                break;
            case "Thurday":
                contentTv.setText(R.string.reader_prayer_thursday_label);
                headerTv.setText(R.string.reader_prayer_thursday_header_label);
                break;
            case "Friday":
                contentTv.setText(R.string.reader_prayer_friday_label);
                headerTv.setText(R.string.reader_prayer_friday_header_label);
                break;
            case "Saturday":
                contentTv.setText(R.string.reader_prayer_saturday_label);
                headerTv.setText(R.string.reader_prayer_saturday_header_label);
                break;
            case "Sunday":
                contentTv.setText(R.string.reader_prayer_sunday_label);
                headerTv.setText(R.string.reader_prayer_sunday_header_label);
                break;
            default:
                break;
        }
    }
}