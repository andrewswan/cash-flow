// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.andrewswan.cashflow.domain;

import com.andrewswan.cashflow.domain.Account;
import com.andrewswan.cashflow.domain.MonetaryTransaction;
import com.andrewswan.cashflow.domain.RecurrenceType;
import java.math.BigDecimal;
import java.util.Date;

privileged aspect MonetaryTransaction_Roo_JavaBean {
    
    public String MonetaryTransaction.getDescription() {
        return this.description;
    }
    
    public void MonetaryTransaction.setDescription(String description) {
        this.description = description;
    }
    
    public Date MonetaryTransaction.getNextDate() {
        return this.nextDate;
    }
    
    public void MonetaryTransaction.setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }
    
    public BigDecimal MonetaryTransaction.getAmount() {
        return this.amount;
    }
    
    public void MonetaryTransaction.setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public Date MonetaryTransaction.getLastDate() {
        return this.lastDate;
    }
    
    public void MonetaryTransaction.setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
    
    public Integer MonetaryTransaction.getRecurrenceInterval() {
        return this.recurrenceInterval;
    }
    
    public void MonetaryTransaction.setRecurrenceInterval(Integer recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
    }
    
    public RecurrenceType MonetaryTransaction.getRecurrenceType() {
        return this.recurrenceType;
    }
    
    public void MonetaryTransaction.setRecurrenceType(RecurrenceType recurrenceType) {
        this.recurrenceType = recurrenceType;
    }
    
    public Account MonetaryTransaction.getAccount() {
        return this.account;
    }
    
    public void MonetaryTransaction.setAccount(Account account) {
        this.account = account;
    }
    
}
