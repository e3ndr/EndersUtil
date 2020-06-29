/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.concurrent;

import lombok.SneakyThrows;

/**
 * An Async class which will return null on completion.
 */
public class AsyncRunnable<T> extends Async<T> {
    private boolean set = false;
    private Exception exception;

    public AsyncRunnable(Runnable runnable) {
        new Thread(() -> {
            try {
                runnable.run();
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
        
        return null;
    }

}
