<%--
 *  Product: Posterita Web-Based POS and Adempiere Plugin
 *  Copyright (C) 2007  Posterita Ltd
 *  This file is part of POSterita
 *  
 *  POSterita is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * @author Praveen
--%>

<!-- createBPartner.jsp -->
<%@ page import="org.posterita.struts.bPartner.BPartnerAction" %>
<%@ page import ="org.posterita.Constants" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>	
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/pos.tld" prefix="pos"%>

<bean:define id="title"><pos:message key="create.bpartner" textOnly="true"/></bean:define>
<%@ include file="/jsp/include/posHeader.jsp" %>
<%@ include file="/jsp/include/errors.jsp" %>
	 
<html:form action="/CreateBPartnerAction">
<html:hidden property="action" value="<%=BPartnerAction.CREATE_BPARTNER%>"/>
	 
	<table width="100%" border="0" cellpadding="5" cellspacing="0">
	 <tr>
   			 <td>	
   			 	<pos:message key="Name"/><mandatory>*</mandatory>
   			 </td>	
   			 	
   		
 			  <td>
 				  <html:text property="partnerName"/>
 			  </td>  		
   		</tr>
   		
   		<tr>
   			 <td>	
   			 	<pos:message key="Name2" /><mandatory>*</mandatory>
   			 </td>	
   			 	
   		
 			  <td>
 				  <html:text property="name2"/>
 			  </td>  		
   		</tr>
   		
   		
   		<tr>
    		<td width="15%">
				<pos:message key="address1" /><mandatory>*</mandatory>
			</td>
				
			<td>	
				<html:text property="address1"/>
			</td>	
		</tr>	
	   	 
	   	 
   		<tr>
    		<td width="15%">
				<pos:message key="address2" />
			</td>
				
			<td>	
				<html:text property="address2"/>
			</td>	
		</tr>	
			   	 
	   	<tr>
	   	 	<td width="15%">
	   	 		<pos:message key="postalAddr" />
	   	 	</td>
	   	 	
	   	 	<td>
	   	 		<html:text property="postalAddress"/>
	   	 	</td>
	   	 </tr>	
	   	 
	   	 <tr>
	   	 	<td width="15%">
	   	 		<pos:message key="city" />
	   	 	</td>
	   	 	
	   	 	<td>
	   	 		<html:text property="city"/>
	   	 	</td>	   	 	
	   	 </tr>   	 
	   	 	   	 
	   	 <tr>
	   	 	<td width="15%">
	   	 		<pos:message key="phone" />
	   	 	</td>
	   	 	
	   	 	<td>
	   	 		<html:text property="phone"/>
	   	 	</td>	   	 	
	   	 </tr>
	   	 		
	   	 <tr>
	   	 	<td width="15%">
	   	 		<pos:message key="fax" />
	   	 	</td>
	   	 	
	   	 	<td>
	   	 		<html:text property="fax"/>
	   	 	</td>	   	 	
	   	 </tr>
	   	 
	   	 <tr>
			<td width="15%">
		   		<pos:message key="isCustomer" />
		   	</td>
		   	
		   			   	
		   	<td> 	
		   		
	   	 		<html:checkbox property="isCustomer" value="true">
	   	 		<input type="hidden" name="isCustomer" value="false">	
	   	 		</html:checkbox>	
		   	 </td>
		 </tr>
		
		 <tr>
				<td width="15%">
					<pos:message key="isVendor" />
				</td>
				
				<td>
					<html:checkbox property="isVendor" value="true">
					<input type="hidden" name="isVendor" value="false">
					</html:checkbox>
				</td>		
		 </tr>
		 
		<tr>
			<td>
				<label><pos:message key="organisation.name"/>:</label><mandatory>*</mandatory>
			</td>
		
			<td>
				<html:select property="orgId" styleClass="text">
					<html:options collection="<%=Constants.USER_ORGS%>" property="key" labelProperty="name"/>
			 	</html:select>
			</td>
		</tr>			 
	<%--	
		 <tr>
				<td width="15%">
					<pos:message key="isEmployee" />
				</td>
				
				<td>
					<html:checkbox property="isEmployee" value="true">
					<input type="hidden" name="isEmployee" value="false">
					</html:checkbox>
				</td>		
		 </tr>
		
		 <tr>
				<td width="15%">
					<pos:message key="isSalesRep" />
				</td>
				
				<td>
					<html:checkbox property="isSalesRep" value="true">
					<input type="hidden" name="isSalesRep" value="false">
					</html:checkbox>
				</td>		
		 </tr>
		
		 <tr>
				<td width = "15%">
					<bean:message key="bPartner.region"/>
				</td>
				
				<td>
					<html:select property="regionId">
	   	 				<html:options collection="<%=Constants.REGIONS%>" property="key" labelProperty="name"/>
	   	 			</html:select>	
	   	 		</td>
	   	 </tr>
	   	 --%>			
		 <tr>
		 		<td>
					&nbsp;
				</td>
			
	   	    	<td>
			   		<html:submit styleClass="smallbutton save">
			   	 		&nbsp;
					</html:submit>
		 		</td>
	     </tr>
	   	 
	</table>
	
</html:form>				
<%@ include file="/jsp/include/posFooter.jsp" %>
	   
	
												