package com.bbva.rbvd.lib.r410.impl;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;
import com.bbva.rbvd.lib.r410.impl.utils.MockUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The RBVDR410Impl class...
 */
public class RBVDR410Impl extends RBVDR410Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(RBVDR410Impl.class);

	@Override
	public EmployeePayrollResponseDTO execute() {
		MockUtils mockUtils = new MockUtils();
		return mockUtils.getMockGetPayrollTrx();
	}
}
