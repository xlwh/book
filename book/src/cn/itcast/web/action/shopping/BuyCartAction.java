package cn.itcast.web.action.shopping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.BuyCart;
import cn.itcast.bean.BuyItem;
import cn.itcast.bean.product.ProductInfo;
import cn.itcast.bean.product.ProductStyle;
import cn.itcast.service.product.ProductInfoService;
import cn.itcast.utils.WebUtil;
import cn.itcast.web.formbean.shopping.BuyCartForm;
/**
 * ���ﳵ
 */
@Controller("/shopping/cart")
public class BuyCartAction extends Action {
	@Resource ProductInfoService infoService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BuyCartForm formbean = (BuyCartForm)form;
		BuyCart cart = WebUtil.getBuyCart(request);
		if(cart == null ){
			cart = new BuyCart();
			request.getSession().setAttribute("buyCart", cart);
		}
		WebUtil.addCookie(response, "JSESSIONID", request.getSession().getId(), request.getSession().getMaxInactiveInterval());
		if(formbean.getProductid()!=null && formbean.getProductid()>0){
			ProductInfo product = infoService.find(formbean.getProductid());
			if(product!=null){//���洦���Ʒ����ʽ,ֻ�����û�ѡ�����ʽ
				ProductStyle currentStyle = null;
				for(ProductStyle style : product.getStyles()){
					if(style.getId().equals(formbean.getStyleid())){
						currentStyle = style;
						break;
					}
				}
				product.getStyles().clear();
				product.addProductStyle(currentStyle);
			}
			BuyItem item = new BuyItem(product);//����Ʒ��ӽ����ﳵ
			cart.addBuyItem(item);
		}		
		return mapping.findForward("buyCart");
	}

}
