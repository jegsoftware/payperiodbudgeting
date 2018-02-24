package com.jegsoftware.payperiodbudgeting.logic;



import android.view.View;

import com.jegsoftware.payperiodbudgeting.data.BudgetItem;
import com.jegsoftware.payperiodbudgeting.data.IBudgetItemListData;
import com.jegsoftware.payperiodbudgeting.data.ItemType;
import com.jegsoftware.payperiodbudgeting.view.IView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * Created by jonathon on 2/6/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListControllerTest {

    @Mock
    IBudgetItemListData budgetItemData;

    @Mock
    IView view;

    @Mock
    View viewRoot;

    ListController listController;

    ArrayList<BudgetItem> plannedItems = new ArrayList<>();
    ArrayList<BudgetItem> actualItems = new ArrayList<>();
    ArrayList<BudgetItem> deposits = new ArrayList<>();

    private static BudgetItem PLANNED_ITEM = new BudgetItem(
            ItemType.PLANNED_EXPENSE,
            "",
            "Test planned expense",
            50.00,
            "Checking"
    );

    private static BudgetItem ACTUAL_ITEM = new BudgetItem(
            ItemType.ACTUAL_EXPENSE,
            "2/6/18",
            "Test actual expense",
            42.42,
            "Checking"
    );

    private static BudgetItem DEPOSIT = new BudgetItem(
            ItemType.DEPOSIT,
            "1/31/18",
            "Test deposit",
            4242.00,
            "Checking"
    );

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        plannedItems.add(PLANNED_ITEM);

        Mockito.when(budgetItemData.getItemsByType(ItemType.PLANNED_EXPENSE))
                .thenReturn(plannedItems);

        actualItems.add(ACTUAL_ITEM);

        Mockito.when(budgetItemData.getItemsByType(ItemType.ACTUAL_EXPENSE))
                .thenReturn(actualItems);

        deposits.add(DEPOSIT);

        Mockito.when(budgetItemData.getItemsByType(ItemType.DEPOSIT))
                .thenReturn(deposits);

    }

    @Test
    public void getsPlannedItems() {
        listController = new ListController(budgetItemData, view, ItemType.PLANNED_EXPENSE);

        Mockito.verify(view).setupListActivity(plannedItems);
    }

    @Test
    public void getsActualItems() {
        listController = new ListController(budgetItemData, view, ItemType.ACTUAL_EXPENSE);

        Mockito.verify(view).setupListActivity(actualItems);
    }

    @Test
    public void getsDeposits() {
        listController = new ListController(budgetItemData, view, ItemType.DEPOSIT);

        Mockito.verify(view).setupListActivity(deposits);
    }

    @Test
    public void onListItemClicked() {
        listController = new ListController(budgetItemData, view, ItemType.PLANNED_EXPENSE);
        listController.onListItemClick(PLANNED_ITEM, viewRoot);

        Mockito.verify(view).startItemEditActivity(PLANNED_ITEM, viewRoot);
    }

    @Test
    public void onAddItemClicked() {
        listController = new ListController(budgetItemData, view, ItemType.PLANNED_EXPENSE);
        listController.onAddItemClicked(viewRoot);

        Mockito.verify(view).startItemEditActivity(null, viewRoot);
    }

}