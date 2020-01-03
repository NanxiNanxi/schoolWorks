package com.learnandroid.automativecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoanReportActivity extends Activity {

    private String price;
    private String downPaymentValue;
    private String tax;
    private String totalCost;
    private String borrowAmount;
    private String interestAmount;
    private String monthPay;
    private String strMonthlyPay;
    private String strLoanReport;
    private TextView viewMonthlyPay;
    private TextView viewLoanReport;
    private Button btnBack;
    private String term;
    private Auto myAuto;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_page);

        myAuto = new Auto();
        viewMonthlyPay = (TextView)findViewById(R.id.monthlyPay);
        viewLoanReport = (TextView)findViewById(R.id.report);
        btnBack = (Button)findViewById(R.id.btnBack);

        Intent intent = getIntent();

        Bundle getbundle = intent.getExtras();

        price = getbundle.getString("price");
        downPaymentValue = getbundle.getString("downPayment");
        term = getbundle.getString("term");
        calculateResult();

        /*tax = bundle.getString("tax");
        totalCost = bundle.getString("totalCost");
        borrowAmount = bundle.getString("borrowAmount");
        interestAmount = bundle.getString("interestAmount");
        monthPay = bundle.getString("monthPay");*/


        reportBuilder();
        viewMonthlyPay.setText(strMonthlyPay);
        viewLoanReport.setText(strLoanReport);
        btnBack.setOnClickListener(btnListener);


    }

    public void calculateResult(){
         myAuto.setPrice(Double.parseDouble(String.valueOf(price)));
                myAuto.setDownPayment(Double.parseDouble(String.valueOf(downPaymentValue)));
                myAuto.setLoanTerm(term);
                downPaymentValue = String.format("%.2f",myAuto.getDownPayment());
                tax = String.format("%.2f",myAuto.taxAmount());
                totalCost =String.format("%.2f", myAuto.totalCost());
                borrowAmount= String.format("%.2f",myAuto.borrowedAmount());
                interestAmount= String.format("%.2f",myAuto.interestAmount());
                monthPay = String.format("%.2f",myAuto.monthlyPayment());



    }
    public void reportBuilder(){

        strMonthlyPay =(String)this.getResources().getString(R.string.report_line1)+ monthPay
                +(String)this.getResources().getString(R.string.report_pay1)+price
                +(String)this.getResources().getString(R.string.report_pay2)+downPaymentValue
                +(String)this.getResources().getString(R.string.report_pay3)+tax
                +(String)this.getResources().getString(R.string.report_pay4)+totalCost
                +(String)this.getResources().getString(R.string.report_pay5)+borrowAmount
                +(String)this.getResources().getString(R.string.report_pay6)+interestAmount
                +"\n"
                +(String)this.getResources().getString(R.string.report_term)+" "+term;
        strLoanReport = (String)this.getResources().getString(R.string.report_note)
                +(String)this.getResources().getString(R.string.report_note1)
                +(String)this.getResources().getString(R.string.report_note2)
                +(String)this.getResources().getString(R.string.report_note3);
    }

    public void goBack(){
        Intent backIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("totalCost",totalCost);
        bundle.putString("interestAmount",interestAmount);
        bundle.putString("borrowAmount",borrowAmount);
        backIntent.putExtras(bundle);
        backIntent.setClass(this, MainActivity.class);
        //startActivity(backIntent);
        setResult(1001, backIntent);
        finish();

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goBack();

        }
    };
}
