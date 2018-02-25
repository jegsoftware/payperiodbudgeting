package com.jegsoftware.payperiodbudgeting.logic;

import android.view.View;

import com.jegsoftware.payperiodbudgeting.data.BudgetItem;
import com.jegsoftware.payperiodbudgeting.data.IBudgetItemData;
import com.jegsoftware.payperiodbudgeting.data.ItemType;
import com.jegsoftware.payperiodbudgeting.view.IEditItemView;

/**
 * Created by jonathon on 2/24/18.
 */

public class EditItemController {

    private IBudgetItemData budgetItemData;
    private IEditItemView editItemView;

    public EditItemController(IBudgetItemData budgetItemData, IEditItemView editItemView, BudgetItem item, ItemType type) {
        this.budgetItemData = budgetItemData;
        this.editItemView = editItemView;
        if (item == null) {
            item = new BudgetItem(type,"","",0.00,"");
        }
        editItemView.setUpItemEdit(item);
    }

    public void onSaveItemClick(BudgetItem itemToSave) {
        budgetItemData.save(itemToSave);
        editItemView.sendSavedItemToList(itemToSave);
    }
}
