package cn.edu.lcu.cs.designpattern.iterator.vaccination;

/**
 * @Description 护士，专职打疫苗
 * @Author Ling
 * @Date 2021/9/29 23:53
 * @Version 1.0
 */
public class Nurse {
    /**
     * 给人接种疫苗
     *
     * @param person
     */
    public void inoculate(Person person) {
        person.setVaccinated(true);
        System.out.println(person.getName() + "接种了疫苗");
    }
}
