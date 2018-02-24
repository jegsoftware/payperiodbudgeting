package com.jegsoftware.payperiodbudgeting.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jegsoftware.payperiodbudgeting.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        EditText planDate = (EditText) findViewById(R.id.fld_plan_period);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        planDate.setText(df.format(new Date()));
    }

    public void cardClicked(View view) {
        Intent i = new Intent(this, ListActivity.class);

        startActivity(i);

    }
}
