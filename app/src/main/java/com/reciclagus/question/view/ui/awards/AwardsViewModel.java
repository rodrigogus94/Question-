package com.reciclagus.question.view.ui.awards;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AwardsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AwardsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}