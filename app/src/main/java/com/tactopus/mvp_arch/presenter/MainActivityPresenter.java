package com.tactopus.mvp_arch.presenter;

import android.content.Context;

import com.tactopus.mvp_arch.R;
import com.tactopus.mvp_arch.contract.MainActivityContract;
import com.tactopus.mvp_arch.model.MainActivityModel;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static  String TAG = "MainActivityPresenter";
    private MainActivityContract.View mView;
    private Context mContext;
    private MainActivityContract.Model model;

    public MainActivityPresenter(MainActivityContract.View view, Context context){
        mView=view;
        mContext=context;
        initPresenter();
    }

    private void initPresenter(){
        model= new MainActivityModel(mContext,this);
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view) {

        if(view.getId()== R.id.send_button){
            model.sendNameToDatabase(mView.getName());
        }
    }

    @Override
    public void updateUI(String whichUi) {
        mView.updateUi(whichUi);
    }

}
