package com.soft.social.login.model;

import java.io.Serializable;
import java.sql.Date;

public class UserEtity implements Serializable {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 用户手机号
     */
    private String telephoneNum;

    /**
     * 用户创建时间
     */
    private String createTime;

    /**
     * 验证码
     */
    private String verifyCode;

    /**
     * 使用机型
     */
    private String phoneType;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 用户名
     */
    private String userName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
