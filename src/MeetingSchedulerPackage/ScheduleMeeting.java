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
            System.out.println("Enter day:");
            String day = scanner.nextLine();
            while (!Validations.isValidDay(day)) {
                System.out.println("Invalid day. Please enter a valid day of the week:");
                day = scanner.nextLine();
            }

            System.out.println("Enter start time:");
            String startTime = scanner.nextLine();
            while (!Validations.isValidTime(startTime)) {
                System.out.println("Invalid start time. Please enter time in HH:mm format:");
                startTime = scanner.nextLine();
            }

            System.out.println("Enter end time:");
            String endTime = scanner.nextLine();
            while (!Validations.isValidTime(endTime)) {
                System.out.println("Invalid end time. Please enter time in HH:mm format:");
                endTime = scanner.nextLine();
            }

            // Validate time range
            while (!Validations.isValidTimeRange(startTime, endTime)) {
                System.out.println("End time must be after start time. Please re-enter times:");

                System.out.print("Enter start time (HH:mm): ");
                startTime = scanner.nextLine();
                while (!Validations.isValidTime(startTime)) {
                    System.out.println("Invalid start time. Please enter time in HH:mm format:");
                    startTime = scanner.nextLine();
                }

                System.out.print("Enter end time (HH:mm): ");
                endTime = scanner.nextLine();
                while (!Validations.isValidTime(endTime)) {
                    System.out.println("Invalid end time. Please enter time in HH:mm format:");
                    endTime = scanner.nextLine();
                }
            }
            System.out.println("Enter room number:");
            String roomNumber = scanner.nextLine();
            while(!Validations.isValidRoomNumber(roomNumber)){
                System.out.println("Invalid room number. Room numbers must be integer.Please enter room number:");
                roomNumber = scanner.nextLine();
            }
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

