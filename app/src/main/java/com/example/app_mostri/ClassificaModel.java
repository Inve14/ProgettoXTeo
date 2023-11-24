package com.example.app_mostri;

import java.util.ArrayList;
import java.util.List;

public class ClassificaModel {
    List<String> contacts;
    //bisogna creare una lista di Player con caratteristiche "nome_player" e "punteggio_player" --> bisogna creare la classe Player

    public ClassificaModel() {
        contacts = new ArrayList<>();
    }

    public void simulateLoadData() {
        for (int i = 0; i<100; i++) {
            contacts.add("Contact " + i);
        }
    }

    public int getContactsCount() {
        return contacts.size();
    }

    public String getContact(int index) {
        return contacts.get(index);
    }
}
