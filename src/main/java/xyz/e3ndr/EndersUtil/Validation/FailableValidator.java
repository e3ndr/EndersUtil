/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.Validation;

import java.util.Collection;

/**
 * The Class FailableValidator, will fail, providing a string to the abstract method {@link FailableValidator#onFail(String)}
 */
public abstract class FailableValidator {
    
    /**
     * Validate not null.
     *
     * @param obj the object to validate
     * @return true, if not null
     */
    public void validateNotNull(String error, Object obj) {
        if (!Validator.validateNotNull(obj)) onFail(error);
    }
    
    /**
     * Validate collection not null, this is null-safe.
     *
     * @param objs the objects to validate
     * @return true, if not null
     */
    public void validateCollectionNotNull(String error, Collection<Object> objs) {
        if (!Validator.validateCollectionNotNull(objs)) onFail(error);
    }
    
    /**
     * Validate array not null, this is null-safe.
     *
     * @param objs the objects to validate
     * @return true, if not null
     */
    public void validateArrayNotNull(String error, Object... objs) {
        if (!Validator.validateArrayNotNull(objs)) onFail(error);
    }
    
    /**
     * Validate equals, this is null-safe.
     *
     * @param obj1
     * @param obj2
     * @return true, if equal
     */
    public void validateEquals(String error, Object obj1, Object obj2) {
        if (!Validator.validateEquals(obj1, obj2)) onFail(error);
    }
    
    /**
     * Validate type.
     *
     * @param obj the obj to test
     * @param clazz the clazz to test assignment
     * @return true, if not null
     */
    public void validateType(String error, Object obj, Class<?> clazz) {
        if (!Validator.validateType(obj, clazz)) onFail(error);
    }
    
    protected void validateString(String error) {
        if (error == null) throw new IllegalArgumentException("Error string is null.");
    }
    
    protected abstract void onFail(String error);

}
