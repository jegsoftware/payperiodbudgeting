package com.jegsoftware.payperiodbudgeting.data;

import java.util.UUID;

/**
 * Created by jonathon on 2/24/18.
 */

public interface IBudgetItemData {
    void save(BudgetItem item);

    BudgetItem retrieve(UUID id);
}
