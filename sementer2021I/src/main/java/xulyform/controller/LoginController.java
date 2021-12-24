package xulyform.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xulyform.dao.UserDAO;
import xulyform.model.user;

@Controller(value = "logincontroller")
public class LoginController {
	
	UserDAO ud;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("u", new user());
		return mav;
	}
	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("u") user user) throws SQLException {
		ModelAndView mav;
	    ud = new UserDAO();
	    if(ud.CheckLogin(user)) {
	    	mav = new ModelAndView("home");
	    	mav.addObject("mes","login success");
	    }
	    else {	    	
	    	mav = new ModelAndView("login"); 
	    	mav.addObject("mes","login fail");
	    	mav.addObject("u",user);
	    }
	    return mav;
	}
	
}
