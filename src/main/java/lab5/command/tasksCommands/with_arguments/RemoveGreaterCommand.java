package lab5.command.tasksCommands.with_arguments;

import lab5.command.parsing.Command;
import lab5.command.parsing.ObjectParser;
import lab5.command.visitor.Visitor;
import lab5.entity.Movie;

import java.io.BufferedReader;
import java.io.IOException;

public class RemoveGreaterCommand implements Command {

    private Movie movie = null;

    private String[] args = null;

    public String toString(){
        return "remove_greater {element} - удалить из коллекции все элементы, превыщающие заданный";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String[] getArgs(){
        return args;
    }

    public Movie getMovie(){
        return movie;
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
//        ObjectParser objectParser = new ObjectParser();
        args = arguments;
        return true;

//        try{
//            movie = objectParser.parseObject(in);
//
//        }catch (IOException e){
//            System.out.println("при добавлении объекта, с которым будем сравнивать произошла ошибка");
//        } finally {
//            return true;
//        }
    }
}

