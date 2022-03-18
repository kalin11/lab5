package lab5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lab5.collection.CollectionReader;
import lab5.collection.LinkedCollection;
import lab5.command.tasksCommands.ParseFromFile;
import lab5.entity.*;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.*;

public class Tester {
    public LinkedCollection collection;

    public Tester(LinkedCollection c) {
        this.collection = c;
    }

    public static void main(String[] args) throws ParseException {

//        System.out.println(MovieGenre.valueOf("action").getClass());
        Coordinates coordinates = new Coordinates(1, 2);
        Person person = new Person("Jora", ZonedDateTime.now(), 98.9F, Country.INDIA);
        Movie movie = new Movie(1, "Vasya", coordinates, new Date(), 4, 99L, MovieGenre.ACTION, MpaaRating.R, person);
        movie.setGenre(MovieGenre.valueOf("HORROR"));
        System.out.println(movie.getGenre());
//        LinkedCollection collection = new LinkedCollection();
//
//        Tester tester = new Tester(collection);
////        CollectionReader collectionReader = new CollectionReader(collection);
//
//        String filePath = "C:\\Users\\kal1n\\IdeaProjects\\labka5\\laba.txt";
////        collectionReader.uploadCollection(collectionReader.readFromFile(filePath));
//        tester.uploadCollection(tester.readFromFile(filePath));
//        System.out.println(collection);
//        String d = "Fri Mar 11 17:40:57 MSK 2022";
//        SimpleDateFormat format = new SimpleDateFormat();
//        Date date = format.parse(d);
//        System.out.println(date);
//        String test = "1, 2, 3 4,3,1";
//        String[] a = test.split(" ");
////        System.out.println(Arrays.toString(a));
//
//
//    }
//
//    public List<String[]> readFromFile(String filePath) {
//        List<String[]> read = null;
//        String fileName = "C:\\Users\\kal1n\\IdeaProjects\\labka5\\laba.txt";
//        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
//            read = reader.readAll();
//            read.forEach((x) -> {
//                System.out.println(Arrays.toString(x));
//
//            });
////            String x = read.get(0)[1];
////            System.out.println(x);
////            System.out.println(Arrays.toString(read.get(0)));
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }
//        return read;
//
//    }
//    public Movie convert(String[] tmp) throws ParseException {
//        Coordinates coord = new Coordinates(1, 1);
//        Person per = new Person("Gora", ZonedDateTime.now(), 31.8F, Country.INDIA);
//        Movie movie = new Movie(1, "What", coord, new Date(), 32, 32L, MovieGenre.ACTION, MpaaRating.R, per);
//        ParseFromFile parse = new ParseFromFile();
//
//        Coordinates coordinates = new Coordinates(parse.parseX(tmp[2]), parse.parseY(tmp[3]));
//
//        Person person = new Person(parse.parseString(tmp[9]), parse.parseZND(tmp[10]), parse.parseWeight(tmp[11]), parse.parseCountry(tmp[12]));
//
//        movie.setId(parse.parseID(tmp[0]));
//        movie.setName(parse.parseString(tmp[1]));
//        movie.setCoordinates(coordinates);
//        movie.setCreationDate(parse.parseDate(tmp[4]));
//        movie.setOscarsCount(parse.parseOscarsCount(tmp[5]));
//        movie.setLength(parse.parseLength(tmp[6]));
//        movie.setGenre(parse.parseMovieGenre(tmp[7]));
//        movie.setMpaaRating(parse.parseMpaaRating(tmp[8]));
//        movie.setOperator(person);
//
////        System.out.println(movie.getMovieName());
//
//        return movie;
//    }
//
//    public void uploadCollection(List<String[]> res){
//        Coordinates coord = new Coordinates(1,1);
//        Person per = new Person("Gora", ZonedDateTime.now(), 31.8F,Country.INDIA);
//        Movie movie = new Movie(1, "What", coord,new Date(), 32, 32L, MovieGenre.ACTION, MpaaRating.R, per);
////        System.out.println(Arrays.toString(movies));
//        for (int i = 0; i < res.size(); i++){
//            try {
//                String[] movieFields = res.get(i);
//                System.out.println("----------------------");
//                System.out.println(Arrays.toString(movieFields));
//                movie = convert(movieFields);
//
//            } catch (ParseException e) {
//                System.out.println("");
//            }
//            try{
//                collection.add(movie);
//            }catch (NullPointerException e){
//                System.out.println("то");
//            }
//
//        }
//
//    }
    }
}













//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        String strDate = dateFormat.format(date);
//        System.out.println(strDate);
//        String element = "MonJan0100:00:00MSK1900";
//        String year = element.substring(19);
//        System.out.println(year);
//        String month = element.substring(3,6);
//        System.out.println(month);
//        String day = element.substring(6,8);
//        System.out.println(day);
//        String time = element.substring(8,16);
//        System.out.println(time);
//        String dat = year+"-"+day+"-"+"03"+" "+time;
//        System.out.println(dat);
//
//        Date date = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").parse(dat);
//        System.out.println(date);

//        if (element.substring())
//        2022-24-10 06:24:28

//        Thu Mar 10 18:11:38 MSK 2022

//        for (int i = 0; i < args.length; i++){
//            System.out.println(args[i]);
//        }
//        String file = "C:\\Users\\kal1n\\IdeaProjects\\labka5.laba.txt";
//        if (args.length > 0){
//            file = args[1];
//        }
//        System.out.println(args[1]);

//        Date date = new Date();
//        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//        String d = date.toString();
//        System.out.println(format.parse(d));

//        LinkedList<Movie> collection = new LinkedList<Movie>();
//        LinkedList<Movie> movies = new LinkedList<>();
//        CollectionReader collectionReader = new CollectionReader(movies);
//        collectionReader.readFromFile();
//        collectionReader.xz(collectionReader.readFromFile());


//        String[] temp = new String[]{"1,WHAT,3,131,08/20/1973,31,31,DRAMA,G,Vasya,1900-01-10T12:12:12.900+02:30:17[Europe/Moscow],31.0,JAPAN", "2,THE,3,2,05/07/1961,1,2,DRAMA,R,Katya,1930-06-02T12:12:12.900+02:00[Europe/Moscow],45.0,ITALY"};
////        try {
////
////
////            }
////        }
//        for (int i = 0; i < temp.length; i++) {
//            String[] fields = temp[i].split(",");
//            Coordinates coordinates = new Coordinates(1,2);
//            Person person = new Person("Dima", ZonedDateTime.now(), 4.9F, Country.INDIA);
//            Movie movie = new Movie(1, "What", coordinates,new Date(), 32, 32L, MovieGenre.ACTION, MpaaRating.R, person);
////            Movie movie = (Movie) Movie.Default.clone();
//            ParseFromFile parse = new ParseFromFile();
//            Coordinates coordinates1 = new Coordinates(parse.parseX(fields[2]), parse.parseY(fields[3]));
//
//            Person person1 = new Person(parse.parseString(fields[9]), parse.parseZND(fields[10]), parse.parseWeight(fields[11]), parse.parseCountry(fields[12]));
//
//            movie.setId(parse.parseID(fields[0]));
//            movie.setName(parse.parseString(fields[1]));
//            movie.setCoordinates(coordinates1);
//            try {
//                movie.setCreationDate(parse.parseDate(fields[4]));
//            } catch (ParseException e) {
//                System.out.println("da");
//            }
//            movie.setOscarsCount(parse.parseOscarsCount(fields[5]));
//            movie.setLength(parse.parseLength(fields[6]));
//            movie.setGenre(parse.parseMovieGenre(fields[7]));
//            movie.setMpaaRating(parse.parseMpaaRating(fields[8]));
//            movie.setOperator(person1);
//            System.out.println(movie);
//            movies.add(movie);
//        }
//        System.out.println(movies);
//        System.out.println(movies);
//        } catch (ParseException e) {
//            System.out.println("da");
//        }
//        System.out.println(movies);
//        for (String t : temp) {
//            try {
//                movies.addLast(collectionReader.convert(t));
//            } catch (ParseException e) {
//                System.out.println("whay");
//            }

//        }System.out.println(movies);


















//
//        Date startInclusive = new Date("12/12/1908");
//        Date endExclusive = new Date("13/01/2000");
//        System.out.println(endExclusive);
////        randDate();
////        String data = randDate();
////        Date date = new Date(randDate());
////        System.out.println(date);
//            Test t = new Test();
//            String p = t.randDate();
//            System.out.println(p);
//            Date date = new Date(p);
//        System.out.println(date);
//        String txt = "03/03/1900 333";
//        String m = txt.substring(6,10);
//        System.out.println(m);
//        }
//        LinkedList<String> list = new LinkedList<>();
//        String[] mas = new String[]{"1", "Privet", "3"};
//        for (String line : mas) {
//            list.add(line);
//        }
//        System.out.println(list);


//        String fileName = "C:\\Users\\kal1n\\IdeaProjects\\labka5\\laba.csv";
//        ParseFromFile parse = new ParseFromFile();
//
////        LinkedCollection collection = new LinkedCollection();
//        LinkedList<Movie> list = new LinkedList<>();
//        try (CSVReader reader = new CSVReader(new FileReader(fileName))){
//            List<String[]> read = reader.readAll();
//            Movie movie = Movie.Default;
//
//            System.out.println(read);
//
//            for (int i = 0; i < read.size(); i ++){
//                System.out.println(Arrays.toString(read.get(i)));
//                String[] x = read.get(i);
//                Coordinates coordinates = new Coordinates(parse.parseX(x[2]), parse.parseY(x[3]));
//
//                Person person = new Person(parse.parseString(x[9]), parse.parseZND(x[10]), parse.parseWeight(x[11]), parse.parseCountry(x[12]));
//
//                movie.setId(parse.parseID(x[0]));
//                movie.setName(parse.parseString(x[1]));
//                movie.setCoordinates(coordinates);
//                try {
//                    movie.setCreationDate(parse.parseDate(x[4]));
//                } catch (ParseException e) {
//                    System.out.println("something went wrong");
//                }
//                movie.setOscarsCount(parse.parseOscarsCount(x[5]));
//                movie.setLength(parse.parseLength(x[6]));
//                movie.setGenre(parse.parseMovieGenre(x[7]));
//                movie.setMpaaRating(parse.parseMpaaRating(x[8]));
//                movie.setOperator(person);
//
//                System.out.println(movie);
//
//                list.add(movie);
//            }
//            System.out.println(list);

//
//            read.forEach((x) -> {
//                System.out.println(Arrays.toString(x));
//                Movie movie = Movie.Default;
//
//                Coordinates coordinates = new Coordinates(parse.parseX(x[2]), parse.parseY(x[3]));
//
//                Person person = new Person(parse.parseString(x[9]), parse.parseZND(x[10]), parse.parseWeight(x[11]), parse.parseCountry(x[12]));
//
//                movie.setId(parse.parseID(x[0]));
//                movie.setName(parse.parseString(x[1]));
//                movie.setCoordinates(coordinates);
//                try {
//                    movie.setCreationDate(parse.parseDate(x[4]));
//                } catch (ParseException e) {
//                    System.out.println("something went wrong");
//                }
//                movie.setOscarsCount(parse.parseOscarsCount(x[5]));
//                movie.setLength(parse.parseLength(x[6]));
//                movie.setGenre(parse.parseMovieGenre(x[7]));
//                movie.setMpaaRating(parse.parseMpaaRating(x[8]));
//                movie.setOperator(person);
//
//                list.add(movie);
//
//                System.out.println(movie);



//                System.out.println(x[1]);
//            });
//            System.out.println(Arrays.toString(read.get(0)));
//            System.out.println(list);
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }

//        HashSet<String> set = new HashSet<>();
//        String xx  = "ito";
//        set.add(xx);
//        Files.readAllLines();
//
//        System.out.println(set.remove(xx));
//
//        System.out.println(set);


//class Test{
//    public String randDate(){
//        int year = (int) (Math.random() * 50) + 1950 ;
////            System.out.println(year);
//        int[] a = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
//        int g = (int) (Math.random()*12);
//        String month = "";
//        if (fields[g] > 9){
//            month = String.valueOf(fields[g]);
//        }
//        else{
//            month = "0"+String.valueOf(fields[g]);
//        }
////            System.out.println(month);
//        int[] b = new int[31];
//        int p = 1;
//        for (int z = 0; z < b.length; z++){
//            b[z] = p;
//            p++;
//        }
//        String day ="";
//        int e = (int) (Math.random()*31);
//        if (b[e] > 9){
//            day = String.valueOf(b[e]);
//        }
//        else{
//            day = "0"+String.valueOf(b[e]);
//        }
//
//        return (month+"/"+day+"/"+year);
//
//}}

