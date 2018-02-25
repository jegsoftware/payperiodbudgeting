package com.jegsoftware.payperiodbudgeting.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jegsoftware.payperiodbudgeting.R;
import com.jegsoftware.payperiodbudgeting.data.BudgetItem;
import com.jegsoftware.payperiodbudgeting.data.FakeListDataSource;
import com.jegsoftware.payperiodbudgeting.data.ItemType;
import com.jegsoftware.payperiodbudgeting.logic.ListController;

import java.util.List;
import java.util.Locale;

public class ListActivity extends AppCompatActivity implements IListView, View.OnClickListener {

    private static final String EXTRA_BUDGET_ITEM = "EXTRA_BUDGET_ITEM";

    private List<BudgetItem> itemList;
    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private ItemType listType;

    private ListController listController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_item_list_view);
        layoutInflater = getLayoutInflater();

        FloatingActionButton addItemButton = (FloatingActionButton) findViewById(R.id.fab_add_item);
        addItemButton.setOnClickListener(this);

        listType = ItemType.PLANNED_EXPENSE;
        listController = new ListController(new FakeListDataSource(), this, listType);
    }

    @Override
    public void startItemEditActivity(BudgetItem item, View viewRoot) {
        Intent i = new Intent(this, EditItemActivity.class);
        i.putExtra(EXTRA_BUDGET_ITEM, item);

        startActivity(i);
    }

    @Override
    public void setupListActivity(List<BudgetItem> budgetItemList) {
        this.itemList = budgetItemList;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                layoutManager.getOrientation()
        );

        itemDecoration.setDrawable(
                ContextCompat.getDrawable(
                        ListActivity.this,
                        R.drawable.divider_dark
                )
        );

        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.fab_add_item) {
            listController.onAddItemClicked(view);
        }
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            ImageView icon = v.findViewById(R.id.img_item_type);
            switch (listType) {
                case PLANNED_EXPENSE:
                    icon.setImageResource(R.drawable.ic_assignment_black_24dp);
                    break;
                case ACTUAL_EXPENSE:
                    icon.setImageResource(R.drawable.ic_receipt_black_24dp);
                    break;
                case DEPOSIT:
                    icon.setImageResource(R.drawable.ic_account_balance_black_24dp);
                    break;
            }

            ProgressBar progressBar = v.findViewById(R.id.prg_item_data);
            progressBar.setVisibility(View.GONE);

            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            BudgetItem curItem = itemList.get(position);
            holder.date.setText(curItem.getDate());
            holder.amount.setText(String.format(Locale.US,"$%.2f",curItem.getAmount()));
            holder.account.setText(curItem.getAccount());
            holder.description.setText(curItem.getDescription());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private TextView date;
            private TextView amount;
            private TextView account;
            private TextView description;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);
                this.date = itemView.findViewById(R.id.list_item_date);
                this.amount = itemView.findViewById(R.id.list_item_amount);
                this.account = itemView.findViewById(R.id.list_item_account);
                this.description = itemView.findViewById(R.id.list_item_desc);
                this.container = itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                BudgetItem clickedItem = itemList.get(this.getAdapterPosition());
                listController.onListItemClick(clickedItem, view);
            }
        }

    }
}
