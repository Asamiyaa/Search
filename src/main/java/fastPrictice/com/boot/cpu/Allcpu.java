package com.boot.cpu;

import java.util.ArrayList;
import java.util.List;

public class Allcpu {

    public static void main(String[] args) {

//        Integer[] i = new Integer[]{1,2,3};
        List i = new ArrayList<Integer>();

        /**
         * 死循环将不释放资源，导致下面的的线程不会执行
         */
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i.add(1);
                System.out.println("1 is add");
            }
        }).start();
        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i.remove(i.size() -1);
                System.out.println("1 delete");
            }
        }).start();

        System.out.println("=====");

    }
}

