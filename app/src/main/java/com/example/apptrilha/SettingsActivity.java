package com.example.apptrilha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {
    private RadioGroup speedunit;
    private RadioGroup geocoord;
    private RadioGroup mapor;
    private RadioGroup maptype;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        speedunit = findViewById(R.id.speedunit);
        geocoord = findViewById(R.id.geocoord);
        mapor = findViewById(R.id.mapor);
        maptype = findViewById(R.id.maptype);
        sharedPreferences = getSharedPreferences("radioButtonState", Context.MODE_PRIVATE);
        // Define um listener para o RadioGroup
        setupRadioGroup(speedunit, "speedunit");
        setupRadioGroup(geocoord, "geocoord");
        setupRadioGroup(mapor, "mapor");
        setupRadioGroup(maptype, "maptype");

        // Restaura o estado do RadioButton
        restoreCheckedRadioButtonId();
    }

    private void setupRadioGroup(final RadioGroup radioGroup, final String key) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                saveCheckedRadioButtonId(checkedId, key);
            }
        });
    }


    private void saveCheckedRadioButtonId(int checkedId, String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, checkedId);
        editor.apply();
    }

    private void restoreCheckedRadioButtonId() {
        for (RadioGroup radioGroup : new RadioGroup[]{speedunit, geocoord, mapor, maptype}) {
            String key = getResources().getResourceEntryName(radioGroup.getId());
            int checkedRadioButtonId = sharedPreferences.getInt(key, -1);
            if (checkedRadioButtonId != -1) {
                RadioButton radioButton = radioGroup.findViewById(checkedRadioButtonId);
                if (radioButton != null) {
                    radioButton.setChecked(true);
                }
            }
        }
    }
}






