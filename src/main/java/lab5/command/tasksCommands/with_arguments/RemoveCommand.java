package lab5.command.tasksCommands.with_arguments;

import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;
import java.util.LinkedList;

public class RemoveCommand implements Command {

    private String[] args = null;

    private LinkedList list = null;

    public String toString(){
        return "remove_by_id id - удалить элемент из коллекции по его id";
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
        if (arguments.length == 0){
            System.out.println("вы не ввели аргумент");
        }
        if (arguments.length > 1){
            System.out.println("неверный формат ввод аргумента");
        }
        else {
            try{
                long x = Long.parseLong(arguments[0]);
            }catch (NumberFormatException e){
                System.out.println("тип аргумента неправильный");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.print("");
            }


        }
        return true;
    }
}
