package com.learnandroid.personnelapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnFocusChangeListener;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity {
    private Personnel person;
    private EditText name;
    private EditText address;
    private EditText phone;
    private EditText email;
    private EditText position;
    private EditText supervisor;
    private EditText role;
    private EditText birthday;
    private TextView age;
    private CheckBox married;
    private Calendar c;
    private TextView showName;
    private TextView showAddress;
    private TextView showPhone;
    private TextView showEmail;
    private TextView showSupervisor;
    private TextView showPosition;
    private TextView showRole;
    private TextView showBirthday;
    private TextView showMarried;
    private TextView personId;
    private ImageView headerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = new Personnel();

        personId = (EditText)findViewById(R.id.txtID);
        name=(EditText)findViewById(R.id.txtName);
        showName = (TextView)findViewById(R.id.showName);
        address=(EditText)findViewById(R.id.txtAddress);
        showAddress = (TextView)findViewById(R.id.showAddress);
        phone=(EditText)findViewById(R.id.txtPhone);
        showPhone = (TextView)findViewById(R.id.showPhone);
        email=(EditText)findViewById(R.id.txtEmail);
        showEmail = (TextView)findViewById(R.id.showEmail);
        position=(EditText)findViewById(R.id.txtPosition);
        showPosition = (TextView)findViewById(R.id.showPosition);
        supervisor=(EditText)findViewById(R.id.txtSupervisor);
        showSupervisor = (TextView)findViewById(R.id.showSupervisor);
        role=(EditText)findViewById(R.id.txtRole);
        showRole = (TextView)findViewById(R.id.showRole);
        birthday=(EditText)findViewById(R.id.txtBirthday);
        showBirthday = (TextView)findViewById(R.id.showBirthday);
        age=(TextView) findViewById(R.id.txtAge);
        married=(CheckBox) findViewById(R.id.isMarried);
        showMarried = (TextView)findViewById(R.id.showMarried);
        headerImage = (ImageView)findViewById(R.id.txtImage);
        personId = (TextView)findViewById(R.id.txtID);

        name.setOnFocusChangeListener(focusChangeListener);
        address.setOnFocusChangeListener(focusChangeListener);
        email.setOnFocusChangeListener(focusChangeListener);
        phone.setOnFocusChangeListener(focusChangeListener);
        position.setOnFocusChangeListener(focusChangeListener);
        supervisor.setOnFocusChangeListener(focusChangeListener);
        role.setOnFocusChangeListener(focusChangeListener);
        birthday.setOnFocusChangeListener(focusChangeListener);
        personId.setOnFocusChangeListener(focusChangeListener);




        married.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(married.isChecked()){
                    person.setMarried(true);
                    showMarried.setText("Yes");
                }
                else{
                    person.setMarried(false);
                    showMarried.setText("No");
                }

            }
        });



    }



   OnFocusChangeListener focusChangeListener = new OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {

                switch (v.getId()) {
                    case R.id.txtName:
                        person.setName(name.getText().toString());
                        showName.setText(person.getName());
                        Log.d("Name EditTextChanged", "onFocusChange: " + name.getText().toString() +
                                "***" + person.getName());
                        break;

                    case R.id.txtAddress:
                        person.setAddress(address.getText().toString());
                        showAddress.setText(person.getAddress());
                        break;

                    case R.id.txtPhone:
                        person.setPhone(phone.getText().toString());
                        showPhone.setText(person.getPhone());
                        break;

                    case R.id.txtEmail:
                        person.setEmail(email.getText().toString());
                        showEmail.setText(person.getEmail());
                        break;

                    case R.id.txtPosition:
                        person.setJobPosition(position.getText().toString());
                        showPosition.setText(person.getJobPosition());
                        break;

                    case R.id.txtSupervisor:
                        person.setSupervisorName(supervisor.getText().toString());
                        showSupervisor.setText(person.getSupervisorName());
                        break;

                    case R.id.txtRole:
                        person.setRole(role.getText().toString());
                        showRole.setText(person.getRole());
                        break;

                    case R.id.txtBirthday:
                        DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
                        Date newBirthday = null;
                        try {
                            newBirthday = dateformat.parse(birthday.getText().toString());
                            person.setBirthday(newBirthday);
                            person.setAge();
                            age.setText(String.valueOf(person.getAge()));
                            showBirthday.setText(dateformat.format(person.getBirthday()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;

                    case R.id.txtID:
                        if (Integer.parseInt(personId.getText().toString())==1){

                            headerImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.personnel1));
                        }
                        else if (Integer.parseInt(personId.getText().toString())==2){

                            headerImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.personnel2));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),
                                    "Personal ID can only be 1 or 2, please enter a valid number!",Toast.LENGTH_LONG).show();

                        }
                        break;



                }
            }

        }
    };
}
