package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

import java.util.Optional;

import lombok.val;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private First_Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setText("open");
        fragment = First_Fragment.newInstance("","");
        binding.button.setOnClickListener((x)->{
            if (!fragment.isAdded()) {
                this.showFragment();
            } else {
                this.closeFragment();
            }
        });
    }

    private void showFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(binding.fragmentContainer.getId(),fragment)
                .addToBackStack(null)
                .commit();
        binding.button.setText("close");
    }

    private void  closeFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .remove(this.fragment)
                .commit();
        binding.button.setText("open");
    }

}