package com.example.cc1.miaudiolibros;

/**
 * Created by cc1 on 27/09/2019.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.cc1.miaudiolibros.fragments.PreferenciasFragment;

public class PreferenciasActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenciasFragment()).commit();

    }
}