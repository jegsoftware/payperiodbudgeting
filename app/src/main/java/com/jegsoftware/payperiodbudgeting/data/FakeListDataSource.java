package com.jegsoftware.payperiodbudgeting.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jonathon on 2/5/18.
 */

public class FakeListDataSource implements IBudgetItemListData {

    private final int LIST_SIZE = 10;

    private final String[] dates = {
            "6/5/91",
            "5/8/95",
            "5/22/95",
            "8/1/99",
            "10/5/03",
            "1/15/07",
            "4/16/15"
    };

    private final String[] descs = {
            "McDonald's",
            "Paycheck",
            "Groceries",
            "Woodman's",
            "Walmart",
            "Amazon",
            "Walgreen's"
    };

    private final Double[] amts = {
            42.00,
            125.00,
            32.68,
            59.12,
            11034.09,
            2.38,
            3.14,
            4.2
    };

    private final String[] accts = {
            "Checking",
            "Credit Card"
    };

    @Override
    public List<BudgetItem> getItemsByType(ItemType type) {
        ArrayList<BudgetItem> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < LIST_SIZE; i++) {
            BudgetItem itemToAdd = new BudgetItem(
                    type,
                    dates[random.nextInt(dates.length)],
                    descs[random.nextInt(descs.length)],
                    amts[random.nextInt(amts.length)],
                    accts[random.nextInt(accts.length)]
            );
            list.add(itemToAdd);
        }
        return list;
    }
}
