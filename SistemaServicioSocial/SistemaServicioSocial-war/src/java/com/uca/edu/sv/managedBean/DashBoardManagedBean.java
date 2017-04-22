/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author jcsoriano
 */
@ManagedBean(name = "dashBoardManagedBean")
@RequestScoped
public class DashBoardManagedBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
    private String boysType="line";
     
    private String girlsType="column";
     
    private List<String> chartTypes = new ArrayList<String>();
     
    public DashBoardManagedBean() {
        chartTypes.add("line");
        chartTypes.add("bar");
        chartTypes.add("pie");
        chartTypes.add("column");
    }
 
    public String getBoysType() {
        return boysType;
    }
 
    public void setBoysType(String boysType) {
        this.boysType = boysType;
    }
 
    public String getGirlsType() {
        return girlsType;
    }
 
    public void setGirlsType(String girlsType) {
        this.girlsType = girlsType;
    }
 
    public List<String> getChartTypes() {
        return chartTypes;
    }
 
    public void setChartTypes(List<String> chartTypes) {
        this.chartTypes = chartTypes;
    }
     
    public void redraw() {
    }
    
}
