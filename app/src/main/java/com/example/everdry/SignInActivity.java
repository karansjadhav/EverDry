package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {
    Button signin;
    Button signup1;
    TextView call;

    FirebaseAuth mAuth;

    TextInputLayout regMail,regPassword;
    String uemail,upassword;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            if(uid.equals("vfJHYhyUZWWumffrHZnOMkrHXDp2")) {
                Intent intent = new Intent(SignInActivity.this, AdminHome.class);
                startActivity(intent);
                finish();
            }
            else if(mAuth.getCurrentUser().isEmailVerified()) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        signin = findViewById(R.id.signin);
        signup1 = findViewById(R.id.signup1);
        call = findViewById(R.id.call);
        regMail = findViewById(R.id.useremail);
        regPassword = findViewById(R.id.userpassword);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uemail = regMail.getEditText().getText().toString();
                upassword = regPassword.getEditText().getText().toString();

                if(!validateEmail() | !validatePassword()) {
                    Toast.makeText(SignInActivity.this, "Enter Valid Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(uemail, upassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful() && mAuth.getCurrentUser().isEmailVerified() && uemail.equals("karans.jadhav7105@gmail.com") && upassword.equals("Karan@123")) {

                                        Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(SignInActivity.this, AdminHome.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else if (task.isSuccessful() && mAuth.getCurrentUser().isEmailVerified()) {

                                        Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(SignInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "9370732391";
                Intent phone_intent = new Intent(Intent.ACTION_CALL);
                phone_intent.setData(Uri.parse("tel: " + number));
                startActivity(phone_intent);
            }
        });

    }

    public boolean validateEmail() {;

        if (uemail.isEmpty()) {
            regMail.setError("Please enter Email");
            return false;
        }
        return true;
    }

    private boolean validatePassword() {

        if (upassword.isEmpty()) {
            regPassword.setError("Please enter Password");
            return false;
        }
        return true;
    }

}