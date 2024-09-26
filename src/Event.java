import java.time.*;

public abstract class Event implements Comparable<Event> {
    String name; // Name of the event.
    LocalDateTime dateTime; // The time and date the event starts.

    // Constructor for Event
    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    // Abstract method that returns the name
    public String getName() {
        return name;
    }

    // Method that returns the dateTime
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Sets the dateTime
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Sets the name of the Event
    public void setName(String name) {
        this.name = name;
    }

    // Compares the date of this Event to the incoming event and returns a positive int if this event
    // comes later, a negative int if this event comes before, and 0 if the two have the same dateTime.
    public int compareTo(Event e) {
        return this.getDateTime().compareTo(e.getDateTime());
    }
}
