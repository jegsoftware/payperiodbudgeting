package com.jegsoftware.payperiodbudgeting.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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
    private BudgetItem budgetItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Toolbar toolBar = findViewById(R.id.tlb_edit_item);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        budgetItem = (BudgetItem) getIntent().getSerializableExtra(EXTRA_BUDGET_ITEM);
        ItemType listType = (ItemType) getIntent().getSerializableExtra(EXTRA_LIST_TYPE);
        editItemController = new EditItemController(new FakeItemDataSource(), this, budgetItem, listType);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.men_save_item) {
            budgetItem.setDate(date.getText().toString());
            budgetItem.setDescription(desc.getText().toString());
            budgetItem.setAccount(account.getText().toString());

            Double amountAsDouble = getAmountAsDouble();
            budgetItem.setAmount(amountAsDouble);
            // re-set the text so that it displays properly formatted regardless of how the user entered it.
            amount.setText(String.format(Locale.US, "$%.2f", amountAsDouble));


            editItemController.onSaveItemClick(budgetItem);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Double getAmountAsDouble() {
        String amountText = amount.getText().toString();
        if (amountText.charAt(0) == '$') {
            amountText = amountText.substring(1,amountText.length());
        }
        return Double.parseDouble(amountText);
    }

    @Override
    public void setUpItemEdit(BudgetItem item) {
        budgetItem = item;

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

        String message = String.format(Locale.US, "Item saved in the amount of $%.2f", savedItem.getAmount());
        Toast.makeText(EditItemActivity.this, message, Toast.LENGTH_LONG).show();

    }
}
