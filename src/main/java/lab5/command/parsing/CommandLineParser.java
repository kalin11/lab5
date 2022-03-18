package lab5.command.parsing;

import lab5.command.CommandName;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class CommandLineParser {

    private final BufferedReader in;
    private final HashMap<CommandName, Command> commands;
    private boolean shouldClose = false;
    public CommandLineParser(BufferedReader in, HashMap<CommandName, Command> c) {
        this.in = in;
        this.commands = c;
    }

    public boolean shouldClose() {
        return shouldClose;
    }

    ///////////
    public void readLine(Visitor visitor) throws IOException {
        String line = in.readLine();
        if (line == null) {
            shouldClose = true;
            return;
        }
        ///
        ////////////////
        final String[] cmds = line.trim().replaceAll("\\s+", " ").toLowerCase().split(" "); //todo rename
        final String[] commandArguments = new String[cmds.length - 1];
        System.arraycopy(cmds, 1, commandArguments, 0, cmds.length - 1);

        Command c = commands.get(CommandName.fromString(cmds[0]));
        if (c == null) {
            System.out.println("Такой команды нет");
        } else {
            if (c.execute(commandArguments, in)) {
                c.accept(visitor);

            } else {
                shouldClose = true;
            }
        }
        ///////////////////

    }
}
