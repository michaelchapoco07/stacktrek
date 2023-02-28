
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //First Name
        System.out.print("Enter your First Name: ");

        Scanner firstInput = new Scanner(System.in);
        String firstName = firstInput.nextLine();

        Pattern specialCharacter = Pattern.compile("([\\d!@#$%^&*()_+=|<>?{}\\\\/~-])");
        Matcher hasSpecial = specialCharacter.matcher(firstName);

        boolean foundSpecial = hasSpecial.find();

        if(foundSpecial){
            System.out.println("Has Special Characters");
            System.exit(0);
        } else if (firstName.length()>=50) {
            System.out.println("First name has a limit of 50 Characters");
            System.exit(0);
        } else {
            System.out.println("Valid First Name");
        }

        //Last Name
        System.out.print("Enter your Last Name: ");

        Scanner secondInput = new Scanner(System.in);
        String lastName = secondInput.nextLine();

        Pattern lastNameSpecialCharacter = Pattern.compile("([\\d!@#$%^&*()_+=|<>?{}\\\\/~-])");
        Matcher lastNameHasSpecial = lastNameSpecialCharacter.matcher(lastName);

        boolean lastNameFoundSpecial = lastNameHasSpecial.find();

        if(lastNameFoundSpecial){
            System.out.println("Has Special Characters");
            System.exit(0);

        } else if (lastName.length()>=50) {
            System.out.println("First name has a limit of 50 Characters");
            System.exit(0);
        } else {
            System.out.println("Valid last name");
        }

        //Birthday
        System.out.print("Enter your Birthday in yyyy/MM/dd format: ");

        Scanner thirdInput = new Scanner(System.in);
        String birthday = thirdInput.nextLine();

        Pattern birthdayPattern = Pattern.compile("^((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$");
        Matcher correctPattern = birthdayPattern.matcher(birthday);

        boolean hasCorrectPattern = correctPattern.find();

        if(hasCorrectPattern){
            System.out.println("Valid Birthday");
        } else {
            System.out.println("Not a valid Format/Birthday");
            System.exit(0);
        }

        //Course
        System.out.print("Enter your Course: ");

        Scanner fourthInput = new Scanner(System.in);
        String course = fourthInput.nextLine();

        Pattern coursePattern = Pattern.compile("\\d");
        Matcher courseCorrectPattern = coursePattern.matcher(course);

        boolean hasCourseCorrectPattern = courseCorrectPattern.find();

        if(hasCourseCorrectPattern){
            System.out.println("Has Numbers");
            System.exit(0);

        } else if (course.length()>=50) {
            System.out.println("Course has a limit of 50 Characters");
            System.exit(0);
        } else {
            System.out.println("Valid Course");
        }

        //Email
        System.out.print("Enter your Email anonymous@gmail.com: ");

        Scanner fifthInput = new Scanner(System.in);
        String email = fifthInput.nextLine();

        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9!#$%&]+@[a-zA-Z0-9.]+$");
        Matcher emailCorrectPattern = emailPattern.matcher(email);

        boolean hasEmailCorrectPattern = emailCorrectPattern.find();

        if(hasEmailCorrectPattern){
            System.out.println("Valid Email");
        }  else {
            System.out.println("Not a valid format");
        }

        LocalDate date = LocalDate.now();
        String stringDate = date.toString();
        System.out.println(stringDate);
        System.out.println(stringDate.substring(0,4) + "-" + birthday.substring(5,7)+(0)+(1)+"-"+lastName.substring(0,1));

    }
}