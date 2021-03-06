/*
 jBilling - The Enterprise Open Source Billing System
 Copyright (C) 2003-2009 Enterprise jBilling Software Ltd. and Emiliano Conde

 This file is part of jbilling.

 jbilling is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 jbilling is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with jbilling.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sapienter.jbilling.server.payment;

import com.sapienter.jbilling.server.entity.AchDTO;
import com.sapienter.jbilling.server.entity.CreditCardDTO;
import com.sapienter.jbilling.server.entity.PaymentAuthorizationDTO;
import com.sapienter.jbilling.server.entity.PaymentInfoBankDTO;
import com.sapienter.jbilling.server.entity.PaymentInfoCashDTO;
import com.sapienter.jbilling.server.entity.PaymentInfoChequeDTO;
import com.sapienter.jbilling.server.user.UserWS;
import com.sapienter.jbilling.server.util.Constants;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Emil
 */
public class PaymentWS implements Serializable {

    private Integer userId = null;
    private PaymentInfoChequeDTO cheque = null;
    private PaymentInfoCashDTO cash = null;
    private PaymentInfoBankDTO bank = null;
    private CreditCardDTO creditCard = null;
    private AchDTO ach = null;
    private String method = null;
    private Integer invoiceIds[] = null;
    // refund specific fields
    private Integer paymentId = null; // this is the payment refunded / to refund
    private PaymentAuthorizationDTO authorization = null;
    //missing properties from PaymentDTO
    private String amount;
    private Integer isRefund;
    private Integer paymentMethodId;
    private Date paymentDate;
    private Integer currencyId;
    private int id;
    private Integer isPreauth;
    private Integer attempt;
    private String balance;
    private Date createDatetime;
    private Date updateDatetime;
    private int deleted;
    private Integer baseUserId;
    private Integer resultId;
    private String paymentNotes = null;
    private Integer paymentPeriod;
    private BigDecimal amountAsDecimal;
    private BigDecimal balanceAsDecimal;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    /**
     *
     */
    public PaymentWS() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PaymentInfoChequeDTO getCheque() {
        return cheque;
    }

    public void setCheque(PaymentInfoChequeDTO cheque) {
        this.cheque = cheque;
    }

    public PaymentInfoCashDTO getCash() {
        return cash;
    }

    public void setCash(PaymentInfoCashDTO cash) {
        this.cash = cash;
    }

    public PaymentInfoBankDTO getBank() {
        return bank;
    }

    public void setBank(PaymentInfoBankDTO bank) {
        this.bank = bank;
    }

    public CreditCardDTO getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardDTO creditCard) {
        this.creditCard = creditCard;
    }

    public AchDTO getAch() {
        return ach;
    }

    public void setAch(AchDTO ach) {
        this.ach = ach;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer[] getInvoiceIds() {
        return invoiceIds;
    }

    public void setInvoiceIds(Integer[] invoiceIds) {
        this.invoiceIds = invoiceIds;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentAuthorizationDTO getAuthorizationId() {
        return authorization;
    }

    public void setAuthorization(PaymentAuthorizationDTO authorization) {
        this.authorization = authorization;
    }

    // required by CXF
    public void setAuthorizationId(PaymentAuthorizationDTO authorization) {
        this.authorization = authorization;
    }

    public String getAmount() {
        return amount;
    }

    public BigDecimal getAmountAsDecimal() {
        if (amountAsDecimal != null) {
            return amountAsDecimal;
        }
        return (amount == null ? null : new BigDecimal(amount));
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * <strong>Note:</strong> Subsequent call to getAmount returns value rounded
     * to 2 decimals. Use getAmountAsDecimal if precision is important, i.e. for
     * calculations
     *
     * @param quantity
     */
    public void setAmount(BigDecimal amount) {
        this.amountAsDecimal = amount;
        if (amount != null) {
            this.amount = amount.setScale(Constants.BIGDECIMAL_SCALE_STR, Constants.BIGDECIMAL_ROUND).toString();
        }
    }

    public Integer getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Integer isRefund) {
        this.isRefund = isRefund;
    }

    public Integer getMethodId() {
        return paymentMethodId;
    }

    public void setMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIsPreauth() {
        return isPreauth;
    }

    public void setIsPreauth(Integer isPreauth) {
        this.isPreauth = isPreauth;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public String getBalance() {
        return balance;
    }

    public BigDecimal getBalanceAsDecimal() {
        if (balanceAsDecimal != null) {
            return balanceAsDecimal;
        }
        return (balance == null ? null : new BigDecimal(balance));
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * <strong>Note:</strong> Subsequent call to getBalance returns value
     * rounded to 2 decimals. Use getBalanceAsDecimal if precision is important,
     * i.e. for calculations
     *
     * @param quantity
     */
    public void setBalance(BigDecimal balance) {
        this.balanceAsDecimal = balance;
        if (balance != null) {
            this.balance = balance.setScale(Constants.BIGDECIMAL_SCALE_STR, Constants.BIGDECIMAL_ROUND).toString();
        }
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Integer getBaseUserId() {
        return baseUserId;
    }

    public void setBaseUserId(Integer baseUserId) {
        this.baseUserId = baseUserId;
    }

    public void setPaymentNotes(String paymentNotes) {
        this.paymentNotes = paymentNotes;
    }

    public String getPaymentNotes() {
        return paymentNotes;
    }

    public void setPaymentPeriod(Integer paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public Integer getPaymentPeriod() {
        return paymentPeriod;
    }
    /**
     * @param id
     * @param amount
     * @param createDateTime
     * @param paymentDate
     * @param attempt
     * @param deleted
     * @param methodId
     * @param resultId
     * @param isRefund
     */
//    public PaymentWS(Integer id, Float amount, Date createDateTime,
//            Date paymentDate, Integer attempt, Integer deleted,
//            Integer methodId, Integer resultId, Integer isRefund,
//            Integer isPreauth,
//            Integer currencyId, Float balance) {
//        super(id, amount, balance, createDateTime, null, paymentDate, attempt,
//                deleted, methodId, resultId, isRefund, isPreauth, currencyId, null, null);
//    }
    /**
     * @param otherValue
     */
//    public PaymentWS(PaymentDTO otherValue) {
//        super(otherValue);
//    }
}
