package com.bbva.rbvd.lib.r410.utils;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MockUtils {
    private static final String RESPONSE_MOCK = "{\"id\":\"0814000072051\",\"status\":{\"id\":\"DONE\",\"name\":\"Theprocessuploadedthepayrollsuccessfully\"},\"payroll\":[{\"firstName\":\"Sally\",\"lastName\":\"Bucelli\",\"secondLastName\":\"Bucelli\",\"birthDate\":\"2002-02-05\",\"gender\":{\"id\":\"MALE\"},\"identityDocument\":{\"documentType\":{\"id\":\"DNI\"},\"documentNumber\":\"72839100\"},\"contactDetails\":[{\"contact\":{\"contactDetailType\":\"EMAIL\",\"address\":\"juzuda@example.com\"}},{\"contact\":{\"contactDetailType\":\"MOBILE\",\"number\":\"7066459685\"}}],\"hireDate\":\"2021-02-20\",\"salaryAmount\":{\"amount\":6863.52,\"currency\":\"PEN\"},\"payrollStatus\":{\"id\":\"ACTIVE\",\"name\":\"Theemployeeisactiveinthepayroll\"}},{\"firstName\":\"Warren\",\"lastName\":\"Chini\",\"secondLastName\":\"Chini\",\"birthDate\":\"2002-02-05\",\"gender\":{\"id\":\"FEMALE\"},\"identityDocument\":{\"documentType\":{\"id\":\"DNI\"},\"documentNumber\":\"72839101\"},\"contactDetails\":[{\"contact\":{\"contactDetailType\":\"EMAIL\",\"address\":\"anonucow@example.com\"}},{\"contact\":{\"contactDetailType\":\"MOBILE\",\"number\":\"8748589156\"}}],\"hireDate\":\"2021-02-20\",\"salaryAmount\":{\"amount\":6863.52,\"currency\":\"PEN\"},\"payrollStatus\":{\"id\":\"ACTIVE\",\"name\":\"Theemployeeisactiveinthepayroll\"}},{\"firstName\":\"Tillie\",\"lastName\":\"Bettini\",\"secondLastName\":\"Bettini\",\"birthDate\":\"2002-02-05\",\"gender\":{\"id\":\"FEMALE\"},\"identityDocument\":{\"documentType\":{\"id\":\"DNI\"},\"documentNumber\":\"72839102\"},\"contactDetails\":[{\"contact\":{\"contactDetailType\":\"EMAIL\",\"address\":\"kuba@example.com\"}},{\"contact\":{\"contactDetailType\":\"MOBILE\",\"number\":\"6834037739\"}}],\"hireDate\":\"2021-02-20\",\"salaryAmount\":{\"amount\":6863.52,\"currency\":\"PEN\"},\"payrollStatus\":{\"id\":\"ACTIVE\",\"name\":\"Theemployeeisactiveinthepayroll\"}},{\"firstName\":\"Maude\",\"lastName\":\"Scarpelli\",\"secondLastName\":\"Scarpelli\",\"birthDate\":\"2002-02-05\",\"gender\":{\"id\":\"MALE\"},\"identityDocument\":{\"documentType\":{\"id\":\"DNI\"},\"documentNumber\":\"72839103\"},\"contactDetails\":[{\"contact\":{\"contactDetailType\":\"EMAIL\",\"address\":\"juw@example.com\"}},{\"contact\":{\"contactDetailType\":\"MOBILE\",\"number\":\"4777078411\"}}],\"hireDate\":\"2021-02-20\",\"salaryAmount\":{\"amount\":6863.52,\"currency\":\"PEN\"},\"payrollStatus\":{\"id\":\"ACTIVE\",\"name\":\"Theemployeeisactiveinthepayroll\"}},{\"firstName\":\"Laura\",\"lastName\":\"Holland\",\"secondLastName\":\"Holland\",\"birthDate\":\"2002-02-05\",\"gender\":{\"id\":\"FEMALE\"},\"identityDocument\":{\"documentType\":{\"id\":\"DNI\"},\"documentNumber\":\"72839104\"},\"contactDetails\":[{\"contact\":{\"contactDetailType\":\"EMAIL\",\"address\":\"vis@example.com\"}},{\"contact\":{\"contactDetailType\":\"MOBILE\",\"number\":\"3095437721\"}}],\"hireDate\":\"2021-02-20\",\"salaryAmount\":{\"amount\":6863.52,\"currency\":\"PEN\"},\"payrollStatus\":{\"id\":\"ACTIVE\",\"name\":\"Theemployeeisactiveinthepayroll\"}}]}";
    private static final String DATE = "yyyy-MM-dd";
    private final Gson gson;

    public MockUtils() {
        gson = new GsonBuilder()
                .setDateFormat(DATE)
                .create();
    }

    public EmployeePayrollResponseDTO getMockGetPayrollTrx(){
        return this.gson.fromJson(RESPONSE_MOCK, EmployeePayrollResponseDTO.class);
    }
}
