package MeetingSchedulerPackage;

import java.util.List;

public class Scheduler {
    public boolean canScheduleMeeting(Meeting meeting) {
        MeetingRoom room = meeting.getRoom();
        if (!room.isAvailable(meeting.getDay(), meeting.getStartTime(), meeting.getEndTime())) {
            return false;
        }

        for (Participant participant : meeting.getParticipants()) {
            if (!participant.isAvailable(meeting.getDay(), meeting.getStartTime(), meeting.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    public void scheduleMeeting(Meeting meeting) {
        MeetingRoom room = meeting.getRoom();
        room.scheduleMeeting(meeting);

        for (Participant participant : meeting.getParticipants()) {
            participant.scheduleMeeting(meeting);
        }
    }
}
