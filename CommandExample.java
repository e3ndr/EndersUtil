package xyz.e3ndr.endersutil.test;

import lombok.SneakyThrows;
import xyz.e3ndr.endersutil.input.Command;
import xyz.e3ndr.endersutil.input.CommandExecutor;

public class CommandExample {

    @SneakyThrows
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor() {
            @Override
            public String onCommand(String[] args, String raw) {
                return "Success! " + raw;
            }
        };

        Command command = new Command(4, executor, "test", "*", "a", "b"); // Supports wildcards

        System.out.println(command.execute("test \"very nice\" a b"));
        System.out.println(command.execute("test somewhat_nice a b"));
        System.out.println(command.execute("test not_nice a c"));
        System.out.println(command.execute("test not_nice a"));

        // OUTPUT:
        // Success! test very nice a b
        // Success! test somewhat_nice a b
        // INPUT_TOKEN, c
        // INPUT_LENGTH, null
    }

}
