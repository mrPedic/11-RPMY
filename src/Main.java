import java.util.Locale;
import exercise_1.Exercise;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввести значение сам/рандомно выбрать? (сам/рандом): ");
        System.out.print(">>>");
        String vibor = scanner.next().toLowerCase(Locale.ROOT);

        switch (vibor){
            case "сам":{

                System.out.print("Тогда вводите значение : ");
                double x = scanner.nextDouble();

                Exercise exercise = new Exercise(x);
                System.out.println(exercise.SolveTheEquation());

                break;
            }
            case "рандом":{

                System.out.print("Тогда введите верхний предел случайного числа : ");
                double numberMax = scanner.nextDouble();
                System.out.print("Введите нижний предел случайного числа :");
                double numberMin = scanner.nextDouble();

                Random random = new Random();
                double x = random.nextDouble() * (numberMax - numberMin) + numberMin;
                System.out.println("Выбранное случайного число : "+ x);

                Exercise exercise = new Exercise(x);
                System.out.println(exercise.SolveTheEquation());

                break;
            }
            default:{
                System.out.println("Введено не правильное значение : " + vibor + ". Попытайтесь снова");
            }
        }

    }
}