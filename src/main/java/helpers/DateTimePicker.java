package helpers;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateTimePicker extends JPanel {

    private JDateChooser dateChooser;
    private JSpinner timeSpinner;

    public DateTimePicker() {
        setLayout(new FlowLayout());

        // Date Picker
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date()); // Default to today

        // Time Picker (HH:mm)
        SpinnerDateModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // Default to current time

        // Add components
        add(new JLabel("Select Date:"));
        add(dateChooser);
        add(new JLabel("Select Time:"));
        add(timeSpinner);
    }

    public LocalDateTime getSelectedDateTime() {
        Date selectedDate = dateChooser.getDate();
        Date selectedTime = (Date) timeSpinner.getValue();

        if (selectedDate == null || selectedTime == null) {
            return null;
        }

        // Merge Date and Time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTime(selectedTime);

        // Set time from timeSpinner
        calendar.set(Calendar.HOUR_OF_DAY, timeCalendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, timeCalendar.get(Calendar.MINUTE));

        // Convert to LocalDateTime
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
