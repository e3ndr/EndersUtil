package xyz.e3ndr.endersutil.test;

import static xyz.e3ndr.endersutil.concurrent.Async.async;
import static xyz.e3ndr.endersutil.concurrent.Async.await;
import static xyz.e3ndr.endersutil.concurrent.Async.sleep;

import java.util.concurrent.TimeUnit;

import xyz.e3ndr.endersutil.concurrent.Async;

public class Example {

    public static void main(String[] args) {
        Async<Long> time = async(() -> {
            sleep(TimeUnit.SECONDS, 2);
            return System.currentTimeMillis();
        });

        // This will basically return the start time + 2000 milliseconds.
        // Not a very practical example, but it's for demonstration purposes.
        long start = System.currentTimeMillis();
        long finish = await(time);

        System.out.println(String.format("%d - %d = %d", finish, start, (finish - start)));
    }

}
