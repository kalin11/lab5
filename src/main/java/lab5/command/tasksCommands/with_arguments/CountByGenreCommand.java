package lab5.command.tasksCommands.with_arguments;

import lab5.command.CommandName;
import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;
import java.util.Arrays;

public class CountByGenreCommand implements Command {

    private String[] args = null;

    public String toString(){
        return "count_by_genre genre - вывести количество элементов, значение поля genre которых равно заданному";
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
        if (arguments.length > 1){
            System.out.println("неверный формат ввода аргумента");
        }
        else{
            try{
                CommandName.valueOf(CommandName.class, arguments[0]);
            }catch (IllegalArgumentException e){
                System.out.println();
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.print("");
            }
        }
        return true;
    }
}
