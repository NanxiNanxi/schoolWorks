package com.learnandroid.automativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Auto myAuto;
    String monthlyPayment;
    String report;

    private EditText price;
    private EditText downPayment;
    private RadioGroup yearOpts;
    private Button loadReport;
   // private double downPaymentValue;
    //private double tax;
    private String totalCost = "";
    private String borrowAmount;
    private String interestAmount;
    //private double monthPay;
    private String term;
    private TextView result;
    private String showResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*myAuto = new Auto();*/
        price = (EditText)findViewById(R.id.txtPrice);
        downPayment = (EditText)findViewById(R.id.txtDown);
        yearOpts = (RadioGroup)findViewById(R.id.yearOptions);
        loadReport = (Button)findViewById(R.id.load);
        result = (TextView)findViewById(R.id.reportResult);

        /*receiveResult();
        buildResult();*/





        Integer year = yearOpts.getCheckedRadioButtonId();
        RadioButton yearChecked = (RadioButton)findViewById(year);
        term = yearChecked.getText().toString();

        loadReport.setOnClickListener(loadListener);







    }
    View.OnClickListener loadListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!TextUtils.isEmpty(price.getText()) && !TextUtils.isEmpty(downPayment.getText())){

                sendToReport();


               /* myAuto.setPrice(Double.parseDouble(String.valueOf(price.getText().toString())));
                myAuto.setDownPayment(Double.parseDouble(String.valueOf(downPayment.getText().toString())));
                myAuto.setLoanTerm(term);
                downPaymentValue = myAuto.getDownPayment();
                tax = myAuto.taxAmount();
                totalCost = myAuto.totalCost();
                borrowAmount=myAuto.borrowedAmount();
                interestAmount=myAuto.interestAmount();
                monthPay = myAuto.monthlyPayment();
                sendToReport();
                price.setText("");
                downPayment.setText("");*/
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Please enter a valid number!",Toast.LENGTH_LONG).show();
            }

            }


    };

    public void sendToReport(){
        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        bundle.putString("price",price.getText().toString());
        bundle.putString("downPayment",downPayment.getText().toString());
        bundle.putString("term", term);
        /*bundle.putString("downPaymentValue", String.format("%.2f",downPaymentValue));
        bundle.putString("tax", String.format("%.2f",tax));
        bundle.putString("totalCost",String.format("%.2f",totalCost));
        bundle.putString("borrowAmount", String.format("%.2f",borrowAmount));
        bundle.putString("interestAmount", String.format("%.2f",interestAmount));
        bundle.putString("monthPay",String.format("%.2f",monthPay));
        bundle.putString("price",price.getText().toString());
        bundle.putString("term",term);*/

        intent.putExtras(bundle);
        intent.setClass(this,LoanReportActivity.class);
        startActivityForResult(intent,1000);
}

    public void receiveResult(){
        Intent getIntent = getIntent();
         Bundle getBundle = getIntent.getExtras();
            totalCost = getBundle.getString("totalCost");
            borrowAmount = getBundle.getString("borrowAmount");
            interestAmount = getBundle.getString("interestAmount");



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1000 && resultCode == 1001){
            Bundle getBundle = data.getExtras();
            totalCost = getBundle.getString("totalCost");
            borrowAmount = getBundle.getString("borrowAmount");
            interestAmount = getBundle.getString("interestAmount");
            buildResult();
            result.setText(showResult);
        }

    }

    public void buildResult(){
        if (totalCost != "") {
            showResult = (String)this.getResources().getString(R.string.report_pay4)+totalCost
                    +(String)this.getResources().getString(R.string.report_pay5)+borrowAmount
                    +(String)this.getResources().getString(R.string.report_pay6)+interestAmount;

        }
        else{
            showResult = "";
        }



    }



}
