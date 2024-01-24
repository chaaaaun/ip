package chatbot.exceptions;

import chatbot.Command;

public class InvalidCommandException extends DukeException {
    public static String ERRSTR;

    static {
        StringBuilder result = new StringBuilder();
        result.append("Invalid command! Only the following commands are allowed:\n");
        for (Command c : Command.values()) {
            result.append(c.getStringRep()).append("\n");
        }
        ERRSTR = result.toString();
    }
    public InvalidCommandException() {
        super(ERRSTR);
    }
}