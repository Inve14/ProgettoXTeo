package com.example.app_mostri;

import android.os.Handler;
import android.os.Looper;

public class UiThreadHelper {

    public static void runOnUiThread(Runnable action) {
        // Verifica se siamo già nel thread principale
        if (Looper.myLooper() == Looper.getMainLooper()) {
            // Siamo già nel thread principale, quindi possiamo eseguire direttamente l'azione
            action.run();
        } else {
            // Non siamo nel thread principale, quindi postiamo l'azione nell'handler del thread principale
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(action);
        }
    }
}

