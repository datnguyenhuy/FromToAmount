package com.example.fromtoamount;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner editFrom,editTo;
    EditText editAmount,editResult;
    List<String> list;
    ArrayAdapter<String> adapter;

    double[] tygia={20000,10000,5000,2000,1000,500} ;
    double getTo,getFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTo=findViewById(R.id.edit_to);
        editFrom=findViewById(R.id.edit_from);
        editAmount=findViewById(R.id.edit_amount);
        editResult=findViewById(R.id.edit_result);

        list= new ArrayList<>();
        list.add("USD");
        list.add("EUR");
        list.add("VND");
        list.add("YEN");
        list.add("LAO");
        list.add("NDT");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list);
        editTo.setAdapter(adapter);
        editTo.setSelection(5);
        editFrom.setSelection(4);
        editFrom.setAdapter(adapter);

        editTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getTo=tygia[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getFrom=tygia[position];
                try{
                    //if(editAmount.getText().toString()!="")
                    {
                        double amount= Double.parseDouble(editAmount.getText().toString());
                        double result=amount*getFrom/getTo;
                        editResult.setText(String.format("%.2f",result));
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    {
                        double amount= Double.parseDouble(editAmount.getText().toString());
                        double result=amount*getFrom/getTo;
                        editResult.setText(String.format("%.2f",result));
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}