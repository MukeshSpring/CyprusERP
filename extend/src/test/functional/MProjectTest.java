/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2008 SC ARHIPAC SERVICE SRL. All Rights Reserved.            *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package test.functional;

import org.cyprusbrs.model.MProject;
import org.cyprusbrs.model.MProjectIssue;
import org.cyprusbrs.model.MProjectLine;
import org.cyprusbrs.model.MProjectPhase;
import org.cyprusbrs.util.Env;

import test.AdempiereTestCase;

/**
 * @author Teo Sarca, www.arhipac.ro // used by red1
 */
public class MProjectTest extends AdempiereTestCase
{
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		assertEquals("Client is not GardenWorld", 11, Env.getAD_Client_ID(getCtx()));
	}
	
	public void testQuery() throws Exception
	{
		MProject proj = new MProject(getCtx(),101,null); 
		{
			//test ProjectLines
			MProjectLine[] lines = proj.getLines();
			assertTrue("There should be lines in this project", lines.length > 0);
		}
		{
			//test ProjectIssue
			MProjectIssue[] issues = proj.getIssues();
			assertTrue("There are no issues in this project", issues.length == 0);
		}
		{
			//test ProjectPhase
			MProjectPhase[] lines = proj.getPhases();
			assertTrue("There are no phases in this project", lines.length == 0);
		}
	}
}
