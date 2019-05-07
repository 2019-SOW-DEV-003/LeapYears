package com.leapyears.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.leapyears.R;
import com.leapyears.model.LeapYear;
import com.leapyears.viewmodel.LeapYearViewModel;
import com.leapyears.viewmodelfactory.ViewModelFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LeapYearViewModel viewModel;
    private EditText edtYear;
    private TextView txtResult;
    private Button btnFind;
    private Button btnClear;
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFind = findViewById(R.id.button_find);
        btnClear = findViewById(R.id.button_clear);
        edtYear = findViewById(R.id.edt_leapyear);
        txtResult = findViewById(R.id.txt_result);
        container = findViewById(R.id.container);

        ViewModelFactory factory = new ViewModelFactory(this.getApplication(), new LeapYear());
        viewModel = ViewModelProviders.of(this, factory).get(LeapYearViewModel.class);

        btnFind.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        container.setOnClickListener(this);

        addObserver();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_clear){
            edtYear.setText("");
            edtYear.setError(null);
        } else if(v.getId() == R.id.button_find){
            if(edtYear.getText().toString().equals("")){
                edtYear.setError("Please enter a value");
            } else{
                viewModel.find(Integer.valueOf(edtYear.getText().toString()));
            }
        }
    }

    private void addObserver() {
        viewModel.getResultLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String result) {
                txtResult.setText(result);
            }
        });
    }
}
