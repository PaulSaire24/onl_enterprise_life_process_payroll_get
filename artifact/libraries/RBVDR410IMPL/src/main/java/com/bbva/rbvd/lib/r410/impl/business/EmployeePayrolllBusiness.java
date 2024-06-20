package com.bbva.rbvd.lib.r410.impl.business;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.rbvd.dto.py.payroll.PayrollDTO;
import com.bbva.rbvd.lib.r410.impl.transform.list.EmployeePayrollTransformList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class EmployeePayrolllBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePayrolllBusiness.class);


    public PayrollDTO getEmployeePayroll(List<Map<String, Object>> contractDetail) {

        EmployeePayrollTransformList employeePayrollTransformList = new EmployeePayrollTransformList();
        List<PayrollDTO> listPolicyDetailDTO = employeePayrollTransformList.transformListMapToListPolicyDetailDTO(contractDetail);

        PolicyDetailDTO out = listPolicyDetailDTO....;
        out.setId(contractId);
        out.getRenewalPolicy().setRenewalType(ConstantUtils.ContractStatus.AUTOMATIC);
        out.getCurrentInstallment().setPeriod(getPeriodToCurrentInstallment(receiptsFiltered));
        out.setInstallmentPayment(getInstallmentPaymentDTO(receiptsFiltered, numberOfReceipts));

        LOGGER.info("***** RBVDR410Impl - getEmployeePayroll END *****");
        LOGGER.info("***** RBVDR410Impl - getEmployeePayroll out: {} *****", out);

        return out;
    }





}
