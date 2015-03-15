package cn.itcast.web.action.privilege;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.PageView;
import cn.itcast.bean.privilege.PrivilegeGroup;
import cn.itcast.service.privilege.PrivilegeGroupService;
import cn.itcast.web.formbean.privilege.PrivilegeGroupForm;
/**
 * Ȩ�����ҳ�б�
 */
@Controller("/control/privilegegroup/list")
public class PrivilegeGroupListAction extends Action {
	@Resource PrivilegeGroupService groupService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrivilegeGroupForm formbean = (PrivilegeGroupForm)form;
		PageView<PrivilegeGroup> pageView = new PageView<PrivilegeGroup>(12, formbean.getPage());
		pageView.setQueryResult(groupService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult()));
		request.setAttribute("pageView", pageView);
		return mapping.findForward("list");
	}

}
