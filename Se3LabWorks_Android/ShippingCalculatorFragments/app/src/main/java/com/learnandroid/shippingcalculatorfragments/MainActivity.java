package com.learnandroid.shippingcalculatorfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TASK 4: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT

        int mCurrentOrientation = getResources().getConfiguration().orientation;

        if ( mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT ) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            fragment = new Fragment1();
            //---landscape mode---
            // android.R.id.content refers to the content
            // view of the activity
            fragmentTransaction.replace(
                    android.R.id.content,fragment);
            // android.R.id.content refers to the content
            // view of the activity
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();



        } else if ( mCurrentOrientation== Configuration.ORIENTATION_LANDSCAPE ) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            //---landscape mode---
            // android.R.id.content refers to the content
            // view of the activity
            fragment = new Fragment2();
            fragmentTransaction.replace(
                    android.R.id.content, fragment);
            // android.R.id.content refers to the content
            // view of the activity
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        //CREATE THE DATA MODEL FOR STORING THE ITEM TO BE SHIPPED
        shipItem = new ShipItem();


       /** Log.d("Fragment", fragment.getView().toString());
        //TASK 3: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT
        weightET = fragment.getView().findViewById(R.id.editText1);

        //TASK 3: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        baseCostTV = fragment.getView().findViewById(R.id.textView4);
        addedCostTV = fragment.getView().findViewById(R.id.textView6);
        totalCostTV = fragment.getView().findViewById(R.id.textView8);
        weightET.addTextChangedListener(weightTextWatcher);**/


    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int mCurrentOrientation = getResources().getConfiguration().orientation;

        if ( mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT ) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            fragment = new Fragment1();
            //---landscape mode---
            // android.R.id.content refers to the content
            // view of the activity
            fragmentTransaction.replace(
                    android.R.id.content,fragment);
            // android.R.id.content refers to the content
            // view of the activity
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();



        } else if ( mCurrentOrientation== Configuration.ORIENTATION_LANDSCAPE ) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            //---landscape mode---
            // android.R.id.content refers to the content
            // view of the activity
            fragment = new Fragment2();
            fragmentTransaction.replace(
                    android.R.id.content, fragment);
            // android.R.id.content refers to the content
            // view of the activity
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }


    }


}
