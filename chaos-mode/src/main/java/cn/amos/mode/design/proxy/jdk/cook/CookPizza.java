package cn.amos.mode.design.proxy.jdk.cook;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class CookPizza implements Cook {

    @Override
    public String production() {
        return "Pizza";
    }
}
