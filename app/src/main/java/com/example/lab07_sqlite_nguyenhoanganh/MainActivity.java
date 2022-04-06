package com.example.lab07_sqlite_nguyenhoanganh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnCreen01;
    private Button btnCreen02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnCreen01 = (Button) findViewById(R.id.button4);
        btnCreen02 = (Button) findViewById(R.id.button6);
        btnCreen01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        btnCreen02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListTravel();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, BasicSqlite.class);
        startActivity(intent);
    }
    public void openListTravel(){
        Intent intent = new Intent(this, CustomListTravel.class);
        startActivity(intent);
    }

}