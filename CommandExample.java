package xyz.e3ndr.endersutil;

import lombok.SneakyThrows;
import xyz.e3ndr.endersutil.input.Command;
import xyz.e3ndr.endersutil.input.CommandExecutionException;
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

        try {
            System.out.println(command.execute("test \"very nice\" a b"));
        } catch (CommandExecutionException e) {
            e.printStackTrace(); // You would normally parse out the key and reason
        }

        try {
            System.out.println(command.execute("test somewhat_nice a b"));
        } catch (CommandExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(command.execute("test not_nice a c"));
        } catch (CommandExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(command.execute("test not_nice a"));
        } catch (CommandExecutionException e) {
            e.printStackTrace();
        }

        // OUTPUT:
        // Success! test very nice a b
        // Success! test somewhat_nice a b
        // xyz.e3ndr.endersutil.input.CommandExecutionException: input.token, c
        // xyz.e3ndr.endersutil.input.CommandExecutionException: input.length, null
    }

}
