package test;

import lab5.collection.LinkedCollection;
import lab5.command.tasksCommands.ParseFromFile;
import lab5.entity.Coordinates;
import lab5.entity.Movie;
import lab5.entity.Person;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Main{


    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
//        main.readFromFile();
//        System.out.println(main.readFromFile());
        main.parseFile();

    }

    public String readFromFile() {
        Movie m = Movie.Default;
        String result = "";
        String path = "C:\\Users\\kal1n\\IdeaProjects\\labka5\\laba.csv";

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))){
            try {
                int i;
                String tmp = "";
                while ((i = bis.read()) != -1){
                    char c = (char) i;
                    if (c != '\n'){
                        tmp += String.valueOf(c).replaceAll(" ", "");
                    }
                    if (c == '\n') {
                        System.out.println(tmp);
                        result += tmp + " ";
                        tmp  = "";

                    }

                }
            }finally {
                bis.close();
            }


        } catch (IOException e) {
            System.out.println("чот не то считали");
        }

        return result;
    }

    public void parseFile() {
        LinkedList<Movie> mov = new LinkedList<>();
        String line = readFromFile();
        String[] movies = line.split(" ");
        Movie[] m = new Movie[2];
        Movie t = null;
        Movie g = null;

        System.out.println("---------------");
//        System.out.println(movies[0]);
        try{
            t = convert(movies[0]);
            g = convert(movies[1]);
        }
        catch (ParseException e){
            System.out.println("what");
        }
        mov.add(t);
        System.out.println(mov);
        mov.add(g);
        System.out.println(mov);



//        for (int i = 0; i < movies.length; i++){
//            try {
////                convert(movies[i]);
//                mov.addLast(convert(movies[2]));
//            }catch (ParseException e){
//                System.out.println("не спарсилось(");
//            }
//        }
//        System.out.println(mov);
//        for (String movie :  movies){
//            try{
//                mov.add(convert(movie));
//            }catch (ParseException e){
//                System.out.println("не смогли запарсить((");
//            }
//        }
//        System.out.println(mov);
    }


    public Movie convert(String tmp) throws ParseException {
        Movie movie = Movie.Default;
        ParseFromFile parse = new ParseFromFile();
        String[] a = tmp.split(",");

//        System.out.println(Arrays.toString(a));

        Coordinates coordinates = new Coordinates(parse.parseX(a[2]), parse.parseY(a[3]));

        Person person = new Person(parse.parseString(a[9]), parse.parseZND(a[10]), parse.parseWeight(a[11]), parse.parseCountry(a[12]));

        movie.setId(parse.parseID(a[0]));
        movie.setName(parse.parseString(a[1]));
        movie.setCoordinates(parse.parseX(a[2]),parse.parseY(a[3]));
        movie.setCreationDate(parse.parseDate(a[4]));
        movie.setOscarsCount(parse.parseOscarsCount(a[5]));
        movie.setLength(parse.parseLength(a[6]));
        movie.setGenre(parse.parseMovieGenre(a[7]));
        movie.setMpaaRating(parse.parseMpaaRating(a[8]));
        movie.setOperator(person);

//        System.out.println(movie.getMovieName());

        return movie;



    }
}
//        Scanner scanner = new Scanner(System.in);
//        String newLine = scanner.nextLine().trim().replaceAll("add", "");
//
//        System.out.println(newLine.trim());

//        System.out.println("Алексей".matches("^([А-Я]{1}[а-яё]{1,50})$"));
//        Scanner scanner = new Scanner(System.in);
//        String read = scanner.nextLine();
//        if (read != null){
//
//            int hour = (int) (Math.random()*23);
//            int minute = (int) (Math.random()*59);
//            int second = (int) (Math.random()*59);
//
//
//            DateTimeFormatter formatter =
//                    DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");
//
//            String time = read + "T"+ String.valueOf(hour) + ":" + String.valueOf(minute) + ":" + String.valueOf(second)+".277+03:00[Europe/Moscow]";
//
////            System.out.println(time);
//
////            ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
//
//            ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-12-16T20:28:33.213+05:30[Asia/Calcutta]", formatter);
////
//            ZonedDateTime zdt = ZonedDateTime.parse(read,DateTimeFormatter.ISO_ZONED_DATE_TIME);
//
//
//            System.out.println(zdt);

//            System.out.println(zonedDateTime);





//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))){
//            try {
//                int i;
//                String tmp = "";
//                while ((i = bis.read()) != -1){
//                    char c = (char) i;
//                    if (c != '\n'){
//                        tmp += String.valueOf(c).replaceAll(" ", "");
//                    }
//                    if (c == '\n') {
//                        System.out.println(tmp);
//                        Movie m = convert(tmp);
//                        list.add(m);
//                        tmp  = "";
//                        System.out.println(list);
//                    }
//                }
//            } catch (ParseException e) {
//                System.out.println("не смогли спарсить");
//            } finally {
//                bis.close();
//            }
//
//        } catch (IOException e) {
//            System.out.println("чот не то считали");
//        }
//
//        return list;
