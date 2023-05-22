
package com.example.activitydemo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    public static final String RETVAL_KEY="RETURN STRING";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final TextView lblAusgabe = (TextView) findViewById(R.id.lblAusgabe);
        lblAusgabe.setText("Dritte Activity " +  getIntent().getExtras().getString(MainActivity.KEY));
        Button btnBack = (Button) findViewById(R.id.btnZurueck);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultData = new Intent();
                resultData.putExtra(RETVAL_KEY,"->: " + lblAusgabe.getText());
                setResult(Activity.RESULT_OK,resultData);
                finish();

            }
        });
    }
}

