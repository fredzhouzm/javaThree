package com.javaThree.web.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fred on 2015/4/23.
 */
@Scope("singleton")
@Controller
@RequestMapping({"/income/"})
public class IncomeManagement {
    public IncomeManagement() {
    }

    @RequestMapping({"/create.htm"})
    public String incomeCreateBegin() {
        return "income/createIncome";
    }
}
