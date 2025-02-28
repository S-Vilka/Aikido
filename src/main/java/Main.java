import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PracticeTracker trackerAikido = new PracticeTracker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Aikido Practice Tracker =====");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) {
                System.out.println("Exiting the program!");
                sc.close();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter the date of practice session (YYYY-MM-DD): ");
                    String dateInput = sc.nextLine();

                    System.out.println("Enter session duration in minutes: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a number.");
                        sc.next();
                        break;
                    }

                    int duration = sc.nextInt();
                    sc.nextLine();

                    LocalDate date;
                    try {
                        date = LocalDate.parse(dateInput);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format! Please use YYYY-MM-DD.");
                        break;
                    }

                    Session newSession = new Session(date, duration);
                    trackerAikido.addSession(newSession);
                    System.out.println("Practice session added");
                    break;

                case 2:
                    System.out.println("Total practice sessions: " + trackerAikido.getTotalSessionCount());
                    System.out.println("Total practice time: " + trackerAikido.getTotalPracticeTime() + " minutes");
                    break;

                case 3:
                    int totalSessions = trackerAikido.getTotalSessionCount();
                    int sessionsLeft = Math.max(100 - totalSessions, 0);

                    if (trackerAikido.isEligibleForGraduation()) {
                        System.out.println("You are eligible for Kyu graduation.");
                    } else {
                        System.out.println("You are not ready yet!");
                        System.out.println("Sessions needed for eligibility: " + sessionsLeft);
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}