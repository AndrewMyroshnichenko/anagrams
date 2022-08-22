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


    private EditText editInputPhrase;
    private EditText usersExceptCharacters;
    private TextView tvResult;
    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
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

                if(exceptCharacters == ""){
                    tvResult.setText(Anagram.reverseOnlyLetters(inputPhrase));
                } else {
                    tvResult.setText(Anagram.reverseExceptChars(inputPhrase, exceptCharacters));
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
        usersExceptCharacters = findViewById(R.id.editText_characters);
        editInputPhrase = findViewById(R.id.editText_input_phrase);
        tvResult = findViewById(R.id.textView_result);
    }
}