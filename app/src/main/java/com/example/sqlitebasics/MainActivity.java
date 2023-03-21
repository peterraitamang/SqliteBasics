package com.example.sqlitebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sqlitebasics.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DBadapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

//        EditText name = binding.username;
//        EditText password = binding.password;
//        EditText updateOld = binding.currentname;
//        EditText updateNew = binding.newname;
//        EditText deleteName = binding.deleteUsername;

        helper = new DBadapter(this);
    }
    public void addUser(View view){
        String t1 = binding.username.getText().toString();
        String t2 = binding.password.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()){
            Message.message(getApplicationContext(),"Enter both name and password");
        }
        else {
            long id = helper.insertData(t1,t2);
            if(id<=0){
                Message.message(getApplicationContext(),"Insertion Unsuccessful.");
                binding.username.setText("");
                binding.password.setText("");
            }else {
                Message.message(getApplicationContext(),"Insertion Successful");
                binding.username.setText("");
                binding.password.setText("");
            }
        }
    }
    public void viewdata(View view){
        String data = helper.getData();
        Message.message(this, data);
    }
}