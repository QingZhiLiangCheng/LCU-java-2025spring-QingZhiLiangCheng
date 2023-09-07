package cn.edu.lcu.cs.designpattern.adapter.signin;

/**
 * 第三方登录兼容接口
 */
public interface PassportForThird {
    ResultMsg loginForTel(String telephone, String code);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForRegister(String userName, String passWord);
}