package com.example.acer.calculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Button zeroBtn;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divideBtn;
    private Button clearBtn;
    private Button equaltoBtn;
    private Button percentBtn;
    private EditText dataEditText;
    private TextView resultTextView;
    private final char addition = '+';
    private final char subtraction = '-';
    private final char multiplication = '*';
    private final char division = '/';
    private final char percent = '%';
    private final char equal = 0;
    private double val1 = Double.NaN;
    private double val2;
    private double answer;
    private char action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"0");
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"1");
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"2");
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"3");
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"4");
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"5");
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"6");
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"7");
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"8");
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEditText.setText(dataEditText.getText().toString()+"9");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                action = addition;
                resultTextView.setText(String.valueOf(val1) + "+");
                dataEditText.setText(null);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                action = subtraction;
                resultTextView.setText(String.valueOf(val1) + "-");
                dataEditText.setText(null);
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                action = multiplication;
                resultTextView.setText(String.valueOf(val1) + "*");
                dataEditText.setText(null);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                action = division;
                resultTextView.setText(String.valueOf(val1) + "/");
                dataEditText.setText(null);
            }
        });

        percentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                action = percent;
                resultTextView.setText(String.valueOf(val1) + "%");
                dataEditText.setText(null);
            }
        });



        equaltoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                action = equal;
                resultTextView.setText(resultTextView.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(answer));
                dataEditText.setText(String.valueOf(answer));
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataEditText.getText().length() > 0){
                    CharSequence data = dataEditText.getText().toString();
                    dataEditText.setText(data.subSequence(0, data.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    dataEditText.setText(null);
                    resultTextView.setText(null);
                }
            }
        });
    }

    private void setupUIViews(){

        zeroBtn = (Button) findViewById(R.id.zeroBtn);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        twoBtn = (Button) findViewById(R.id.twoBtn);
        threeBtn = (Button) findViewById(R.id.threeBtn);
        fourBtn = (Button) findViewById(R.id.fourBtn);
        fiveBtn = (Button) findViewById(R.id.fiveBtn);
        sixBtn = (Button) findViewById(R.id.sixBtn);
        sevenBtn = (Button) findViewById(R.id.sevenBtn);
        eightBtn = (Button) findViewById(R.id.eightBtn);
        nineBtn = (Button) findViewById(R.id.nineBtn);
        addBtn = (Button) findViewById(R.id.addBtn);
        subBtn = (Button) findViewById(R.id.subBtn);
        mulBtn = (Button) findViewById(R.id.mulBtn);
        divideBtn = (Button) findViewById(R.id.divideBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        equaltoBtn = (Button) findViewById(R.id.equaltoBtn);
        percentBtn = (Button) findViewById(R.id.percentBtn);
        dataEditText = (EditText) findViewById(R.id.dataEditText);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    private void calculate(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(dataEditText.getText().toString());

            switch(action){
                case addition:
                    answer = val1 + val2;
                    break;
                case subtraction:
                    answer = val1 - val2;
                    break;
                case multiplication:
                    answer = val1 * val2;
                    break;
                case division:
                    answer = val1 / val2;
                    break;
                case percent:
                    answer = (val1/100)*val2;
                case equal:
                    break;
            }
            val1 = answer;
        }
        else{
            val1 = Double.parseDouble(dataEditText.getText().toString());
        }
    }
}
