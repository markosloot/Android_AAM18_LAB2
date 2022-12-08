package kz.talipovsn.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity  {

    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;
    private Spinner spinner;
    private String fio, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        radioGroup = findViewById(R.id.radioGroup);
        spinner =    findViewById(R.id.spinner);

        fio = getIntent().getStringExtra("fio");
        gender = getIntent().getStringExtra("gender");
    }

    public void onInfo(View v) {
        Intent intent_res = new Intent(SecondActivity.this, ResultActivity.class);

        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        intent_res.putExtra("fio", fio);
        intent_res.putExtra("gender", gender);
        intent_res.putExtra("edu", selectRadioButton.getText());
        intent_res.putExtra("country", spinner.getSelectedItem().toString());

        startActivity(intent_res);
    }

    public void onBack(View v) {
        setResult(RESULT_OK);
        finish();
    }

}
