package com.jegsoftware.payperiodbudgeting.data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by jonathon on 2/5/18.
 */

public class BudgetItem implements Serializable {
    private ItemType type;
    private String date;
    private String description;
    private Double amount;
    private String account;
    private UUID id;

    public BudgetItem(ItemType type, String date, String description, Double amount, String account) {
        this.type = type;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.account = account;
        this.id = UUID.randomUUID();
    }

    public BudgetItem(UUID id, ItemType type, String date, String description, double amount, String account) {
        this(type, date, description, amount, account);
        this.id = id;
    }

    public ItemType getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public UUID getId() {
        return id;
    }

}
