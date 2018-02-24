package com.jegsoftware.payperiodbudgeting.view;

import android.view.View;

import com.jegsoftware.payperiodbudgeting.data.BudgetItem;

import java.util.List;

/**
 * Created by jonathon on 2/6/18.
 */

public interface IView {

    void startItemEditActivity(BudgetItem item, View viewRoot);

    void setupListActivity(List<BudgetItem> budgetItemList);
}
