package com.learnandroid.autocalculatorfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**基本逻辑为
 * 1  分别创建fragment的xml和java class
 * 2. 分别在碎片中创建可以传递数据的接口
 * 3. 在mainactivity实现接口
 * 4. 在mainactivity中创建更换碎片的方法
 * 5. 数据可以在接口中自动传输
 * 6. 数据传递后获得当前的MainActivity实例
 * 7. 在OnlickListenner中出发事件，使用mainactivity的实例中的更换碎片的方法，即可实现数据的交互传递
 */
public class Fragment1 extends Fragment {
    private MainActivity mainActivity;
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
    private SendData sendData;
    private Bundle receiveResultBundle;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


    View view =inflater.inflate(R.layout.fragment1, container, false);


        //mainActivity = (MainActivity) getActivity();
        price =(EditText)view.findViewById(R.id.txtPrice);
        downPayment = (EditText)view.findViewById(R.id.txtDown);
        yearOpts = (RadioGroup) view.findViewById(R.id.yearOptions);
        loadReport = (Button) view.findViewById(R.id.load);
        result = (TextView) view.findViewById(R.id.reportResult);
        Integer year = yearOpts.getCheckedRadioButtonId();
        RadioButton yearChecked = view.findViewById(year);

        Log.d("Fragment1", "onCreateView");
        /**mainActivity = (MainActivity) getActivity();
        price =(EditText)mainActivity.findViewById(R.id.txtPrice);
        downPayment = (EditText)mainActivity.findViewById(R.id.txtDown);
        yearOpts = (RadioGroup) mainActivity.findViewById(R.id.yearOptions);
        loadReport = (Button) mainActivity.findViewById(R.id.load);
        result = (TextView) mainActivity.findViewById(R.id.reportResult);
        Integer year = yearOpts.getCheckedRadioButtonId();
        RadioButton yearChecked = mainActivity.findViewById(year);**/
        term = yearChecked.getText().toString();
        loadReport.setOnClickListener(loadListener);
        receiveResult();

        return view;

   //---Inflate the layout for this fragment---

    }



/**    @Override
    public void onStart() {
        super.onStart();



        mainActivity = (MainActivity) getActivity();
        price =(EditText)mainActivity.findViewById(R.id.txtPrice);
        downPayment = (EditText)mainActivity.findViewById(R.id.txtDown);
        yearOpts = (RadioGroup) mainActivity.findViewById(R.id.yearOptions);
        loadReport = (Button) mainActivity.findViewById(R.id.load);
        result = (TextView) mainActivity.findViewById(R.id.reportResult);
        Integer year = yearOpts.getCheckedRadioButtonId();
        RadioButton yearChecked = mainActivity.findViewById(year);
        term = yearChecked.getText().toString();


        loadReport.setOnClickListener(loadListener);



    }**/

    @Override
    public void onAttach(Context context) {

        try {
            sendData = (SendData) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
        super.onAttach(context);
    }


    View.OnClickListener loadListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!TextUtils.isEmpty(price.getText()) && !TextUtils.isEmpty(downPayment.getText())){

                Bundle bundle = new Bundle();
                bundle.putString("price",price.getText().toString());
                bundle.putString("downPayment",downPayment.getText().toString());
                bundle.putString("term", term);
                sendData.BundleTransmit(bundle,2);

                price.setText("");
                downPayment.setText("");
                mainActivity = (MainActivity)getActivity();
                mainActivity.switchFragments();


            }
            else{
                Toast.makeText(view.getContext().getApplicationContext(),
                        "Please enter a valid number!",Toast.LENGTH_LONG).show();
            }

        }


    };



    public interface SendData{
        public void BundleTransmit(Bundle bundle, int num);

    }


    public void receiveResult(){
        mainActivity = (MainActivity)getActivity();
        receiveResultBundle = mainActivity.bundleFragment2;
        if(receiveResultBundle != null){
            totalCost = receiveResultBundle.getString("totalCost");
            borrowAmount = receiveResultBundle.getString("borrowAmount");
            interestAmount = receiveResultBundle.getString("interestAmount");
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
