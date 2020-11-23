package controllerDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import model.student;
import model.studentDao;

@Controller
public class ControllerDemo {
	
	private ApplicationContext conn;
	@RequestMapping("/home")
	public String view1()
	{
		return "home";
	}
	@RequestMapping("/register")
	public String view2(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		student stud = conn.getBean("info",student.class);
		m.addAttribute("bean",stud);
		return "register";
	}
	
	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean")student s, Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		studentDao obj = conn.getBean("dao",studentDao.class);
		obj.save(s);
		m.addAttribute("msg", "record insert successfully");
		return "register";
	}

}
