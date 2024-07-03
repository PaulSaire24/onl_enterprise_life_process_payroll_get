package com.bbva.rbvd.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDatabase {
    public static List<Map<String, Object>> getMaps() {
        List<Map<String, Object>> listObs = new ArrayList<>();
        Map<String, Object>	mapObs = new HashMap<>();
        mapObs.put("PAYROLL_EMPLOYEE_ID","12345");
        mapObs.put("OBSERV_RESULT_PROCESS_DESC","MANL CO000028||Se recomienda corregir apepat: JUAREZ para DNI: 72839101 del asegurado.");
        Map<String, Object>	mapObs1 = new HashMap<>();
        mapObs1.put("PAYROLL_EMPLOYEE_ID","12345");
        mapObs1.put("OBSERV_RESULT_PROCESS_DESC","MANL CO000028||Se recomienda corregir apepat: JUAREZ para DNI: 72839101 del asegurado.");
        listObs.add(mapObs);
        listObs.add(mapObs1);
        return listObs;
    }

    public static List<Map<String, Object>> getMapList() {
        Map<String,Object> mapResult = new HashMap<>();
        mapResult.put("PAYROLL_EMPLOYEE_ID","12345");
        mapResult.put("PAYROLL_ID","12455");
        mapResult.put("MOVEMENT_STATUS","ST");
        mapResult.put("EMPLOYEE_FIRST_NAME","PAUL");
        mapResult.put("EMPLOYEE_FIRST_LAST_NAME","SAIRE");
        mapResult.put("EMPLOYEE_SECOND_LAST_NAME","PAUCAR");
        mapResult.put("EMPLOYEE_BIRTH_DATE",new Date());
        mapResult.put("EMPLOYEE_GENDER_TYPE","F");
        mapResult.put("EMPLOYEE_STATUS_ID","VAL");
        mapResult.put("EMPLOYEE_PERSONAL_TYPE","L");
        mapResult.put("EMPLOYEE_PERSONAL_ID","71960800");
        mapResult.put("EMPLOYEE_EMAIL_NAME","psaire@gamil.com");
        mapResult.put("EMPLOYEE_CELLPHONE_NUMBER_ID","960675837");
        mapResult.put("JOB_POSITION_EE_START_DATE",new Date());
        mapResult.put("MONTH_PAYMENT_AMOUNT",new BigDecimal(1500));
        mapResult.put("UPLOADED_STATUS_TYPE","MANL");

        Map<String,Object> mapResult2 = new HashMap<>();
        mapResult2.put("PAYROLL_EMPLOYEE_ID","56789");
        mapResult2.put("PAYROLL_ID","12455");
        mapResult2.put("MOVEMENT_STATUS","ST");
        mapResult2.put("EMPLOYEE_FIRST_NAME","KYEV");
        mapResult2.put("EMPLOYEE_FIRST_LAST_NAME","MENDEX");
        mapResult2.put("EMPLOYEE_SECOND_LAST_NAME","RODRI");
        mapResult2.put("EMPLOYEE_BIRTH_DATE",new Date());
        mapResult2.put("EMPLOYEE_GENDER_TYPE","F");
        mapResult2.put("EMPLOYEE_STATUS_ID","VAL");
        mapResult2.put("EMPLOYEE_PERSONAL_TYPE","L");
        mapResult2.put("EMPLOYEE_PERSONAL_ID","71960800");
        mapResult2.put("EMPLOYEE_EMAIL_NAME","psaire@gamil.com");
        mapResult2.put("EMPLOYEE_CELLPHONE_NUMBER_ID","960675889");
        mapResult2.put("JOB_POSITION_EE_START_DATE",new Date());
        mapResult2.put("MONTH_PAYMENT_AMOUNT",new BigDecimal(1690));
        mapResult2.put("UPLOADED_STATUS_TYPE",null);
        List<Map<String,Object>> listResult = new ArrayList<>();
        listResult.add(mapResult);
        listResult.add(mapResult2);
        return listResult;
    }
}
