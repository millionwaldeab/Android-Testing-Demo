package com.asmarasoftwaresolutions.testcasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asmarasoftwaresolutions.domain_layer.computations.ComputationsInterfaceImpl;

public class MainActivity extends AppCompatActivity {
    private TextView mResult, mDescription;
    private EditText mUserInput;
    private Button mShow;
    private Spinner mCountriesList, mUnitsList;
    private ComputationsInterfaceImpl mComputationsInterfaceImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResult = findViewById(R.id.tv_result);
        mDescription = findViewById(R.id.tv_input_description);
        mUserInput = findViewById(R.id.et_user_input);
        mShow = findViewById(R.id.b_show);
        mCountriesList = findViewById(R.id.s_countries);
        mUnitsList = findViewById(R.id.s_measurement_units);
        mComputationsInterfaceImpl = new ComputationsInterfaceImpl();
        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getComputation(mUserInput.getText().toString());
            }
        });
    }

    public void getComputation(String arg) {
        if (arg.isEmpty()){
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.no_input_submitted_error),
                    Toast.LENGTH_LONG).show();
            mResult.setText(getResources().getText(R.string.no_input_submitted_error));
            return;
        }
        //convert to imperial system
        if (mCountriesList.getSelectedItemPosition() == 0 || mCountriesList.getSelectedItemPosition() == 5) {
            if (mUnitsList.getSelectedItemPosition() == 0) {
                mResult.setText(String.valueOf(mComputationsInterfaceImpl.centimeterToInches(arg)));
            }
            if (mUnitsList.getSelectedItemPosition() == 1) {
                mResult.setText(String.valueOf(mComputationsInterfaceImpl.kgToLb(arg)));
            }
            if (mUnitsList.getSelectedItemPosition() == 2) {
                mResult.setText(String.valueOf(mComputationsInterfaceImpl.celsiusToFrenheit(arg)));
            }
        } else {
            //convert to metric system
            if (mUnitsList.getSelectedItemPosition() == 0) {
                mResult.setText(String.valueOf(mComputationsInterfaceImpl.inchesToCentimeter(arg)));
            }
            if (mUnitsList.getSelectedItemPosition() == 1) {
                mResult.setText(String.valueOf(mComputationsInterfaceImpl.lbToKg(arg)));
            }
            if (mUnitsList.getSelectedItemPosition() == 2) {
                mResult.setText(String.valueOf(mComputationsInterfaceImpl.frenheitToCelcius(arg)));
            }
        }
    }
}
