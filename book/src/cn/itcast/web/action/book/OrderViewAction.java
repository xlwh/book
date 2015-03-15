package cn.itcast.web.action.book;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.book.Order;
import cn.itcast.bean.privilege.Employee;
import cn.itcast.service.book.OrderService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.utils.WebUtil;
import cn.itcast.web.action.privilege.Permission;
import cn.itcast.web.formbean.book.OrderForm;
/**
 * 订单信息查看
 */
@Controller("/control/order/view")
public class OrderViewAction extends Action {
	@Resource OrderService orderService;

	@Override  @Permission(module="order", privilege="view")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm formbean = (OrderForm)form;
		Employee employee = WebUtil.getEmployee(request);
		String username = employee.getUsername();
		Order order = orderService.addLock(formbean.getOrderid(), username);
		if(order.getLockuser()!=null && !order.getLockuser().equals(username)){
			request.setAttribute("message", "订单已经被"+ order.getLockuser() + "加锁");
			request.setAttribute("urladdress", SiteUrl.readUrl("control.order.list"));
			return mapping.findForward("message");
		}
		request.setAttribute("order", order);
		return mapping.findForward("order");
	}
}
