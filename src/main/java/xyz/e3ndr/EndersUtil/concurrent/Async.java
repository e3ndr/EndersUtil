/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * The Class Async.
 */
public abstract class Async<T> {
    
    /**
     * Waits for the thread to complete and then returns the value.
     *
     * @return the value
     */
    public abstract T await();

    /**
     * Creates a new Async, which will return null on completion.
     *
     * @param runnable the runnable to wrap
     * @return a new {@link AsyncRunnable}
     */
    public static Async<?> async(Runnable runnable) {
        return new AsyncRunnable<>(runnable);
    }
    
    /**
     * Creates a new async, which will return the value from the callable on completion.
     *
     * @param callable the callable to wrap
     * @return a new {@link AsyncCallable}
     */
    public static <T> Async<T> async(Callable<T> callable) {
        return new AsyncCallable<T>(callable);
    }

    /**
     * Awaits the completion of a future
     *
     * @param future the future
     * @return the value
     */
    @SneakyThrows
    public static <T> T await(Future<T> future) {
        return future.get();
    }

    /**
     * A convience method for {@link Async#await}
     * <br/><br/>
     * Waits for the thread to complete and then returns the value.
     *
     * @return the value
     */
    public static <T> T await(Async<T> async) {
        return async.await();
    }

    /**
     * Sleep.
     *
     * @param unit the unit
     * @param time the amount of time
     */
    @SneakyThrows
    public static void sleep(TimeUnit unit, long time) {
        Thread.sleep(unit.toMillis(time));
    }

    /**
     * Sleep.
     *
     * @param millis the amount of millis to sleep for
     */
    @SneakyThrows
    public static void sleep(long millis) {
        Thread.sleep(millis);
    }
    
}
