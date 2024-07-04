package com.bbva.rbvd.lib.r410;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

import com.bbva.pisd.lib.r404.PISDR404;
import com.bbva.rbvd.dto.payroll.dto.PayrollEmployeeDTO;
import com.bbva.rbvd.dto.payroll.dto.StatusDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.helper.MockDatabase;
import com.bbva.rbvd.lib.r410.business.PayrollBusiness;
import com.bbva.rbvd.lib.r410.impl.RBVDR410Impl;
import com.bbva.rbvd.lib.r410.repository.PayrollDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Map;
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
	private PayrollDao payrollDao;

	@InjectMocks
	private PayrollBusiness payrollBusiness;

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
		List<Map<String, Object>> listResult = MockDatabase.getMapList();
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("QUOTATION_ID", input.getQuotationId());

		List<Map<String, Object>> listObs = MockDatabase.getMaps();
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

	@Test
	public void executeTestEmpty(){
		EmployeePayrollFilterDTO input  = new EmployeePayrollFilterDTO();
		input.setQuotationId("1243455540");
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("QUOTATION_ID", input.getQuotationId());

		when(this.pisdr404.executeGetListASingleRow("PISD.SELECT_PAYROLL_EMPLOYEES",arguments)).thenReturn(null);

		EmployeePayrollResponseDTO resu = rbvdR410.executeGetInformationPayroll(input);

		assertEquals(1, context.getAdviceList().size());
		Assert.assertNull(resu);
		// Verificar que los métodos se llamaron con los parámetros correctos
		verify(pisdr404, times(1)).executeGetListASingleRow("PISD.SELECT_PAYROLL_EMPLOYEES",arguments);
	}

	@Test
	public void testGetObsPayroll() {
		// Preparar datos de prueba
		PayrollEmployeeDTO employee = new PayrollEmployeeDTO();
		employee.setEmployeeId("123");
		employee.setPayRollStatus(new StatusDTO());
		List<PayrollEmployeeDTO> payroll = Arrays.asList(employee);

		EmployeePayrollResponseDTO response = new EmployeePayrollResponseDTO();
		response.setPayroll(payroll);


		Map<String, Object> resultObs = new HashMap<>();
		resultObs.put("EMPLOYEE_IDS", Arrays.asList("123"));

		when(payrollDao.fetchDataAsMapList(anyString(), anyMap())).thenReturn(Arrays.asList(resultObs));

		payrollBusiness.getObsPayroll(response, payrollDao);

		// Verificar que los métodos se llamaron con los parámetros correctos
		verify(payrollDao, times(1)).fetchDataAsMapList(anyString(), anyMap());
	}


}
