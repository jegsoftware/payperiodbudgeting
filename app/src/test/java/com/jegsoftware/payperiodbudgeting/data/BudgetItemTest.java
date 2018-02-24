package com.jegsoftware.payperiodbudgeting.data;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by jonathon on 2/5/18.
 */
public class BudgetItemTest {
    BudgetItem testNewItem;
    BudgetItem testRetrievedItem;
    UUID existingItemId;

    @Before
    public void init() {
        testNewItem = new BudgetItem(ItemType.PLANNED_EXPENSE, "1/1/73", "Test item", 42.42, "Checking");
        assertNotNull(testNewItem);
        existingItemId = UUID.randomUUID();
        testRetrievedItem = new BudgetItem(existingItemId, ItemType.ACTUAL_EXPENSE, "1/1/42", "Test retrieved item", 17.93, "Credit Card");
    }

    @Test
    public void dateGetSet() {
        testNewItem.setDate("1/1/2000");
        assertEquals("1/1/2000", testNewItem.getDate());
    }

    @Test
    public void descriptionGetSet() {
        testNewItem.setDescription("Another test");
        assertEquals("Another test", testNewItem.getDescription());
    }

    @Test
    public void amountGetSet() {
        testNewItem.setAmount(42.00);
        assertEquals(42.00, testNewItem.getAmount(),0.00);
    }

    @Test
    public void accountGetSet() {
        testNewItem.setAccount("Credit Card");
        assertEquals("Credit Card", testNewItem.getAccount());
    }

    @Test
    public void typeGet() {
        assertEquals(ItemType.PLANNED_EXPENSE, testNewItem.getType());
    }

    @Test
    public void idGet() {
        assertTrue(testNewItem.getId() instanceof UUID);
        assertEquals(existingItemId, testRetrievedItem.getId());
    }

}