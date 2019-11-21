package com.example.dineserve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.view.View;


import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;




public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    private final AppCompatActivity activity = SignupActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;
    private TextInputLayout textInputLayoutMobileNumber;
    private TextInputLayout textInputLayoutPlace;
    private TextInputLayout textInputLayoutPanNumber;
    private TextInputLayout textInputLayoutAdhaarNumber;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;
    private TextInputEditText textInputEditTextMobileNumber;
    private TextInputEditText textInputEditTextPlace;
    private TextInputEditText textInputEditTextPanNumber;
    private TextInputEditText textInputEditTextAdhaarNumber;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        initViews();
        initListeners();
        initObjects();

          }


    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);
        textInputLayoutMobileNumber=(TextInputLayout) findViewById(R.id.textInputLayoutMobileNumber);
       textInputLayoutPlace=(TextInputLayout)findViewById(R.id.textInputLayoutPlace);
       textInputLayoutPanNumber=(TextInputLayout)findViewById(R.id.textInputLayoutPanNumber);
       textInputLayoutAdhaarNumber=(TextInputLayout)findViewById(R.id.textInputLayoutAdhaarnumber);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);
        textInputEditTextMobileNumber=(TextInputEditText)findViewById(R.id.textInputEditTextMobilenumber);
        textInputEditTextPlace=(TextInputEditText)findViewById(R.id.textInputEditTextplace);
        textInputEditTextPanNumber=(TextInputEditText)findViewById(R.id.textInputEditTextPannumber);
        textInputEditTextAdhaarNumber=(TextInputEditText)findViewById(R.id.textInputEditTextAdhaarNumber);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextMobileNumber, textInputEditTextMobileNumber,
                textInputLayoutMobileNumber, getString(R.string.Mobile_Number))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPlace, textInputEditTextPlace,
                textInputLayoutPlace, getString(R.string.Place))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPanNumber, textInputEditTextPanNumber,
                textInputLayoutPanNumber, getString(R.string.Pan_Number))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextAdhaarNumber, textInputEditTextAdhaarNumber,
                textInputLayoutAdhaarNumber, getString(R.string.Adhaar_Number))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            user.setName(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());
            user.setPhonenumber(textInputEditTextMobileNumber.getText().toString().trim());
            user.setAddress(textInputEditTextPlace.getText().toString().trim());
            user.setPannumber(textInputEditTextPanNumber.getText().toString().trim());
            user.setAdhaarNumber(textInputEditTextAdhaarNumber.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
        textInputEditTextMobileNumber.setText(null);
        textInputEditTextPlace.setText(null);
        textInputEditTextPanNumber.setText(null);
        textInputEditTextAdhaarNumber.setText(null);
    }
}

