package com.example.app_mostri;

import android.util.Log;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassificaModel extends Classifica {
    List<String> contacts;
    User user;

    public ClassificaModel() {
        contacts = new ArrayList<>();
    }

    public void simulateLoadData() {
        contacts.add(user.toString());
    }

    public int getContactsCount() {
        return contacts.size();
    }

    public String getContact(int index) {
        return contacts.get(index);
    }
}
