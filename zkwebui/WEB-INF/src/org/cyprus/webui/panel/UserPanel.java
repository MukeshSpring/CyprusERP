/******************************************************************************
 * Product: Posterita Ajax UI 												  *
 * Copyright (C) 2007 Posterita Ltd.  All Rights Reserved.                    *
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
 * Posterita Ltd., 3, Draper Avenue, Quatre Bornes, Mauritius                 *
 * or via info@posterita.org or http://www.posterita.org/                     *
 *****************************************************************************/

package org.cyprus.webui.panel;

import java.util.Properties;

import org.cyprus.webui.LayoutUtils;
import org.cyprus.webui.component.Label;
import org.cyprus.webui.component.Messagebox;
import org.cyprus.webui.component.ToolBarButton;
import org.cyprus.webui.session.SessionManager;
import org.cyprus.webui.window.WPreference;
import org.cyprusbrs.model.MClient;
import org.cyprusbrs.model.MOrg;
import org.cyprusbrs.model.MRole;
import org.cyprusbrs.model.MUser;
import org.cyprusbrs.util.Env;
import org.cyprusbrs.util.Msg;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Vbox;

/**
 *
 * @author  <a href="mailto:agramdass@gmail.com">Ashley G Ramdass</a>
 * @date    Feb 25, 2007
 * @version $Revision: 0.10 $
 */
public class UserPanel extends Vbox  implements EventListener
{

	private static final long serialVersionUID = -45350536628290540L;

	private Properties ctx;

    private ToolBarButton logout = new ToolBarButton();
    private ToolBarButton role = new ToolBarButton();
    private ToolBarButton preference = new ToolBarButton();

    private Label lblUserNameValue = new Label();
	private WPreference preferencePopup;

    public UserPanel()
    {
        this.ctx = Env.getCtx();
        init();
    }

    private void init()
    {
    	this.setStyle("text-align:right");

    	// Elaine 2008/11/07 - fix the layout problem in IE7
    	this.setWidth("100%");
    	this.setAlign("right");
    	//

    	lblUserNameValue.setValue(getUserName() + "@" + getClientName() + "." + getOrgName());
    	lblUserNameValue.setStyle("text-align:right");
    	LayoutUtils.addSclass("desktop-header-font", lblUserNameValue);
    	this.appendChild(lblUserNameValue);

    	Hbox hbox = new Hbox();

    	preference.setLabel(Msg.getMsg(Env.getCtx(), "Preference"));
    	preference.addEventListener(Events.ON_CLICK, this);
    	preference.setStyle("text-align:right");
    	LayoutUtils.addSclass("desktop-header-font", preference);
    	preference.setParent(hbox);

    	Separator sep = new Separator("vertical");
    	sep.setBar(true);
    	sep.setParent(hbox);

    	role.setLabel(this.getRoleName());
    	role.addEventListener(Events.ON_CLICK, this);
    	role.setStyle("text-align:right");
    	LayoutUtils.addSclass("desktop-header-font", role);
    	role.setParent(hbox);

    	sep = new Separator("vertical");
    	sep.setBar(true);
    	sep.setParent(hbox);

    	logout.setLabel(Msg.getMsg(Env.getCtx(),"Logout"));
    	logout.addEventListener(Events.ON_CLICK, this);
    	logout.setStyle("text-align:right");
    	LayoutUtils.addSclass("desktop-header-font", logout);
    	logout.setParent(hbox);

    	this.appendChild(hbox);
    }

    private String getUserName()
    {
        MUser user = MUser.get(ctx);
        return user.getName();
    }

    private String getRoleName()
    {
        MRole role = MRole.getDefault(ctx, false);
        return role.getName();
    }

    private String getClientName()
    {
        MClient client = MClient.get(ctx);
        return client.getName();
    }

    private String getOrgName()
    {
    	int orgId = Env.getAD_Org_ID(ctx);
    	if (orgId > 0)
    	{
    		MOrg org = MOrg.get(ctx, orgId);
    		return org.getName();
    	}
    	else
    	{
    		return "*";
    	}
    }

	public void onEvent(Event event) throws Exception {
		if (event == null)
			return;

		if (logout == event.getTarget())
        {
            SessionManager.logoutSession();
        }
		else if (role == event.getTarget())
		{
			String roleInfo = MRole.getDefault().toStringX(Env.getCtx());
			roleInfo = roleInfo.replace(Env.NL, "<br>");
			Messagebox.showDialog(roleInfo, "Role Info", Messagebox.OK, Messagebox.INFORMATION);
		}
		else if (preference == event.getTarget())
		{
			if (preferencePopup != null)
			{
				preferencePopup.detach();
			}
			preferencePopup = new WPreference();
			preferencePopup.setPage(this.getPage());
			preferencePopup.open(preference);
		}

	}
}
