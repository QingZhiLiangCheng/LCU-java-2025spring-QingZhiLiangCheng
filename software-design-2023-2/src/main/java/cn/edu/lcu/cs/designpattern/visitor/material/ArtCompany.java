package cn.edu.lcu.cs.designpattern.visitor.material;

//具体访问者：艺术公司
class ArtCompany implements Company {
    public String create(Paper element) {
        return "讲学图";
    }

    public String create(Cuprum element) {
        return "朱熹铜像";
    }
}
