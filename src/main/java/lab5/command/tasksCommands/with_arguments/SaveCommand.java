package lab5.command.tasksCommands.with_arguments;

import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;

public class SaveCommand implements Command {

    private String[] args = null;

    public String[] getArgs(){
        return args;
    }

    @Override
    public String toString(){
        return "save: сохранить коллекцию в файл";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public boolean execute(String[] arguments, BufferedReader in) {
        args = arguments;
        if (arguments.length == 0){
            System.out.println("не указан путь файла, куда сохранять");
        }
        else if (arguments.length > 1){
            System.out.println("некорректный ввод пути файла");
        }
        else {

        }
        return true;
    }
}
