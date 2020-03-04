package bookLibrary.gui;

import java.beans.PropertyChangeSupport;

public class BookLibraryModel {
    private final PropertyChangeSupport propertyChangeSupport;

    BookLibraryModel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }
}
