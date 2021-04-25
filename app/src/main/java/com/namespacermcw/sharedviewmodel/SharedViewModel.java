package com.namespacermcw.sharedviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<CharSequence> textOne = new MutableLiveData<>();

    public void setTextOne(CharSequence input) {
        textOne.setValue(input);
    }

    public LiveData<CharSequence> getTextOne() {
        return textOne;
    }

    private MutableLiveData<CharSequence> textTwo = new MutableLiveData<>();

    public void setTextTwo(CharSequence input) {
        textTwo.setValue(input);
    }

    public LiveData<CharSequence> getTextTwo() {
        return textTwo;
    }

    private MutableLiveData<CharSequence> textThree = new MutableLiveData<>();

    public void setTextThree(CharSequence input) {
        textThree.setValue(input);
    }

    public LiveData<CharSequence> getTextThree() {
        return textThree;
    }
}
