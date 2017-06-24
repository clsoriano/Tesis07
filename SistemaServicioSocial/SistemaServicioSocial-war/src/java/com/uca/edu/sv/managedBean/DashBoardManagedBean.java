/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author jcsoriano
 */
@Controller
public class DashBoardManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String boysType = "line";

    private String girlsType = "column";

    private List<String> chartTypes = new ArrayList<String>();
    private MapModel simpleModel;
    private String centerLocation2 = "31.94,-83.0";
    private double radius = 5000.0;
    private int minZoom = 9;
    private int maxZoom = 11;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);

        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
        simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
        simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
        simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
    }

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

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public String getCenterLocation2() {
        return centerLocation2;
    }

    public void setCenterLocation2(String centerLocation2) {
        this.centerLocation2 = centerLocation2;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getMinZoom() {
        return minZoom;
    }

    public void setMinZoom(int minZoom) {
        this.minZoom = minZoom;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        this.maxZoom = maxZoom;
    }

}
