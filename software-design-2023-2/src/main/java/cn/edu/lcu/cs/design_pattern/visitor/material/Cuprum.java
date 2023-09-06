package cn.edu.lcu.cs.design_pattern.visitor.material;

//具体元素：铜
class Cuprum implements Material {
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}
