/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.cyprusbrs.www;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cyprusbrs.util.WebDoc;
import org.cyprusbrs.util.WebEnv;
import org.cyprusbrs.util.WebUtil;

public class Test2 extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6839830507472511719L;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		WebEnv.initWeb(config);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Test");
		dispatcher.forward(request, response);
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		WebDoc doc = WebDoc.create ("Get Request Test2");
		//
		WebUtil.createResponse(request, response, this, null, doc, true);
	} 

} 
