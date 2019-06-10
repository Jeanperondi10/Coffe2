package com.example.seu_cafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int n = 0, preco = 0, total = 0;
    TextView text, textView, totalView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        textView = findViewById(R.id.textoUnid);
        totalView = findViewById(R.id.textoTotal);
    }

    public void button1(View view) {
        preco = 4;
        calculo();
    }

    public void button2(View view) {
        preco = 5;
        calculo();
    }

    public void button3(View view) {
        preco = 6;
        calculo();
    }

    public void button4(View view) {
        preco = 7;
        calculo();
    }

    public void button5(View view) {
        preco = 3;
        calculo();
    }

    public void button6(View view) {
        preco = 4;
        calculo();
    }//DFSADA

    public void reduz(View view) {
        if (n > 0) {
            n--;
            text.setText("" + n);
            calculo();
        }
    }

    public void aumenta(View view) {
        n++;
        text.setText("" + n);
        calculo();
    }

    public void calculo() {
        total = preco * n;
        textView.setText("Preco Unidade: " + preco);
        totalView.setText("Preco Total: " + total);
    }



}
