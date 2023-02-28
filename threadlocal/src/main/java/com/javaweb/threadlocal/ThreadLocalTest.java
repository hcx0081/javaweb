package com.javaweb.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * {@code @Description:}
 */
public class ThreadLocalTest {
    public static Map<String, Object> data = new HashMap<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    
    private static Random random = new Random();
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
    
    public static class Task implements Runnable {
        
        @Override
        public void run() {
            // 在run方法中，随机生成一个变量（线程要关联的数据〉，然后以当前线程名为key保存到map中
            int i = random.nextInt(1000);// 0~999中的整数
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]" + "生成的随机数是：" + i);
            // data.put(name, i);
            threadLocal.set(i);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            new OrderService().createOrder();
            
            
            // 在run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            // Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程[" + name + "]快结束时取出关联的数据是：" + o);
            
        }
    }
    
}