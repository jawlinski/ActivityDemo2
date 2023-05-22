package com.example.activitydemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    public static final String KEY ="DATENTRANSFER_01";
    public static final int REQUEST_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtEingabe= (EditText) findViewById(R.id.txtEingabe) ;
        Button btn =  (Button)  findViewById(R.id.btnZurZweitenActivity);
        Button btn2 =  (Button)  findViewById(R.id.btnZurDrittenActivity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(KEY,txtEingabe.getText().toString());
                startActivityForResult(intent,REQUEST_ID);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                intent.putExtra(KEY,txtEingabe.getText().toString());
                startActivityForResult(intent,REQUEST_ID);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ID) {
            if (resultCode == RESULT_OK) {
                String retValue = data.getStringExtra(SecondActivity.RETVAL_KEY);
                EditText txtEingabe = (EditText) findViewById(R.id.txtEingabe);
                txtEingabe.setText(retValue);
            }
        }
    }

}