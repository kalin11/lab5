package lab5.command.visitor;

import lab5.command.tasksCommands.with_arguments.*;
import lab5.command.tasksCommands.without_arguments.*;

public interface Visitor {

    void visit(AddCommand c);
    void visit(HelpCommand c);
    void visit(ShowCommand c);
    void visit(HeadCommand c);
    void visit(ClearCommand c);
    void visit(SaveCommand c);
    void visit(InfoCommand c);
    void visit(AverageOfLength c);
    void visit(PrintUniqueOscarsCount c);
    void visit(UpdateCommand c);
    void visit(RemoveCommand c);
    void visit(CountByGenreCommand c);
    void visit(RemoveGreaterCommand c);
    void visit(RemoveLowerCommand c);
    void visit(ExecuteScriptCommand c);
    // todo add visits for every command
}


