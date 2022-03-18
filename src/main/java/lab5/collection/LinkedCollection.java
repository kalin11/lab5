package lab5.collection;

import lab5.command.parsing.ObjectParser;
import lab5.entity.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;


public class LinkedCollection {

    private final LinkedList<Movie> list;
    private final Instant initializationTime = Instant.now();


    public LinkedCollection(){
        this.list = new LinkedList<>();
    }

    private Movie movie = null;

    public Movie getMovie(){
        return movie;
    }

    /**
     * this method add Movie object to list
     * @param movie - object which will be added to list
     */

    public void add(Movie movie){
        list.add(movie);
    }

    public String toString(){
        return list.toString();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    /**
     * Get all Movie object Fields and make String from them
     * @return String with all Movie Fields
     */

    public String print(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Movie movie : list){
            sb.append(movie.getId()).append(",")
                    .append(movie.getMovieName()).append(",")
                    .append(movie.getCoordinates()).append(",")
                    .append(movie.getCreationDate()).append(",")
                    .append(movie.getOscarsCount()).append(",")
                    .append(movie.getLength()).append(",")
                    .append(movie.getGenre()).append(",")
                    .append(movie.getMpaaRating()).append(",")
                    .append(movie.getOperator()).append("; ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method is printing first element of this list
     */

    public void printFirstElement(){
        if (list.size() == 0){
            System.out.println("коллекция пустая");
        }
        else {
            System.out.println(list.getFirst());
        }
    }

    /**
     * This method clear list
     */

    public void clear(){
        list.clear();
        System.out.println("коллекция была очищена " + list);
    }

    /**
     * This method save list to File
     * @param path - way to File
     */

    public void save(String path)  {
        if (list.size() == 0){
            try {
                PrintWriter writer = new PrintWriter(path);
                writer.print("");
                writer.close();
            }catch (FileNotFoundException e){
                System.out.println("файла не существует");
                return;
            }
        }
        else {
            try{
                PrintWriter writer = new PrintWriter(path);
                writer.print("");
                writer.close();
            }catch (FileNotFoundException e) {
                System.out.println("у файла нет прав для записи");
                System.out.print("");
                return;
            }
            try{
                for (Movie movie : list) {
                CollectionWriter collectionWriter = new CollectionWriter(movie);
                collectionWriter.writeInFile(path);
            }
            }catch (FileNotFoundException e){
                System.out.println("файл не найден");
            }

        }
        System.out.println("коллекция была сохранена в указаный файл");

    }

    /**
     * This method write list info
     */

    public void info(){
        String info = "Type : " + list.getClass().toString() + "\n"+
                "Size : " + list.size() + "\n" +
                "Initialization time " + initializationTime.toString() + "\n";

        System.out.println(info);
    }

    /**
     * This method count average of length of all movies in list
     */

    public void averageOfLength(){
        Long summ = 0L;
        int count = 0;
        if (list.size() == 0){
            System.out.println("коллекция пустая, добавьте объекты");
        }
        else{
            for (Movie movie : list){
                summ += movie.getLength();
                count += 1;
            }
            System.out.println((double) summ/count);
        }
    }

    /**
     * This method print Movies with Unique Oscars Count
     */

    public void printMoviesWithUniqueOscarsCount(){
        HashSet<Integer> uniqueElements = new HashSet<>();

        if (list.size() == 0){
            System.out.println("коллекция пустая, добавьте объекты");
        }
        else {
            for (Movie movie : list){
                uniqueElements.add(movie.getOscarsCount());
            }
            System.out.println(uniqueElements);
        }
    }

    /**
     * This method update existed movie in list to a new movie
     * @param id - id of movie which you need to update
     * @param movie - Movie object that user has enter
     */

    public void updateElement(long id, Movie movie) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in =  new BufferedReader(isr);
        ObjectParser parser = new ObjectParser();
        LinkedCollection linkedCollection = new LinkedCollection();
            try {
                int index = -1;
                int count = 0;
                for (Movie mov : list) {
                    index++;
                    if (mov.getId() == id) {
                        count++;
                        if (count > 0) {
                            linkedCollection.movie = parser.parseObject(in);
                            linkedCollection.getMovie().setId(id);
                            System.out.println(linkedCollection.getMovie().getId());
                            list.set(index, linkedCollection.getMovie());
                        }
                        System.out.println(list);
                        return;
                    }

                }
                System.out.println("нет фильмов с таким id");
            } catch (NumberFormatException e) {
                System.out.println("неверный формат");
            } catch (IOException e) {
                System.out.println("check");
            }

    }

    /**
     * This method remove movie from list by id
     * @param id - id of movie which you wanna remove
     */

    public void remove(long id){
        if (list.size() == 0){
            System.out.println("коллекция пустая");
        }
        if (list.size() > 0){
            int count = 0;
            try{
            for (Movie movie : list) {
                if (movie.getId() == id) {
                    list.remove(movie);
                    count += 1;
                }
                }
            }
            catch (ConcurrentModificationException e){
                System.out.println();
            }
                if (count == 0){
                    System.out.println("кино с таким id нет");
                }
                else{
                    System.out.println("объекты были удалены");
                    System.out.println(list);
                }
            }

    }

    /**
     * This method counts Movies in list with entered MovieGenre
     * @param genre - Genre of movie
     */

    public void countByGenre(MovieGenre genre) {
        if (list.size() > 0) {
            int count = 0;
            for (Movie movie : list) {
                if (movie.getGenre() == genre) {
                    count += 1;
                }
            }
            System.out.println("фильмов с жанром " + genre + " - " + count);
        }
        else{
            System.out.println("коллекция пустая");
        }
    }

    /**
     * This method remove all movies which oscars count is greater than entered
     * @param movie - entered movie
     */

    public void removeGreater(Movie movie){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in =  new BufferedReader(isr);
        ObjectParser parser = new ObjectParser();
        try{
            Movie mov = parser.parseObject(in);
            list.removeIf(m -> mov.compareTo(m) < 0);
            System.out.println("объекты были удалены");
            System.out.println(list);
        }catch (IOException e){
            System.out.println("что-то не смогли");
        }
    }

    /**
     * This method remove all movies which oscars count is lower than entered
     * @param movie - entered movie
     */

    public void removeLower(Movie movie){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in =  new BufferedReader(isr);
        ObjectParser parser = new ObjectParser();
        try {
            Movie mov = parser.parseObject(in);
            list.removeIf(m -> mov.compareTo(m) > 0);
            System.out.println("объекты были удалены");
            System.out.println(list);
        }catch (IOException e){
            System.out.println("не удалось чот");
        }


    }

    public void removeG(Movie movie){
        list.removeIf(m -> movie.compareTo(m) < 0);
    }

    public void removeL(Movie movie){
        list.removeIf(m -> movie.compareTo(m) > 0);
    }
    public void updateMov(long id, Movie movie) throws ConcurrentModificationException{
        int index = -1;
            for (Movie m : list){
                index++;
                if (m.getId() == id){
                    m.setId(id);
                    m.setName(movie.getMovieName());
                    m.setCoordinates(movie.getCoordinates());
                    m.setCreationDate(movie.getCreationDate());
                    m.setOscarsCount(movie.getOscarsCount());
                    m.setLength(movie.getLength());
                    m.setGenre(movie.getGenre());
                    m.setMpaaRating(movie.getMpaaRating());
                    m.setOperator(movie.getOperator());
                    list.set(index,m);
                }
            }
            System.out.println(list);
    }
}
