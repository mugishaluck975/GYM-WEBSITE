package com.example.client_reg_form;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Student_Profile extends AppCompatActivity {

    EditText Std_Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Std_Profile = findViewById(R.id.std_profile);


        String Fname = getIntent().getStringExtra("FULLNAME");
        String Enroll = getIntent().getStringExtra("ENROLLMENT");
        String Pphone = getIntent().getStringExtra("PARENT CONTACT");
        String Dob = getIntent().getStringExtra("DOB");
        String Gdr = getIntent().getStringExtra("GENDER");
        String Cls = getIntent().getStringExtra("CLASS");

        String stdProfile = "FULLNAME:" + Fname + "\n"+
                "ENROLLMENT:" + Enroll + "\n" +
                "PARENT CONTACT:" + Pphone + "\n" +
                "DOB:" + Dob + "\n" +
                "GENDER" + Gdr + "\n"
                + "CLASS" + Cls;

        Std_Profile.setText(stdProfile);
    }
}