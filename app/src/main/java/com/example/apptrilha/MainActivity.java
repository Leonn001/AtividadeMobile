package com.example.apptrilha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button registerbtn;
    private Button managebtn;
    private Button sharebtn;
    private Button settingsbtn;
    private Button sobrebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerbtn = findViewById(R.id.registerbtn);
        managebtn = findViewById(R.id.managebtn);
        sharebtn = findViewById(R.id.sharebtn);
        settingsbtn = findViewById(R.id.settingsbtn);
        sobrebtn = findViewById(R.id.aboutbtn);
        onClickLeon(registerbtn);
        onClickLeon(managebtn);
        onClickLeon(sharebtn);
        onClickLeon(settingsbtn);
        onClickLeon(sobrebtn);
    }

    public void onClickLeon (Button btn) {
       if(btn==registerbtn) {
           btn.setOnClickListener(v->{
               Intent intent = new Intent(this, RegisterActivity.class);
               startActivity(intent);
           });
       }

       if(btn==managebtn) {
           btn.setOnClickListener(v->{
               Intent intent = new Intent(this, ManageActivity.class);
               startActivity(intent);
           });
       }

       if(btn==sharebtn) {
           btn.setOnClickListener(v->{
               Intent intent = new Intent(this, ShareActivity.class);
               startActivity(intent);
           });
       }

       if(btn==settingsbtn) {
           btn.setOnClickListener(v->{
               Intent intent = new Intent(this, SettingsActivity.class);
               startActivity(intent);
           });
       }

       if(btn==sobrebtn) {
           btn.setOnClickListener(v->{
               Intent intent = new Intent(this, AboutActivity.class);
               startActivity(intent);
           });
       }
    }
}