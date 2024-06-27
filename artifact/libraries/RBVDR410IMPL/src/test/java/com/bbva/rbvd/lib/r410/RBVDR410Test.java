package com.bbva.rbvd.lib.r410;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

import com.bbva.pisd.lib.r404.PISDR404;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.impl.RBVDR410Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/RBVDR410-app.xml",
		"classpath:/META-INF/spring/RBVDR410-app-test.xml",
		"classpath:/META-INF/spring/RBVDR410-arc.xml",
		"classpath:/META-INF/spring/RBVDR410-arc-test.xml" })
public class RBVDR410Test {

	@Spy
	private Context context;

	@InjectMocks
	private RBVDR410Impl rbvdR410;

	@Mock
	private PISDR404 pisdr404;

	@Mock
	ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.rbvdR410;
		if(this.rbvdR410 instanceof Advised){
			Advised advised = (Advised) this.rbvdR410;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTestOK(){
		EmployeePayrollFilterDTO input  = new EmployeePayrollFilterDTO();
		input.setQuotationId("1243455540");
		List<Map<String, Object>> listResult = getMapList();
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("QUOTATION_ID", input.getQuotationId());

		List<Map<String, Object>> listObs = getMaps();
		Map<String, Object> argumentsObs = new HashMap<>();
		List<String> listIds = Arrays.asList("12345","56789");
		argumentsObs.put("EMPLOYEE_IDS", listIds);

		when(this.pisdr404.executeGetListASingleRow("PISD.SELECT_PAYROLL_EMPLOYEES",arguments)).thenReturn(listResult);
		when(this.pisdr404.executeGetListASingleRow("PISD.SELECT_PAYROLL_OBS_BY_EMPLOYEES",argumentsObs)).thenReturn(listObs);
		when(this.applicationConfigurationService.getProperty("GENDER_ID_F")).thenReturn("FEMALE");
		when(this.applicationConfigurationService.getProperty("GENDER_ID_M")).thenReturn("MALE");
		when(this.applicationConfigurationService.getProperty("ST")).thenReturn("STARTED PAYROLL");
		when(this.applicationConfigurationService.getProperty("L")).thenReturn("DNI");

		EmployeePayrollResponseDTO resu = rbvdR410.executeGetInformationPayroll(input);

		assertEquals(0, context.getAdviceList().size());
		Assert.assertNotNull(resu);
		assertEquals("12455",resu.getId());
		assertEquals("ST",resu.getStatus().getId());
	}

	private static List<Map<String, Object>> getMaps() {
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

	private static List<Map<String, Object>> getMapList() {
		Map<String,Object> mapResult = new HashMap<>();
		mapResult.put("PAYROLL_EMPLOYEE_ID","12345");
		mapResult.put("PAYROLL_ID","12455");
		mapResult.put("MOVEMENT_STATUS","ST");
		mapResult.put("EMPLOYEE_FIRST_NAME","PAUL");
		mapResult.put("EMPLOYEE_FIRST_LAST_NAME","SAIRE");
		mapResult.put("EMPLOYEE_SECOND_LAST_NAME","PAUCAR");
		mapResult.put("EMPLOYEE_BIRTH_DATE","2024-11-12");
		mapResult.put("EMPLOYEE_GENDER_TYPE","F");
		mapResult.put("EMPLOYEE_STATUS_ID","VAL");
		mapResult.put("EMPLOYEE_PERSONAL_TYPE","L");
		mapResult.put("EMPLOYEE_PERSONAL_ID","71960800");
		mapResult.put("EMPLOYEE_EMAIL_NAME","psaire@gamil.com");
		mapResult.put("EMPLOYEE_CELLPHONE_NUMBER_ID","960675837");
		mapResult.put("JOB_POSITION_EE_START_DATE","2024-11-12");
		mapResult.put("MONTH_PAYMENT_AMOUNT",new BigDecimal(1500));
		mapResult.put("UPLOADED_STATUS_TYPE","MANL");

		Map<String,Object> mapResult2 = new HashMap<>();
		mapResult2.put("PAYROLL_EMPLOYEE_ID","56789");
		mapResult2.put("PAYROLL_ID","12455");
		mapResult2.put("MOVEMENT_STATUS","ST");
		mapResult2.put("EMPLOYEE_FIRST_NAME","KYEV");
		mapResult2.put("EMPLOYEE_FIRST_LAST_NAME","MENDEX");
		mapResult2.put("EMPLOYEE_SECOND_LAST_NAME","RODRI");
		mapResult2.put("EMPLOYEE_BIRTH_DATE","2024-11-12");
		mapResult2.put("EMPLOYEE_GENDER_TYPE","F");
		mapResult2.put("EMPLOYEE_STATUS_ID","VAL");
		mapResult2.put("EMPLOYEE_PERSONAL_TYPE","L");
		mapResult2.put("EMPLOYEE_PERSONAL_ID","71960800");
		mapResult2.put("EMPLOYEE_EMAIL_NAME","psaire@gamil.com");
		mapResult2.put("EMPLOYEE_CELLPHONE_NUMBER_ID","960675889");
		mapResult2.put("JOB_POSITION_EE_START_DATE","2024-11-12");
		mapResult2.put("MONTH_PAYMENT_AMOUNT",new BigDecimal(1690));
		mapResult2.put("UPLOADED_STATUS_TYPE","MANL");
		List<Map<String,Object>> listResult = new ArrayList<>();
		listResult.add(mapResult);
		listResult.add(mapResult2);
		return listResult;
	}


}
