package fileter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.EzbShopcar;

public class ShopcarListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		EzbShopcar sc=new EzbShopcar();
		arg0.getSession().setAttribute("sc",sc);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

}
