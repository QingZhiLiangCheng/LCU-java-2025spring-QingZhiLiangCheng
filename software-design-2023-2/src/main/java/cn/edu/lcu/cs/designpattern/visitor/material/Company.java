package cn.edu.lcu.cs.designpattern.visitor.material;

//抽象访问者:公司
interface Company {
    String create(Paper element);

    String create(Cuprum element);
}
