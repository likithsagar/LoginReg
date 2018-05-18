package com.chipwaretechnologies.loginreg;

import com.google.gson.annotations.SerializedName;

/**
 * Created by likit on 5/8/2018.
 */

public class User {


    private String username_reg;


    private String password_reg;


    private String access_id_reg;


    private String security_question_reg;


    private String answer_reg;



    public String getUsername_reg() {
        return username_reg;
    }

    public void setUsername_reg(String username_reg) {
        this.username_reg = username_reg;
    }

    public String getPassword_reg() {
        return password_reg;
    }

    public void setPassword_reg(String password_reg) {
        this.password_reg = password_reg;
    }

    public String getAccess_id_reg() {
        return access_id_reg;
    }

    public void setAccess_id_reg(String access_id_reg) {
        this.access_id_reg = access_id_reg;
    }

    public String getSecurity_question_reg() {
        return security_question_reg;
    }

    public void setSecurity_question_reg(String security_question_reg) {
        this.security_question_reg = security_question_reg;
    }

    public String getAnswer_reg() {
        return answer_reg;
    }

    public void setAnswer_reg(String answer_reg) {
        this.answer_reg = answer_reg;
    }
    @SerializedName("date")
    private String date;

    @SerializedName("project_name")
    private String project_name;

    @SerializedName("time_started")
    private String time_started;

    @SerializedName("time_stopped")
    private String time_stopped;

    @SerializedName("time_duration")
    private String time_duration;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getTime_started() {
        return time_started;
    }

    public void setTime_started(String time_started) {
        this.time_started = time_started;
    }

    public String getTime_stopped() {
        return time_stopped;
    }

    public void setTime_stopped(String time_stopped) {
        this.time_stopped = time_stopped;
    }

    public String getTime_duration() {
        return time_duration;
    }

    public void setTime_duration(String time_duration) {
        this.time_duration = time_duration;
    }
}
