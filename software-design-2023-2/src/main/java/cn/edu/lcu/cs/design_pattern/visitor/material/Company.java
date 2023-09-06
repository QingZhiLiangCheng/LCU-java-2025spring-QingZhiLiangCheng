package cn.edu.lcu.cs.design_pattern.visitor.material;

//抽象访问者:公司
interface Company {
    String create(Paper element);

    String create(Cuprum element);
}
