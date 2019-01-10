package com.soft.social.queryData.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SocialSecurityBaseEntity  implements Serializable {

    /**
     * 城市
     */
    private String city;

    /**
     * 社保最低缴纳金额
     */
    private BigDecimal socialPaymentMin;

    /**
     * 社保最高缴纳金额
     */
    private BigDecimal socialPaymentMax;

    private BigDecimal personalPensionProportion;

    private BigDecimal personalMedicalProportion;

    private BigDecimal personalLostJobProportion;

    private BigDecimal companyPensionProportion;

    private BigDecimal companyMedicalProportion;

    private BigDecimal companyLostJobProportion;

    private BigDecimal companyInjuryProportion;

    private BigDecimal companyBirthProportion;

    private BigDecimal accumulationFundPaymentMin;

    private BigDecimal accumulationFundPaymentMax;

    private BigDecimal accumulationFundProportion;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getSocialPaymentMin() {
        return socialPaymentMin;
    }

    public void setSocialPaymentMin(BigDecimal socialPaymentMin) {
        this.socialPaymentMin = socialPaymentMin;
    }

    public BigDecimal getSocialPaymentMax() {
        return socialPaymentMax;
    }

    public void setSocialPaymentMax(BigDecimal socialPaymentMax) {
        this.socialPaymentMax = socialPaymentMax;
    }

    public BigDecimal getPersonalPensionProportion() {
        return personalPensionProportion;
    }

    public void setPersonalPensionProportion(BigDecimal personalPensionProportion) {
        this.personalPensionProportion = personalPensionProportion;
    }

    public BigDecimal getPersonalMedicalProportion() {
        return personalMedicalProportion;
    }

    public void setPersonalMedicalProportion(BigDecimal personalMedicalProportion) {
        this.personalMedicalProportion = personalMedicalProportion;
    }

    public BigDecimal getPersonalLostJobProportion() {
        return personalLostJobProportion;
    }

    public void setPersonalLostJobProportion(BigDecimal personalLostJobProportion) {
        this.personalLostJobProportion = personalLostJobProportion;
    }

    public BigDecimal getCompanyPensionProportion() {
        return companyPensionProportion;
    }

    public void setCompanyPensionProportion(BigDecimal companyPensionProportion) {
        this.companyPensionProportion = companyPensionProportion;
    }

    public BigDecimal getCompanyMedicalProportion() {
        return companyMedicalProportion;
    }

    public void setCompanyMedicalProportion(BigDecimal companyMedicalProportion) {
        this.companyMedicalProportion = companyMedicalProportion;
    }

    public BigDecimal getCompanyLostJobProportion() {
        return companyLostJobProportion;
    }

    public void setCompanyLostJobProportion(BigDecimal companyLostJobProportion) {
        this.companyLostJobProportion = companyLostJobProportion;
    }

    public BigDecimal getCompanyInjuryProportion() {
        return companyInjuryProportion;
    }

    public void setCompanyInjuryProportion(BigDecimal companyInjuryProportion) {
        this.companyInjuryProportion = companyInjuryProportion;
    }

    public BigDecimal getCompanyBirthProportion() {
        return companyBirthProportion;
    }

    public void setCompanyBirthProportion(BigDecimal companyBirthProportion) {
        this.companyBirthProportion = companyBirthProportion;
    }

    public BigDecimal getAccumulationFundPaymentMin() {
        return accumulationFundPaymentMin;
    }

    public void setAccumulationFundPaymentMin(BigDecimal accumulationFundPaymentMin) {
        this.accumulationFundPaymentMin = accumulationFundPaymentMin;
    }

    public BigDecimal getAccumulationFundPaymentMax() {
        return accumulationFundPaymentMax;
    }

    public void setAccumulationFundPaymentMax(BigDecimal accumulationFundPaymentMax) {
        this.accumulationFundPaymentMax = accumulationFundPaymentMax;
    }

    public BigDecimal getAccumulationFundProportion() {
        return accumulationFundProportion;
    }

    public void setAccumulationFundProportion(BigDecimal accumulationFundProportion) {
        this.accumulationFundProportion = accumulationFundProportion;
    }

}
