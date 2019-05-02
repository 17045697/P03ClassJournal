package com.example.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;

public class add_page extends AppCompatActivity {

    int requestCode = 1;
    Button btna, btnb, btnc, btnd, btnf, btnx;
    Button btnSubmit;
    RadioGroup RG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        RG = findViewById(R.id.grade);
        btna = findViewById(R.id.radioButtonA);
        btnb = findViewById(R.id.radioButtonB);
        btnc = findViewById(R.id.radioButtonC);
        btnd = findViewById(R.id.radioButtonD);
        btnf = findViewById(R.id.radioButtonF);
        btnx = findViewById(R.id.radioButtonX);

        btnSubmit = findViewById(R.id.buttonSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = RG.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selected);
                Intent i = new Intent();
                i.putExtra("grade", rb.getText().toString());
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }


}
