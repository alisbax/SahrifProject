package com.binary.sharifproject.Components;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.binary.sharifproject.Help.AppController;
import com.binary.sharifproject.R;


/**
 * Created by P.kokabi on 8/6/2016.
 */
public abstract class DialogGeneral extends Dialog implements View.OnClickListener {

    private CButton confirm_btn, cancel_btn;
    TextView title_tv;
    String titleText, confirmTitle, cancelTitle;
    boolean isCancelVisible = true, isCancelable = true;

    public DialogGeneral(@Nullable String titleText, @Nullable String confirmTitle
            , @Nullable String cancelTitle, boolean isCancelVisible, boolean isCancelable) {
        super(AppController.getCurrentContext());
        this.titleText = titleText;
        this.confirmTitle = confirmTitle;
        this.cancelTitle = cancelTitle;
        this.isCancelVisible = isCancelVisible;
        this.isCancelable = isCancelable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_general);
        setCancelable(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        findViews();
        if (titleText != null) {
            title_tv.setText(titleText);
        }
        if (confirmTitle != null) {
            confirm_btn.setText(confirmTitle);
        }
        if (confirmTitle != null) {
            cancel_btn.setText(cancelTitle);
        }
        if (!isCancelVisible) {
            cancel_btn.setVisibility(View.GONE);
        } else {
            cancel_btn.setVisibility(View.VISIBLE);
        }
        setCancelable(isCancelable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm_btn:
                onConfirm();
                dismiss();
                break;
            case R.id.cancel_btn:
                onCancel();
                dismiss();
                break;
        }
    }

    private void findViews() {
        confirm_btn = (CButton) findViewById(R.id.confirm_btn);
        cancel_btn = (CButton) findViewById(R.id.cancel_btn);

        title_tv = (TextView) findViewById(R.id.title_tv);

        onClickListeners();
    }

    private void onClickListeners() {
        confirm_btn.setOnClickListener(this);
        cancel_btn.setOnClickListener(this);
    }

    public abstract void onConfirm();

    public abstract void onCancel();
}
