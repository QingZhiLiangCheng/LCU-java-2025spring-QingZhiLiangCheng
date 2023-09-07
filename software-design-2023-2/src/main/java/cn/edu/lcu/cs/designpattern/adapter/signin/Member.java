package cn.edu.lcu.cs.designpattern.adapter.signin;

import lombok.Data;

@Data
public class Member {
    private String userName;
    private String passWord;
    private String mid;
    private String info;
}