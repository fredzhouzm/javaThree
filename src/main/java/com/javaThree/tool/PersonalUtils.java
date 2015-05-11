package com.javaThree.tool;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Fred on 2015/5/2.
 */
@Scope("singleton")
@Service
public class PersonalUtils {

    //�������ת����String��������
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public String intToString(int number,int index){
        String tmp = String.valueOf(number);
        if(tmp.getBytes().length >= index){
            return tmp;
        }
        else{
            for(int i=tmp.getBytes().length;i<index;i++){
                tmp = "0"+tmp;
            }
            return tmp;
        }
    }

    public String bigDecimalToString(BigDecimal bigDecimal){
        return decimalFormat.format(bigDecimal);
    }

    public Boolean isBlankOrNull(String string){
        if(string==null || "".equals(string) || string.length()<=0 || string.isEmpty() == true){
            return true;
        }
        else{
            return false;
        }
    }
}
