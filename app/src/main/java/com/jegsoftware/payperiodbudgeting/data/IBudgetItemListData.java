package com.jegsoftware.payperiodbudgeting.data;

import java.util.List;

/**
 * Created by jonathon on 2/5/18.
 */

public interface IBudgetItemListData {
    public List<BudgetItem> getItemsByType(ItemType type);
}
