package cn.amos.design.prototype.demo3;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 * *** Date 默认实现了Cloneable接口类
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Person implements Cloneable {

    private Long id;
    private String name;
    private Work work;

    public void setUserInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setWorkInfo(Work work) {
        this.work = work;
    }

    public String display() {
        return "ID: " + this.id + ", NAME: " + this.name
                + "\nCOMPANY: " + this.work.getCompany() + ", JOIN DATE: " + this.work.getDate();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person personClone = (Person) super.clone();
        personClone.setWorkInfo((Work) work.clone());

        return super.clone();
    }
}