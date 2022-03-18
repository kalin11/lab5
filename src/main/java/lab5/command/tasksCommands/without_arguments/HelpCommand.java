package lab5.command.tasksCommands.without_arguments;

import com.sun.istack.internal.NotNull;
import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;

public class HelpCommand implements Command {
    private String[] args;

    public String[] getArgs(){
        return args;
    }

    @Override
    public String toString() {
        return "help - вывести инфо о командах";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
        args = arguments;
        return true;
    }
}
