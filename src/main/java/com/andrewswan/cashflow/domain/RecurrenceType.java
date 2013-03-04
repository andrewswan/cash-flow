package com.andrewswan.cashflow.domain;

/**
 * The ways in which something can recur
 * 
 * @author Admin
 */
public enum RecurrenceType {

    ANNUALLY,
    
    DAILY,

    /**
     * For example on the 3rd of every month. Future monthly types that could be
     * added include ones like "on the 2nd (last) Monday (or weekday) of every
     * month".
     */
    MONTHLY_BY_DATE,
    
    NEVER,
    
    QUARTERLY,
    
    WEEKLY;
}
