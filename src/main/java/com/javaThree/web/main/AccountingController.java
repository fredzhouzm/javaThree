package com.javaThree.web.main;

import com.javaThree.mybatis.model.PfmsUser;
import com.javaThree.service.AccountingService;
import com.javaThree.service.CommonService;
import com.javaThree.service.Constants;
import com.javaThree.web.domain.SelectGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fred on 2015/5/18.
 */
@Scope("singleton")
@Controller
@RequestMapping("/main/")
public class AccountingController {

    protected static final Logger logger = LoggerFactory.getLogger("com.javaThree.web.main.AccountingController");
    @Autowired
    AccountingService accountingService;
    @Autowired
    CommonService commonService;

    @RequestMapping(value = "/accounting.htm")
    public ModelAndView accounting(HttpSession httpSession){
        logger.info("Recieved request to accounting.htm");
        //获取当前用户
        PfmsUser pfmsUser = commonService.getSessionUser(httpSession);
        ModelAndView mav = new ModelAndView();
        List<SelectGroup> selectGroupIncomeList = accountingService.getSelectGroup(pfmsUser.getId(), Constants.BY_SELECT_INCOME_TYPE);
        List<SelectGroup> selectGroupExpendList = accountingService.getSelectGroup(pfmsUser.getId(), Constants.BY_SELECT_EXPEND_TYPE);
        mav.addObject("incomeSelectGroups",selectGroupIncomeList);
        mav.addObject("expendSelectGroups",selectGroupExpendList);
        mav.setViewName("form");
        return mav;
    }
}
