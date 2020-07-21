/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.endersutil.input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.NonNull;

/**
 * The Class Command.
 */
public class Command<T> {
    private static final Pattern pattern = Pattern.compile("([^\"]\\S*|\".+?\")\\s*");

    private String[] parametersRegex;
    private String[] parameters;
    private int minimumLength;
    private CommandExecutor<T> executor;

    /**
     * Instantiates a new command.
     *
     * @param minimumLength the minimum length of a command
     * @param executor the executor
     * @param parameters the parameters, supports the wildcard *
     */
    public Command(int minimumLength, @NonNull CommandExecutor<T> executor, @NonNull String... parameters) {
        this.parametersRegex = new String[parameters.length];
        this.parameters = new String[parameters.length];
        this.minimumLength = minimumLength;
        this.executor = executor;

        for (int i = 0; i != this.parameters.length; i++) {
            String parameter = parameters[i].trim().toLowerCase();
            String regex = parameter.replace(".", "\\.").replace("*", ".*");

            this.parameters[i] = parameter;
            this.parametersRegex[i] = regex;
        }

    }

    /**
     * Execute.
     *
     * @param input the input
     * @param executor the executor
     * @return the response
     * @throws CommandExecutionException thrown when validation fails.
     */
    public CommandResponse execute(String input, T executor) {
        List<String> args = new ArrayList<>();
        Matcher m = pattern.matcher(input);

        while (m.find()) {
            args.add(m.group(1).replace("\"", ""));
        }

        if (args.size() < this.minimumLength) {
            return new CommandResponse(CommandError.INPUT_LENGTH);
        } else {
            for (int i = 0; (i != this.parametersRegex.length) && (i != args.size()); i++) {
                String regex = this.parametersRegex[i];
                String arg = args.get(i);

                if (!arg.toLowerCase().matches(regex)) {
                    return new CommandResponse(CommandError.INPUT_TOKEN, arg);
                } else if (!this.executor.validate(arg, i, executor)) {
                    return new CommandResponse(CommandError.INPUT_VALIDATION, arg);
                }
            }

            String[] array = args.toArray(new String[0]);

            return new CommandResponse(this.executor.onCommand(array, makeString(array), executor));
        }
    }

    private static String makeString(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (String arg : args) {
            sb.append(' ').append(arg);
        }

        return sb.substring(1);
    }

}
