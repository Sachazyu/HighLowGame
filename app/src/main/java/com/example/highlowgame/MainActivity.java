package com.example.highlowgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1; //untuk batas sampai 20
    }

    public void randomNumberGenerator() //untuk repeat game
    { Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1; }

    public void onGuess (View view) {
        String message = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

            if (guessedNumber < 1 || guessedNumber > 20)
                message = "Tidak boleh lebih dari 20 !!!";
            else if (guessedNumber < randomNumber)
                message = "Terlalu Rendah !!";
            else if (guessedNumber > randomNumber)
                message = "Terlalu Tinggi !!";
            else {
                message = "You got me !!";
                randomNumberGenerator(); //pengaplikasian yang berulang sampai bertemu dengan solusinya
            }
        } catch (Exception e) {
            message = "Tidak Boleh Kosong !!!";
        } finally {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}