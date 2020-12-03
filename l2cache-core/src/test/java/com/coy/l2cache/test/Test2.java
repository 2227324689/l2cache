package com.coy.l2cache.test;

import com.coy.l2cache.util.RunnableWarpper;
import com.coy.l2cache.util.ThreadPoolSupport;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenck
 * @date 2020/12/3 23:45
 */
public class Test2 {

    private static final ThreadPoolExecutor poolExecutor = ThreadPoolSupport.getPool("publish_redis_msg");

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            poolExecutor.execute(new RunnableWarpper(() -> {
                System.out.println("publish message  " + finalI);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "publish message  " + finalI));
        }
        while (true) {

        }
    }
}
