package ru.myitschool.lesson15122020;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class CalcActivity extends AppCompatActivity {
    EditText editA, editB;
    TextView textView;
    Button div;
    double a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        editA = (EditText) findViewById(R.id.edittextA);
        editB = findViewById(R.id.edittextB);
        textView = findViewById(R.id.textView);
        div = findViewById(R.id.div);


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    a = Double.parseDouble(editA.getText().toString());
                    b = Double.parseDouble(editB.getText().toString());
                    if (b != 0)
                        textView.setText("" + a / b);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Не верный ввод " + e.toString(), Toast.LENGTH_SHORT).show();
                    textView.setText("Не верный ввод " + e.toString());
                }


            }
        });

    }
}