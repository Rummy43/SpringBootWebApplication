package spring.boot.webApp.Spring.Boot.Web.Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import spring.boot.webApp.Spring.Boot.Web.interfaces.UserAllowed;
import spring.boot.webApp.Spring.Boot.Web.interfaces.UserAllowed.DatTabs;

@UserAllowed(datTabs=DatTabs.INQUIRY)
@Controller
public class Test2Controller {
	
	@GetMapping("/check")
	public String userAnnotationCheck() {
		System.out.println("in check:test2 controller..");
		return "test";
	}
}
