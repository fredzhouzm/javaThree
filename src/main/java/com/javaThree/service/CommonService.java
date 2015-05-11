package com.javaThree.service;

import com.javaThree.mybatis.dao.PfmsUserMapper;
import com.javaThree.mybatis.model.PfmsUser;
import com.javaThree.mybatis.model.PfmsUserExample;
import com.javaThree.web.domain.RegisterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Fred on 2015/4/23.
 */
@Scope("singleton")
@Service
public class CommonService {

    protected static Logger logger = LoggerFactory.getLogger("com.javaThree.service.CommonService");

    private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    PfmsUserMapper pfmsUserMapper;

    public CommonService() {
    }

    public boolean birthdateCheck(String birthdate) {
        logger.info("Begin the method of birthdateCheck");
        Date birthdateDB = null;

        try {
            birthdateDB = this.fmt.parse(birthdate);
        } catch (ParseException var4) {
            return false;
        }

        return !birthdateDB.after(new Date());
    }

    public boolean checkUserNameIsExist(String userName) {
        logger.info("Begin the method of checkUserNameIsExist");
        PfmsUserExample pue = new PfmsUserExample();
        pue.createCriteria().andLoginNameEqualTo(userName);
        List pu = this.pfmsUserMapper.selectByExample(pue);
        return pu.isEmpty();
    }

    public PfmsUser getUserByLoginName(String userName) {
        logger.info("Begin the method of getUserByLoginName");
        PfmsUserExample pue = new PfmsUserExample();
        pue.createCriteria().andLoginNameEqualTo(userName);
        List pu = this.pfmsUserMapper.selectByExample(pue);
        return !pu.isEmpty() && pu.size() == 1?(PfmsUser)pu.get(0):null;
    }

    public void registeruserToPfmsAcc(PfmsUser pfmsUser, RegisterUser user) {
        logger.info("Begin the method of registeruserToPfmsAcc");
        pfmsUser.setLoginName(user.getLoginName());
        pfmsUser.setPassword(user.getPassword());
        pfmsUser.setName(user.getNickName());
        pfmsUser.setGender(user.getGender());
        pfmsUser.setBirthDate(user.getBirthdateDB());
        if(user.getEmail() != null && user.getEmail().length() > 0) {
            pfmsUser.setMailAddress(user.getEmail());
        }

        pfmsUser.setTimestamp(new Date(System.currentTimeMillis()));
        pfmsUser.setFirstLogin("1");
        pfmsUser.setUserType("1");
    }

    @Transactional
    public void insertPfmsUser(PfmsUser pfmsUser) {
        logger.info("Begin the method of insertPfmsUser");
        this.pfmsUserMapper.insert(pfmsUser);
    }

    public PfmsUser getSessionUser(HttpSession httpSession){
        logger.info("Begin the method of getSessionUser");
        PfmsUser pfmsUser = null;
        pfmsUser = (PfmsUser)httpSession.getAttribute("session_user");
        return pfmsUser;
    }
}
