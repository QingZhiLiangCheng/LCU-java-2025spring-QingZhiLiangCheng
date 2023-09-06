package cn.edu.lcu.cs.design_pattern.visitor.material;

//具体访问者：造币公司
class Mint implements Company {
    public String create(Paper element) {
        return "纸币";
    }

    public String create(Cuprum element) {
        return "铜币";
    }
}
