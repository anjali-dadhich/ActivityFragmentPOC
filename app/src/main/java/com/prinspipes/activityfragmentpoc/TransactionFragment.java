package com.prinspipes.activityfragmentpoc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionFragment extends Fragment {

     EditText editText;

    public TransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        editText = view.findViewById(R.id.editText);
        return view;
    }

    public boolean CheckAllFields() {
        Log.d("CheckAllFields: ", String.valueOf(editText.length()));
        if (editText.length() == 0) {
            ((MainActivity) requireActivity()).validationError = "Please select ARN";
            return false;
        }
        return true;
    }
}