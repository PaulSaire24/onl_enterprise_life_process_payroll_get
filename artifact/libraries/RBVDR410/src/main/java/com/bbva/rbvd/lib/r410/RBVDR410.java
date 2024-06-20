package com.bbva.rbvd.lib.r410;

import com.bbva.rbvd.dto.payroll.process.EmployeePayrollFilterDTO;
import com.bbva.rbvd.dto.payroll.process.EmployeePayrollResponseDTO;

public interface RBVDR410 {

	EmployeePayrollResponseDTO executeGetInformationPayroll(EmployeePayrollFilterDTO input);

}
