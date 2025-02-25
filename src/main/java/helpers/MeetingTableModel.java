package helpers;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.stream.Collectors;
import models.Meeting;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeetingTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Topic", "Duration", "Date Time", "Attended Students"};
    private List<Meeting> meetings;

    // DateTimeFormatter for parsing and formatting
    private static final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
    private static final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public MeetingTableModel(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public int getRowCount() {
        return meetings.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Meeting meeting = meetings.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return meeting.getTopic();  // Topic
            case 1:
                return meeting.getDuration() + " minutes";  // Duration
            case 2:
                // Parse and format the DateTime
                try {
                LocalDateTime dateTime = LocalDateTime.parse(meeting.getDateTime(), inputFormatter);
                return dateTime.format(outputFormatter);  // Formatted DateTime
            } catch (Exception e) {
                return meeting.getDateTime(); // Fallback: return original string if parsing fails
            }
            case 3:
                // Get Admitted Students' usernames as a comma-separated string
                return meeting.getAdmittedStudents()
                        .stream()
                        .map(student -> student.getUsername())
                        .collect(Collectors.joining(", "));
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
