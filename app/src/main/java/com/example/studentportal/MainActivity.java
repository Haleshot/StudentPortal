package com.example.studentportal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText phone;
    EditText sapid;
    EditText password;
    Button signup;
    Button altlogin;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        sapid = findViewById(R.id.sapid);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        altlogin = findViewById(R.id.altlogin);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputValidation()) {
                    String userName = name.getText().toString().trim();
                    String userEmail = email.getText().toString().trim();
                    String userPhone = phone.getText().toString().trim();
                    String userSapid = sapid.getText().toString().trim();
                    String userPassword = password.getText().toString().trim();

                    DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");
                    DatabaseReference currentUserRef = usersRef.child(userSapid);

                    currentUserRef.child("name").setValue(userName);
                    currentUserRef.child("email").setValue(userEmail);
                    currentUserRef.child("phone").setValue(userPhone);
                    currentUserRef.child("sapid").setValue(userSapid);
                    currentUserRef.child("password").setValue(userPassword);

                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, com.example.studentportal.login.class);
                    startActivity(intent);
                    name.getText().clear();
                    email.getText().clear();
                    phone.getText().clear();
                    sapid.getText().clear();
                    password.getText().clear();
                }
            }
        });


//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (inputValidation()) {
//                    String userName = name.getText().toString().trim();
//                    String userEmail = email.getText().toString().trim();
//                    String userPhone = phone.getText().toString().trim();
//                    String userSapid = sapid.getText().toString().trim();
//                    String userPassword = password.getText().toString().trim();
//
//                    User user = new User(userName, userEmail, userPhone, userSapid, userPassword);
//                    databaseReference.child(userSapid).setValue(user);
//
//                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        altlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });
    }

    public boolean inputValidation() {
        if (name.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (email.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (phone.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter Phone no.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (sapid.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter SAP ID", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}

//
//package com.example.studentportal;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//    EditText name;
//    EditText email;
//    EditText phone;
//    EditText sapid;
//    EditText password;
//    Button signup;
//    Button altlogin;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        name = findViewById(R.id.name);
//        email = findViewById(R.id.email);
//        phone = findViewById(R.id.phone);
//        sapid = findViewById(R.id.sapid);
//        password = findViewById(R.id.password);
//        signup = findViewById(R.id.signup);
//        altlogin = findViewById(R.id.altlogin);
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sap = sapid.getText().toString();
//                String pass = password.getText().toString();
//                if (TextUtils.isEmpty(sap || TextUtils.isEmpty(pass))) {
//                    Toast.makeText(MainActivity.this, "Enter credentials", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//        });
//
//        altlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, login.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    public boolean inputValidation() {
//        if (name.getText().toString().isEmpty()) {
//            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (email.getText().toString().isEmpty()) {
//            Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (phone.getText().toString().isEmpty()) {
//            Toast.makeText(MainActivity.this, "Enter Phone no.", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (sapid.getText().toString().isEmpty()) {
//            Toast.makeText(MainActivity.this, "Enter SAP ID", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (password.getText().toString().isEmpty()) {
//            Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
//            return false;
//        } else {
//            return true;
//        }
//    }
//}
//
////package com.example.studentportal;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import android.os.Bundle;
////
////public class MainActivity extends AppCompatActivity {
////    EditText name;
////    EditText email;
////    EditText phone;
////    EditText sapid;
////    EditText password;
////    Button signup;
////    Button altlogin;
////
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////        name = findViewById(R.id.name);
////        email = finviewById(R.id.email);
////        phone = findViewById(R.id.phone);
////        sapid = findViewById(R.id.sapid);
////        password = findViewById(R.id.password);
////    }
////    public boolean inputValidation() {
////        if (name.getText().toString().isEmpty()) {
////            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
////            return false;
////        } else if (email.getText().toString().isEmpty()) {
////            Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
////            return false;
////        } else if (phone.getText().toString().isEmpty()) {
////            Toast.makeText(MainActivity.this, "Enter Phone no.", Toast.LENGTH_SHORT).show();
////            return false;
////        } else if (sapid.getText().toString().isEmpty()) {
////            Toast.makeText(MainActivity.this, "Enter SAP ID", Toast.LENGTH_SHORT).show();
////            return false;
////        } else if (password.getText().toString().isEmpty()) {
////            Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
////            return false;
////        } else {
////            return true;
////        }
////    }
////
////    inputValidation();
////    signup.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            if (inputValidation()) {
////                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
////            }
////        }
////    });
////    altlogin.setOnClickListener(new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            Intent intent = new Intent(MainActivity.this, login.class);
////            startActivity(intent);
////        }
////    });
////    }
////}