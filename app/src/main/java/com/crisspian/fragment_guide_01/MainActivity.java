package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

import lombok.val;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener((x)->{
            this.showFragment();
        });
    }

    private void showFragment(){
        val fragment = First_Fragment.newInstance("","");
        getSupportFragmentManager().beginTransaction()
                .add(binding.fragmentContainer.getId(),fragment)
                .addToBackStack(null)
                .commit();
    }

}