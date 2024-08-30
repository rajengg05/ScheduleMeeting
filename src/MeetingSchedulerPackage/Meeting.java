package MeetingSchedulerPackage;

import java.util.List;

public class Meeting {
    private String day;
    private String startTime;
    private String endTime;
    private MeetingRoom room;
    private List<Participant> participants;

    public Meeting(String day, String startTime, String endTime, MeetingRoom room, List<Participant> participants) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.participants = participants;
    }

    // Getters for the meeting properties
    public String getDay() { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public MeetingRoom getRoom() { return room; }
    public List<Participant> getParticipants() { return participants; }
}
