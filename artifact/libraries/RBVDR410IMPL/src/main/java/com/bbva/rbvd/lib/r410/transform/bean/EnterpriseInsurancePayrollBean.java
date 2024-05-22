package com.bbva.rbvd.lib.r410.transform.bean;

import com.bbva.rbvd.dto.payroll.dto.*;
import com.bbva.rbvd.dto.payroll.utils.ConstantsUtils;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class EnterpriseInsurancePayrollBean {
    private EnterpriseInsurancePayrollBean() {
    }
    public static List<PayrollEmployeeDTO> getBeanInsurancePayrollDao(List<Map<String,Object>> payrollInfo) {

        return payrollInfo.stream()
                .map(payrolesInfo -> {
                    Timestamp birthDateTimestamp = (Timestamp) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_BIRTH_DATE);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String birthDateString = sdf.format(birthDateTimestamp);
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(birthDateString, dateFormatter);

                    String salaryString = (String) payrolesInfo.get("MONTH_PAYMENT_AMOUNT");
                    double salary = convertToDoubleWithTwoDecimals(salaryString);

                    PayrollEmployeeDTO payrollInformationDAO = new PayrollEmployeeDTO();
                    payrollInformationDAO.setFirstName((String) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_FIRST_NAME));
                    payrollInformationDAO.setSecondLastName((String) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_SECOND_LAST_NAME));
                    payrollInformationDAO.setLastName((String) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_FIRST_LAST_NAME));
                    payrollInformationDAO.setGender(generateGender((String) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_FIRST_NAME)));
                    payrollInformationDAO.setBirthDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    if(payrolesInfo.get("EMPLOYEE_CELLPHONE_NUMBER_ID")!=null
                            || payrolesInfo.get("EMPLOYEE_EMAIL_NAME")!=null ){
                    payrollInformationDAO.setContactDetails(generateContacts((String) payrolesInfo.get("EMPLOYEE_EMAIL_NAME"),
                            (String) payrolesInfo.get("EMPLOYEE_CELLPHONE_NUMBER_ID")));
                    }

                    if(payrolesInfo.get("EMPLOYEE_PERSONAL_ID")!=null) {
                        payrollInformationDAO.setIdentityDocument(generateDocuments((String) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_PERSONAL_ID),
                                (String) payrolesInfo.get(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_PERSONAL_TYPE)));
                    }

                    if(payrolesInfo.get("MONTH_PAYMENT_AMOUNT")!=null) {
                    payrollInformationDAO.setSalaryAmount(generateSalaryAmount(salary));
                    }
                    return payrollInformationDAO;
                })
                .collect(Collectors.toList());

    }
    public static double convertToDoubleWithTwoDecimals(String numberString) {
        BigDecimal bigDecimal = new BigDecimal(numberString);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
    public static DescriptionDTO generateGender(String gender) {
        DescriptionDTO descriptionDTO = new DescriptionDTO();
        descriptionDTO.setId(gender);
    return descriptionDTO;
    }
    public static List<ContactDetailsDTO> generateContacts(String phone,String email) {
        List<ContactDetailsDTO> contactDetailsList = new ArrayList<>();
        ContactDetailsDTO contactPhoneDetails = new ContactDetailsDTO();
        ContactDetailsDTO contactEmailDetails = new ContactDetailsDTO();
        ContactDTO contactPhoneDTO = new ContactDTO();
        ContactDTO contactEmailDTO = new ContactDTO();
        if(phone != null) {
            contactPhoneDTO.setNumber(phone);
            contactPhoneDTO.setContactDetailType("MOBILE");
            contactPhoneDetails.setContact(contactPhoneDTO);
            contactDetailsList.add(contactPhoneDetails);
        }
        if(email != null) {
            contactEmailDTO.setNumber(email);
            contactEmailDTO.setContactDetailType("EMAIL");
            contactEmailDetails.setContact(contactEmailDTO);
            contactDetailsList.add(contactEmailDetails);
        }
        return contactDetailsList;
    }
    public static SalaryAmountDTO generateSalaryAmount(Double amount) {
        SalaryAmountDTO salaryAmountDTO= new SalaryAmountDTO();
       salaryAmountDTO.setAmount(amount);

        return salaryAmountDTO;
    }
    public static IdentityDocumentDTO generateDocuments(String documentId,String documentType) {
        IdentityDocumentDTO documentDTO= new IdentityDocumentDTO();
        DescriptionDTO descriptionDTO = new DescriptionDTO();
        documentDTO.setDocumentNumber(documentId);
        descriptionDTO.setId(documentType);
        documentDTO.setDocumentType(descriptionDTO);
        return documentDTO;
    }
}
