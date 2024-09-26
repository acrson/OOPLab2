// Carson Stell

import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    Event event; // The event this panel displays
    JButton completeButton; // Button to complete the event

    public EventPanel(Event event) {
        this.event = event;

        // Set layout and background color
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Display event information
        JLabel nameLabel = new JLabel("Name: " + event.getName());
        JLabel dateTimeLabel = new JLabel("Date & Time: " + event.getDateTime());
        add(nameLabel, BorderLayout.NORTH);
        add(dateTimeLabel, BorderLayout.CENTER);

        // If event is Completable, show complete button
        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener(e -> {
                ((Completable) event).complete();
                updateCompletionStatus();
            });
            add(completeButton, BorderLayout.SOUTH);
        }
    }

    // Updates the completion status of a meeting or deadline
    public void updateCompletionStatus() {
        if (event instanceof Completable && ((Completable) event).isComplete()) {
            setBackground(Color.GREEN); // Change color, indicates completion
            completeButton.setEnabled(false); // Disable button when completed
        }
    }
}