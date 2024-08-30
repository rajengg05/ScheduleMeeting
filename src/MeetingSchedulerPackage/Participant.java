package MeetingSchedulerPackage;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private String name;
    private List<Meeting> scheduledMeetings;

    public Participant(String name) {
        this.name = name;
        this.scheduledMeetings = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Meeting> getScheduledMeetings() { return scheduledMeetings; }

    public boolean isAvailable(String day, String startTime, String endTime) {
        for (Meeting meeting : scheduledMeetings) {
            if (meeting.getDay().equals(day) && !timesDoNotOverlap(meeting.getStartTime(), meeting.getEndTime(), startTime, endTime)) {
                return false;
            }
        }
        return true;
    }

    public void scheduleMeeting(Meeting meeting) {
        scheduledMeetings.add(meeting);
    }

    private boolean timesDoNotOverlap(String existingStart, String existingEnd, String newStart, String newEnd) {
        return existingEnd.compareTo(newStart) <= 0 || newEnd.compareTo(existingStart) <= 0;
    }
}

