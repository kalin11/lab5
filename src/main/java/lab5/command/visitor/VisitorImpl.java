package lab5.command.visitor;

import lab5.collection.LinkedCollection;
import lab5.command.CommandName;
import lab5.command.parsing.Command;
import lab5.command.tasksCommands.ParseFromFile;
import lab5.command.tasksCommands.with_arguments.*;
import lab5.command.tasksCommands.without_arguments.*;
import lab5.entity.*;
import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.zip.DataFormatException;

public class VisitorImpl implements Visitor {

    private final LinkedCollection collection;
    private final HashMap<CommandName, Command> commands;
//    private HashSet<String> paths = new HashSet<>();
    private BufferedReader in;

    public VisitorImpl(LinkedCollection collection, HashMap<CommandName, Command> commands) {
        this.collection = collection;
        this.commands = commands;
    }

    @Override
    public void visit(AddCommand c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'add' должна быть без аргументов");
        } else {
            collection.add(c.getMovie());
            System.out.println(collection);
            System.out.println("Done");
        }

    }

    @Override
    public void visit(HelpCommand c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'help' должна быть без параметров");
        } else {

            commands.forEach((commandName, command) -> {
                System.out.println(command.toString());
            });
        }


//        System.out.println(
//
//                "show - вывести все элементы коллекции\n" +
//                        "info - вывести информацию о коллекции\n" +
//                        "add {element} - добавить новый элемент в коллекцию\n" +
//                        "update id {element} - обновить значение элемента коллекции, id которого равен заданному\n" +
//                        "remove_by_id id - удалить элемент из коллекции по его id\n" +
//                        "clear - удалить элемент из коллекции по его id\n" +
//                        "save - сохранить коллекцию в файл\n" +
//                        "execute_script file_name - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
//                        "exit - завершить проограмму, без сохранения в файл\n" +
//                        "head - вывести первый элемент коллекции\n" +
//                        "remove_greater {element} - удалить из коллекции все элементы, превыщающие заданный\n" +
//                        "remove_lower {element} - удалить из коллекции все элементы, меньшие,чем заданный\n" +
//                        "average_of_length - вывести среднее значение поля length для всех элементов коллекции\n" +
//                        "count_by_genre genre - вывести количество элементов, значение поля genre которых равно заданному\n" +
//                        "print_unique_oscars_count : вывести уникальные значения поля oscarsCount всех элементов в коллекции\n"
//
//
//        );
    }


    @Override
    public void visit(ShowCommand c) {

        if (c.getArgs().length > 0) {
            System.out.println("команда 'show' должна быть без аргумента");
        } else {
            System.out.println(collection.print());
        }
    }

    public void visit(HeadCommand c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'head' должна быть без аргумента");
        } else {
            collection.printFirstElement();
        }
    }

    public void visit(ClearCommand c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'clear' должна быть без аргумента");
        } else {
            collection.clear();
        }
    }

    public void visit(SaveCommand c) {
        try {
            collection.save(c.getArgs()[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("");
        }
    }

    public void visit(InfoCommand c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'info' должна быть без аргумента");
        } else {
            collection.info();
        }
    }

    public void visit(AverageOfLength c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'average_of_length' должна быть без аргумента");

        } else {
            collection.averageOfLength();
        }
    }

    public void visit(PrintUniqueOscarsCount c) {
        if (c.getArgs().length > 0) {
            System.out.println("команда 'print_unique_oscars_count' должна быть без аргумента");
        } else {
            collection.printMoviesWithUniqueOscarsCount();
        }
    }

    //
    public void visit(UpdateCommand c) {
        if (c.getArgs().length == 0){
            System.out.println("вы не ввели id элемента, который надо обновить");
        }
        else if (c.getArgs().length > 1){
            System.out.println("слишком много аргументов");

        }
        else {
            if (collection.isEmpty()) {
                System.out.println("коллекция пустая, чего обновлять?");
            } else {
                String[] m = c.getArgs();
                try {
                    long id = Long.parseLong(m[0]);
                    collection.updateElement(id, collection.getMovie());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print("");
                } catch (NumberFormatException e) {
                    System.out.println("попробуйте заново");
                }
            }
        }


    }

    public void visit(RemoveCommand c) {
        c.getArgs();
//        System.out.println(Arrays.toString(c.getArgs()));

        String[] m = c.getArgs();

        try {
            long id = Long.parseLong(m[0]);
            collection.remove(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("");
        } catch (NumberFormatException e) {
            System.out.println("попробуйте заново");
        }

    }

    public void visit(CountByGenreCommand c) {
        try {
            if (c.getArgs().length == 1) {

                String m = c.getArgs()[0].toUpperCase(Locale.ROOT);

                MovieGenre movieGenre = MovieGenre.valueOf(m);

                collection.countByGenre(movieGenre);
            } else if (c.getArgs().length == 0) {
                System.out.println("вы ввели команду без аргумента, что считать? вы можете ввести 'ACTION, DRAMA, HORROR, SCIENCE_FICTION'");
            } else {
                System.out.println("некорректный ввод параметра");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("некорректный тип параметра, попробуйте заново, вы можете ввести 'ACTION, DRAMA, HORROR, SCIENCE_FICTION'");
        }

    }

    public void visit(RemoveGreaterCommand c) {
        if (collection.isEmpty()) {
            System.out.println("коллекция пустая");
        } else {

            if (c.getArgs().length > 0) {
                System.out.println("у команды 'remove_greater' не должно быть параметров");
            } else {
                collection.removeGreater(c.getMovie());
            }
        }
    }

    public void visit(RemoveLowerCommand c) {
        if (collection.isEmpty()) {
            System.out.println("коллекция пустая");
        } else {
            if (c.getArgs().length > 0) {
                System.out.println("у команды 'remove_lower' не должно быть параметров");
            } else {
                collection.removeLower(c.getMovie());
            }
        }
    }

    boolean flag = false;

    public void visit(ExecuteScriptCommand c) {
        try {
            HashSet<String> paths = new HashSet<>();
            String filename = c.getArgs()[0].toLowerCase(Locale.ROOT);
            findAllPathForScript(c,paths,filename);
            if (flag) {
                System.out.println("извините, но вы пытаетесь зациклить скрипт и сломать мою прогу(( укажите другой файл");
            }
            else {
                executeFileCommands(c);
                paths.add(c.getArgs()[0].toLowerCase(Locale.ROOT));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("");
        }catch (IOException e){
            System.out.println("недостаточно прав(");
        }

    }


    public void findAllPathForScript(ExecuteScriptCommand c, HashSet<String> set, String path) throws IOException {
        set.add(path.toLowerCase(Locale.ROOT));
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        if (flag){
            return;
        }
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            for (String s : allLines) {
                if (s.contains("execute_script") && s.contains(".txt")) {
                    String[] line = s.split(" ");
                    set1.add(line[1].toLowerCase(Locale.ROOT));
                }
            }
            for (String str : set1) {
                if (!set.contains(str)) {
                    findAllPathForScript(c, set, str);
                } else {
                    flag = true;
                    return;
                }
            }
        }catch (ConcurrentModificationException e) {
            System.out.print("");
        }
    }

    public void executeFileCommands(ExecuteScriptCommand c) {


        try {
            List<String> fileCommands = Files.readAllLines(Paths.get(c.getArgs()[0]));
            fileCommands.removeIf(command -> command.equals(" ") || command.equals(""));
            boolean flag = false;
            for (String cmd : fileCommands) {
                final String[] cmds = cmd.trim().replaceAll("\\s+", " ").split(" ");
                final String[] commandsArgs = new String[cmds.length - 1];
                System.arraycopy(cmds, 1, commandsArgs, 0, cmds.length - 1);
                Command command = commands.get(CommandName.fromString(cmds[0]));
//
                if (Arrays.toString(new String[]{cmds[0]}).equals("[help]")) {
                    HelpCommand helpCommand = new HelpCommand();
                    helpCommand.execute(new String[0], in);
                    this.visit(helpCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[info]")) {
                    InfoCommand infoCommand = new InfoCommand();
                    infoCommand.execute(new String[0], in);
                    this.visit(infoCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[clear]")) {
                    ClearCommand clearCommand = new ClearCommand();
                    clearCommand.execute(new String[0], in);
                    this.visit(clearCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[show]")) {
                    ShowCommand showCommand = new ShowCommand();
                    showCommand.execute(new String[0], in);
                    this.visit(showCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[remove_by_id]")) {
                    RemoveCommand removeCommand = new RemoveCommand();
                    removeCommand.execute(commandsArgs, in);
                    this.visit(removeCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[save]")) {
                    SaveCommand saveCommand = new SaveCommand();
                    saveCommand.execute(commandsArgs, in);
                    this.visit(saveCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[head]")) {
                    HeadCommand headCommand = new HeadCommand();
                    headCommand.execute(new String[0], in);
                    this.visit(headCommand);
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[exit]")) {
                    ExitCommand exitCommand = new ExitCommand();
                    exitCommand.execute(new String[0], in);
                    System.exit(0);

                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[average_of_length]")) {
                    AverageOfLength averageOfLength = new AverageOfLength();
                    averageOfLength.execute(new String[0], in);
                    this.visit(averageOfLength);

                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[count_by_genre]")) {
                    CountByGenreCommand count = new CountByGenreCommand();
                    count.execute(commandsArgs, in);
                    this.visit(count);

                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[print_unique_oscars_count]")) {
                    PrintUniqueOscarsCount print = new PrintUniqueOscarsCount();
                    print.execute(new String[0], in);
                    this.visit(print);

                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[add]")) {
                    try {
                        String f = cmd.substring(4);
                        if (getFields(f) == null ){
                            return;
                        }
                        else {
                            collection.add(getFields(f));
                            System.out.println(collection);
                        }
                    } catch (NumberFormatException | DateTimeParseException | NullPointerException e) {
                        System.out.println("не удалось запарсить");
                        return;
                    } catch (IllegalArgumentException e) {
                        System.out.println("какое-то Enum значение не удалось запарсить");
                        return;
                    }
                } else if (Arrays.toString(new String[]{cmds[0]}).equals("[remove_greater]")) {
                    try{
                        String f = cmd.substring(15);;
                        if (getFields(f) == null || getFields(f).getCoordinates().getY() == 2){
                            System.out.println("проверьте значения Movie у команд 'remove_greater'");
                            return;
                        }
                        else{
                            collection.removeG(getFields(f));
                            System.out.println(collection);
                        }
                    } catch (NumberFormatException | DateTimeParseException | NullPointerException e) {
                            System.out.println("не удалось запарсить");
                            return;
                    } catch (IllegalArgumentException e){
                        System.out.println("какое-то Enum значение не удалось запарсить");
                        return;
                    }

                }
                else if (Arrays.toString(new String[]{cmds[0]}).equals("[remove_lower]")){
                    try{
                        String f = cmd.substring(13);
                        if (getFields(f) == null || getFields(f).getCoordinates().getY() == 2){
                            System.out.println("проверьте значения Movie у команд 'remove_lower'");
                            return;
                        }
                        else{
                            collection.removeL(getFields(f));
                            System.out.println(collection);
                        }
                    }catch (NumberFormatException | DateTimeParseException | NullPointerException e){
                        System.out.println("не удалось запарсить");
                    }catch (IllegalArgumentException e){
                        System.out.println("какой-то Enum значение не удалось запарсить");
                        return;
                    }
                }
                else if (Arrays.toString(new String[]{cmds[0]}).equals("[update]")){
//                    System.out.println(cmd);
                    String idAndMov = cmd.substring(7);
//                    System.out.println(idAndMov);
                    String fileds = idAndMov.substring(idAndMov.indexOf(" ") + 1);
//                    System.out.println(fileds);
                    String id = cmd.replace(fileds, "").substring(7).trim();
//                    System.out.println(id);
                    try{
                        String f = fileds;
//                        System.out.println(f);
//                        System.out.println(getFields(f).getCoordinates().getX());
//                        System.out.println(getFields(f).getOscarsCount());
//                        System.out.println(getFields(f).getCoordinates());
                        if (getFields(f) == null || getFields(f).getCoordinates().getY() == -1000000000){
                            System.out.println("проверьте значения Movie у команд 'update'");
                            return;
                        }
                        else{
                            long ID = Long.parseLong(id);
                            Movie movie = getFields(f);
                            collection.updateMov(ID, getFields(f));
//                            collection.getMovie().setCreationDate(getFields(f).getCreationDate());
                        }
                    }catch (NumberFormatException e){
                        System.out.print("");
                    }
                }
                else if (Arrays.toString(new String[]{cmds[0]}).equals("[execute_script]")){
                    ExecuteScriptCommand scriptCommand = new ExecuteScriptCommand();
//                    System.out.println(Arrays.toString(commandsArgs));
                    String[] args = new String[commandsArgs.length];
                    for (int i = 0; i < commandsArgs.length; i++){
                        args[i] = commandsArgs[i].toLowerCase(Locale.ROOT);
                    }
                    scriptCommand.execute(args, in);
                    this.visit(scriptCommand);
                }
                else {
                    flag = true;
                }
            }
            if (flag){
                System.out.println("файл не содержит команд/неверный формат команд");
            }
        } catch (IOException e) {
            System.out.print("");
        }

    }

    public Movie getFields(String f) {
        String[] fields = f.split(",");
        if (fields.length != 13) {
            System.out.print("");
        }
        else {
            ParseFromFile parse = new ParseFromFile();
            Person person = new Person("Jora", ZonedDateTime.now(), 98.9F, Country.INDIA);
            Movie movie = new Movie(1, "Vasya", new Coordinates(1,-1000000000), new Date(), 4, 99L, MovieGenre.ACTION, MpaaRating.R, person);
            try {
                movie.setId(parse.parseID(fields[0]));
                movie.setName(parse.parseString(fields[1]));
                if (parse.parseY(fields[3]) > 884) {
                    System.out.print("");
                } else {
                    movie.setCoordinates(parse.parseX(fields[2]), parse.parseY(fields[3]));
                }
                movie.setCreationDate(parse.parseDate(fields[4]));
                movie.setOscarsCount(parse.parseOscarsCount(fields[5]));
                movie.setLength(parse.parseLength(fields[6]));
                movie.setGenre(MovieGenre.valueOf(fields[7]));
                movie.setMpaaRating(MpaaRating.valueOf(fields[8]));
                Person p = new Person(parse.parseString(fields[9]),
                        parse.parseZND(fields[10]),
                        parse.parseWeight(fields[11]),
                        Country.valueOf(fields[12]));
                movie.setOperator(p);
                return movie;
            } catch (ParseException e) {
                System.out.println("не удалось спарсить");
            }

        }
        return null;
    }
}
