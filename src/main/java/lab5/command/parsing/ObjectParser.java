package lab5.command.parsing;

import lab5.command.tasksCommands.ParseFromConsole;
import lab5.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class ObjectParser {

    public Movie parseObject(BufferedReader in) throws IOException {
        ParseFromConsole process = new ParseFromConsole();

//        String date = ParseFromConsole.resRandDate;

        Long id = process.randomID();

//        System.out.println("id of movie is " + id);
//
        String name = process.processString("Введите название фильма ", in);

        int x = process.processIntWithoutLimits("Введите Х координату ", in);

        int y = process.processIntY("Введите Y координату ", in);

        Date date = Calendar.getInstance().getTime();

        System.out.println("Фильм был создан : " + date);

        int oscarCount = process.processInt("Введите число оскаров ", in);

        Long length = process.processLong("Введите длину ", in);

        Country country = process.processCountry("Введите страну ", in);
//
        MpaaRating mpaaRating = process.processRating("Введите рейтинг ", in);

        MovieGenre movieGenre = process.processGenre("Введите жанр ", in);
//
        String personName = process.processStringForName("Введите имя оператора ", in);

        Float personWeight = process.processFloat("Введите вес операвтора ", in);

        System.out.println("---------------------------");
        ZonedDateTime zonedDateTime1 = process.processZND("Введите дату ", in);

        Coordinates coordinates = new Coordinates(x, y);

        Person operator = new Person(personName, zonedDateTime1, personWeight, country);

        return new Movie(id,
                        name,
                        coordinates,
                        date,
                        oscarCount,
                        length,
                        movieGenre,
                        mpaaRating,
                        operator);
    }

}
