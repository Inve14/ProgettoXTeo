package com.example.app_mostri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


public class Classifica extends Fragment {

    ClassificaViewModel viewModel;

    public Classifica() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ClassificaViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ClassificaAdapter adapter = new ClassificaAdapter(this, viewModel, i -> {
            Log.d("CapiamoMeglio", "(Activity) Hai cliccato sull'elemento con posizione: " + i);
        });

        recyclerView.setAdapter(adapter);
*/
    }

}