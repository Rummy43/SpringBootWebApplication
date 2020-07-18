package spring.boot.webApp.Spring.Boot.Web.Application;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.boot.webApp.Spring.Boot.Web.interfaces.UserAllowed;

@Component
public class ProductServiceInterceptor extends HandlerInterceptorAdapter {
   @Override
   public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	   HttpSession session= request.getSession();
	   Map<String,String> roleMap = (Map<String, String>) session.getAttribute("map");
	   System.out.println(roleMap);
	   HandlerMethod obj = (HandlerMethod) handler;
	   if(obj.getBean().getClass().isAnnotationPresent(UserAllowed.class)) {
		   Annotation an = obj.getBean().getClass().getAnnotation(UserAllowed.class);
		   UserAllowed ua = (UserAllowed) an;
		   System.out.println(ua.datTabs());
		   System.out.println(roleMap.values().contains(ua.datTabs().toString()));
		   if(roleMap.values().contains(ua.datTabs().toString())) {
			   System.out.println("yes it is....");
		   }else {
			   return false;
		   }
	   }
	   
	   
      return true;
   }
   @Override
   public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler, 
      ModelAndView modelAndView) throws Exception {}
   
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
      Object handler, Exception exception) throws Exception {}
}
