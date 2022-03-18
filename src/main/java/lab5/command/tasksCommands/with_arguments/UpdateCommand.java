package lab5.command.tasksCommands.with_arguments;

import lab5.command.parsing.Command;
import lab5.command.parsing.ObjectParser;
import lab5.command.visitor.Visitor;
import lab5.entity.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class UpdateCommand implements Command {

    private Movie movie = null;

    private String[] args = null;

    public String toString(){
        return "update id {element} - обновить значение элемента коллекции, id которого равен заданному";
    }

    public Movie getMovie(){
        return movie;
    }

    public String[] getArgs(){
        return args;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
        args = arguments;
        try {
            long x = Long.parseLong(arguments[0]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("");
        } catch (NumberFormatException e) {
            System.out.println("тип аргумента неправильный");
        }

            return true;
        }

    }
