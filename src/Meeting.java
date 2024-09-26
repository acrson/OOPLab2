import java.time.*;

public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime; // The time the meeting is over
    private String location; // Represents the location of the event
    private boolean complete; // Holds a Boolean representing whether the task this deadline tracks is complete

    // Constructor
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.endDateTime = end;
        this.location = location;
    }

    // Sets the complete boolean to true
    public void complete() {
        complete = true;
    }

    // Returns the complete boolean
    public boolean isComplete() {
        return complete;
    }

    // Returns the endDateTime
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    // Returns the duration of the meeting, (dateTime - endDateTime)
    public Duration getDuration() {
        return Duration.between(dateTime, endDateTime);
    }

    // Returns the location of the meeting
    public String getLocation() {
        return location;
    }

    // Sets the end of the meeting
    public void setEndDateTime(LocalDateTime end) {
        endDateTime = end;
    }

    // Sets the location of the meeting
    void setLocation(String location) {
        this.location = location;
    }
}
