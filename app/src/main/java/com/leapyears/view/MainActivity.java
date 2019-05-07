package com.leapyears.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.leapyears.R;
import com.leapyears.viewmodel.LeapYearViewModel;
import com.leapyears.viewmodelfactory.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

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

        ViewModelFactory factory = new ViewModelFactory(this.getApplication(), new LeapYearUtils());
        viewModel = ViewModelProviders.of(this, factory).get(LeapYearViewModel.class);

    }
}
