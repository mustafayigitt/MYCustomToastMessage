package com.mustafayigit.mycustomtoastmessage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mustafayigit.mycustomtoast.MYToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeInfoToast();
        makeSuccessToast();
        makeWarningToast();
        makeErrorToast();
    }

    public void makeInfoToast() {
        MYToast myToast = MYToast.makeToast(this, "This is an Info Toast Message");
        myToast.show();
    }

    public void makeSuccessToast() {
        MYToast.makeToast(this, "This is a Success Toast Message", MYToast.LENGTH_SHORT, MYToast.CUSTOM_TYPE_SUCCESS, MYToast.CUSTOM_GRAVITY_TOP).show();
    }

    public void makeWarningToast() {
        MYToast.makeToast(this, "This is a Warning Toast Message", MYToast.LENGTH_SHORT, MYToast.CUSTOM_TYPE_WARNING, MYToast.CUSTOM_GRAVITY_CENTER).show();
    }

    public void makeErrorToast() {
        MYToast.makeToast(this, "This is an Error Toast Message", MYToast.CUSTOM_DURATION_LONG, MYToast.CUSTOM_TYPE_ERROR).show();
    }
}
