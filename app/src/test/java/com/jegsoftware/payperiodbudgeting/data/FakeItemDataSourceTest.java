package com.jegsoftware.payperiodbudgeting.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jonathon on 2/24/18.
 */
public class FakeItemDataSourceTest {

    private FakeItemDataSource dataSource;

    @Before
    public void init() {
        dataSource = new FakeItemDataSource();
        assertNotNull(dataSource);
    }

    @Test
    public void savesItem() {
        BudgetItem testItem = new BudgetItem(ItemType.PLANNED_EXPENSE,
                                            "6/29/70",
                                            "Test item",
                                            2.05,
                                            "Credit Card");
        dataSource.save(testItem);
        BudgetItem retrievedItem = dataSource.retrieve(testItem.getId());
        assertEquals(testItem, retrievedItem);
    }

}