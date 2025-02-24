package helpers;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateTimePicker extends JPanel {

    private JDateChooser dateChooser;
    private JSpinner timeSpinner;

    public DateTimePicker() {
        // Set layout for two-line display
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Create components
        JLabel dateLabel = new JLabel("Select Date:");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
        dateChooser.setMinSelectableDate(new Date()); // Prevent past dates

        JLabel timeLabel = new JLabel("Select Time:");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        SpinnerDateModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setFont(new Font("Arial", Font.PLAIN, 18));
        timeSpinner.setValue(new Date()); // Default to current time

        // Add components in two rows
        gbc.gridy = 0;
        add(dateLabel, gbc);
        gbc.gridy = 1;
        add(dateChooser, gbc);
        gbc.gridy = 2;
        add(timeLabel, gbc);
        gbc.gridy = 3;
        add(timeSpinner, gbc);

        // Add validation to prevent past times when today is selected
        dateChooser.getDateEditor().addPropertyChangeListener(evt -> validateTimeSelection());
        timeSpinner.addChangeListener(e -> validateTimeSelection());
    }

    private void validateTimeSelection() {
        Date selectedDate = dateChooser.getDate();
        Date selectedTime = (Date) timeSpinner.getValue();
        Calendar now = Calendar.getInstance();

        if (selectedDate != null) {
            Calendar selectedCal = Calendar.getInstance();
            selectedCal.setTime(selectedDate);

            // If the user selects today, ensure time is in the future
            if (isSameDay(selectedCal, now)) {
                Calendar timeCal = Calendar.getInstance();
                timeCal.setTime(selectedTime);

                // If selected time is before now, reset to current time
                if (timeCal.before(now)) {
                    timeSpinner.setValue(now.getTime());
                }
            }
        }
    }

    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public LocalDateTime getSelectedDateTime() {
        Date selectedDate = dateChooser.getDate();
        Date selectedTime = (Date) timeSpinner.getValue();
        if (selectedDate == null || selectedTime == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTime(selectedTime);
        calendar.set(Calendar.HOUR_OF_DAY, timeCalendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, timeCalendar.get(Calendar.MINUTE));

        return DateUtils.convertDateToLocalDateTime(calendar.getTime());
    }

    public void setSelectedDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return;
        }
        dateChooser.setDate(DateUtils.convertLocalDateTimeToDate(dateTime));
        timeSpinner.setValue(DateUtils.convertLocalDateTimeToDate(dateTime));
    }
}
