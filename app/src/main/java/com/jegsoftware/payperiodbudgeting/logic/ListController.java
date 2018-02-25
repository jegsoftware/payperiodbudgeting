package com.jegsoftware.payperiodbudgeting.logic;

import android.view.View;

import com.jegsoftware.payperiodbudgeting.data.BudgetItem;
import com.jegsoftware.payperiodbudgeting.data.IBudgetItemListData;
import com.jegsoftware.payperiodbudgeting.data.ItemType;
import com.jegsoftware.payperiodbudgeting.view.IListView;

/**
 * Created by jonathon on 2/6/18.
 */

public class ListController {

    private IBudgetItemListData budgetItemData;
    private IListView view;

    public ListController(IBudgetItemListData budgetItemData, IListView view, ItemType type) {
        this.budgetItemData = budgetItemData;
        this.view = view;
        view.setupListActivity(budgetItemData.getItemsByType(type));
    }

    public void onListItemClick(BudgetItem plannedItem, View viewRoot) {
        view.startItemEditActivity(plannedItem, viewRoot);
    }

    public void onAddItemClicked(View viewRoot) {
        view.startItemEditActivity(null, viewRoot);
    }
}
