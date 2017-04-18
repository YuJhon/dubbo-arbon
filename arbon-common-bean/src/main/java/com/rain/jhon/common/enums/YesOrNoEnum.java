package com.rain.jhon.common.enums;

/**
 * <p>功能描述</br> 是否的枚举</p>
 * @className  YesOrNoEnum
 * @author  jiangyu
 * @date  2016年8月11日 下午2:54:39
 * @version  v1.0
 */
public enum YesOrNoEnum {
    NO(0, "NO"),YES(1, "YES");

    private Integer value;

    private String text;

    private YesOrNoEnum(Integer value, String text)
    {
        this.value = value;
        this.text = text;
    }

    public Integer getValue()
    {
        return value;
    }

    public String getText()
    {
        return text;
    }

}
