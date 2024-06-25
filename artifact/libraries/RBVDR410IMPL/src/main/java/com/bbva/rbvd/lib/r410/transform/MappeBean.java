package com.bbva.rbvd.lib.r410.transform;

import com.bbva.rbvd.dto.payroll.dto.DescriptionDTO;
import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;
import com.bbva.rbvd.dto.payroll.dto.IdentityDocumentDTO;
import com.bbva.rbvd.dto.payroll.dto.ContactDetailsDTO;
import com.bbva.rbvd.dto.payroll.dto.SalaryAmountDTO;
import com.bbva.rbvd.dto.payroll.dto.ContactDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappeBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(MappeBean.class);

    private static final Map<String,String []> statusMap = new HashMap<>();
    static {
        statusMap.put("VAL", new String[]{"VALIDATED", "EMPLEADO VALIDO POR RIMAC"});
        statusMap.put("OBS", new String[]{"OBSERVED", "EMPLEADO OBSERVADO POR RIMAC"});
        statusMap.put("AMN", new String[]{"AMENDED", "EMPLEADO CORREGIDO POR CLIENTE"});
        statusMap.put("UAP", new String[]{"UNAPPROVED", "EMPLEADO EN VALIDACION"});
    }

    public static EmployeePayrollResponseDTO mapResultPayroll (List<Map<String,Object>> mapList) throws ParseException {
        EmployeePayrollResponseDTO response = new EmployeePayrollResponseDTO();
        response.setId((String) mapList.get(0).get("PAYROLL_ID"));
        DescriptionDTO status =  new DescriptionDTO();
        status.setId((String) mapList.get(0).get("MOVEMENT_STATUS"));
        response.setStatus(status.getId()!=null?status:null);
        List<PayrollEmployeeDTO> listPayroll = new ArrayList<>();

        for (Map<String,Object> map : mapList){
            PayrollEmployeeDTO payroll = new PayrollEmployeeDTO();
            payroll.setFirstName((String) map.get("EMPLOYEE_FIRST_NAME"));
            payroll.setLastName((String) map.get("EMPLOYEE_FIRST_LAST_NAME"));
            payroll.setSecondLastName(map.get("EMPLOYEE_SECOND_LAST_NAME") != null? (String) map.get("EMPLOYEE_SECOND_LAST_NAME") : null);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            payroll.setBirthDate(dateFormat.parse((String) map.get("EMPLOYEE_BIRTH_DATE")));
            payroll.setGender(new DescriptionDTO());
            payroll.getGender().setId((String) map.get("EMPLOYEE_GENDER_TYPE"));
            payroll.setPayrollStatus(setPayRollStatus(map.get("EMPLOYEE_STATUS_ID")));
            DescriptionDTO documentType = new DescriptionDTO();
            documentType.setId((String) map.get("EMPLOYEE_PERSONAL_TYPE"));
            IdentityDocumentDTO identityDocument = new IdentityDocumentDTO();
            identityDocument.setDocumentType(documentType);
            identityDocument.setDocumentNumber((String) map.get("EMPLOYEE_PERSONAL_ID"));
            payroll.setIdentityDocument(identityDocument);
            payroll.setContactDetails(setContac(map.get("EMPLOYEE_CELLPHONE_NUMBER_ID"),map.get("EMPLOYEE_EMAIL_NAME")));
            payroll.setHireDate(dateFormat.parse((String) map.get("JOB_POSITION_EE_START_DATE")));
            SalaryAmountDTO salary = new SalaryAmountDTO();
            salary.setAmount(((BigDecimal) map.get("MONTH_PAYMENT_AMOUNT")).doubleValue());
            salary.setCurrency("PEN");
            payroll.setSalaryAmount(map.get("MONTH_PAYMENT_AMOUNT")!=null?salary:null);
            payroll.setLoadType(map.get("UPLOADED_STATUS_TYPE")!=null? (String) map.get("UPLOADED_STATUS_TYPE"):null);
            listPayroll.add(payroll);
        }
        response.setPayroll(listPayroll);
        LOGGER.info("*** RBVDR410Impl  mapResultPayroll -> {}",response);
        return response;
    }

    private static List<ContactDetailsDTO> setContac(Object phoneId, Object email){
        List<ContactDetailsDTO> contactList =  new ArrayList<>();

        if(phoneId == null && email == null) return null;
        if (phoneId != null) {
            ContactDTO contact = new ContactDTO();
            contact.setContactDetailType("MOBILE");
            contact.setNumber(phoneId.toString());
            ContactDetailsDTO contactDetails =  new ContactDetailsDTO();
            contactDetails.setContact(contact);
            contactList.add(contactDetails);
        }
        if (email != null) {
            ContactDTO contact = new ContactDTO();
            contact.setContactDetailType("EMAIL");
            contact.setAddress(email.toString());
            ContactDetailsDTO contactDetails =  new ContactDetailsDTO();
            contactDetails.setContact(contact);
            contactList.add(contactDetails);
        }
        return contactList;
    }

    private static DescriptionDTO setPayRollStatus(Object status){
        if(status==null)return null;
        String[] val = statusMap.get((String) status);
        if(val==null)return null;
        DescriptionDTO statusPayRoll = new DescriptionDTO();
        statusPayRoll.setId((String) status);
        statusPayRoll.setName(val[0]);
        statusPayRoll.setDescription(val[1]);
        return statusPayRoll;
    }
}
