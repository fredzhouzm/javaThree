package com.javaThree.service;

import com.javaThree.web.domain.LevelOneProject;
import com.javaThree.web.domain.LevelTwoProject;
import com.javaThree.web.domain.SelectGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Fred on 2015/5/18.
 */
@Scope("singleton")
@Service
public class AccountingService {

    protected static Logger logger = LoggerFactory.getLogger("com.javaThree.service.AccountingService");
    @Autowired
    SettingsService settingsService;

    //获取用户的分类设置以供添加收入、支出单据使用
    public List<SelectGroup> getSelectGroup(int userId,String type){
        logger.info("Recieved request to redirectLogin.htm");
        List<SelectGroup> selectGroupLinkedList = new LinkedList<SelectGroup>();
        LinkedHashMap<String, LevelOneProject> formMap;
        if("0".equals(type)) {
            formMap = settingsService.getIncomeSettings(userId);
        }
        else {
            formMap = settingsService.getExpendSettings(userId);
        }
        Iterator iterator = formMap.entrySet().iterator();
        while(iterator.hasNext()){
            SelectGroup selectGroup = new SelectGroup();
            Map.Entry entry = (Map.Entry)iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            selectGroup.setProId(key.toString());
            LevelOneProject levelOneProject = (LevelOneProject)value;
            selectGroup.setName(levelOneProject.getProjectName());
            LinkedHashMap<String,String> mapTwo = new LinkedHashMap<String, String>();
            List<LevelTwoProject> levelTwoProjectList = levelOneProject.getLevelTwoProjectList();
            for(LevelTwoProject levelTwoProject:levelTwoProjectList){
                mapTwo.put(levelTwoProject.getProjectID(),levelTwoProject.getProjectName());
            }
            selectGroup.setSelectGroupMap(mapTwo);
            selectGroupLinkedList.add(selectGroup);
        }
        return selectGroupLinkedList;
    }

}
