package lab5.command.tasksCommands.with_arguments;

import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class ExecuteScriptCommand implements Command {

    private String[] args = null;

    public String[] getArgs(){
        return args;
    }

    public String toString(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
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
        else if(arguments.length == 0){
            System.out.println("не введен путь к файлу");
        }
        else {
            String path = arguments[0];
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("файл не существует");
            } else if (!file.canRead() || !file.canWrite()) {
                System.out.println("файл не доступен для чтения/записи");
            } else if (file.isDirectory()) {
                System.out.println("это не файл, а директория");
            }
        }
        return true;
    }
}
