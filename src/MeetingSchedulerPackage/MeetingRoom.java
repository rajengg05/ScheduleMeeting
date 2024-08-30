package MeetingSchedulerPackage;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String roomName;
    private List<Meeting> scheduledMeetings;

    public MeetingRoom(String roomName) {
        this.roomName = roomName;
        this.scheduledMeetings = new ArrayList<>();
    }

    public String getRoomName() { return roomName; }
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

