package com.example.chocolatekinza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   // public static final String TAG = "Kinza Amjad";

    Button buttonGuess;
    private EditText enterGuess;
    private int REQUEST_CODE = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "onCreate called:", Toast.LENGTH_SHORT).show();

        enterGuess = findViewById(R.id.guess_field);
        buttonGuess = findViewById(R.id.button_guess);

        
        
        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String guess = enterGuess.getText().toString().trim();
                
                if(!guess.isEmpty()) {

                    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                    intent.putExtra("kinza", guess);
                    intent.putExtra("name","Kinza Bond");
                    intent.putExtra("age", 22);
                    startActivityForResult(intent, REQUEST_CODE);
                    //startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "Text field must be filled with value", Toast.LENGTH_SHORT).show();
                }
            }
        });

      //  Log.d(TAG, "onCreate: called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            String kinzaData = data.getStringExtra("message_back");
            Toast.makeText(MainActivity.this, kinzaData, Toast.LENGTH_SHORT).show();
        }
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this, "onStart called:", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onStart: called");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(MainActivity.this, "onResume called:", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onResume: called");
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(MainActivity.this, "onStop called:", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onStop: called");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(MainActivity.this, "onPause called:", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onPause: called");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(MainActivity.this, "onDestroy called:", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onDestroy: called");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(MainActivity.this, "onRestart called:", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onRestart: called");
//
//    }
}