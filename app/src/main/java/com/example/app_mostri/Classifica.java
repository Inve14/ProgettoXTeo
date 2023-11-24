package com.example.app_mostri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Classifica extends Fragment {

    ClassificaViewModel viewModel;

    public Classifica() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_classifica, container, false);

        viewModel = new ViewModelProvider(this).get(ClassificaViewModel.class);

        RecyclerView recyclerView = rootView.findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ClassificaAdapter adapter = new ClassificaAdapter(getActivity(), viewModel, i -> {
            Log.d("CapiamoMeglio", "(Activity) Hai cliccato sull'elemento con posizione: " + i);
        });

        ApiInterface apiInterface = RetrofitClient.getRetrofitIstance().create(ApiInterface.class);
        Call<List<User>> call = apiInterface.getUserInformation("l5p8XVRmz6ApeTVeeUwK");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> risposta = response.body();
                    if (risposta != null) {
                        CompletableFuture.runAsync(() -> {
                            for (User item : risposta) {
                                final User user = new User(item.getExperience(), item.getLife(), item.getProfileversion(), item.getUid());
                                UiThreadHelper.runOnUiThread(() -> {
                                    Log.d("CapiamoMeglio1", "onResponse: User= " + user.toString());
                                    // Aggiorna l'adapter o l'UI a seconda delle tue esigenze
                                    adapter.notifyDataSetChanged();
                                });
                            }
                        });
                    } else {
                        Log.d("MainActivity", "onResponse: Response body is null");
                    }
                }
            }




            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t.getMessage());
            }
        });






/*
                ApiInterface apiInterface = RetrofitClient.getRetrofitIstance().create(ApiInterface.class);
                Call<List<User>> call = apiInterface.getUserInformation("l5p8XVRmz6ApeTVeeUwK");

                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (response.isSuccessful()) {
                            List<User> risposta = response.body();
                            if (risposta != null) {
                                for (User item : risposta) {
                                    User user = new User(item.getExperience(), item.getLife(), item.getProfileversion(), item.getUid());
                                    Log.d("CapiamoMeglio1", "onResponse: User=" + user);
                                }
                            } else {
                                Log.d("MainActivity", "onResponse: Response body is null");
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Log.d("MainActivity", "onFailure: " + t.getMessage());
                    }
                });*/

        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
