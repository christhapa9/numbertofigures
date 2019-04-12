package com.example.numberstofigures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txt_Number;
    private TextView txt_Result;
    private Button btn_Convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setAction();
    }
    private void initiate(){
        txt_Number=findViewById(R.id.txtInput);
        txt_Result=findViewById(R.id.txtOutput);
        btn_Convert=findViewById(R.id.btn_convert);
    }
    private void setAction(){
        btn_Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(txt_Number.getText().toString());
                model model = new model();
                if (input < 20) {

                    txt_Result.setText(model.getOnes()[input]);
                } else if (input < 100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        txt_Result.setText(model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        txt_Result.setText(model.getTens()[tensIndex]);
                    }
                } else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0) {
                        txt_Result.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex]
                                + " " + model.getOnes()[onesIndex]);
                    } else {
                        txt_Result.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex]);
                    }
                }
            }});
        }
    }
