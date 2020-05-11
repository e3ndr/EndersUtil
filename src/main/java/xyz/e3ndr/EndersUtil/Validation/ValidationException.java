/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.validation;

/**
 * The Class ValidationException.
 */
public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 2937536558016108372L;

    public ValidationException(String error) {
        super(error);
    }

}
