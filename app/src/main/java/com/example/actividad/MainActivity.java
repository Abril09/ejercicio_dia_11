package com.example.actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.prathameshmore.toastylibrary.Toasty;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }

        Timber.d("on create main actity  "+ this.getClass().getSimpleName());
        final Toasty toasty = new Toasty(MainActivity.this);
        Button buton= findViewById(R.id.button_1);

        buton.setOnClickListener(x -> {
            toasty.successToasty(this,"bien ",Toasty.LENGTH_LONG,Toasty.CENTER);
        });

     }
}