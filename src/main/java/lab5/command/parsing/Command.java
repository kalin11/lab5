package lab5.command.parsing;

import lab5.command.visitor.Visitor;

import java.io.BufferedReader;

public interface Command {
   void accept(Visitor v);
   boolean execute(String[] arguments, BufferedReader in);
}
