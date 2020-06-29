/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.validators;

import java.util.Collection;

/**
 * The Class ThrowingValidator, this class will throw a
 * {@link ValidationException} with the provided error. You must catch it.
 */
public class ThrowingValidator {
    private static final FailableValidator validator = new FailableValidator() {
        @Override
        protected void onFail(String error) {
            throw new ValidationException(error);
        }
    };

    private ThrowingValidator() {}

    /**
     * Validate not null.
     *
     * @param error the error string
     * @param obj the object to validate
     * @return the provided object
     */
    public static <T> T validateNotNull(String error, T obj) {
        validator.validateNotNull(error, obj);
        return obj;
    }

    /**
     * Validate collection not null, this is null-safe.
     *
     * @param error the error string
     * @param objs the objects to validate
     * @return the provided object
     */
    public static <T> Collection<T> validateCollectionNotNull(String error, Collection<T> objs) {
        validator.validateArrayNotNull(error, objs);
        return objs;
    }

    /**
     * Validate array not null, this is null-safe.
     *
     * @param error the error string
     * @param objs the objects to validate
     * @return the provided object
     */
    public static <T> T[] validateArrayNotNull(String error, @SuppressWarnings("unchecked") T... objs) {
        validator.validateArrayNotNull(error, objs);
        return objs;
    }

    /**
     * Validate type.
     *
     * @param error the error string
     * @param obj the obj to test
     * @param clazz the clazz to test assignment
     */
    public static void validateType(String error, Object obj, Class<?> clazz) {
        validator.validateType(error, obj, clazz);
    }

}
