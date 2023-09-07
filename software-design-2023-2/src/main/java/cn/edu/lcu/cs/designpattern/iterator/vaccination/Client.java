package cn.edu.lcu.cs.designpattern.iterator.vaccination;

/**
 * @Description 疫苗接种迭代器模式演示代码
 * @Author Ling
 * @Date 2021/9/30 0:16
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 迭代数据的消费者
        Nurse nurse = new Nurse();

        // 初始化容器
        Container container = new Container();
        container.add(new Person("zhangsan"));
        container.add(new Person("lisi"));
        container.add(new Person("wangwu"));

        // 获取容器的迭代器对象
        Iterator iterator = container.iterator();
        // 当还有未迭代对象时，循环迭代
        while (iterator.hasNext()) {
            // 获取下个未迭代的对象
            Person person = iterator.next();
            // 消费这个对象，进行疫苗接种
            nurse.inoculate(person);
        }
    }
}
