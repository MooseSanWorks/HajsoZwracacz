package com.example.hajsozwracacz;

public class DataRecord {
    private String cash;
    private String persons;
    private String cashBack;

    public DataRecord(String cash, String persons, String cashBack) {
        this.cash = cash;
        this.persons = persons;
        this.cashBack = cashBack;
    }


    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getCashBack() {
        return cashBack;
    }

    public void setCashBack(String cashBack) {
        this.cashBack = cashBack;
    }
}
