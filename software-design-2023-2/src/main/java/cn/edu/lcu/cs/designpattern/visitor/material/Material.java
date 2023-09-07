package cn.edu.lcu.cs.designpattern.visitor.material;

//抽象元素：材料
interface Material {
    String accept(Company visitor);
}
