/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.validation;

import java.util.function.Consumer;

/**
 * The Class CastValidator.
 */
public class CastValidator {

    /**
     * Casts an object and passes it to a consumer.
     *
     * @param <T> the generic type
     * @param success the success
     * @param obj the obj
     * @param clazz the clazz
     * @return true, if successful
     */
    public static <T> boolean castType(Consumer<T> success, Object obj, Class<T> clazz) {
        if (!Validator.validateNotNull(success)) {
            throw new IllegalArgumentException("Success is null.");
        } else if (Validator.validateArrayNotNull(obj, clazz)) {
            try {
                success.accept(clazz.cast(obj));

                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            throw new IllegalArgumentException("Parameter is null.");
        }
    }

}
