package com.example.chocolatekinza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {

    private TextView textViewRecieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        textViewRecieved = findViewById(R.id.recieved_textView);

        Bundle kinzaExtra = getIntent().getExtras();

        if(getIntent().getStringExtra("kinza") != null){

//            String missAmjad = getIntent().getStringExtra("kinza").toString() +
//                    "\n" + getIntent().getStringExtra("name").toString() +
//                    "\n" + String.valueOf(getIntent().getIntExtra("age", 0));
//

            String missChocolatyKinza = kinzaExtra.getString("kinza") +
                    "\n" + kinzaExtra.getString("name") +
                    "\n" + kinzaExtra.getInt("age");

            textViewRecieved.setText(missChocolatyKinza);

            textViewRecieved.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = getIntent();
                    intent.putExtra("message_back","Kinza Bond is comming back");
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

        }
    }
}