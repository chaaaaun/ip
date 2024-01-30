package chatbot;

import chatbot.exceptions.InvalidCommandException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private static final Map<String, Command> cmdStrMap = new HashMap<>();

    static {
        for (Command cmd : Command.values()) {
            cmdStrMap.put(cmd.toString(), cmd);
        }
    }

    public static Command toCommand(String rep) throws InvalidCommandException {
        String[] split = rep.split("\\s+", 2);
        Command cmd = cmdStrMap.get(split[0]);
        if (split.length > 1) {
            cmd.withArgs(split[1]);
        }
        if (cmd == null) {
            throw new InvalidCommandException();
        }
        return cmd;
    }

    public static LocalDateTime parseDate(String date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern(
                        "[yyyy-MM-dd HH:mm]" +
                                "[yyyy-MM-dd]" +
                                "[yyyy-MM]"
                ))
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();

        return LocalDateTime.parse(date, formatter);
    }
}