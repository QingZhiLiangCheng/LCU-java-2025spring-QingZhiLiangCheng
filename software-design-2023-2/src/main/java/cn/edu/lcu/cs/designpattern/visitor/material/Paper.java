package cn.edu.lcu.cs.designpattern.visitor.material;

//具体元素：纸
class Paper implements Material {
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}
