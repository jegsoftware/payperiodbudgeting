package com.jegsoftware.payperiodbudgeting.view;

import com.jegsoftware.payperiodbudgeting.data.BudgetItem;

/**
 * Created by jonathon on 2/24/18.
 */

public interface IEditItemView {

    void setUpItemEdit(BudgetItem item);

    void sendSavedItemToList(BudgetItem savedItem);
}
