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
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    Button signup;
    Button signin1;
    TextView call;

    TextInputLayout regName, regMobile, regPassword, regMail;
    String uname,umobile,uemail,upassword;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        signup = findViewById(R.id.signup);
        signin1 = findViewById(R.id.signin1);
        call = findViewById(R.id.call);
        regName = findViewById(R.id.name);
        regMobile = findViewById(R.id.mobilenumber);
        regMail = findViewById(R.id.email);
        regPassword = findViewById(R.id.password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname = regName.getEditText().getText().toString();
                umobile = regMobile.getEditText().getText().toString();
                uemail = regMail.getEditText().getText().toString();
                upassword = regPassword.getEditText().getText().toString();

                if(!validateName() | !validateMobileNumber() | !validateEmail() | !validatePassword()) {
                    Toast.makeText(SignUpActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(uemail,upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()) {
                                            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
                                            DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

                                            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                                            UserInformation userInformation = new UserInformation(uname,umobile,uemail,upassword,"1");
                                            databaseReference.child(uid).setValue(userInformation);

                                            Toast.makeText(SignUpActivity.this, "Register Successfully. Please check your Email for Verification.", Toast.LENGTH_SHORT).show();

                                            regName.getEditText().setText("");
                                            regMobile.getEditText().setText("");
                                            regMail.getEditText().setText("");
                                            regPassword.getEditText().setText("");
                                        }
                                        else {
                                                    Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();}
                        }
                    });
                }

            }
        });

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
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

    private boolean validateName() {

        if(uname.isEmpty()) {
            regName.setError("Please enter Full Name");
            return false;
        }
        else {
            regName.setError(null);
            return true;
        }
    }

    private boolean validateMobileNumber() {

        if(umobile.isEmpty()) {
            regMobile.setError("Please enter Mobile Number");
            return false;
        }
        else if(Patterns.PHONE.matcher(umobile).matches()) {
            regMobile.setError(null);
            return true;
        }
        else {
            Toast.makeText(SignUpActivity.this, "Mobile Number is Invalid", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public boolean validateEmail() {;

        if (uemail.isEmpty()) {
            regMail.setError("Please enter Email");
            return false;
        }
        else if(Patterns.EMAIL_ADDRESS.matcher(uemail).matches()) {
            regMail.setError(null);
            return true;
        }else {
            Toast.makeText(SignUpActivity.this, "Email is Invalid", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private boolean validatePassword() {
        Pattern PASSWORD_PATTERN = Pattern.compile("^" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$");

        if (upassword.isEmpty()) {
            regPassword.setError("Field can not be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(upassword).matches()) {
            regPassword.setError("Password is too weak");
            return false;
        } else {
            regPassword.setError(null);
            return true;
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}