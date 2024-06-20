package com.bbva.rbvd.lib.r410.impl.transform.bean;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.rbvd.dto.policydetail.policy.*;
import com.bbva.rbvd.dto.policydetail.utils.ContractEnum;
import com.bbva.rbvd.dto.policydetail.utils.PaymentTypeEnum;
import com.bbva.rbvd.dto.policydetail.utils.PeriodEnum;
import com.bbva.rbvd.dto.policydetail.utils.SubscriptionTypeEnum;
import com.bbva.rbvd.lib.r033.impl.utils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EmployeePayrollBean {
    private ApplicationConfigurationService applicationConfigurationService;

    public EmployeePayrollBean(ApplicationConfigurationService applicationConfigurationService) {
        this.applicationConfigurationService = applicationConfigurationService;
    }
    private static final String PRODUCT_TYPE_TAG = "TYPE.PRODUCT.";
    private static final String PRODUCT_TYPE_DEFAULT = "VEHICLE";
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePayrollBean.class);

    public PolicyDetailDTO mapTransformPolicyDetailDTO(Map<String, Object> map, List<CommonDTO> coverages){

        LOGGER.info("[***] ReceiptTransformBean mapTransformPolicyDetailDTO map - {} ", map);

        String productTy = applicationConfigurationService.getDefaultProperty(
                PRODUCT_TYPE_TAG + map.get(ContractEnum.INSURANCE_PRODUCT_TYPE.name())
                , PRODUCT_TYPE_DEFAULT);

        PolicyDetailDTO out =  PolicyDetailDTO.Builder.an()
                .policyNumber((String) map.get(ContractEnum.POLICYID.name()))
                .productType(productTy)
                .product(ProductDTO.Builder.an()
                        .id((String) map.get(ContractEnum.INSURANCE_PRODUCT_TYPE.name()))
                        .name((String) map.get(ContractEnum.INSURANCE_PRODUCT_DESC.name()))
                        .plan(PlanDTO.Builder.an()
                                .id((String) map.get(ContractEnum.INSURANCE_MODALITY_TYPE.name()))
                                .planType(CommonDTO.BuilderCommon.an()
                                        .id((String) map.get(ContractEnum.INSURANCE_MODALITY_TYPE.name()))
                                        .name((String) map.get(ContractEnum.INSUR_MODALITY_DESC.name())).build())
                                .coverage(coverages).build())
                        .build())
                .insuredAmount(AmountDTO.Builder.an()
                        .amount(ConvertUtils.getDouble(ContractEnum.INSURED_AMOUNT.name(), map))
                        .currency((String) map.get(ContractEnum.CURRENCY_ID.name()))
                        .build())
                .status(CommonDTO.BuilderCommon.an().id((String) map.get(ContractEnum.CONTRACT_STATUS_ID.name())).description((String) map.get(ContractEnum.CONTRACT_STATUS_DESC.name())).build())
                .insuranceCompany(CommonDTO.BuilderCommon.an().id(Objects.toString(map.get(ContractEnum.INSURANCE_COMPANY_ID.name()),"")).name((String) map.get(ContractEnum.INSURANCE_COMPANY_DESC.name())).build())
                .paymentConfiguration(PaymentConfigurationDTO.Builder.an()
                        .paymentType(PaymentTypeEnum.DIRECT_DEBIT.name())
                        .frequency(CommonDTO.BuilderCommon.an()
                                .id((String) map.get(ContractEnum.POLICY_PAYMENT_FREQUENCY_TYPE.name()))
                                .name((String) map.get(ContractEnum.PAYMENT_FREQUENCY_NAME.name()))
                                .build())
                        .build())
                .cancelationDate(ConvertUtils.getLocalDate(ContractEnum.POLICY_ANNULATION_DATE.name(), map))
                .validityPeriod(ValidityPeriodDTO.Builder.an()
                        .unit(PeriodEnum.ANNUAL.name())
                        .description(PeriodEnum.ANNUAL.getDescription())
                        .startDate(ConvertUtils.getLocalDate(ContractEnum.INSURANCE_CONTRACT_START_DATE.name(), map))
                        .endDate(ConvertUtils.getLocalDate(ContractEnum.INSURANCE_CONTRACT_END_DATE.name(), map))
                        .build())
                .currentInstallment(InstallmentDTO.Builder.an()
                        .installmentAmount(AmountDTO.Builder.an()
                                .amount(ConvertUtils.getDouble(ContractEnum.PREMIUM_AMOUNT.name(), map))
                                .currency((String) map.get(ContractEnum.CURRENCY_ID.name()))
                                .build())
                        .installmentType(null)
                        .build())
                .subscriptionType(SubscriptionTypeEnum.INDIVIDUAL.name())
                .businessAgent(CommonDTO.BuilderCommon.an().id(Objects.toString(map.get(ContractEnum.INSURANCE_MANAGER_ID.name()), StringUtils.EMPTY)).build())
                .bank(BankDTO.Builder.an().
                        id((String) map.get(ContractEnum.INSURANCE_CONTRACT_ENTITY_ID.name()))
                        .branch(CommonDTO.BuilderCommon.an().id((String) map.get(ContractEnum.INSURANCE_CONTRACT_BRANCH_ID.name())).name(StringUtils.EMPTY).build())
                        .build())
                .build();

        String strRenewalNumber = Objects.toString(map.get(ContractEnum.RENEWAL_NUMBER.name()),"");
        if (!StringUtils.isEmpty(strRenewalNumber)) {
            out.setRenewalPolicy(RenewalDTO.Builder.an().counter(NumberUtils.createInteger(strRenewalNumber)).renewalDate(ConvertUtils.getLocalTimeDate(ContractEnum.NEXT_RENEWAL_START_DATE.name(), map)).build());
        }

        return out;

    }

}
