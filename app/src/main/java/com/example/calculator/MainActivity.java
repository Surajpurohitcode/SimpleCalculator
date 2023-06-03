package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,zero,dot;
    Button clear,dividebtn,reminder,multiply,sum,sub,reslut;
    String data;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        zero = findViewById(R.id.btnzero);
        clear = findViewById(R.id.clear_btn);
        dividebtn = findViewById(R.id.oprator2);
        reminder = findViewById(R.id.oprator3);
        sum = findViewById(R.id.sum);
        multiply = findViewById(R.id.multiply_btn);
        sub = findViewById(R.id.subtract);
        input = (EditText) findViewById(R.id.input);
        dot = findViewById(R.id.dot);
        output = findViewById(R.id.output);

        reslut = findViewById(R.id.reslut);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"9");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText("");
                output.setText("");
                output.setVisibility(View.GONE);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"0");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+".");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"-");
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"+");

            }
        });

        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"%");
            }
        });

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"÷");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data+"x");
            }
        });

        reslut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = data.replaceAll("%","/100");
                data = data.replaceAll("x","*");
                data = data.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finaloutput = "";
                Scriptable scriptable = rhino.initSafeStandardObjects();
                finaloutput = rhino.evaluateString(scriptable,data,"javascript",1,null).toString();
                output.setText(finaloutput);
                output.setVisibility(View.VISIBLE);

            }
        });


    }
}