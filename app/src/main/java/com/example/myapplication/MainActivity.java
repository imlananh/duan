package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     //khai bao cac icon
    private EditText edtDataIntent;
    private Button btnStartService;
    private Button btnStopService;



    //anh xa qua id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtDataIntent = findViewById(R.id.edt_data_intent);
        btnStartService = findViewById(R.id.btn_start_service);
        btnStopService = findViewById(R.id.btn_stop_service);



        //bat su kien onclick
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();

            }


        });





        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();

            }
        });
    }




    //creatmethod support - su ly logic
    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key_data_intent",edtDataIntent.getText().toString().trim() );

        startService(intent);
    }

    private void clickStartService() {
        Intent intent = new Intent (this, MyService.class);
        stopService(intent);


    }
}