package com.example.lab07_sqlite_nguyenhoanganh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListTravel extends AppCompatActivity {
    private List<Travel> listTravel;
    private ListView listView;
    private Button btnAdd;
    private Button btnCancel;
    private Button btnDelete;
    private TextView txtAdd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_travel);
        DatabaseHandlerTravel db = new DatabaseHandlerTravel(this);

        btnAdd = (Button) findViewById(R.id.button10);
        btnCancel = (Button) findViewById(R.id.button11);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //xoa rong text field
                txtAdd = findViewById(R.id.editTextTextPersonName2);
                txtAdd.setText("");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //get value in textAdd
                txtAdd = findViewById(R.id.editTextTextPersonName2);
                String value =  txtAdd.getText().toString();
                if(value.length()!=0){
                    db.addContact(new Travel(value));
                    txtAdd.setText("");
                    Toast.makeText( CustomListTravel.this,"Add Succesfully!" , Toast.LENGTH_LONG).show();
//                    //render
                    TravelAdapter adapter = new TravelAdapter(CustomListTravel.this, R.layout.activity_item_travel, renderData(db));
                    listView.setAdapter(adapter);
                }
                else{
                    Toast.makeText( CustomListTravel.this,"input không được để trống!" , Toast.LENGTH_LONG).show();
                }
            }
        });

        listView = (ListView) findViewById(R.id.list_travel);

        TravelAdapter adapter = new TravelAdapter(this, R.layout.activity_item_travel, renderData(db));
        listView.setAdapter(adapter);
    }


    //render list user into array
    public List<Travel> renderData(DatabaseHandlerTravel db){
        // Reading all contacts
        List<Travel> list = new ArrayList<Travel>();
        List<Travel> contacts = db.getAllContacts();
        for (Travel cn : contacts) {
            list.add(cn);
        }

        return list;
    }
}
