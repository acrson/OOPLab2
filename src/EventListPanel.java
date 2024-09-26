// Carson Stell

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.*;

public class EventListPanel extends JPanel {
    ArrayList<Event> events; // A list of the events to be listed
    JPanel controlPanel; // Holds the controls for the event display
    JPanel displayPanel; // A panel to hold the EventPanels corresponding to the events.

    // A drop down that will sort the events in the list by name, date, or by the same qualities but in reverse order.
    JComboBox<String> sortDropDown;

    // A set of checkboxes that allow the user to filter displayed events
    JCheckBox filterComplete;
    JCheckBox filterDeadlines;
    JCheckBox filterMeetings;

    // a button that opens an AddEventModal.
    JButton addEventButton;

    public EventListPanel() {
        setPreferredSize(new Dimension(750, 500));
        setBackground(Color.GREEN);
        events = new ArrayList<>();

        // Control Panel
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Sort Drop-Down
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date"});
        controlPanel.add(sortDropDown);

        // Filter Checkboxes
        filterComplete = new JCheckBox("Show Complete");
        filterDeadlines = new JCheckBox("Show Deadlines");
        filterMeetings = new JCheckBox("Show Meetings");
        controlPanel.add(filterComplete);
        controlPanel.add(filterDeadlines);
        controlPanel.add(filterMeetings);

        // Adds the event button
        addEventButton = new JButton("Add Event");
        controlPanel.add(addEventButton);

        // display panel
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        // Add panels to main panel
        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        // Action for Add Event Button
        addEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the AddEventModal when clicked
                new AddEventModal(EventListPanel.this).setVisible(true);
            }
        });

        filterComplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // I was going to implement this but ran out of time :(
            }
        });
    }

    public void addDefaultEvents() {
        // Creates default events with default names, times, and locations that are to be added to display
        Deadline deadline = new Deadline("REALLY Important Deadline", LocalDateTime.now().plusDays(1));
        Meeting meeting = new Meeting("REALLY Important Meeting", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(1), "Interesting Location");

        addEvent(deadline);
        addEvent(meeting);
    }

    // Adds the display panel , ensuring it is repainted and revalidated
    public void addEvent(Event event) {
        events.add(event);
        EventPanel eventPanel = new EventPanel(event);
        displayPanel.add(eventPanel);
        displayPanel.repaint();
        displayPanel.revalidate();
    }
}