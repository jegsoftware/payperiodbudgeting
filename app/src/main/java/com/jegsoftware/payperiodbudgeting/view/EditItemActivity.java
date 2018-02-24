package com.jegsoftware.payperiodbudgeting.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jegsoftware.payperiodbudgeting.R;
import com.jegsoftware.payperiodbudgeting.data.BudgetItem;

import java.util.Locale;

public class EditItemActivity extends AppCompatActivity {

    private static final String EXTRA_BUDGET_ITEM = "EXTRA_BUDGET_ITEM";

    private TextView date;
    private TextView amount;
    private TextView account;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        BudgetItem item = (BudgetItem) getIntent().getSerializableExtra(EXTRA_BUDGET_ITEM);

        date = findViewById(R.id.fld_item_date);
        date.setText(item.getDate());

        amount = findViewById(R.id.fld_item_amount);
        amount.setText(String.format(Locale.US,"$%.2f", item.getAmount()));

        account = findViewById(R.id.fld_item_account);
        account.setText(item.getAccount());

        desc = findViewById(R.id.fld_item_description);
        desc.setText(item.getDescription());

    }
}
