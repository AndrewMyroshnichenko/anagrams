package com.example.anagrams;

public class MainActivity extends AppCompatActivity {

    private String s;
    private EditText editInputPhrase;
    private EditText usersExceptCharacters;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        usersExceptCharacters = findViewById(R.id.editText_characters);
        editInputPhrase = findViewById(R.id.editText_input_phrase);
        tvResult = findViewById(R.id.textView_result);
        TextWatcher textWatcher = new TextWatcher() {
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
                String exceptCharacters = usersExceptCharacters.getText().toString().trim();
                tvResult.setText(Anagram.reverse(inputPhrase, exceptCharacters));

            }
        };

        editInputPhrase.addTextChangedListener(textWatcher);
    }
}