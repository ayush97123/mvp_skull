package com.tactopus.mvp_arch.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tactopus.mvp_arch.R;
import com.tactopus.mvp_arch.contract.MainActivityContract;
import com.tactopus.mvp_arch.presenter.MainActivityPresenter;
import com.tactopus.mvp_arch.utils.StaticVariables;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private EditText nameEditText;
    private Button sendButton;

    private MainActivityPresenter mainActivityPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityPresenter(this, this);
    }

    @Override
    public void initView() {
        nameEditText = findViewById(R.id.name_edit_text);
        sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityPresenter.onClick(v);
            }
        });
    }

    @Override
    public String getName() {
        return nameEditText.getText().toString();
    }

    @Override
    public void updateUi(String whichUi) {
        switch (whichUi) {
            case StaticVariables
                    .UPLOAD_SUCCESS: {
                // update ui accordingly
                break;
            }

            case StaticVariables

                    .UPLOAD_FAILED: {
                // update ui accordingly
                break;
            }

        }
    }
}
