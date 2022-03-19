package lab5;

import com.sun.istack.internal.NotNull;
import lab5.collection.CollectionReader;
import lab5.collection.LinkedCollection;
import lab5.command.CommandName;
import lab5.command.parsing.Command;
import lab5.command.parsing.CommandLineParser;
import lab5.command.tasksCommands.with_arguments.*;
import lab5.command.tasksCommands.without_arguments.*;
import lab5.command.visitor.VisitorImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        boolean pathIsCorrect = true;
        LinkedCollection collection = new LinkedCollection();
        HashMap<CommandName, Command> commands = initCommands();


        while(pathIsCorrect) {
            String filePath = args[0];
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("указаный файл не существует");
                return;
            } else if (!file.canRead() || !file.canWrite()) {
                System.out.println("файл не доступен для чтения/записи");
                return;
            } else if (file.isDirectory()) {
                System.out.println("это не файл, а директория");
                return;
            } else {
                if (file.length() == 0){
                    collection = new LinkedCollection();
                    pathIsCorrect = false;
                }
                else{
                    CollectionReader collectionReader = new CollectionReader(collection);
                    collection = collectionReader.read(filePath);
                    pathIsCorrect = false;
                }
            }
        }





        VisitorImpl visitor = new VisitorImpl(collection, commands);




        CommandLineParser parser = new CommandLineParser(new BufferedReader(new InputStreamReader(System.in)), commands);
        System.out.println("Добро пожаловать. Введите команду.\nЧтобы получить список команд, начертите 'help'");
        try {
            while (!parser.shouldClose()) {
                System.out.print(">>> ");
                parser.readLine(visitor);
            }
        } catch (IOException e) {
            System.out.println();
        }
    }

    static HashMap<CommandName, Command> initCommands() {
        HashMap<CommandName, Command> commands = new HashMap<>();
        commands.put(CommandName.HELP, new HelpCommand());
        commands.put(CommandName.EXIT, new ExitCommand());
        commands.put(CommandName.ADD, new AddCommand());
        commands.put(CommandName.SHOW, new ShowCommand());
        commands.put(CommandName.HEAD, new HeadCommand());
        commands.put(CommandName.SAVE, new SaveCommand());
        commands.put(CommandName.INFO, new InfoCommand());
        commands.put(CommandName.AVERAGE_OF_LENGTH, new AverageOfLength());
        commands.put(CommandName.PRINT_UNIQUE_OSCARS_COUNT, new PrintUniqueOscarsCount());
        commands.put(CommandName.UPDATE_ID, new UpdateCommand());
        commands.put(CommandName.REMOVE_BY_ID, new RemoveCommand());
        commands.put(CommandName.COUNT_BY_GENRE, new CountByGenreCommand());
        commands.put(CommandName.REMOVE_GREATER, new RemoveGreaterCommand());
        commands.put(CommandName.CLEAR, new ClearCommand());
        commands.put(CommandName.REMOVE_LOWER, new RemoveLowerCommand());
        commands.put(CommandName.EXECUTE_SCRIPT, new ExecuteScriptCommand());
        //todo script
        return commands;
    }
}
