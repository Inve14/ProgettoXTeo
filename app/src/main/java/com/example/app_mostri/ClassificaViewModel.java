package com.example.app_mostri;

import androidx.lifecycle.ViewModel;

public class ClassificaViewModel extends ViewModel{
    ClassificaModel theModel;

    public ClassificaViewModel() {
        theModel = new ClassificaModel();
        theModel.simulateLoadData();
    }


    public int getContactsCount() {
        return theModel.getContactsCount();
    }

    public String getContact(int index) {
        return theModel.getContact(index);
    }
}
