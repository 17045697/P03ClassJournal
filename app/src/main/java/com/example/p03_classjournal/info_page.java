package com.example.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class info_page extends AppCompatActivity {

    Button btnInfo;
    Button btnAdd;
    Button btnEmail;
    TextView tvGrade;
    TextView tvWeek;
    ListView lvGrade;
    ArrayList<module> modules;
    ArrayAdapter aa;
    private Intent dataIntent;

    int requestCode1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmail);

        lvGrade = findViewById(R.id.LVGrade);
        tvWeek = findViewById(R.id.textViewWeek);
        tvGrade = findViewById(R.id.textViewGrade);

        Intent i = getIntent();
        String code = i.getStringExtra("code");
        setTitle("Info on " + code);

        modules = new ArrayList<module>();

        if (code.equalsIgnoreCase("C347")) {
            modules.add(new module(1, "A"));
            modules.add(new module(2, "B"));
        } else {
            modules.add(new module(1, "C"));
            modules.add(new module(2, "D"));
        }

        aa = new ModuleAdapter(this, R.layout.row, modules);
        lvGrade.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "";

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), add_page.class);
                int week = modules.get(modules.size() - 1).getWeek();
                intent.putExtra("week", week);
                startActivityForResult(intent, requestCode1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (resultCode == RESULT_OK) {
                String grade = dataIntent.getStringExtra("grade");
                modules.add(new module((modules.get(modules.size() - 1).getWeek() + 1), grade));
                aa.notifyDataSetChanged();
            }
        }

    }
}