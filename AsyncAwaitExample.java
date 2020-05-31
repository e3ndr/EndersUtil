package xyz.e3ndr.EndersUtil.test;

import static xyz.e3ndr.EndersUtil.concurrent.Async.async;
import static xyz.e3ndr.EndersUtil.concurrent.Async.await;
import static xyz.e3ndr.EndersUtil.concurrent.Async.sleep;

import java.util.concurrent.TimeUnit;

import xyz.e3ndr.EndersUtil.concurrent.Async;

public class Example {

    public static void main(String[] args) {
        Async<Long> time = async(() -> {
            sleep(TimeUnit.SECONDS, 2);
            return System.currentTimeMillis();
        });

        long start = System.currentTimeMillis();
        long finish = await(time);
        
        System.out.println(String.format("%d - %d = %d", finish, start, (finish - start)));
    }

}
