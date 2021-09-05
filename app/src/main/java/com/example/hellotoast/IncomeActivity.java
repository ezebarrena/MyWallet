package com.example.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IncomeActivity extends AppCompatActivity {

    private EditText editTextmontoIngreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        editTextmontoIngreso = findViewById(R.id.editNumberIncome);

        Button buttonAccept = findViewById(R.id.button_accept);
        buttonAccept.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (editTextmontoIngreso.getText().toString().equals("")){
                    Toast.makeText(IncomeActivity.this, "Inserte un numero", Toast.LENGTH_SHORT).show();
                } else{
                    int montoIngreso = Integer.parseInt(editTextmontoIngreso.getText().toString());
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("numero", montoIngreso);
                    setResult(RESULT_OK, resultIntent);
                }
            }
        });
    }


    public void backToMain(View view) {
    }
}