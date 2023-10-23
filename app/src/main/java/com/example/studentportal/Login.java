package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText sapid;
    EditText password;
    Button loginbtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sapid = findViewById(R.id.sapid);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sap = sapid.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(sap) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(login.this, "Enter credentials", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(sap, pass);
                }
            }
        });
    }

    private void loginUser(String sap, String pass) {
        auth.signInWithEmailAndPassword(sap + "@domain.com", pass)
                .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
//package com.example.myapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class login extends AppCompatActivity {
//    EditText sapid;
//    EditText password;
//    Button loginbtn;
//    FirebaseAuth auth;
//
//    // Write a message to the database
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("message");
//
//    myRef.setValue("Hello, World!");
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        sapid = findViewById(R.id.sapid);
//        password = findViewById(R.id.password);
//        loginbtn = findViewById(R.id.login);
//
//        auth = FirebaseAuth.getInstance();
//
//
//
//
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sap = sapid.getText().toString();
//                String pass = password.getText().toString();
//                if (TextUtils.isEmpty(sap )) {
//                    Toast.makeText(login.this, "Enter credentials", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    registerUser(sap, pass);
//                }
//
//
//            }
//        });
//    }
//
//    private void registerUser(String sap, String pass) {
//        auth.createUser(sapid,password).addOnCompleteListener( login.this, new OnCompleteListener<AuthResult>()
//        {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {
//                    Toast.makeText(login.this, "Successful", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(login.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }
//
//
//    private static class FirebaseAuth {
//        public Object createUser;
//
//        public static FirebaseAuth getInstance() {
//            return null;
//        }
//
//        public void createUser(EditText sapid, EditText password) {
//            return ;
//        }
//    }
//}