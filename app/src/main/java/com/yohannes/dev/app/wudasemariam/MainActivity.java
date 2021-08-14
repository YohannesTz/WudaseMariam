package com.yohannes.dev.app.wudasemariam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yohannes.dev.app.wudasemariam.Util.LocaleHelper;
import com.yohannes.dev.app.wudasemariam.activities.ReaderActivity;
import com.yohannes.dev.app.wudasemariam.activities.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] prayerArray = getResources().getStringArray(R.array.prayer_array_en);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String language = prefs.getString(getString(R.string.language_key), "amh");

        Log.e("SELECTEDLANGUAGE", language);
        LocaleHelper.setLocale(this, language);

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.text_item, prayerArray);
        ListView listView = findViewById(R.id.texts_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent detailActivity = new Intent(getApplicationContext(), ReaderActivity.class);
            detailActivity.putExtra("prayerDate", prayerArray[position]);
            startActivity(detailActivity);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}