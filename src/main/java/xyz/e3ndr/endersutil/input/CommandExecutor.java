/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.input;

/**
 * The Interface CommandExecutor.
 */
public interface CommandExecutor<T> {

    /**
     * Validate.
     *
     * @param input the input
     * @param index the index of the argument
     * @param executor the executor
     * @return true, if valid
     */
    default boolean validate(String arg, int index, T executor) {
        return true;
    }

    /**
     * Executes when command validation succeeds.
     *
     * @param args the arguments
     * @param input the input, in its replaced form
     * @param executor the executor
     * @return the response
     */
    public String onCommand(String[] args, String input, T executor);

}
