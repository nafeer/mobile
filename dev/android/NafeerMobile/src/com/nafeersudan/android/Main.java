package com.nafeersudan.android;

import java.util.ArrayList;
import java.util.HashMap;

import com.nafeersudan.android.R;

import com.nafeersudan.android.soap.KSoapHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        KSoapHandler handler = new KSoapHandler("http://www.nafeersudan.com/nafeer_portal/ws/index.php");
        //String response = handler.login("altaif.bakri@gmail.com", "122");
        ArrayList<String> response =handler.loadAreas("4");
        EditText editText = (EditText) findViewById(R.id.editText1);
        editText.setText(response.get(1));
        
        handler.saveNotification("13.08.2013", "nadir", "0912345678", "it", "1", "2", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "no");
        Log.e("save", "DONE");
    }
}


