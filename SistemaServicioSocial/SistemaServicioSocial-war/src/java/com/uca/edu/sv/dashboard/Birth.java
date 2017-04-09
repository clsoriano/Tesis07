/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.dashboard;

/**
 *
 * @author jcsoriano
 */
public class Birth {
  
    protected String year;
    protected Integer amount;
  
    public String getYear() {
        return year;
    }
  
    public void setYear(String year) {
        this.year = year;
    }
  
    public Integer getAmount() {
        return amount;
    }
  
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
  
    public Birth() {
    }
  
    public Birth(String year, Integer amount) {
        this.year = year;
        this.amount = amount;
    }

}
