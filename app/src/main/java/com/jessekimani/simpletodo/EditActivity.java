package com.jessekimani.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText updItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        updItem = findViewById(R.id.updItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Task");

        updItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //clicked when user is done editing
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent with user results
                Intent intent = new Intent();
                //pass the data back to Main
                intent.putExtra(MainActivity.KEY_ITEM_TEXT,updItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set the result of the intent
                setResult(RESULT_OK,intent);
                //finish activity, close screen, go back
                finish();
            }
        });
    }
}