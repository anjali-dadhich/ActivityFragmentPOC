package com.prinspipes.activityfragmentpoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    String validationError = "Please fill all fields"; // access and update by fragments
    TransactionFragment transactionFragmentObject; //global reference of fragment so only one reference is there
    Transaction2Fragment transaction2FragmentObject; //global reference of fragment so only one reference is there

    // use to identify current fragment
    int currentFragmentNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        //default fragmnet
        transactionFragmentObject = new TransactionFragment();
        addFragment(R.id.frameLayout, transactionFragmentObject,1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentFragmentNumber == 1){
                    // call fragment method to check validation
                    if (transactionFragmentObject.CheckAllFields()) {
                        // proceed to next fragment
                        transaction2FragmentObject = new Transaction2Fragment();
                        replaceFragment(R.id.frameLayout, transaction2FragmentObject, 2);
                    } else {
                        //show error
                        Toast.makeText(MainActivity.this, validationError, Toast.LENGTH_SHORT).show();
                    }
                } else if (currentFragmentNumber == 2) {
                    if (transaction2FragmentObject.CheckAllFields()) {
                        // proceed to next fragment
                        replaceFragment(R.id.frameLayout, transactionFragmentObject, 1);
                    } else {
                        //show error
                        Toast.makeText(MainActivity.this, validationError, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    private void addFragment(int frameLayoutId, Fragment fragmentObject, int fragmentNumber) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameLayoutId, fragmentObject);
        currentFragmentNumber = fragmentNumber;
        fragmentTransaction.commit();
    }

    private void replaceFragment(int frameLayoutId, Fragment fragmentObject, int fragmentNumber) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId, fragmentObject);
        currentFragmentNumber = fragmentNumber;
        fragmentTransaction.commit();
    }
}