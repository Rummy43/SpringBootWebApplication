package spring.boot.webApp.Spring.Boot.Web.Application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.boot.webApp.Spring.Boot.Web.Application.controller.UserController.Test;
import spring.boot.webApp.Spring.Boot.Web.Application.model.User;
import spring.boot.webApp.Spring.Boot.Web.Application.model.UserList;
import spring.boot.webApp.Spring.Boot.Web.Application.repository.UserRepository;
import spring.boot.webApp.Spring.Boot.Web.interfaces.UserAllowed;
import spring.boot.webApp.Spring.Boot.Web.interfaces.UserAllowed.DatTabs;

@UserAllowed(datTabs=DatTabs.CREATE_CLAIM)
@Controller
public class TestController {

	@Autowired
	UserRepository userRepository;
	List<Test> test = new ArrayList<>();
	
	@GetMapping("/test")
	public String test() {
		System.out.println("in test controller...");
		return "test";
	}
	
	@GetMapping("/")
	public String index1(HttpSession session) {
		System.out.println("here in index page...");
		Map<String,String> roleMap = new HashMap<String,String>();
		roleMap.put("Role1", "INQUIRY");
		roleMap.put("Role2", "CREATE_CLAIM");
		session.setAttribute("map", roleMap);
		return "index";
	}
	
	@GetMapping("/getUser")
	public String getUser(Model model,HttpServletRequest request,HttpSession session) {
		System.out.println("here in getUser next... page...");
		System.out.println(session);
		session.getAttribute("usersList");
		List<User> l = new ArrayList<User>();
		UserList ul = new UserList();
		//ul =(UserList) session.getAttribute("usersList");
		/*System.out.println(session.getAttribute("usersList"));
		if(session.getAttribute("usersList")==null) {
			System.out.println("inside if..");
		for(int i=0;i<2;i++) {
	    User u = new User();
	    	u.setId(1);
	    	u.setFirstName("Rummy"+i);
	    	u.setLastName("Yara"+i);
	    	u.setPhone("8985644485");
	    	u.setAddress("apg"+i);
	    	l.add(u);
		}
			ul.setUsers(l);
	    	model.addAttribute("usersList",ul);
	    	session.setAttribute("usersList", ul);
		}*/
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "Rummy");
		map.put("nickName", "Chanti");
		model.addAttribute("map", map);
		
		l = userRepository.findAll();
		ul.setUsers(l);
		model.addAttribute("usersList",ul);
	    return "User";
	}
	
	@GetMapping("/addUserPage")
	public String getAddUserPage(Model model) {
		model.addAttribute("user",new User());
		return "addUser";
	}
	
	@GetMapping("/retrieveDataPage")
	public String getRetrievePage() {
		return "Retrieve";
	}
	
	@GetMapping("/dataNew")
	@ResponseBody
	public String test(@RequestParam Map map) {
		System.out.println(map);
		return "excellent";
	}
	
	@PostMapping("/retrieveDataNew")
	@ResponseBody
	public List<Test> getData(@RequestBody Map map) {
		System.out.println(map);
		System.out.println(map.get("fromDate"));
		List<Test> l = new ArrayList<>();
		for(int i=0; i<3; i++) {
			Test t1 = new Test();
			t1.setData("test"+i);
			t1.setTooltip("tooltip"+i);
			t1.setSelected(true);
			l.add(t1);
		}
		if(test.isEmpty()) {
			test=l;
		}
		return test;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public String update() {
		System.out.println("in update");
		System.out.println(test);
		test.get(1).setSelected(false);
		return "true";
	}
	
	
	@GetMapping("/getJsp")
	public String getJSP() {
		System.out.println("in get JSP...");
		return "page1";
	}
	
	class Test{
		private String data;
		private String tooltip;
		private boolean selected;
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getTooltip() {
			return tooltip;
		}
		public void setTooltip(String tooltip) {
			this.tooltip = tooltip;
		}
		public boolean isSelected() {
			return selected;
		}
		public void setSelected(boolean selected) {
			this.selected = selected;
		}
	}
}
