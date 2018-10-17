package com.example.maxim.homework_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.add_button);
        Button removeButton = findViewById(R.id.remove_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDocument();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDocument();
            }
        });
    }

    private void addDocument() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int backStackSize = fragmentManager.getBackStackEntryCount();

        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, DocumentFragment.create(backStackSize + 1))
                .addToBackStack(null)
                .commit();
    }

    private void removeDocument() {
        getSupportFragmentManager().popBackStackImmediate();
    }
}
