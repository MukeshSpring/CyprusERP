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
package org.cyprusbrs.util;

import java.util.ListResourceBundle;

/**
 *  License Dialog Translation
 *
 *  @author     ZhaoXing Meng
 *  @version    $Id: IniRes_zh_CN.java,v 1.2 2006/07/30 00:52:23 jjanke Exp $
 */
public class IniRes_zh_CN extends ListResourceBundle
{
	/** Translation Content     */
	static final Object[][] contents = new String[][]
	{
	{ "Adempiere_License",   "\u6700\u7ec8\u7528\u6237\u8bb8\u53ef\u534f\u8bae" },
	{ "Do_you_accept",      "\u60a8\u540c\u610f\u6b64\u534f\u8bae\u5417\uff1f" },
	{ "No",                 "\u4e0d" },
	{ "Yes_I_Understand",   "\u662f\uff0c\u6211\u540c\u610f\u5e76\u4e14\u63a5\u53d7" },
	{ "license_htm",        "org/adempiere/license.htm" },
	{ "License_rejected",   "\u6743\u9650\u88ab\u62d2\u7edd\u6216\u5df2\u8fc7\u671f" }
	};

	/**
	 *  Get Content
	 *  @return Content
	 */
	public Object[][] getContents()
	{
		return contents;
	}   //  getContent
}   //  IniRes
