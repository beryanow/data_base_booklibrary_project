package bookLibrary;

import bookLibrary.gui.BookLibraryController;
import bookLibrary.hibernate.*;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                BookLibraryController bookLibraryController = new BookLibraryController();
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
