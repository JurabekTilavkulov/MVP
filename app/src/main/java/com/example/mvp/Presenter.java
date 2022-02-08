package com.example.mvp;

public class Presenter implements Contract.Presenter,Contract.Model.OnFinishedListener{


    private Contract.View mainView;
    private Contract.Model model;

    public Presenter(Contract.View mainView, Contract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void onFinished(String string) {
        if (mainView != null) {
            mainView.setString(string);
            mainView.hideProgress();
        }
    }

    @Override
    public void onButtonCLick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        model.getNextCourse(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
