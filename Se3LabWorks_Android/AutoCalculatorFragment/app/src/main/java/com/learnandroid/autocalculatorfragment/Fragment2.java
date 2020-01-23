package com.learnandroid.autocalculatorfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
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
    private MainActivity mainActivity;
    private Bundle getbundle;
    private SendData2 sendData2;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.d("Fragment1", "onCreateView");
        View view = inflater.inflate(R.layout.fragment2, container, false);
        mainActivity = (MainActivity) getActivity();
        getbundle = mainActivity.bundleFragment1;
        if (getbundle != null) {

            myAuto = new Auto();
            viewMonthlyPay = (TextView) view.findViewById(R.id.monthlyPay);
            viewLoanReport = (TextView) view.findViewById(R.id.report);
            btnBack = (Button) view.findViewById(R.id.btnBack);


            price = getbundle.getString("price");
            downPaymentValue = getbundle.getString("downPayment");
            term = getbundle.getString("term");
            calculateResult();
            reportBuilder();
            viewMonthlyPay.setText(strMonthlyPay);
            viewLoanReport.setText(strLoanReport);
            btnBack.setOnClickListener(btnListener);

            //---Inflate the layout for this fragment---

        }
        return view;
    }



        /*tax = bundle.getString("tax");
        totalCost = bundle.getString("totalCost");
        borrowAmount = bundle.getString("borrowAmount");
        interestAmount = bundle.getString("interestAmount");
        monthPay = bundle.getString("monthPay");*/






    public interface SendData2{
        public void sendResultBundle(Bundle bundle, int num);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            sendData2 = (SendData2) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
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
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Bundle bundle = new Bundle();
            bundle.putString("totalCost",totalCost);
            bundle.putString("interestAmount",interestAmount);
            bundle.putString("borrowAmount",borrowAmount);
            sendData2.sendResultBundle(bundle,1);
            mainActivity = (MainActivity)getActivity();
            mainActivity.switchFragments();

        }
    };
}
