// Carson Stell

import java.time.*;

public class Deadline extends Event implements Completable {
    boolean complete; // Holds a Boolean representing whether the task this deadline tracks is complete

    // Constructor
    Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        this.complete = false;
    }

    // Sets the complete boolean to true
    public void complete() {
        complete = true;
    }

    // Returns the complete boolean
    public boolean isComplete() {
        return complete;
    }
}
