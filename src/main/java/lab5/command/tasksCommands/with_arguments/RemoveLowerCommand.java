package lab5.command.tasksCommands.with_arguments;

import lab5.collection.LinkedCollection;
import lab5.command.parsing.Command;
import lab5.command.parsing.ObjectParser;
import lab5.command.visitor.Visitor;
import lab5.entity.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class RemoveLowerCommand implements Command {

    private Movie movie = null;

    private String[] args = null;
    public String[] getArgs(){
        return args;
    }

    public String toString(){
        return "remove_lower {element} - удалить из коллекции все элементы, меньшие,чем заданный";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Movie getMovie(){
        return movie;
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
        args = arguments;
        return true;
    }
}
