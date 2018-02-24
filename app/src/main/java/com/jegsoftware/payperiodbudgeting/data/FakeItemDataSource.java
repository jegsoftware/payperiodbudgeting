package com.jegsoftware.payperiodbudgeting.data;

import java.util.UUID;

/**
 * Created by jonathon on 2/24/18.
 */

public class FakeItemDataSource implements IBudgetItemData {
    BudgetItem savedItem;

    @Override
    public void save(BudgetItem item) {
        savedItem = item;
    }

    @Override
    public BudgetItem retrieve(UUID id) {
        return savedItem;
    }
}
