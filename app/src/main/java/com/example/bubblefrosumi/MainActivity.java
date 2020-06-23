package com.example.bubblefrosumi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Here we create lists of messages and usernames
    List<String> listMessages=new ArrayList<String>();
    List<String> listBelngWho=new ArrayList<String>();
    // This is for spinner to choose the user
    String category = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Our main list view
        final ListView listView=findViewById(R.id.listView);



        // Spinner to choose the user
        final Spinner spinnerCategory = (Spinner) findViewById(R.id.spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("Me");
        categories.add("Sumi");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinnerCategory.setAdapter(dataAdapter);
        // Here we choose the user (you or me)
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                if (item != null && item.toString() != "Choose the category") {
                    category = item.toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });




        // Textview for the message text
        final EditText editText=findViewById(R.id.editText);
        // Button send
        Button button=findViewById(R.id.button);
        // If the user is me then we add "Me" to the list of users that will further indicate to our adapter that it has to choose the layout "my_message" and if it is "Sumi" then their_message
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=editText.getText().toString();
                if (category.equals("Me")){

                    listMessages.add(editText.getText().toString());
                    listBelngWho.add("Me");

                    // now we convert the lists to arrays because the ArrayAdapter needs arrays

                    String[] listMessagesArray=new String[listMessages.size()];
                    listMessages.toArray(listMessagesArray);

                    String[] listBelngWhoArray=new String[listBelngWho.size()];
                    listBelngWho.toArray(listBelngWhoArray);


                    listView.setAdapter( new MessageAdapter(MainActivity.this, listMessagesArray,listBelngWhoArray) );
                }
                if (category.equals("Sumi")){

                    listMessages.add(editText.getText().toString());
                    listBelngWho.add("Sumi");


                    String[] listMessagesArray=new String[listMessages.size()];
                    listMessages.toArray(listMessagesArray);

                    String[] listBelngWhoArray=new String[listBelngWho.size()];
                    listBelngWho.toArray(listBelngWhoArray);


                    listView.setAdapter( new MessageAdapter(MainActivity.this, listMessagesArray,listBelngWhoArray) );
                }
            }
        });





    }
}
