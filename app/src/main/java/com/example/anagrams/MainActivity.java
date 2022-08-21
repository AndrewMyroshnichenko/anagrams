package com.example.anagrams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.anagrams.utils.Anagram;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioReverseOnlyLetter, radioReverseExceptXL, radioUserReverse;
    private EditText editInputPhrase, usersExceptCharacters;
    private TextView tvPrevention, tvResult;
    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        OnCreatePreferences();
    }

    @Override
    protected void onStart() {
        super.onStart();

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String getStrInputPhrase = editInputPhrase.getText().toString().trim();

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String inputPhrase = editInputPhrase.getText().toString().trim();
                String  exceptCharacters = usersExceptCharacters.getText().toString().trim();

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton_reverse_only_letter:
                        tvResult.setText(Anagram.reverseOnlyLetters(inputPhrase));
                        break;
                    case R.id.radioButton_reverse_except_xl:
                        tvResult.setText(Anagram.reverseExceptXL(inputPhrase));
                        break;
                    case R.id.radioButton_user_reverse:
                        tvResult.setText(Anagram.reverseExceptChars(inputPhrase, exceptCharacters));
                        break;

                }

            }
        };

        editInputPhrase.addTextChangedListener(textWatcher);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textWatcher = null;
    }

    private void init(){
        radioGroup = findViewById(R.id.rg_choose_reverse);
        radioReverseOnlyLetter = findViewById(R.id.radioButton_reverse_only_letter);
        radioReverseExceptXL = findViewById(R.id.radioButton_reverse_except_xl);
        radioUserReverse = findViewById(R.id.radioButton_user_reverse);
        usersExceptCharacters = findViewById(R.id.editText_characters);
        editInputPhrase = findViewById(R.id.editText_input_phrase);
        tvPrevention = findViewById(R.id.textView_prevention);
        tvResult = findViewById(R.id.textView_result);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton_user_reverse:
                        tvPrevention.setVisibility(View.VISIBLE);
                        usersExceptCharacters.setVisibility(View.VISIBLE);
                        break;
                    default:
                        tvPrevention.setVisibility(View.GONE);
                        usersExceptCharacters.setVisibility(View.GONE);
                }
            }
        });

    }

    private void OnCreatePreferences(){
        tvPrevention.setVisibility(View.GONE);
        usersExceptCharacters.setVisibility(View.GONE);
    }
}