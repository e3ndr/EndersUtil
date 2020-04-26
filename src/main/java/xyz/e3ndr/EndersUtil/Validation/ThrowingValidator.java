/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.Validation;

import java.util.Collection;

/**
 * The Class ThrowingValidator, this class will throw a {@link ValidationException} with the provided error. You must catch it.
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
     * @return true, if not null
     */
    public static void validateNotNull(String error, Object obj) {
        validator.validateNotNull(error, obj);
    }
    
    /**
     * Validate collection not null, this is null-safe.
     *
     * @param error the error string
     * @param objs the objects to validate
     * @return true, if not null
     */
    public static void validateCollectionNotNull(String error, Collection<Object> objs) {
        validator.validateCollectionNotNull(error, objs);
    }
    
    /**
     * Validate array not null, this is null-safe.
     *
     * @param error the error string
     * @param objs the objects to validate
     * @return true, if not null
     */
    public static void validateArrayNotNull(String error, Object... objs) {
        validator.validateArrayNotNull(error, objs);
    }
    
    /**
     * Validate equals, this is null-safe.
     *
     * @param error the error string
     * @param obj1
     * @param obj2
     * @return true, if equal
     */
    public static void validateEquals(String error, Object obj1, Object obj2) {
        validator.validateEquals(error, obj1, obj2);
    }
    
    /**
     * Validate type.
     *
     * @param error the error string
     * @param obj the obj to test
     * @param clazz the clazz to test assignment
     * @return true, if not null
     */
    public static void validateType(String error, Object obj, Class<?> clazz) {
        validator.validateType(error, obj, clazz);
    }

}
