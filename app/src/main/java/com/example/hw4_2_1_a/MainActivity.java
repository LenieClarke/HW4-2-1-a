package com.example.hw4_2_1_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    private ItemsDataAdapter adapter;
    private List<String> effort = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        ListView listView = findViewById(R.id.list);

        fillEffort();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomItemData();
            }
        });

        adapter = new ItemsDataAdapter(this, null);
        listView.setAdapter(adapter);
    }

    private void fillEffort() {
        effort.add(getString(R.string.subtitleBook));
        effort.add(getString(R.string.subtitleGrammar));
        effort.add(getString(R.string.subtitlePodcast));
        effort.add(getString(R.string.subtitleFilm));
        effort.add(getString(R.string.subtitleCommunication));
    }

    private void generateRandomItemData() {
        adapter.addItem(new ItemData(R.drawable.ic_baseline_adb_24,
                getString(R.string.title) + adapter.getCount(),
                effort.get(random.nextInt(effort.size())), random.nextBoolean()));
    }
}