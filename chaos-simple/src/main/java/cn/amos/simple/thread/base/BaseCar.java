package cn.amos.simple.thread.base;

import java.util.Random;

public class BaseCar implements CarInterface {

    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
