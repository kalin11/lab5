package lab5.command.tasksCommands.with_arguments;

import lab5.command.parsing.Command;
import lab5.command.parsing.ObjectParser;
import lab5.command.visitor.Visitor;
import lab5.entity.*;

import java.io.BufferedReader;
import java.io.IOException;

public class AddCommand implements Command {
    private Movie movie = null;
    private String[] args = null;

    @Override
    public String toString() {
        return "add {element} - добавить новый элемент в коллекцию";
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public String[] getArgs(){
        return args;
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
        args = arguments;
        ObjectParser objectParser = new ObjectParser();
        try {
            movie = objectParser.parseObject(in);
            System.out.println("id фильма - "+movie.getId());
            System.out.println("дата создания фильма -" +movie.getCreationDate());
        } catch (IOException e) {
            System.out.println("При добавлении мы не смогли добавить.");
        } finally {
            return true;
        }
    }
}