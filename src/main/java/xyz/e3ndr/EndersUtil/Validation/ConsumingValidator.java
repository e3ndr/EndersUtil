/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.validation;

import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;

/**
 * Instantiates a new consuming validator, this will send a provided error
 * string to the consumer.
 *
 * @param consumer the consumer
 */
@RequiredArgsConstructor
public class ConsumingValidator extends FailableValidator {
    private final Consumer<String> consumer;

    @Override
    protected void onFail(String error) {
        this.consumer.accept(error);
    }

}
