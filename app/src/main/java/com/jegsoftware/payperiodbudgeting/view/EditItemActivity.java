package com.jegsoftware.payperiodbudgeting.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jegsoftware.payperiodbudgeting.R;
import com.jegsoftware.payperiodbudgeting.data.BudgetItem;
import com.jegsoftware.payperiodbudgeting.data.FakeItemDataSource;
import com.jegsoftware.payperiodbudgeting.data.ItemType;
import com.jegsoftware.payperiodbudgeting.logic.EditItemController;

import java.util.Locale;

public class EditItemActivity extends AppCompatActivity implements IEditItemView {

    private static final String EXTRA_BUDGET_ITEM = "EXTRA_BUDGET_ITEM";
    private static final String EXTRA_LIST_TYPE = "EXTRA_LIST_TYPE";

    private TextView date;
    private TextView amount;
    private TextView account;
    private TextView desc;

    private EditItemController editItemController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        BudgetItem item = (BudgetItem) getIntent().getSerializableExtra(EXTRA_BUDGET_ITEM);
        ItemType listType = (ItemType) getIntent().getSerializableExtra(EXTRA_LIST_TYPE);
        editItemController = new EditItemController(new FakeItemDataSource(), this, item, listType);
    }

    @Override
    public void setUpItemEdit(BudgetItem item) {
        date = findViewById(R.id.fld_item_date);
        date.setText(item.getDate());

        amount = findViewById(R.id.fld_item_amount);
        if (item.getAmount() != 0.00) {
            amount.setText(String.format(Locale.US, "$%.2f", item.getAmount()));
        }

        account = findViewById(R.id.fld_item_account);
        account.setText(item.getAccount());

        desc = findViewById(R.id.fld_item_description);
        desc.setText(item.getDescription());

    }

    @Override
    public void sendSavedItemToList(BudgetItem savedItem) {

    }
}
