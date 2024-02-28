package com.bbva.rbvd.dto.getpayroll.process.dto;

import java.io.Serializable;

public class StatusDTO implements Serializable {

    private static final long serialVersionUID = 2931699728946643256L;

    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "StatusDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
