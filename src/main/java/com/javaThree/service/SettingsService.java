package com.javaThree.service;

import com.javaThree.mybatis.dao.PfmsUsageOneMapper;
import com.javaThree.mybatis.dao.PfmsUsageTwoMapper;
import com.javaThree.mybatis.dao.PfmsUserMapper;
import com.javaThree.mybatis.model.*;
import com.javaThree.web.domain.LevelOneProject;
import com.javaThree.web.domain.LevelTwoProject;
import com.javaThree.tool.PersonalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fred on 2015/5/1.
 */
@Scope("singleton")
@Service
public class SettingsService {

    protected static Logger logger = LoggerFactory.getLogger("com.javaThree.service.SettingsService");

    @Autowired
    PfmsUsageOneMapper pfmsUsageOneMapper;
    @Autowired
    PfmsUsageTwoMapper pfmsUsageTwoMapper;
    @Autowired
    PfmsUserMapper pfmsUserMapper;
    @Autowired
    PersonalUtils personalUtils;

    @Transactional
    public HashMap getIncomeSettings(int userId){
        logger.info("Begin the method of getIncomeSettings");

        HashMap<String,LevelOneProject> incomeNode = new HashMap<String, LevelOneProject>();
        PfmsUsageOneExample pfmsUsageOneExample = new PfmsUsageOneExample();

        pfmsUsageOneExample.createCriteria().andCreaterIdEqualTo(userId).andTypeEqualTo("0");
        pfmsUsageOneExample.setOrderByClause("CREATE_TIME");
        List<PfmsUsageOne> pfmsUsageOneList=pfmsUsageOneMapper.selectByExample(pfmsUsageOneExample);
        if (false == pfmsUsageOneList.isEmpty()){
            for(PfmsUsageOne pfmsUsageOne:pfmsUsageOneList){
                LevelOneProject levelOneProject = pfmsUsageOneToLevelOneProject(pfmsUsageOne);
                LinkedList<LevelTwoProject> levelTwoProjectList = getLevelTwoProjectList(userId, levelOneProject.getProjectID());
                levelOneProject.setLevelTwoProjectList(levelTwoProjectList);
                incomeNode.put(levelOneProject.getProjectID(), levelOneProject);
            }
        }

        return incomeNode;
    }

    @Transactional
    public HashMap getExpendSettings(int userId){
        logger.info("Begin the method of getIncomeSettings");

        HashMap<String,LevelOneProject> expendNode = new HashMap<String, LevelOneProject>();
        PfmsUsageOneExample pfmsUsageOneExample = new PfmsUsageOneExample();

        pfmsUsageOneExample.createCriteria().andCreaterIdEqualTo(userId).andTypeEqualTo("1");
        pfmsUsageOneExample.setOrderByClause("CREATE_TIME");
        List<PfmsUsageOne> pfmsUsageOneList = pfmsUsageOneMapper.selectByExample(pfmsUsageOneExample);
        if(false == pfmsUsageOneList.isEmpty()){
            for (PfmsUsageOne pfmsUsageOne:pfmsUsageOneList){
                LevelOneProject levelOneProject = pfmsUsageOneToLevelOneProject(pfmsUsageOne);
                LinkedList<LevelTwoProject> levelTwoProjectLinkedList = getLevelTwoProjectList(userId, levelOneProject.getProjectID());
                levelOneProject.setLevelTwoProjectList(levelTwoProjectLinkedList);
                expendNode.put(levelOneProject.getProjectID(),levelOneProject);
            }
        }

        return expendNode;
    }

    @Transactional
    public LinkedList getLevelTwoProjectList(int userId, String fatherId){
        logger.info("Begin the method of getLevelTwoProjectList");

        LinkedList<LevelTwoProject> levelTwoProjectList = new LinkedList<LevelTwoProject>();
        PfmsUsageTwoExample pfmsUsageTwoExample = new PfmsUsageTwoExample();

        pfmsUsageTwoExample.createCriteria().andCreaterIdEqualTo(userId).andFatherIdEqualTo(fatherId);
        List<PfmsUsageTwo> pfmsUsageTwoList=pfmsUsageTwoMapper.selectByExample(pfmsUsageTwoExample);
        if (false == pfmsUsageTwoList.isEmpty()){
            for(PfmsUsageTwo pfmsUsageTwo:pfmsUsageTwoList){
                LevelTwoProject levelTwoProject = pfmsUsageTwoToLevelTwoProject(pfmsUsageTwo);
                levelTwoProjectList.add(levelTwoProject);
            }
        }

        return levelTwoProjectList;
    }

    @Transactional
    public LevelOneProject getLevelOneProject(String proOneId){
        logger.info("Begin the method of getLevelOneProject");

        PfmsUsageOneExample pfmsUsageOneExample = new PfmsUsageOneExample();
        LevelOneProject levelOneProject = null;

        pfmsUsageOneExample.createCriteria().andIdEqualTo(proOneId);
        List<PfmsUsageOne> pfmsUsageOneList = pfmsUsageOneMapper.selectByExample(pfmsUsageOneExample);
        if (false == pfmsUsageOneList.isEmpty()){
            for(PfmsUsageOne pfmsUsageOne:pfmsUsageOneList){
                levelOneProject = pfmsUsageOneToLevelOneProject(pfmsUsageOne);
            }
        }
        return levelOneProject;
    }

    @Transactional
    public LevelOneProject insertLevelOneProject(String proOneNameAdd,String proOneType,int userId){
        logger.info("Begin the method of insertLevelOneProject");

        PfmsUsageOne pfmsUsageOne = new PfmsUsageOne();

        PfmsUser pfmsUser = pfmsUserMapper.selectByPrimaryKey(userId);
        int usage1Num = pfmsUser.getUsageNum();
        String suffixID = personalUtils.intToString(usage1Num, 5);
        //设置ID
        pfmsUsageOne.setId(String.valueOf(userId) + suffixID);
        //设置Type
        pfmsUsageOne.setType(proOneType.trim());
        //设置Name
        pfmsUsageOne.setName(proOneNameAdd.trim());
        //设置Amount
        pfmsUsageOne.setAmount(new BigDecimal(0.00));
        //设置Chileren
        pfmsUsageOne.setChildren(0);
        //设置CreatorId
        pfmsUsageOne.setCreaterId(userId);
        //设置CreateTime
        pfmsUsageOne.setCreateTime(new Date());
        //设置Descript
        pfmsUsageOne.setDescript("");
        int returnNum = pfmsUsageOneMapper.insert(pfmsUsageOne);
        if (returnNum == 1){
            updateUserInfo(userId,Constants.BY_USAGE_NUM,null);
            return pfmsUsageOneToLevelOneProject(pfmsUsageOne);
        }
        else{
            return null;
        }
    }

    @Transactional
    public void updateUserInfo(int userId,String type,Object param){
        logger.info("Begin the method of updateUserInfo");
        PfmsUser pfmsUser = pfmsUserMapper.selectByPrimaryKey(userId);
        if(type == Constants.BY_LOGIN_NAME){
            String loginName = param.toString().trim();
        }
        else if(type == Constants.BY_PASSWORD){

        }
        else if(type == Constants.BY_LOGIN_NAME){

        }
        else if(type == Constants.BY_NAME){

        }
        else if(type == Constants.BY_GENDER){

        }
        else if(type == Constants.BY_BIRTH_DATE){

        }
        else if(type == Constants.BY_MAIL_ADDRESS){

        }
        else if(type == Constants.BY_USAGE_NUM){
            pfmsUser.setUsageNum(pfmsUser.getUsageNum()+1);
            pfmsUserMapper.updateByPrimaryKey(pfmsUser);
        }
    }

    @Transactional
    public int updateLevelOneProject(String proOneId,String type,Object param){
        logger.info("Begin the method of updateLevelOneProject");

        PfmsUsageOneExample pfmsUsageOneExample = new PfmsUsageOneExample();

        pfmsUsageOneExample.createCriteria().andIdEqualTo(proOneId);
        List<PfmsUsageOne> pfmsUsageOneList = pfmsUsageOneMapper.selectByExample(pfmsUsageOneExample);
        if (false == pfmsUsageOneList.isEmpty()){
            PfmsUsageOne pfmsUsageOne = pfmsUsageOneList.get(0);
            if (type == Constants.BY_CHILDREN) {
                pfmsUsageOne.setChildren(pfmsUsageOne.getChildren() + 1);
            } else if (type == Constants.BY_AMOUNT) {
                BigDecimal amountTmp = pfmsUsageOne.getAmount();
                BigDecimal addAmount = (BigDecimal) param;
                pfmsUsageOne.setAmount(amountTmp.add(addAmount));
            } else if (type == Constants.BY_DESCRIPT) {
                String str = param.toString().trim();
                pfmsUsageOne.setDescript(str);
            } else if (type == Constants.BY_NAME) {
                String name = param.toString().trim();
                pfmsUsageOne.setName(name);
            }
            return pfmsUsageOneMapper.updateByPrimaryKey(pfmsUsageOne);
        }
        else {
            return 0;
        }
    }

    @Transactional
    public LevelTwoProject insertLevelTwoProject(LevelOneProject levelOneProject,String proTwoNameAdd,int userId){
        logger.info("Begin the method of insertLevelTwoProject");

        String parentId = levelOneProject.getProjectID();
        String parentType = levelOneProject.getProjectType();
        int parentChildren = levelOneProject.getProjectChildren();

        PfmsUsageTwo pfmsUsageTwo = new PfmsUsageTwo();
        pfmsUsageTwo.setId(parentId + personalUtils.intToString(parentChildren, 4));
        pfmsUsageTwo.setType(parentType);
        pfmsUsageTwo.setFatherId(parentId);
        pfmsUsageTwo.setName(proTwoNameAdd);
        pfmsUsageTwo.setAmount(new BigDecimal(0.00));
        pfmsUsageTwo.setCreaterId(userId);
        pfmsUsageTwo.setCreateTime(new Date());
        pfmsUsageTwo.setDescript("");
        pfmsUsageTwoMapper.insert(pfmsUsageTwo);
        updateLevelOneProject(pfmsUsageTwo.getFatherId(),Constants.BY_CHILDREN,null);

        return pfmsUsageTwoToLevelTwoProject(pfmsUsageTwo);
    }

    @Transactional
    public int updateLevelTwoProject(String proTwoId, String type, Object param){
        logger.info("Begin the method of updateLevelTwoProject");

        PfmsUsageTwoExample pfmsUsageTwoExample = new PfmsUsageTwoExample();
        pfmsUsageTwoExample.createCriteria().andIdEqualTo(proTwoId);
        List<PfmsUsageTwo> pfmsUsageTwoList = pfmsUsageTwoMapper.selectByExample(pfmsUsageTwoExample);
        if(false == pfmsUsageTwoList.isEmpty()){
            PfmsUsageTwo pfmsUsageTwo = pfmsUsageTwoList.get(0);
            if(type == Constants.BY_NAME){
                String name = param.toString().trim();
                pfmsUsageTwo.setName(name);
            }
            else if(type == Constants.BY_AMOUNT){
                BigDecimal amountTmp = pfmsUsageTwo.getAmount();
                BigDecimal addAmount = (BigDecimal)param;
                pfmsUsageTwo.setAmount(amountTmp.add(addAmount));
            }
            else if(type == Constants.BY_DESCRIPT){
                String str = param.toString().trim();
                pfmsUsageTwo.setDescript(str);
            }
            return pfmsUsageTwoMapper.updateByPrimaryKey(pfmsUsageTwo);
        }
        else{
            return 0;
        }
    }

    @Transactional
    public String modifyProName(String proId, String level, String name){
        logger.info("Begin the method of modifyProName");

        if("1".equalsIgnoreCase(level)){
            String type = getLevelOneProject(proId).getProjectType();
            int rtn = updateLevelOneProject(proId, Constants.BY_NAME, name);
            if(rtn==1) {
                return type;
            }
            else {
                return null;
            }
        }
        else{
            String type = getLevelTwoProject(proId).getProjectType();
            int rtn = updateLevelTwoProject(proId, Constants.BY_NAME,name);
            if(rtn==1){
                return type;
            }
            else{
                return null;
            }
        }
    }

    public LevelTwoProject getLevelTwoProject(String proTwoId){
        logger.info("Begin the method of LevelTwoProject");

        PfmsUsageTwoExample pfmsUsageTwoExample = new PfmsUsageTwoExample();
        LevelTwoProject levelTwoProject = null;

        pfmsUsageTwoExample.createCriteria().andIdEqualTo(proTwoId);
        List<PfmsUsageTwo> pfmsUsageTwoList = pfmsUsageTwoMapper.selectByExample(pfmsUsageTwoExample);
        if(false == pfmsUsageTwoList.isEmpty()){
            levelTwoProject  = pfmsUsageTwoToLevelTwoProject(pfmsUsageTwoList.get(0));
        }
        return levelTwoProject;
    }

    public LevelOneProject pfmsUsageOneToLevelOneProject(PfmsUsageOne pfmsUsageOne){
        logger.info("Begin the method of pfmsUsageOneToLevelOneProject");

        LevelOneProject levelOneProject = new LevelOneProject();

        levelOneProject.setProjectID(pfmsUsageOne.getId());
        levelOneProject.setProjectType(pfmsUsageOne.getType());
        levelOneProject.setProjectName(pfmsUsageOne.getName());
        levelOneProject.setProjectAmount(personalUtils.bigDecimalToString(pfmsUsageOne.getAmount()));
        levelOneProject.setProjectChildren(pfmsUsageOne.getChildren());

        return levelOneProject;
    }

    @Transactional
    public void deleteProject(String id, String level){
        logger.info("Begin the method of deleteProject");

        PfmsUsageOneExample pfmsUsageOneExample = new PfmsUsageOneExample();
        PfmsUsageTwoExample pfmsUsageTwoExample = new PfmsUsageTwoExample();
        if("1".equalsIgnoreCase(level)){
            pfmsUsageTwoExample.createCriteria().andFatherIdEqualTo(id);
            pfmsUsageOneExample.createCriteria().andIdEqualTo(id);
            pfmsUsageTwoMapper.deleteByExample(pfmsUsageTwoExample);
            pfmsUsageOneMapper.deleteByExample(pfmsUsageOneExample);
        }
        else{
            pfmsUsageTwoExample.createCriteria().andIdEqualTo(id);
            pfmsUsageTwoMapper.deleteByExample(pfmsUsageTwoExample);
        }
    }

    public LevelTwoProject pfmsUsageTwoToLevelTwoProject(PfmsUsageTwo pfmsUsageTwo){
        logger.info("Begin the method of pfmsUsageOneToLevelOneProject");

        LevelTwoProject levelTwoProject = new LevelTwoProject();

        levelTwoProject.setProjectID(pfmsUsageTwo.getId());
        levelTwoProject.setProjectType(pfmsUsageTwo.getType());
        levelTwoProject.setProjectFatherID(pfmsUsageTwo.getFatherId());
        levelTwoProject.setProjectName(pfmsUsageTwo.getName());
        levelTwoProject.setProjectAmount(personalUtils.bigDecimalToString(pfmsUsageTwo.getAmount()));

        return levelTwoProject;
    }

    public void setPfmsUsageOneMapper(PfmsUsageOneMapper pfmsUsageOneMapper) {
        this.pfmsUsageOneMapper = pfmsUsageOneMapper;
    }

    public void setPfmsUsageTwoMapper(PfmsUsageTwoMapper pfmsUsageTwoMapper) {
        this.pfmsUsageTwoMapper = pfmsUsageTwoMapper;
    }

    public void setPersonalUtils(PersonalUtils personalUtils) {
        this.personalUtils = personalUtils;
    }
}
