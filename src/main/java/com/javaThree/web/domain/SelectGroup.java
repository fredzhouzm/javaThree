package com.javaThree.web.domain;

import java.util.Map;

/**
 * Created by Fred on 2015/5/18.
 */
public class SelectGroup {
    private String proId;
    private String name;
    private Map<String,String> selectGroupMap;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getSelectGroupMap() {
        return selectGroupMap;
    }

    public void setSelectGroupMap(Map<String, String> selectGroupMap) {
        this.selectGroupMap = selectGroupMap;
    }
}
