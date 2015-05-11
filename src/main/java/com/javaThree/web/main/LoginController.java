package com.javaThree.web.main;

import com.javaThree.mybatis.model.PfmsUser;
import com.javaThree.service.CommonService;
import com.javaThree.web.domain.RegisterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;

/**
 * Created by Fred on 2015/4/23.
 */
@Scope("singleton")
@Controller
@RequestMapping({"/main/"})
public class LoginController {

    protected static Logger logger = LoggerFactory.getLogger("com.javaThree.web.main.LoginController");
    @Autowired
    public CommonService commonService;

    public LoginController() {
    }

    @RequestMapping({"/redirectLogin.htm"})
    public ModelAndView loginRedirect() {
        logger.info("Recieved request to redirectLogin.htm");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("user", new RegisterUser());
        return mav;
    }

    @RequestMapping({"/login.htm"})
    public ModelAndView loginCheck(@ModelAttribute("user") RegisterUser user, BindingResult bindingResult, HttpSession session) {
        logger.info("Recieved request to login.htm");
        logger.info("user to string:"+user.toString());
        ModelAndView mav = new ModelAndView();
        String loginName = user.getLoginName().trim();
        String loginPwd = user.getPassword().trim();
        if(this.commonService.checkUserNameIsExist(loginName)) {
            bindingResult.rejectValue("loginName", "error.notExist.loginName");
            mav.setViewName("login");
            mav.addObject(user);
            return mav;
        } else {
            PfmsUser pfmsUser = this.commonService.getUserByLoginName(loginName);
            if(!pfmsUser.getPassword().equals(loginPwd)) {
                bindingResult.rejectValue("password", "error.incorrect.loginPwd");
                mav.setViewName("login");
                mav.addObject(user);
                return mav;
            } else {
                session.setAttribute("session_user", pfmsUser);
                mav.setViewName("welcome");
                mav.addObject("loginName", loginName);
                return mav;
            }
        }
    }

    @RequestMapping({"/register.htm"})
    public ModelAndView registerOp() {
        logger.info("Recieved request to register.htm");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("user", new RegisterUser());
        return mav;
    }

    @RequestMapping({"/registerCheck.htm"})
    public ModelAndView registerChk(@Valid @ModelAttribute("user") RegisterUser user, BindingResult bindingResult) throws ParseException {
        logger.info("Recieved request to registerCheck.htm");
        logger.info("user to string:"+user.toString());
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()) {
            mav.setViewName("register");
            mav.addObject("user", user);
            return mav;
        } else if(!this.commonService.checkUserNameIsExist(user.getLoginName())) {
            bindingResult.rejectValue("accName", "error.exist.loginName");
            mav.setViewName("register");
            mav.addObject("user", user);
            return mav;
        } else if(!this.commonService.birthdateCheck(user.getBirthdate())) {
            bindingResult.rejectValue("birthdate", "error.past.birthdate");
            mav.setViewName("register");
            mav.addObject("user", user);
            return mav;
        } else {
            PfmsUser pfmsUser = new PfmsUser();
            this.commonService.registeruserToPfmsAcc(pfmsUser, user);
            this.commonService.insertPfmsUser(pfmsUser);
            mav.setViewName("welcome");
            return mav;
        }
    }
}
