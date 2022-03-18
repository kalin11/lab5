package lab5.command.tasksCommands.without_arguments;

import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;

public class ShowCommand implements Command {
    private String[] args;

    public String[] getArgs(){
        return args;
    }

    @Override
    public String toString(){
        return "show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
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
