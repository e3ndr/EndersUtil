/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.concurrent;

import java.util.concurrent.Callable;

import lombok.SneakyThrows;

public class AsyncCallable<T> extends Async<T> {
    private boolean set = false;
    private Exception exception;
    private T value;

    public AsyncCallable(Callable<T> callable) {
        new Thread(() -> {
            try {
                this.value = callable.call();
                this.set = true;
            } catch (Exception e) {
                this.exception = e;
            }

            synchronized (this) {
                this.notifyAll();
            }
        }).start();
    }

    @SneakyThrows
    @Override
    public synchronized T await() {
        if (!this.set) {
            this.wait();
        }

        if (this.exception != null) {
            throw this.exception;
        }

        return this.value;
    }

}
