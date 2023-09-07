package cn.edu.lcu.cs.designpattern.adapter.signin;

public class PassportForThirdAdapter extends SignInService implements PassportForThird {
    @Override
    public ResultMsg loginForTel(String telephone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForRegister(String userName, String passWord) {
        super.register(userName, passWord);
        return super.login(userName, passWord);
    }

    //这里使用简单工厂及策略模式
    private ResultMsg procssLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(key, adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
