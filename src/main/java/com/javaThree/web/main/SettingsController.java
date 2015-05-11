package com.javaThree.web.main;

import com.javaThree.mybatis.model.PfmsUser;
import com.javaThree.service.CommonService;
import com.javaThree.service.SettingsService;
import com.javaThree.tool.PersonalUtils;
import com.javaThree.web.domain.LevelOneProject;
import com.javaThree.web.domain.LevelTwoProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fred on 2015/5/1.
 */
@Scope("singleton")
@Controller
@RequestMapping("/main/")
public class SettingsController {

    protected static final Logger logger = LoggerFactory.getLogger("com.javaThree.web.main.SettingsController");
    @Autowired
    SettingsService settingsService;
    @Autowired
    CommonService commonService;
    @Autowired
    PersonalUtils personalUtils;

    public SettingsController(){
    }

    @RequestMapping(value = "/settings.htm")
    public ModelAndView beginOperation( HttpSession session){
        logger.info("Recieved request to redirectLogin.htm");

        //获取当前用户
        PfmsUser pfmsUser = commonService.getSessionUser(session);
        ModelAndView mav = new ModelAndView();
        if(pfmsUser == null){
            mav.setViewName("redirect:/login");

        }
        int userId = pfmsUser.getId();

        //获取收入选项的菜单设置
        HashMap<String,LevelOneProject> incomeNode = settingsService.getIncomeSettings(userId);
        mav.addObject("incomeNode", incomeNode);

        //获取支出选项的菜单设置
        HashMap<String,LevelTwoProject> expendNode = settingsService.getExpendSettings(userId);
        mav.addObject("expendNode",expendNode);

        //获取系统设置

        //获取个人信息设置

        //返回ModelAndView
        mav.setViewName("settings");
        return mav;
    }

    @RequestMapping(value="/addProTwo.json")
    @ResponseBody
    public Map addProTwo(@RequestBody Map map,HttpSession session){
        logger.info("Recieved request to addProTwo.json | this is a Ajax Request!");

        //解析JSON
        String proOneId = (String)map.get("proOneId");
        proOneId=proOneId.trim();
        String proTwoNameAdd = (String)map.get("proTwoNameAdd");
        proTwoNameAdd=proTwoNameAdd.trim();
        Map jsonMap = new HashMap();
        if(personalUtils.isBlankOrNull(proTwoNameAdd) || personalUtils.isBlankOrNull(proOneId)){
            jsonMap.put("opstatus","fail");
            jsonMap.put("optype","");
            jsonMap.put("opid","");
            jsonMap.put("parentId","");
            jsonMap.put("opname","");
            jsonMap.put("amount", "");
        }
        else {
            //根据传回的一级菜单ID获取一级菜单信息
            LevelOneProject levelOneProject = settingsService.getLevelOneProject(proOneId);
            if (levelOneProject == null) {
                jsonMap.put("opstatus", "fail");
                jsonMap.put("optype", "");
                jsonMap.put("opid", "");
                jsonMap.put("parentId", "");
                jsonMap.put("opname", "");
                jsonMap.put("amount", "");
            } else {
                //根据获取的信息新增二级菜单
                LevelTwoProject levelTwoProject = settingsService.insertLevelTwoProject(levelOneProject, proTwoNameAdd, commonService.getSessionUser(session).getId());

                //返回成功的JSON
                jsonMap.put("opstatus", "success");
                jsonMap.put("optype", levelTwoProject.getProjectType());
                jsonMap.put("opid", levelTwoProject.getProjectID());
                jsonMap.put("parentId", levelTwoProject.getProjectFatherID());
                jsonMap.put("opname", levelTwoProject.getProjectName());
                jsonMap.put("amount", levelTwoProject.getProjectAmount());
            }
        }
        return jsonMap;
    }

    @RequestMapping(value="/addProOne.json",method= RequestMethod.POST)
    @ResponseBody
    public Map addProOne(@RequestBody Map map,HttpSession session) {
        logger.info("Recieved request to addProOne.json | this is a Ajax Request!");

        //解析JSON
        String proOneNameAdd = (String)map.get("proOneNameAdd");
        proOneNameAdd=proOneNameAdd.trim();
        String proOneType = (String)map.get("proOneType");
        proOneType=proOneType.trim();
        Map jsonMap = new HashMap();
        if(personalUtils.isBlankOrNull(proOneNameAdd) || personalUtils.isBlankOrNull(proOneType)){
            jsonMap.put("opstatus","fail");
            jsonMap.put("optype", "");
            jsonMap.put("opid","");
            jsonMap.put("opname","");
            jsonMap.put("amount", "");
        }
        else{
            LevelOneProject levelOneProject = settingsService.insertLevelOneProject(proOneNameAdd, proOneType, commonService.getSessionUser(session).getId());
            if (levelOneProject == null){
                jsonMap.put("opstatus","fail");
                jsonMap.put("optype", "");
                jsonMap.put("opid","");
                jsonMap.put("opname","");
                jsonMap.put("amount", "");
            }
            else{
                jsonMap.put("opstatus","success");
                jsonMap.put("optype", levelOneProject.getProjectType());
                jsonMap.put("opid",levelOneProject.getProjectID());
                jsonMap.put("opname",levelOneProject.getProjectName());
                jsonMap.put("amount", levelOneProject.getProjectAmount());
            }
        }

        return jsonMap;
    }

    @RequestMapping(value = "/modifyPro.json",method = RequestMethod.POST)
    @ResponseBody
    public Map modifyPro(@RequestBody Map map){
        logger.info("Recieved request to modifyPro.json | this is a Ajax Request!");

        String proId = (String)map.get("proId");
        proId = proId.trim();
        String proLevel = (String)map.get("proLevel");
        proLevel = proLevel.trim();
        String proNameModify = (String)map.get("proNameModify");
        proNameModify = proNameModify.trim();
        Map jsonMap = new HashMap();

        if(personalUtils.isBlankOrNull(proId) || personalUtils.isBlankOrNull(proLevel) || personalUtils.isBlankOrNull(proNameModify)){
            jsonMap.put("opstatus","fail");
            jsonMap.put("optype", "");
            jsonMap.put("opid","");
            jsonMap.put("opname","");
            jsonMap.put("oplevel", "");
        }
        else{
            String rtn = settingsService.modifyProName(proId, proLevel, proNameModify);
            if(rtn != null) {
                jsonMap.put("opstatus", "success");
                jsonMap.put("optype", rtn);
                jsonMap.put("opid", proId);
                jsonMap.put("opname", proNameModify);
                jsonMap.put("oplevel", proLevel);
            }
            else{
                jsonMap.put("opstatus", "fail");
                jsonMap.put("optype", "");
                jsonMap.put("opid", "");
                jsonMap.put("opname", "");
                jsonMap.put("oplevel", "");
            }
        }
        return jsonMap;
    }

    @RequestMapping(value = "/deletePro.json",method = RequestMethod.POST)
    @ResponseBody
    public Map deletePro(@RequestBody Map map){
        logger.info("Recieved request to modifyPro.json | this is a Ajax Request!");

        String id = (String)map.get("id");
        id = id.trim();
        String level = (String)map.get("level");
        level = level.trim();
        Map jsonMap = new HashMap();

        if(personalUtils.isBlankOrNull(id) || personalUtils.isBlankOrNull(level)){
            jsonMap.put("opstatus", "fail");
            jsonMap.put("optype", "");
            jsonMap.put("opid", "");
            jsonMap.put("oplevel", "");
        }
        else{
            String type = null;
            if("1".equalsIgnoreCase(level)){
                type = settingsService.getLevelOneProject(id).getProjectType();
            }
            else if("2".equalsIgnoreCase(level)){
                type = settingsService.getLevelTwoProject(id).getProjectType();
            }
            settingsService.deleteProject(id,level);
            jsonMap.put("opstatus", "success");
            jsonMap.put("optype", type);
            jsonMap.put("opid", id);
            jsonMap.put("oplevel", level);
        }
        return jsonMap;

    }

    public SettingsService getSettingsService() {
        return settingsService;
    }

    public void setSettingsService(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }
}
