
import java.sql.SQLOutput;
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
        Pattern specialCharacter = Pattern.compile("([\\d!@#$%^&*()_+=|<>?{}\\\\/~-])", Pattern.CASE_INSENSITIVE);
        Matcher hasSpecial = specialCharacter.matcher(firstName);
        boolean foundSpecial = hasSpecial.find();

        while (foundSpecial || firstName.length() >= 50) {
            if (foundSpecial) {
                System.out.println("Special Characters and Numbers are not allowed. Try again");
                System.out.print("Enter your First Name: ");
            } else if (firstName.length() >= 50) {
                System.out.println("The Input exceeded the 50 character limit. Try Again");
                System.out.print("Enter your First Name: ");
            }
            firstName = firstInput.nextLine();
            specialCharacter = Pattern.compile("([\\d!@#$%^&*()_+=|<>?{}\\\\/~-])", Pattern.CASE_INSENSITIVE);
            hasSpecial = specialCharacter.matcher(firstName);

            foundSpecial = hasSpecial.find();
        }

        //LAST NAME
        System.out.print("Enter your Last Name: ");
        Scanner secondInput = new Scanner(System.in);
        String lastName = firstInput.nextLine();
        Pattern specialCharLast = Pattern.compile("([\\d!@#$%^&*()_+=|<>?{}\\\\/~-])", Pattern.CASE_INSENSITIVE);
        Matcher hasSpecialLast = specialCharLast.matcher(lastName);
        boolean foundSpecialLast = hasSpecialLast.find();

        while (foundSpecialLast || lastName.length() >= 50) {
            if (foundSpecialLast) {
                System.out.println("Special Characters and Numbers are not allowed. Try again");
                System.out.print("Enter your Last Name: ");
            } else if (lastName.length() >= 50) {
                System.out.println("The Input exceeded the 50 character limit. Try Again");
                System.out.print("Enter your Last Name: ");
            }
            lastName = secondInput.nextLine();
            specialCharLast = Pattern.compile("([\\d!@#$%^&*()_+=|<>?{}\\\\/~-])", Pattern.CASE_INSENSITIVE);
            hasSpecialLast = specialCharLast.matcher(lastName);

            foundSpecialLast = hasSpecialLast.find();
        }

        //BIRTHDAY
        System.out.print("Enter your Birthday in yyyy/MM/dd format: ");
        Scanner thirdInput = new Scanner(System.in);
        String birthday = thirdInput.nextLine();

        LocalDate date = LocalDate.now();
        String stringDate = date.toString();
        String currentYear = stringDate.substring(0, 4);
        int currentNumberYear = Integer.parseInt(currentYear);

        Pattern birthdayPattern = Pattern.compile("^((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$");
        Matcher correctPattern = birthdayPattern.matcher(birthday);
        boolean hasCorrectPattern = correctPattern.find();

        if (birthday.length() == 10) {
            String container = birthday.substring(0, 4);
            int numberYear = Integer.parseInt(container);
            if ((currentNumberYear - numberYear) < 18) {
                System.out.println("Minimum age is 18");
                hasCorrectPattern = correctPattern.find();
            }
        }

        int numberYear = 1800;
        int userAge = currentNumberYear - numberYear;
        String container = "";


        while ((!(hasCorrectPattern)) || userAge < 18) {
            System.out.println("Validation Error. Try again");
            System.out.print("Enter your Birthday in yyyy/MM/dd format: ");
            birthday = thirdInput.nextLine();
            birthdayPattern = Pattern.compile("^((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])$");
            correctPattern = birthdayPattern.matcher(birthday);
            if (birthday.length() == 10) {
                container = birthday.substring(0, 4);
                numberYear = Integer.parseInt(container);
                if ((currentNumberYear - numberYear) < 18) {
                    System.out.println("Minimum accepted age is 18.");
                    hasCorrectPattern = correctPattern.find();
                }
            }
            hasCorrectPattern = correctPattern.find();
        }


        //COURSE
        System.out.print("Enter your Course: ");
        Scanner fourthInput = new Scanner(System.in);
        String course = fourthInput.nextLine();
        Pattern specialCharCourse = Pattern.compile("\\d");
        Matcher courseCorrectPattern = specialCharCourse.matcher(course);
        boolean hasCourseCorrectPattern = courseCorrectPattern.find();

        while (hasCourseCorrectPattern || course.length() >= 50) {
            if (hasCourseCorrectPattern) {
                System.out.println("Number inputs are not allowed. Try again");
                System.out.print("Enter your Course: ");
            } else if (course.length() >= 50) {
                System.out.println("The Input exceeded the 50 character limit. Try Again");
                System.out.print("Enter your Course: ");
            }
            course = fourthInput.nextLine();
            specialCharCourse = Pattern.compile("\\d");
            courseCorrectPattern = specialCharCourse.matcher(course);

            hasCourseCorrectPattern = courseCorrectPattern.find();

        }

        //EMAIL
        System.out.print("Enter your Email:");

        Scanner fifthInput = new Scanner(System.in);
        String email = fifthInput.nextLine();

        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9!#$%&]+@[a-zA-Z0-9.]+$");
        Matcher emailCorrectPattern = emailPattern.matcher(email);

        boolean hasEmailCorrectPattern = emailCorrectPattern.find();

        while (!(hasEmailCorrectPattern)) {
            System.out.println("Invalid email format. Try again");
            System.out.println("Enter your Email: ");
            email = fifthInput.nextLine();
            emailPattern = Pattern.compile("^[a-zA-Z0-9!#$%&]+@[a-zA-Z0-9.]+$");
            emailCorrectPattern = emailPattern.matcher(email);

            hasEmailCorrectPattern = emailCorrectPattern.find();

        }
        System.out.println(stringDate.substring(0,4) + "-" + birthday.substring(5,7)+(0)+(1)+"-"+lastName.substring(0,1).toLowerCase());
    }

}