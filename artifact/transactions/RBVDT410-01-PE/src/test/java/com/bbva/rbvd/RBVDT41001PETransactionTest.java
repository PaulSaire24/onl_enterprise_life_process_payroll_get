package com.bbva.rbvd;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.test.osgi.DummyBundleContext;
import java.util.ArrayList;
import javax.annotation.Resource;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.RBVDR410;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/RBVDT41001PETest.xml" })
public class RBVDT41001PETransactionTest {

	@Autowired
	private RBVDT41001PETransaction transaction;

	@Resource(name = "dummyBundleContext")
	private DummyBundleContext bundleContext;

	@Mock
	private CommonRequestHeader header;
	@Resource(name = "rbvdR410")
	private RBVDR410 rbvdr410;

	@Mock
	private TransactionRequest transactionRequest;

	@Before
	public void initializeClass() throws Exception {
		// Initializing mocks
		MockitoAnnotations.initMocks(this);
		// Start BundleContext
		this.transaction.start(bundleContext);
		// Setting Context
		this.transaction.setContext(new Context());
		// Set Body
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<>());
		this.transactionRequest.setBody(commonRequestBody);
		// Set Header Mock
		this.transactionRequest.setHeader(header);
		// Set TransactionRequest
		this.transaction.getContext().setTransactionRequest(transactionRequest);
	}

	@Test
	public void testNotNull(){
		Assert.assertNotNull(this.transaction);
		when(rbvdr410.executeGetInformationPayroll(anyObject())).thenReturn(new EmployeePayrollResponseDTO());
		this.transaction.execute();
	}
	@Test
	public void testNull(){
		Assert.assertNotNull(this.transaction);
		when(rbvdr410.executeGetInformationPayroll(anyObject())).thenReturn(null);
		this.transaction.execute();
	}

	// Add Parameter to Transaction
	private void addParameter(final String parameter, final Object value) {
		final TransactionParameter tParameter = new TransactionParameter(parameter, value);
		transaction.getContext().getParameterList().put(parameter, tParameter);
	}

	// Get Parameter from Transaction
	private Object getParameter(final String parameter) {
		final TransactionParameter param = transaction.getContext().getParameterList().get(parameter);
		return param != null ? param.getValue() : null;
	}
}
