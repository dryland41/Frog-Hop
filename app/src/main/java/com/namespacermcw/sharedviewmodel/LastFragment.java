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

import org.w3c.dom.Text;

public class LastFragment extends Fragment {
    private SharedViewModel viewModel;
    //private EditText editText;
    private TextView frogs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_last, container, false);

        //editText = v.findViewById(R.id.edit_text);
        frogs = v.findViewById(R.id.last_text);
        Button button = v.findViewById(R.id.button_jump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewModel.setText(editText.getText());
                viewModel.setTextOne("FROG FROG FROG");
                viewModel.setTextTwo("FROG");
                viewModel.setTextThree("FROG FROG");
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getTextThree().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                //editText.setText(charSequence);
                frogs.setText(charSequence);
            }
        });
    }
}