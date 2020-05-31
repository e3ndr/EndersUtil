/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.concurrent;

import java.util.concurrent.Callable;

import lombok.SneakyThrows;

public class AsyncCallable<T> extends Async<T> {
    private boolean set = false;
    private T value;

    public AsyncCallable(Callable<T> callable) {
        new Thread(() -> this.run(callable)).start();
    }

    @SneakyThrows
    private void run(Callable<T> callable) {
        this.value = callable.call();
        this.set = true;

        synchronized (this) {
            this.notifyAll();
        }
    }

    @SneakyThrows
    @Override
    public synchronized T await() {
        if (!this.set) this.wait();

        return this.value;
    }

}
