package com.li.pc.lutils.bean;

/**
 * author   ：mo
 * data     ：2016/12/21
 * time     ：14:25
 * function :
 */

public class Test extends PinYinBean {
    private String name;

    public Test(String name , String pinyin) {
        this.name = name;
        setPinyin(pinyin);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
