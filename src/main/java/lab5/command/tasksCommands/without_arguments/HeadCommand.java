package lab5.command.tasksCommands.without_arguments;

//import lab5.Collection.CollectionManager;
import lab5.command.parsing.Command;
import lab5.command.visitor.Visitor;

import java.io.BufferedReader;

public class HeadCommand implements Command {
    private String[] args;

    public String[] getArgs(){
        return args;
    }

    @Override
    public String toString() {
        return "head - вывести первый элемент коллекции";
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

//public static class Parser implements CommandParser<HeadCommand, String> {
//    LinkedCollection linkedCollection = new LinkedCollection();
//
//    @Override
//    public String parseCommandLine(String line) {
//        return "head" == line ? line : null;
//    }
//
//    @Override
//    public HeadCommand parseCommand(String lineParsingResult, BufferedReader in) {
//
//        return new HeadCommand();
//    }
//}
