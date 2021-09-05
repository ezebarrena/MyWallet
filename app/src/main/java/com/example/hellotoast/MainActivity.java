package com.example.hellotoast;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int monto;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_ingreso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIncomeActivity(view);
            }
        });


    }

    public void openIncomeActivity(View view){
        Intent intent = new Intent(this, IncomeActivity.class);
        int requestCode = 1;
        startActivityForResult(intent, requestCode);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if (resultCode == RESULT_OK){
                int montoIngreso = Integer.parseInt(data.getStringExtra("numero"));
                monto = monto + montoIngreso;
                String montoTexto = String.valueOf(monto);

            }
        }
    }


}