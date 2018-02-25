package com.jegsoftware.payperiodbudgeting.logic;

import android.view.View;

import com.jegsoftware.payperiodbudgeting.data.BudgetItem;
import com.jegsoftware.payperiodbudgeting.data.IBudgetItemData;
import com.jegsoftware.payperiodbudgeting.data.ItemType;
import com.jegsoftware.payperiodbudgeting.view.IEditItemView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by jonathon on 2/24/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class EditItemControllerTest {

    @Mock
    IBudgetItemData budgetItemData;

    @Mock
    IEditItemView editItemView;

    private static ItemType TEST_TYPE = ItemType.ACTUAL_EXPENSE;

    private static BudgetItem TEST_ITEM = new BudgetItem(
            ItemType.ACTUAL_EXPENSE,
            "5/17/96",
            "Test actual expense",
            29.01,
            "Credit Card"
    );

    private EditItemController controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void onEditExistingItem() {
        controller = new EditItemController(budgetItemData, editItemView, TEST_ITEM, TEST_TYPE);
        Mockito.verify(editItemView).setUpItemEdit(TEST_ITEM);
    }

    @Test
    public void onEditNewItem() {
        controller = new EditItemController(budgetItemData, editItemView, null, TEST_TYPE);
        Mockito.verify(editItemView).setUpItemEdit(Mockito.any(BudgetItem.class));
    }

    @Test
    public void onItemSaveClicked() {
        controller = new EditItemController(budgetItemData, editItemView, TEST_ITEM, TEST_TYPE);
        controller.onSaveItemClick(TEST_ITEM);
        Mockito.verify(editItemView).sendSavedItemToList(TEST_ITEM);
    }

}