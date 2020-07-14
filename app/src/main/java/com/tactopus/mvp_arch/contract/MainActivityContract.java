package com.tactopus.mvp_arch.contract;

public interface MainActivityContract {
    interface View{
        void initView();

        String getName();

        void updateUi(String whichUi);
    }

    interface Model{
        void sendNameToDatabase(String name);
    }

    interface Presenter{
        void onClick(android.view.View view);
        void updateUI(String whichUi);
    }
}
