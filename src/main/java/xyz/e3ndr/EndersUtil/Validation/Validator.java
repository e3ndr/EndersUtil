/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.validation;

import java.util.Collection;

/**
 * The Class Validator.
 */
public class Validator {

    /**
     * Validate not null.
     *
     * @param obj the object to validate
     * @return true, if not null
     */
    public static boolean validateNotNull(Object obj) {
        return obj != null;
    }

    /**
     * Validate collection not null, this is null-safe.
     *
     * @param objs the objects to validate
     * @return true, if not null
     */
    public static boolean validateCollectionNotNull(Collection<Object> objs) {
        if (validateNotNull(objs)) {
            return validateArrayNotNull(objs);
        } else {
            return false;
        }
    }

    /**
     * Validate array not null, this is null-safe.
     *
     * @param objs the objects to validate
     * @return true, if not null
     */
    public static boolean validateArrayNotNull(Object... objs) {
        if (validateNotNull(objs)) {
            for (Object obj : objs) {
                if (obj == null) return false;
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Validate equals, this is null-safe.
     *
     * @param obj1
     * @param obj2
     * @return true, if equal
     */
    public static boolean validateEquals(Object obj1, Object obj2) {
        if (validateArrayNotNull(obj1, obj2)) {
            return obj1.equals(obj2);
        } else {
            return false;
        }
    }

    /**
     * Validate type.
     *
     * @param obj the obj to test
     * @param clazz the clazz to test assignment
     * @return true, if not null
     */
    public static boolean validateType(Object obj, Class<?> clazz) {
        if (validateArrayNotNull(obj, clazz)) {
            return clazz.isAssignableFrom(obj.getClass());
        } else {
            return false;
        }
    }

}
