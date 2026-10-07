package InterviewCoding;
import java.time.LocalDate;
import java.time.Period;

public class Coding4 {
    public static void main(String[] args) {
        // Write a Java Program to find the age of a person in years
        // if the birthday has given?
        LocalDate birthDate = LocalDate.parse("1993-02-05");
        LocalDate currentDate = LocalDate.now();

         Period period = Period.between(birthDate, currentDate);
        System.out.println("You are " + period.getYears() + " years, " + period.getMonths() + " months and " + period.getDays() + " days Old.");
    }
}

