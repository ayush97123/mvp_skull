package com.tactopus.mvp_arch.model;

import android.content.Context;
import android.util.Log;

import com.tactopus.mvp_arch.contract.MainActivityContract;
import com.tactopus.mvp_arch.firebase_database.FirebaseDatabase;
import com.tactopus.mvp_arch.presenter.MainActivityPresenter;
import com.tactopus.mvp_arch.utils.StaticVariables;

public class MainActivityModel implements MainActivityContract.Model {

    private Context mContext;
    private MainActivityPresenter mainActivityPresenter;
    public MainActivityModel(Context mContext, MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter=mainActivityPresenter;
        this.mContext=mContext;
    }

    @Override
    public void sendNameToDatabase(String name) {
        /// call database or any server call from here
        /// then get the result and calll presenter and update ui
        FirebaseDatabase firebaseDatabase = new FirebaseDatabase();
        boolean result = firebaseDatabase.uploadNameToFirebase(name);
        if(result){
            mainActivityPresenter.updateUI(StaticVariables.UPLOAD_SUCCESS);
        }
        else{
            mainActivityPresenter.updateUI(StaticVariables.UPLOAD_FAILED);
        }
    }
}
