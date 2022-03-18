package lab5.command.tasksCommands.without_arguments;

import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;

public class ExitCommand implements Command {
    private String[] args;

    public String[] getArgs(){
        return args;
    }

    @Override
    public String toString() {
        return  "exit - завершить проограмму, без сохранения в файл";
    }

    @Override
    public void accept(Visitor v) {
        throw new RuntimeException("How");
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
        args = arguments;
        return false;
    }
}
