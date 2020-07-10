package xyz.e3ndr.endersutil.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class CommandResponse {
    private CommandError error;
    private String reply;

    public CommandResponse(CommandError error) {
        this.error = error;
    }

    public CommandResponse(String reply) {
        this.reply = reply;
    }

    public String getErrorMessage() {
        return this.reply;
    }

    public boolean hasError() {
        return this.error != null;
    }

}
