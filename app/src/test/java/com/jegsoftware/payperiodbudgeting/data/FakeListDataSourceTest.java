package com.jegsoftware.payperiodbudgeting.data;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jonathon on 2/5/18.
 */
public class FakeListDataSourceTest {

    private FakeListDataSource dataSource;

    @Before
    public void init() {
        dataSource = new FakeListDataSource();
        assertNotNull(dataSource);
    }

    @Test
    public void getsPlannedItems() {
        List<BudgetItem> list = dataSource.getItemsByType(ItemType.PLANNED_EXPENSE);
        assertNotNull(list);
        assertNotEquals(0, list.size());
        assertEquals(ItemType.PLANNED_EXPENSE, list.get(0).getType());
    }

    @Test
    public void getsActualItems() {
        List<BudgetItem> list = dataSource.getItemsByType(ItemType.ACTUAL_EXPENSE);
        assertNotNull(list);
        assertNotEquals(0, list.size());
        assertEquals(ItemType.ACTUAL_EXPENSE, list.get(0).getType());

    }

    @Test
    public void getsDeposits() {
        List<BudgetItem> list = dataSource.getItemsByType(ItemType.DEPOSIT);
        assertNotNull(list);
        assertNotEquals(0, list.size());
        assertEquals(ItemType.DEPOSIT, list.get(0).getType());

    }
}