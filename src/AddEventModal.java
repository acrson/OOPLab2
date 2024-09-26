// Carson Stell

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    private JTextField nameField;
    private JTextField dateTimeField;

    public AddEventModal(EventListPanel eventListPanel) {
        setTitle("Add Event");
        setModal(true);
        setLayout(new GridLayout(3, 2));

        // Event name input
        add(new JLabel("Event Name:"));
        nameField = new JTextField();
        add(nameField);

        // Event date/time input
        add(new JLabel("Date & Time (yyyy-MM-dd HH:mm):"));
        dateTimeField = new JTextField();
        add(dateTimeField);

        // Button to add Deadline
        JButton addDeadlineButton = new JButton("Add Deadline");
        addDeadlineButton.addActionListener(e -> addEvent(eventListPanel, true));
        add(addDeadlineButton);

        // Button to add Meeting
        JButton addMeetingButton = new JButton("Add Meeting");
        addMeetingButton.addActionListener(e -> addEvent(eventListPanel, false));
        add(addMeetingButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void addEvent(EventListPanel eventListPanel, boolean isDeadline) {
        String name = nameField.getText();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeField.getText(), java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        if (isDeadline) {
            eventListPanel.addEvent(new Deadline(name, dateTime));
        } else {
            LocalDateTime endTime = dateTime.plusHours(1);
            eventListPanel.addEvent(new Meeting(name, dateTime, endTime, "Room TBD"));
        }

        dispose();
    }
}