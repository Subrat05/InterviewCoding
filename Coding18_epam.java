package InterviewCoding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Trainer {
    List<String> skills;
    boolean certified;

    Trainer(List<String> skills, boolean certified) {
        this.certified = certified;
        this.skills = skills;
    }
}

public class Coding18_epam {

    // Write a java program, Return one comma separated string containing the skills
    // taught by the certified trainers, include each skill grace and sort the skills
    //alphabetically, assume the trainers and skills values are not null.
    public static String getCertifiedSkills(List<Trainer> trainers) {

        return trainers.stream()
                .filter(x -> x.certified)
                .flatMap(s -> s.skills.stream())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    };

    public static void main(String[] args) {
        List<Trainer> trainers  = Arrays.asList(
                new Trainer(Arrays.asList("Java", "SQL"), true),
                new Trainer(Arrays.asList("Python", "Java"), false),
                new Trainer(Arrays.asList("UI","Springboot", "Java"), true)
        );

        System.out.println(getCertifiedSkills(trainers));
    }
}
