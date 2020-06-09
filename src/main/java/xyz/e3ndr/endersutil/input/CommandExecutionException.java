/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.input;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class CommandExecutionException extends Exception {
    private static final long serialVersionUID = -647287827177245818L;

    private @NonNull String key;
    private String reason;

    /**
     * Instantiates a new command execution exception.
     *
     * @param key the key
     */
    public CommandExecutionException(@NonNull String key) {
        this(key, null);
    }

    /**
     * Instantiates a new command execution exception.
     *
     * @param key the key
     * @param reason the reason
     */
    public CommandExecutionException(@NonNull String key, String reason) {
        super(key + ", " + reason);

        this.key = key;
        this.reason = reason;
    }

}
