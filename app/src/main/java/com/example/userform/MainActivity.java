package com.example.userform;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void submit(View view) {
        EditText txt = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);


        String name = txt.getText().toString();
        String mobile = phone.getText().toString();

        if(!name.matches("[a-zA-Z]+")){
            txt.setError("Name must be a character");
            txt.requestFocus();
        }

        if(mobile.matches("[a-zA-Z]+")){
            phone.setError("Phone must only contain numbers");
            phone.requestFocus();
        }

        Toast.makeText(this, "Thank you "+ name +", your request is being processed", Toast.LENGTH_SHORT).show();
    }
}