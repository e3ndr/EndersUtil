/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.concurrent;

import lombok.SneakyThrows;

/**
 * An Async class which will return null on completion.
 */
public class AsyncRunnable<T> extends Async<T> {
    private boolean set = false;

    public AsyncRunnable(Runnable runnable) {
        new Thread(() -> this.run(runnable)).start();
    }

    private void run(Runnable runnable) {
        runnable.run();

        this.set = true;

        synchronized (this) {
            this.notifyAll();
        }
    }

    @SneakyThrows
    @Override
    public synchronized T await() {
        if (!this.set) this.wait();

        return null;
    }

}
