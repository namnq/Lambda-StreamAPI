package ntqjteam.lambdastreamapi.excercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by toan on 3/1/17.
 */
public class ProgrammerCategorizing {

    public static void main(String[] args) {

        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer("1", "division 1", "team Java", Programmer.Gender.MALE, "Programmer 1"));
        programmers.add(new Programmer("2", "division 2", "team Java", Programmer.Gender.MALE, "Programmer 2"));
        programmers.add(new Programmer("3", "division 1", "team Java", Programmer.Gender.FEMALE, "Programmer 3"));
        programmers.add(new Programmer("4", "division 1", "team Java", Programmer.Gender.MALE, "Programmer 4"));
        programmers.add(new Programmer("5", "division 3", "team Java", Programmer.Gender.FEMALE, "Programmer 5"));
        programmers.add(new Programmer("6", "division 2", "team PHP", Programmer.Gender.FEMALE, "Programmer 6"));
        programmers.add(new Programmer("7", "division 1", "team PHP", Programmer.Gender.MALE, "Programmer 7"));
        programmers.add(new Programmer("8", "division 3", "team PHP", Programmer.Gender.MALE, "Programmer 8"));
        programmers.add(new Programmer("9", "division 2", "team JS", Programmer.Gender.FEMALE, "Programmer 9"));
        programmers.add(new Programmer("10", "division 2", "team JS", Programmer.Gender.MALE, "Programmer 10"));

        Map<String, List<Programmer>> programmersByDiv = programmers.stream()
                .collect(Collectors.groupingBy(Programmer::getDivision));
        programmers.stream().collect(Collectors.groupingBy(Programmer::getDivision,
                Collectors.groupingBy(Programmer::getTeam, Collectors.groupingBy(Programmer::getName))));
    }
}
