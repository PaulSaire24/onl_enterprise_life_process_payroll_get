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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
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
		Map<String,Object> mapResult = new HashMap<>();
		mapResult.put("PAYROLL_ID","12455");
		mapResult.put("MOVEMENT_STATUS","CR");
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

		List<Map<String,Object>> listResult = new ArrayList<>();
		listResult.add(mapResult);

		when(this.pisdr404.executeGetListASingleRow(anyString(),anyMap())).thenReturn(listResult);
		when(this.applicationConfigurationService.getProperty("GENDER_ID_F")).thenReturn("FEMALE");
		when(this.applicationConfigurationService.getProperty("GENDER_ID_M")).thenReturn("MALE");
		EmployeePayrollResponseDTO resu = rbvdR410.executeGetInformationPayroll(input);

		assertEquals(0, context.getAdviceList().size());
		Assert.assertNotNull(resu);
		assertEquals("12455",resu.getId());
		assertEquals("CR",resu.getStatus().getId());
	}



}
