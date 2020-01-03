package com.learnandroid.hellogoodbye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView greetingTextView;
    private boolean isHello;
    private TextView headerTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingTextView = (TextView)findViewById(R.id.button);
        initializeGreeting();
        headerTextView  = (TextView) findViewById(R.id.editText);

        Button exclaimBtn = (Button)findViewById(R.id.button);
        exclaimBtn.setOnClickListener(toggleGreeting);


    }

    private void initializeGreeting(){
        isHello = true;
    }
   /* public void onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.m, menu);
    }*/

    private final View.OnClickListener toggleGreeting =
            new View.OnClickListener(){
                @Override
                public void onClick(View btn) {
                    if(isHello){
                        isHello = false;
                        greetingTextView.setText(R.string.goodbye);
                        headerTextView.setText("GoodBye!");

                    }else{
                        isHello = true;
                        greetingTextView.setText(R.string.hello);
                        headerTextView.setText("Hello!");
                    }
                }
            };

}
