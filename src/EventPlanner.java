// Carson Stell

import java.awt.*;
import javax.swing.*;

public class EventPlanner {
    public static void main(String[] args) {
        // Create a JFrame and add an EventListPanel
        JFrame frame = new JFrame("Event Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EventListPanel eventListPanel = new EventListPanel();
        frame.getContentPane().add(eventListPanel);

        frame.setPreferredSize(new Dimension(800, 800));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);

        // Adds the default events to the event list panel
        eventListPanel.addDefaultEvents();
    }
}
