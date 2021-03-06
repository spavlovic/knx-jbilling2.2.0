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

package com.sapienter.jbilling.server.provisioning.task.mmsc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.1
 * Thu May 28 10:10:49 EST 2009
 * Generated source version: 2.2.1
 * 
 */
 
@WebService(targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", name = "IMMSCHandlerFacade")
@XmlSeeAlso({ObjectFactory.class})
public interface IMMSCHandlerFacade {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getCustomerInfo", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.GetCustomerInfo")
    @ResponseWrapper(localName = "getCustomerInfoResponse", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.GetCustomerInfoResponse")
    @WebMethod
    public com.sapienter.jbilling.server.provisioning.task.mmsc.GetCustomerResponse getCustomerInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        com.sapienter.jbilling.server.provisioning.task.mmsc.GetCustomerRequest arg0
    ) throws MMSCException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addCustomer", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.AddCustomer")
    @ResponseWrapper(localName = "addCustomerResponse", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.AddCustomerResponse")
    @WebMethod
    public com.sapienter.jbilling.server.provisioning.task.mmsc.MmscFacadeHandlerResponse addCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        com.sapienter.jbilling.server.provisioning.task.mmsc.AddCustomerRequest arg0
    ) throws MMSCException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "modifyCustomer", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.ModifyCustomer")
    @ResponseWrapper(localName = "modifyCustomerResponse", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.ModifyCustomerResponse")
    @WebMethod
    public com.sapienter.jbilling.server.provisioning.task.mmsc.MmscFacadeHandlerResponse modifyCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        com.sapienter.jbilling.server.provisioning.task.mmsc.ModifyCustomerRequest arg0
    ) throws MMSCException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteCustomer", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.DeleteCustomer")
    @ResponseWrapper(localName = "deleteCustomerResponse", targetNamespace = "http://mmschandlerfacade.efs.teliasonera.se/", className = "com.sapienter.jbilling.server.provisioning.task.mmsc.DeleteCustomerResponse")
    @WebMethod
    public com.sapienter.jbilling.server.provisioning.task.mmsc.MmscFacadeHandlerResponse deleteCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        com.sapienter.jbilling.server.provisioning.task.mmsc.DeleteCustomerRequest arg0
    ) throws MMSCException_Exception;
}
