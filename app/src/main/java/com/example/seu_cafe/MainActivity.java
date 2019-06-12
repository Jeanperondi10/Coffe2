package com.example.seu_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int n = 0, preco = 0, total = 0;
    TextView text, textView, totalView;
    String tipo = "Nada";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        textView = findViewById(R.id.textoUnid);
        totalView = findViewById(R.id.textoTotal);


        Button btn = findViewById(R.id.send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                //sendEmail.setData(Uri.parse("mailto:jeanperondi10@gmail.com"));
                sendEmail.setType("*/*");
                String[] endereco = {"cafe.do.ifc.concordia@gmail.com"};
                sendEmail.putExtra(Intent.EXTRA_EMAIL, endereco);
                sendEmail.putExtra(Intent.EXTRA_TEXT, "Voce fez um pedido de cafe pelo aplicativo do Jean Perondi\nTipo:" + tipo + "\nPreco unid:" + preco + "\nQuantidade:" + n + "\nTotal:" + total);
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Pedido de café");
                if (sendEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendEmail);
                    Log.i("OnClick", "Intent enviado!");
                }
                Log.i("OnClick", "Botão pressionado");
            }
        });
    }

    public void button1(View view) {
        preco = 4;
        tipo = "Expresso";
        calculo();
    }

    public void button2(View view) {
        preco = 5;
        tipo = "Com leite";
        calculo();
    }

    public void button3(View view) {
        preco = 6;
        tipo = "Capuccino";
        calculo();
    }

    public void button4(View view) {
        preco = 7;
        tipo = "Pingado";
        calculo();
    }

    public void button5(View view) {
        preco = 3;
        tipo = "Macchiato";
        calculo();
    }

    public void button6(View view) {
        preco = 4;
        tipo = "Com chantily";
        calculo();
    }

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

    public void toast(View view) {
        Toast msg;
        if (n > 1) {
            msg = Toast.makeText(getApplicationContext(), "Voce comprou " + n + " cafes!", Toast.LENGTH_LONG);
        } else {
            msg = Toast.makeText(getApplicationContext(), "Voce comprou " + n + " cafe!", Toast.LENGTH_LONG);
        }
        msg.show();
    }


}
