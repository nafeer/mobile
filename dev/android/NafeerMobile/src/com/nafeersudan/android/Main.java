package com.nafeersudan.android;

import com.nafeersudan.android.R;

import com.nafeersudan.android.soap.KSoapHandler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        KSoapHandler handler = new KSoapHandler("http://10.0.2.2/nafeer/index.php");
        String response = handler.login("email@example.com", "pass");
        EditText editText = (EditText) findViewById(R.id.editText1);
        editText.setText(response);
    }
}