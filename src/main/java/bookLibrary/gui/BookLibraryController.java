package bookLibrary.gui;

import bookLibrary.hibernate.BookEntity;
import bookLibrary.hibernate.BookEntityDao;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class BookLibraryController {
    BookLibraryWindow bookLibraryWindow;

    void createBookLibraryWindow() {
        bookLibraryWindow = new BookLibraryWindow();
    }

    public BookLibraryController() {
        createBookLibraryWindow();
        bookLibraryWindow.startBookLibraryWindow();
    }

    public JFrame getWindow() {
        return bookLibraryWindow;
    }
}
