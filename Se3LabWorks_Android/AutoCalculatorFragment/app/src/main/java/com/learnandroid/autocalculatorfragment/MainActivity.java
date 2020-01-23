package com.learnandroid.autocalculatorfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.learnandroid.autocalculatorfragment.Fragment1.SendData;
import com.learnandroid.autocalculatorfragment.Fragment2.SendData2;

public class MainActivity extends AppCompatActivity implements SendData, SendData2 {
    public Bundle bundleFragment1;
    public Bundle bundleFragment2;
    public int fragmentNumber =1;
    public MainActivity mainActivity;
    public Fragment1 fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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









    }
    public void switchFragments(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        if(fragmentNumber ==1 ){


            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(
                    android.R.id.content,fragment1);
            //---landscape mode---
            // android.R.id.content refers to the content
            // view of the activity

        }

        if(fragmentNumber ==2){

            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(
                    android.R.id.content,fragment2);
            //---landscape mode---
            // android.R.id.content refers to the content
            // view of the activity

        }

        // android.R.id.content refers to the content
        // view of the activity
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

/**    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

    }
**/

    @Override
    public void BundleTransmit(Bundle bundle, int num) {

        bundleFragment1 = bundle;
        fragmentNumber = num;
    }



    @Override
    public void sendResultBundle(Bundle bundle, int num) {

        bundleFragment2 = bundle;
        fragmentNumber =num;
    }


}
