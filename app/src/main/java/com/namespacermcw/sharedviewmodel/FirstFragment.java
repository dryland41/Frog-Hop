package com.namespacermcw.sharedviewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private SharedViewModel viewModel;
    //private EditText editText;
    private TextView frogs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

//        editText = v.findViewById(R.id.edit_text);
        frogs = v.findViewById(R.id.first_text);
        Button button = v.findViewById(R.id.button_jump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewModel.setText(editText.getText());
                viewModel.setNumFrogsFirst(viewModel.getNumFrogsFirst() - 1);
                viewModel.setNumFrogsLast(viewModel.getNumFrogsLast() + 1);
                //viewModel.setText(editText.getText());
                if (viewModel.getNumFrogsFirst() == 3) {
                    viewModel.setTextOne(getString(R.string.three_frogs));
                } else if (viewModel.getNumFrogsFirst() == 2) {
                    viewModel.setTextOne(getString(R.string.two_frogs));
                } else if (viewModel.getNumFrogsFirst() == 1) {
                    viewModel.setTextOne(getString(R.string.one_frog));
                } else viewModel.setTextOne(getString(R.string.no_frogs));

                if (viewModel.getGetNumFrogsMiddle() == 3) {
                    viewModel.setTextTwo(getString(R.string.three_frogs));
                } else if (viewModel.getGetNumFrogsMiddle() == 2) {
                    viewModel.setTextTwo(getString(R.string.two_frogs));
                } else if (viewModel.getGetNumFrogsMiddle() == 1) {
                    viewModel.setTextTwo(getString(R.string.one_frog));
                } else viewModel.setTextTwo(getString(R.string.no_frogs));

                if (viewModel.getNumFrogsLast() == 3) {
                    viewModel.setTextThree(getString(R.string.three_frogs));
                } else if (viewModel.getNumFrogsLast() == 2) {
                    viewModel.setTextThree(getString(R.string.two_frogs));
                } else if (viewModel.getNumFrogsLast() == 1) {
                    viewModel.setTextThree(getString(R.string.one_frog));
                } else viewModel.setTextThree(getString(R.string.no_frogs));
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getTextOne().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                //editText.setText(charSequence);
                frogs.setText(charSequence);
            }
        });
    }
}