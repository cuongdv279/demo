package com.projecttlc.controller;

import java.util.regex.Pattern;

/**
 * Created by CHIP_IT_DVC on 06/04/2016.
 */
public class temp {

    public boolean isNumeric(String s) {
        Pattern p = Pattern.compile("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
        if (p.matcher(s).matches()) {
            return true;
        }
        return false;
    }
    public  static void main(String args[]){
        temp s = new temp();
        System.out.println(s.isNumeric("1"));
    }
}
