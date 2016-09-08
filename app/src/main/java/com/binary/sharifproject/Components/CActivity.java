package com.binary.sharifproject.Components;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.binary.sharifproject.Help.AppController;
import com.binary.sharifproject.Help.Constants;
import com.binary.sharifproject.R;
import com.binary.sharifproject.Services.ServerListener;
import com.google.gson.JsonObject;

public class CActivity extends AppCompatActivity implements ServerListener, View.OnClickListener {

    protected static Context context;
    public CoordinatorLayout mainContent;

    public void initialActivity() {
        context = this;
        AppController.setActivityContext(this, this);
        Constants.preventRestart();
        mainContent = (CoordinatorLayout) findViewById(R.id.mainContent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppController.setActivityContext(this, this);
    }

    @Override
    public void onSuccess(String methodName, JsonObject data) {

    }

    @Override
    public void onFailure(String methodName, String message) {
        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

    }

    public void findViews() {
    }

    public void setOnClickListenerForViews() {
    }

    public void serviceCall() {
    }


}
