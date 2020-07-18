package spring.boot.webApp.Spring.Boot.Web.Application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.webApp.Spring.Boot.Web.Application.model.User;
import spring.boot.webApp.Spring.Boot.Web.Application.model.UserList;
import spring.boot.webApp.Spring.Boot.Web.Application.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/loadData")
	public List<User> loadData() throws JSONException {
		System.out.println("here in loadData next... page...");
	    List<User> list = new ArrayList<>();
	    list = userRepository.findAll();
	    return list;
	}
	
	@GetMapping("/getUser1")
	public User getUser() {
		System.out.println("here in getUser..");
	    User u = new User();
	    	u.setId(1);
	    	u.setFirstName("Rummy");
	    	u.setLastName("Yara");
	    	u.setPhone("8985644485");
	    	u.setAddress("apg");
	    return u;
	}
	
	@PostMapping("/submitUser")
	public String submitUser(@ModelAttribute("usersList") UserList ul,HttpSession session) {
		System.out.println("in submit...");
		System.out.println(session.getAttribute("usersList"));
		List<User> l = ul.getUsers();
		for(User u: l) {
			System.out.println(u.toString());
			userRepository.save(u);
		}
		return "successfull..";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "success";
	}
	
	@GetMapping("/retrieveData")
	public List<Test> getData(@RequestBody Map map) {
		System.out.println(map);
		System.out.println(map.get("fromDate"));
		List<Test> l = new ArrayList<>();
		for(int i=0; i<3; i++) {
			Test t1 = new Test();
			t1.setData("test"+i);
			t1.setTooltip("tooltip"+i);
			l.add(t1);
		}
		return l;
	}
	
	class Test{
		private String data;
		private String tooltip;
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
	}
}
