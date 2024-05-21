package com.bbva.rbvd.lib.r410;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.dto.payroll.utils.ConstantsUtils;
import com.bbva.rbvd.lib.r410.impl.RBVDR410Impl;
import com.bbva.rbvd.lib.r414.RBVDR414;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.*;

import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RBVDR410Test {

	@Spy
	private Context context;
	@InjectMocks
	private RBVDR410Impl rbvdR410Impl ;
	@Mock
	private RBVDR414 rbvdR414 ;

	@Mock
	private ApplicationConfigurationService applicationConfigurationService;

	private EmployeePayrollFilterDTO requestInput;

	@Before
	public void setUp() throws Exception {
		context = new Context();
		ThreadContext.set(context);
		requestInput = new EmployeePayrollFilterDTO();
	}
	
	@Test
	public void executeTest(){
		this.requestInput = createInput();
		List<Map<String, Object>> listPlan = createPayroll();
		when(rbvdR414.executeQueryForRowListSelection(anyString(), anyMap()))
				.thenReturn(listPlan);
		EmployeePayrollResponseDTO response = rbvdR410Impl.execute(requestInput);


	}
	private EmployeePayrollFilterDTO createInput(){
		EmployeePayrollFilterDTO input = new EmployeePayrollFilterDTO();

		input.setUploadEmployeesPayrollId("1234561234");
		input.setId("00728427841500");
		return input;
	}
	private List<Map<String, Object>> createPayroll() {
		List<Map<String, Object>> listPayroll = new ArrayList<>();
		Map<String, Object> mapPayroll = new HashMap<>();
		mapPayroll.put(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_FIRST_NAME, "Alvin ");
		mapPayroll.put(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_SECOND_LAST_NAME, "Arteta");
		mapPayroll.put(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_FIRST_LAST_NAME, "Quispe");
		mapPayroll.put(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_GENDER_TYPE, "M");
		mapPayroll.put(ConstantsUtils.InsurancePayrollEmployeeDetailHeaders.EMPLOYEE_BIRTH_DATE, "03/11/1996");
		mapPayroll.put("EMPLOYEE_EMAIL_NAME", "alvinarteta@gmail.com");
		mapPayroll.put("EMPLOYEE_CELLPHONE_NUMBER_ID", "938887465");
		mapPayroll.put("EMPLOYEE_PERSONAL_ID", "76906337");
		mapPayroll.put("EMPLOYEE_PERSONAL_TYPE", "DNI");
		mapPayroll.put("MONTH_PAYMENT_AMOUNT", "50000");
		listPayroll.add(mapPayroll);
		return listPayroll;
	}
}
