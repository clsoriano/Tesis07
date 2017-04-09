/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.dashboard.Birth;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jcsoriano
 */
@ManagedBean(name = "lineChartBean")
@RequestScoped
public class LineChartBean implements Serializable {

    protected List<Birth> boys;
    protected List<Birth> girls;

    public List<Birth> getBoys() {
        return boys;
    }

    public List<Birth> getGirls() {
        return girls;
    }

    public LineChartBean() {
        reload();
    }

    private void reload() {
        boys = new ArrayList<>();
        girls = new ArrayList<>();
        Random r = new Random();
        for (int i = 2000; i < 2010; i++) {
            boys.add(new Birth(Integer.toString(i), r.nextInt(500) + 800));
            girls.add(new Birth(Integer.toString(i), r.nextInt(500) + 800));
        }
    }
}
