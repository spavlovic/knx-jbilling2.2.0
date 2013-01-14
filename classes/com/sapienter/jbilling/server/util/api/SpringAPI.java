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
package com.sapienter.jbilling.server.util.api;

import java.math.BigDecimal;
import java.util.Date;

import com.sapienter.jbilling.server.entity.AchDTO;
import com.sapienter.jbilling.server.entity.CreditCardDTO;
import com.sapienter.jbilling.server.invoice.InvoiceWS;
import com.sapienter.jbilling.server.item.ItemDTOEx;
import com.sapienter.jbilling.server.item.PricingField;
import com.sapienter.jbilling.server.item.ItemTypeWS;
import com.sapienter.jbilling.server.notification.MessageDTO;
import com.sapienter.jbilling.server.order.OrderLineWS;
import com.sapienter.jbilling.server.order.OrderWS;
import com.sapienter.jbilling.server.payment.PaymentAuthorizationDTOEx;
import com.sapienter.jbilling.server.payment.PaymentWS;
import com.sapienter.jbilling.server.user.ContactWS;
import com.sapienter.jbilling.server.user.CreateResponseWS;
import com.sapienter.jbilling.server.user.UserTransitionResponseWS;
import com.sapienter.jbilling.server.user.UserWS;
import com.sapienter.jbilling.server.user.ValidatePurchaseWS;
import com.sapienter.jbilling.server.util.IWebServicesSessionBean;
import com.sapienter.jbilling.server.util.RemoteContext;
import java.util.Collection;

public class SpringAPI implements JbillingAPI {

    private IWebServicesSessionBean session = null;

    public SpringAPI() throws JbillingAPIException {
        this(RemoteContext.Name.API_CLIENT);
    }

    public SpringAPI(RemoteContext.Name bean) {
        session = (IWebServicesSessionBean) RemoteContext.getBean(bean);
    }

    /*
     * INVOICES
     */
    public Integer[] createInvoice(Integer userId, boolean onlyRecurring)
            throws JbillingAPIException {
        try {
            return session.createInvoice(userId, onlyRecurring);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public InvoiceWS getInvoiceWS(Integer invoiceId)
            throws JbillingAPIException {
        try {
            return session.getInvoiceWS(invoiceId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void deleteInvoice(Integer invoiceId) throws JbillingAPIException {
        try {
            session.deleteInvoice(invoiceId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public InvoiceWS getLatestInvoice(Integer userId)
            throws JbillingAPIException {
        try {
            return session.getLatestInvoice(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getLastInvoices(Integer userId, Integer number)
            throws JbillingAPIException {
        try {
            return session.getLastInvoices(userId, number);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getInvoicesByDate(String since, String until)
            throws JbillingAPIException {
        try {
            return session.getInvoicesByDate(since, until);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getUserInvoicesByDate(Integer userId, String since,
            String until) throws JbillingAPIException {
        try {
            return session.getUserInvoicesByDate(userId, since, until);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * ------------------- INVOICE API EXTENSION --------------------------
     */
    /**
     * Retrieves a list of all the {@link InvoiceWS invoices} in a given period
     * of time. The method will return an array of the InvoiceWS objects.<br>
     *
     * @see JbillingAPI#getInvoiceListByDate(java.lang.String, java.lang.String)
     * @throws JbillingAPIException when internal error occurs
     */
    public InvoiceWS[] getInvoiceListByDate(String since, String until) throws JbillingAPIException {
        try {
            return session.getInvoiceListByDate(since, until);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * Generates and returns the paper invoice PDF for the given invoiceId.
     * TODO: Extra check might require to make sure invoice belongs to user.
     *
     * @see JbillingAPI#getPaperInvoicePDF(java.lang.Integer, java.lang.Integer)
     * @throws JbillingAPIException when internal error occurs
     */
    public byte[] getPaperInvoicePDF(Integer invoiceId, Integer userId) throws JbillingAPIException {
        try {
            return session.getPaperInvoicePDF(invoiceId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * Sends an email with the invoice to a customer. This API call is used to
     * manually send an email invoice to a customer. TODO: Extra check might
     * require to make sure invoice belongs to user.
     *
     * @see JbillingAPI#emailInvoice(java.lang.Integer, java.lang.Integer)
     * @throws JbillingAPIException when internal error occurs
     */
    public Boolean emailInvoice(Integer invoiceId, Integer userId) throws JbillingAPIException {
        try {
            return session.emailInvoice(invoiceId, userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /*
     * USERS
     */
    public Integer createUser(UserWS newUser) throws JbillingAPIException {
        try {
            return session.createUser(newUser);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public UserWS getUserWS(Integer userId) throws JbillingAPIException {
        try {
            return session.getUserWS(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ContactWS[] getUserContactsWS(Integer userId)
            throws JbillingAPIException {
        try {
            return session.getUserContactsWS(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateUser(UserWS user) throws JbillingAPIException {
        try {
            session.updateUser(user);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateUserContact(Integer userId, Integer typeId,
            ContactWS contact) throws JbillingAPIException {
        try {
            session.updateUserContact(userId, typeId, contact);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void deleteUser(Integer userId) throws JbillingAPIException {
        try {
            session.deleteUser(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer getUserId(String username) throws JbillingAPIException {
        try {
            return session.getUserId(username);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getUsersInStatus(Integer statusId)
            throws JbillingAPIException {
        try {
            return session.getUsersInStatus(statusId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getUsersNotInStatus(Integer statusId)
            throws JbillingAPIException {
        try {
            return session.getUsersNotInStatus(statusId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getUsersByCreditCard(String number)
            throws JbillingAPIException {
        try {
            return session.getUsersByCreditCard(number);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getUsersByCustomField(Integer typeId, String value)
            throws JbillingAPIException {
        try {
            return session.getUsersByCustomField(typeId, value);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public CreateResponseWS create(UserWS user, OrderWS order)
            throws JbillingAPIException {
        try {
            return session.create(user, order);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer authenticate(String username, String password)
            throws JbillingAPIException {
        try {
            return session.authenticate(username, password);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateCreditCard(Integer userId, CreditCardDTO creditCard)
            throws JbillingAPIException {
        try {
            session.updateCreditCard(userId, creditCard);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateAch(Integer userId, AchDTO ach) throws JbillingAPIException {
        try {
            session.updateAch(userId, ach);
            //new com.sapienter.jbilling.server.user.db.AchDTO(ach));
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    @Override
    public Integer getAutoPaymentType(Integer userId)
            throws JbillingAPIException {
        try {
            return session.getAuthPaymentType(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    @Override
    public void setAutoPaymentType(Integer userId, Integer autoPaymentType, boolean use)
            throws JbillingAPIException {
        try {
            session.setAuthPaymentType(userId, autoPaymentType, use);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public UserTransitionResponseWS[] getUserTransitions(Date from, Date to)
            throws JbillingAPIException {
        try {
            return session.getUserTransitions(from, to);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public UserTransitionResponseWS[] getUserTransitionsAfterId(Integer id)
            throws JbillingAPIException {
        try {
            return session.getUserTransitionsAfterId(id);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * ------------------- USER API EXTENSION --------------------------
     */
    /**
     * Retrieves a list of all {@link UserWS users} in a given status.
     *
     * @param statusId the status id that will be used for extraction
     * @return an array of <code>UserWS</code> objects in a given status.
     * @throws JbillingAPIException when internal error occurs
     */
    public UserWS[] getUserListInStatus(Integer statusId) throws JbillingAPIException {
        try {
            return session.getUserListInStatus(statusId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * Retrieves a list of all {@link UserWS customers} in a given status
     * including sub-accounts. This call excludes any other users that are not
     * Customers.
     *
     * @see JbillingAPI#getCustomersInStatus(java.lang.Integer)
     * @throws JbillingAPIException when internal error occurs
     */
    public Collection<UserWS> getCustomersInStatus(Integer statusId) throws JbillingAPIException {
        try {
            return session.getCustomersInStatus(statusId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * Search for {@link UserWS users}, including sub-accounts by given search
     * parameter. Only search users who are customers.
     *
     * @see JbillingAPI#searchCustomers(java.lang.String)
     * @throws JbillingAPIException when internal error occurs
     */
    public UserWS[] searchCustomers(String searchValue) throws JbillingAPIException {
        try {
            return session.searchCustomers(searchValue);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /*
     * ORDERS
     */
    public Integer createOrder(OrderWS order) throws JbillingAPIException {
        try {
            return session.createOrder(order);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public PaymentAuthorizationDTOEx createOrderPreAuthorize(OrderWS order)
            throws JbillingAPIException {
        try {
            return session.createOrderPreAuthorize(order);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer createOrderAndInvoice(OrderWS order) throws JbillingAPIException {
        try {
            return session.createOrderAndInvoice(order);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS rateOrder(OrderWS order) throws JbillingAPIException {
        try {
            return session.rateOrder(order);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS[] rateOrders(OrderWS orders[]) throws JbillingAPIException {
        try {
            return session.rateOrders(orders);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateOrder(OrderWS order) throws JbillingAPIException {
        try {
            session.updateOrder(order);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS getOrder(Integer orderId) throws JbillingAPIException {
        try {
            return session.getOrder(orderId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getOrderByPeriod(Integer userId, Integer periodId)
            throws JbillingAPIException {
        try {
            return session.getOrderByPeriod(userId, periodId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderLineWS getOrderLine(Integer orderLineId)
            throws JbillingAPIException {
        try {
            return session.getOrderLine(orderLineId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateOrderLine(OrderLineWS line) throws JbillingAPIException {
        try {
            session.updateOrderLine(line);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS getLatestOrder(Integer userId) throws JbillingAPIException {
        try {
            return session.getLatestOrder(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getLastOrders(Integer userId, Integer number)
            throws JbillingAPIException {
        try {
            return session.getLastOrders(userId, number);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void deleteOrder(Integer id) throws JbillingAPIException {
        try {
            session.deleteOrder(id);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS getCurrentOrder(Integer userId, Date date)
            throws JbillingAPIException {
        try {
            return session.getCurrentOrder(userId, date);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS updateCurrentOrder(Integer userId, OrderLineWS[] lines,
            PricingField[] fields, Date date, String eventDescription)
            throws JbillingAPIException {
        try {
            return session.updateCurrentOrder(userId, lines,
                    PricingField.setPricingFieldsValue(fields), date,
                    eventDescription);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /*
     * PAYMENT
     */
    public PaymentAuthorizationDTOEx payInvoice(Integer invoiceId)
            throws JbillingAPIException {
        try {
            return session.payInvoice(invoiceId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer applyPayment(PaymentWS payment, Integer invoiceId)
            throws JbillingAPIException {
        try {
            return session.applyPayment(payment, invoiceId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public PaymentWS getPayment(Integer paymentId) throws JbillingAPIException {
        try {
            return session.getPayment(paymentId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public PaymentWS getLatestPayment(Integer userId)
            throws JbillingAPIException {
        try {
            return session.getLatestPayment(userId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getLastPayments(Integer userId, Integer number)
            throws JbillingAPIException {
        try {
            return session.getLastPayments(userId, number);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /*
     * @see com.sapienter.jbilling.server.util.api.JbillingAPI#processPayment(com.sapienter.jbilling.server.payment.PaymentWS)
     */
    @Override
    public PaymentAuthorizationDTOEx processPayment(PaymentWS payment)
            throws JbillingAPIException {
        try {
            return session.processPayment(payment);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     * ------------------- PAYMENT API EXTENSION --------------------------
     */
    /*
     * ITEM
     */
    public Integer createItem(ItemDTOEx dto) throws JbillingAPIException {
        try {
            return session.createItem(dto);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ItemDTOEx[] getAllItems() throws JbillingAPIException {
        try {
            return session.getAllItems();
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ItemDTOEx getItem(Integer itemId, Integer userId, PricingField[] fields)
            throws JbillingAPIException {
        try {
            return session.getItem(itemId, userId, PricingField.setPricingFieldsValue(fields));
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateItem(ItemDTOEx item) throws JbillingAPIException {
        try {
            session.updateItem(item);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public InvoiceWS getLatestInvoiceByItemType(Integer userId, Integer itemTypeId)
            throws JbillingAPIException {
        try {
            return session.getLatestInvoiceByItemType(userId, itemTypeId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public OrderWS getLatestOrderByItemType(Integer userId, Integer itemTypeId) throws JbillingAPIException {
        try {
            return session.getLatestOrderByItemType(userId, itemTypeId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getLastInvoicesByItemType(Integer userId, Integer itemTypeId, Integer number)
            throws JbillingAPIException {
        try {
            return session.getLastInvoicesByItemType(userId, itemTypeId, number);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer[] getLastOrdersByItemType(Integer userId, Integer itemTypeId, Integer number)
            throws JbillingAPIException {
        try {
            return session.getLastOrdersByItemType(userId, itemTypeId, number);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public BigDecimal isUserSubscribedTo(Integer userId, Integer itemId)
            throws JbillingAPIException {
        try {
            return session.isUserSubscribedTo(userId, itemId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    @Override
    public Integer[] getUserItemsByCategory(Integer userId, Integer categoryId)
            throws JbillingAPIException {
        try {
            return session.getUserItemsByCategory(userId, categoryId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ItemDTOEx[] getItemByCategory(Integer itemTypeId) throws JbillingAPIException {
        try {
            return session.getItemByCategory(itemTypeId);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ItemTypeWS[] getAllItemCategories() throws JbillingAPIException {
        try {
            return session.getAllItemCategories();
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ValidatePurchaseWS validatePurchase(Integer userId, Integer itemId,
            PricingField[] fields) throws JbillingAPIException {
        try {
            return session.validatePurchase(userId, itemId,
                    PricingField.setPricingFieldsValue(fields));
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public ValidatePurchaseWS validateMultiPurchase(Integer userId,
            Integer[] itemIds, PricingField[][] fields)
            throws JbillingAPIException {
        try {
            String[] pricingFields = null;
            if (fields != null) {
                pricingFields = new String[fields.length];
                for (int i = 0; i < pricingFields.length; i++) {
                    pricingFields[i] = PricingField.setPricingFieldsValue(
                            fields[i]);
                }
            }
            return session.validateMultiPurchase(userId, itemIds,
                    pricingFields);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer createItemCategory(ItemTypeWS itemType) throws JbillingAPIException {
        try {
            return session.createItemCategory(itemType);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void updateItemCategory(ItemTypeWS itemType) throws JbillingAPIException {
        try {
            session.updateItemCategory(itemType);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public void generateRules(String rulesData) throws JbillingAPIException {
        try {
            session.generateRules(rulesData);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /*
     * NOTIFICATIONS
     */
    public MessageDTO[] getNotificationMessages() throws JbillingAPIException {
        try {
            return session.getNotificationMessages();
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    public Integer createUpdateNofications(Integer messageId, MessageDTO dto) throws JbillingAPIException {
        try {
            return session.createUpdateNofications(messageId, dto);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }

    /**
     *
     * ------------------- MISC API EXTENSION --------------------------
     */
    /**
     * Saves uploaded logo image file for the user's entity (company).
     *
     * @see JbillingAPI#uploadLogo(byte[])
     * @throws JbillingAPIException when internal error occurs
     */
    public boolean uploadLogo(byte[] inBytes) throws JbillingAPIException {
        try {
            return session.uploadLogo(inBytes);
        } catch (Exception e) {
            throw new JbillingAPIException(e);
        }
    }
}
