package com.bbva.rbvd.lib.r410.repository;

import com.bbva.pisd.lib.r404.PISDR404;

import java.util.List;
import java.util.Map;

public class PayrollDao {
    private PISDR404 pisdr404;

    public PayrollDao(PISDR404 pisdr404) {
        this.pisdr404 = pisdr404;
    }

    public List<Map<String,Object>> fetchDataAsMapList (String queryId, Map<String, Object> arguments) {
        return pisdr404.executeGetListASingleRow(queryId, arguments);
    }
}
