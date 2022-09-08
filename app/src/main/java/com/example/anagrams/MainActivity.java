package com.example.anagrams;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anagrams.utils.Anagram;

public class MainActivity extends AppCompatActivity {


    private EditText editInputPhrase;
    private EditText usersExceptCharacters;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersExceptCharacters = findViewById(R.id.editText_filter);
        editInputPhrase = findViewById(R.id.editText_input);
        tvResult = findViewById(R.id.textView_result);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String inputPhrase = editInputPhrase.getText().toString().trim();
                String exceptCharacters = usersExceptCharacters.getText().toString().trim();
                tvResult.setText(Anagram.reverse(inputPhrase, exceptCharacters));

            }
        };

        editInputPhrase.addTextChangedListener(textWatcher);
    }

}