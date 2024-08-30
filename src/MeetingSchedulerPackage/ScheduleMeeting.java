package MeetingSchedulerPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleMeeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       //commented code is for the extensibility and more useful version of code
        Participant alice = new Participant("Alice");
        Participant bob = new Participant("Bob");

        List<Participant> participants = new ArrayList<>();
        participants.add(alice);
        participants.add(bob);
        while(true) {
            //Validations must also be added to check the inputs. Due to time constraint, couldn't add.
            System.out.println("Enter day:");
            String day = scanner.nextLine();

            System.out.println("Enter start time:");
            String startTime = scanner.nextLine();

            System.out.println("Enter end time:");
            String endTime = scanner.nextLine();

            System.out.println("Enter room number:");
            String roomNumber = scanner.nextLine();
            MeetingRoom room = new MeetingRoom("Room"+roomNumber);
            Meeting meeting = new Meeting(day, startTime, endTime, room, participants);

            Scheduler scheduler = new Scheduler();
            if (scheduler.canScheduleMeeting(meeting)) {
                scheduler.scheduleMeeting(meeting);
                System.out.println("Meeting scheduled successfully.");
                //we can add option here to send emails to all the participants
            } else {
                System.out.println("Meeting cannot be scheduled due to conflicts.");
                //here instead of just showing message we can show conflicting times of participants or rooms
            }
            System.out.println("Do you want to schedule another meeting? (yes/no):");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}

