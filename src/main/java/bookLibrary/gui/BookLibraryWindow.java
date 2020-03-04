package bookLibrary.gui;

import bookLibrary.hibernate.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
import java.util.List;

class GraphDrawer extends JPanel {
    int[] x;
    int[] y;
    int n;

    GraphDrawer(int[] x, int y[], int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D) gh;

        drp.setStroke(new BasicStroke(2));
        drp.setColor(new Color(44, 102, 230, 180));
        drp.drawPolyline(x, y, n);

        drp.setColor(Color.RED);
        for (int i = 0; i < n; i++) {
            drp.fillOval(x[i] - 3, y[i] - 3, 7, 7);
        }
    }
}

class BookEntityRenderer extends JLabel implements ListCellRenderer<BookEntity> {
    BookEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookEntity> list, BookEntity book, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + book.getName() + ".jpg"));
            setIcon(imageIcon);
        } catch (Exception ignored) {}

        setPreferredSize(new Dimension(270, 70));
        try {
            setText(" " + book.getAuthorByAuthorId().getName() + " -> " + book.getName());
        } catch (Exception ignored) {}
        return this;
    }
}

class BookToReadSectionEntityRenderer extends JLabel implements ListCellRenderer<BookToReadSectionEntity> {
    BookToReadSectionEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookToReadSectionEntity> list, BookToReadSectionEntity bookToRead, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + bookToRead.getBookByBookId().getName() + ".jpg"));
        setIcon(imageIcon);

        setPreferredSize(new Dimension(330, 70));
        setText(" " + bookToRead.getBookByBookId().getAuthorByAuthorId().getName() + " -> " + bookToRead.getBookByBookId().getName());
        return this;
    }
}

class QuoteEntityRenderer extends JTextArea implements ListCellRenderer<QuoteEntity> {
    QuoteEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends QuoteEntity> list, QuoteEntity quote, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setPreferredSize(new Dimension(330, 70));
        setText(" " + quote.getContent());
        return this;
    }
}

class BookReadingSectionEntityRenderer extends JLabel implements ListCellRenderer<BookReadingSectionEntity> {
    BookReadingSectionEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookReadingSectionEntity> list, BookReadingSectionEntity bookReading, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + bookReading.getBookByBookId().getName() + ".jpg"));
        setIcon(imageIcon);

        setPreferredSize(new Dimension(330, 70));
        setText(" " + bookReading.getBookByBookId().getAuthorByAuthorId().getName() + " -> " + bookReading.getBookByBookId().getName());
        return this;
    }
}

class BookReadSectionEntityRenderer extends JLabel implements ListCellRenderer<BookReadSectionEntity> {
    BookReadSectionEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookReadSectionEntity> list, BookReadSectionEntity bookRead, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + bookRead.getBookByBookId().getName() + ".jpg"));
        setIcon(imageIcon);

        setPreferredSize(new Dimension(330, 70));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        setText(" " + bookRead.getBookByBookId().getAuthorByAuthorId().getName() + " -> " + bookRead.getBookByBookId().getName() + " -> " + sdf.format(bookRead.getDateOfCompletion()));
        return this;
    }
}

class BookReadThisMonthSectionEntityRenderer extends JLabel implements ListCellRenderer<BookReadSectionEntity> {
    BookReadThisMonthSectionEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookReadSectionEntity> list, BookReadSectionEntity bookRead, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + bookRead.getBookByBookId().getName() + ".jpg"));
        setIcon(imageIcon);

        setPreferredSize(new Dimension(250, 70));
        setText(" " + bookRead.getBookByBookId().getAuthorByAuthorId().getName() + " -> " + bookRead.getBookByBookId().getName());
        return this;
    }
}

class FavouritesEntityRenderer extends JLabel implements ListCellRenderer<FavouritesEntity> {
    FavouritesEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends FavouritesEntity> list, FavouritesEntity favouritesEntity, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + favouritesEntity.getBookByBookId().getName() + ".jpg"));
        setIcon(imageIcon);

        setPreferredSize(new Dimension(250, 70));
        setText(" " + favouritesEntity.getBookByBookId().getAuthorByAuthorId().getName() + " -> " + favouritesEntity.getBookByBookId().getName());
        return this;
    }
}

public class BookLibraryWindow extends JFrame {
    private JFrame gameFrame;

    private JList<BookEntity> bookList;
    private JList<BookToReadSectionEntity> bookToReadList;
    private JList<BookReadingSectionEntity> bookReadingList;
    private JList<BookReadSectionEntity> bookReadList;
    private JList<BookReadSectionEntity> bookReadThisMonthList;
    private JList<FavouritesEntity> favouritesList;
    private JList<QuoteEntity> quoteList;

    private JPanel bookPanel;
    private JPanel addBookPanel;
    private JPanel selectedBookPanel;
    private JPanel myBookSectionPanel;
    private JPanel bookToReadSectionPanel;
    private JPanel bookReadingSectionPanel;
    private JPanel bookReadSectionPanel;
    private JPanel quotePanel;
    private JPanel buttonsReadPanel;
    private JPanel myStatsPanel;
    private JPanel favouritesPanel;
    private JPanel currentMonthReadPanel;
    private JPanel currentMonthReadGraphPanel;
    private JPanel authorCheckBoxesPanel;
    private JPanel genreCheckBoxesPanel;
    private JPanel assessmentCheckBoxesPanel;
    private JPanel graphicPanel;

    private String quoteReal;

    private JLabel noBookSelected;
    private JLabel noBookToRead;
    private JLabel noBookRead;
    private JLabel noBookReading;
    private JLabel noQuote;

    private JButton addBookReadButton;
    private JButton addBookReadButtonAlready;
    private JButton addBookToReadButtonAlready;
    private JButton addBookReadingButton;
    private JButton addBookReadingButtonAlready;
    private JButton addBookToReadButton;

    private JButton filterButton;
    private JButton addBookButton;
    private JButton selectImageButton;
    private JButton selectSmallImageButton;
    private JButton filterButtonOk;
    private JButton addBookButtonCancel;
    private JButton addBookButtonOk;
    private JButton addQuoteButton;
    private JButton saveQuoteButton;
    private JButton addAssessmentButton;
    private JButton addFavouritesButton;
    private JButton addFavouritesButtonAlready;
    private JPanel assessmentButtons;
    private ButtonGroup assessmentButtonsGroup;

    private JRadioButton assessmentZero;
    private JRadioButton assessmentOne;
    private JRadioButton assessmentTwo;
    private JRadioButton assessmentThree;
    private JRadioButton assessmentFour;
    private JRadioButton assessmentFive;

    private JTextField bookTextField;
    private JTextField genreTextField;
    private JTextField authorTextField;
    private JTextField cityTextField;
    private JTextField countryTextField;

    private JTextArea quoteArea;

    private BookToReadSectionEntityDao bookToReadSectionEntityDao;
    private BookReadSectionEntityDao bookReadSectionEntityDao;
    private BookReadingSectionEntityDao bookReadingSectionEntityDao;
    private BookEntityDao bookEntityDao;
    private QuoteEntityDao quoteEntityDao;
    private AuthorEntityDao authorEntityDao;
    private GenreEntityDao genreEntityDao;
    private AssessmentEntityDao assessmentEntityDao;
    private FavouritesEntityDao favouritesEntityDao;

    private DefaultListModel<BookEntity> bookListModel;
    private DefaultListModel<BookToReadSectionEntity> bookToReadListModel;
    private DefaultListModel<BookReadingSectionEntity> bookReadingListModel;
    private DefaultListModel<BookReadSectionEntity> bookReadListModel;
    private DefaultListModel<BookReadSectionEntity> bookReadThisMonthListModel;
    private DefaultListModel<FavouritesEntity> favouritesListModel;

    public void updateSelectedBookArea() {
        selectedBookPanel.removeAll();
        selectedBookPanel.repaint();
        selectedBookPanel.revalidate();

        try {
            JLabel image = new JLabel(new ImageIcon(getClass().getResource("/_" + bookList.getSelectedValue().getName() + ".jpg")));
            image.setAlignmentX(Component.CENTER_ALIGNMENT);
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            selectedBookPanel.add(image);
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        } catch (Exception ignored) {}


        JLabel bookName = new JLabel(bookList.getSelectedValue().getName());
        bookName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel authorName = null;
        try {
            authorName = new JLabel(bookList.getSelectedValue().getAuthorByAuthorId().getName());
        } catch (Exception ignored) {};

        authorName.setAlignmentX(Component.CENTER_ALIGNMENT);

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 19);
        authorName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        selectedBookPanel.add(authorName);
        selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 7)));
        selectedBookPanel.add(bookName);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        BookEntity selectedBookEntity = bookList.getSelectedValue();

        addBookReadButton.setEnabled(true);
        addBookToReadButton.setEnabled(true);
        addBookReadingButton.setEnabled(true);

        BookToReadSectionEntity bookToReadSectionEntity = bookToReadSectionEntityDao.findBookToReadByBookId(selectedBookEntity.getId());

        if (bookToReadSectionEntity != null) {
            buttonsPanel.add(addBookToReadButtonAlready);
            addBookReadingButton.setEnabled(false);
            addBookReadButton.setEnabled(false);
        } else {
            buttonsPanel.add(addBookToReadButton);
        }

        BookReadSectionEntity bookReadSectionEntity = bookReadSectionEntityDao.findBookReadByBookId(selectedBookEntity.getId());
        FavouritesEntity favouritesEntity = favouritesEntityDao.findFavouriteByBookId(selectedBookEntity.getId());

        if (bookReadSectionEntity != null) {
            buttonsPanel.add(addBookReadButtonAlready);
            addBookReadingButton.setEnabled(false);
            addBookToReadButton.setEnabled(false);

            buttonsReadPanel.removeAll();
            buttonsReadPanel.add(addQuoteButton);
            buttonsReadPanel.add(addAssessmentButton);

            if (favouritesEntity != null) {
                buttonsReadPanel.add(addFavouritesButtonAlready);
            } else {
                buttonsReadPanel.add(addFavouritesButton);
            }

            List<AbstractButton> list = Collections.list(assessmentButtonsGroup.getElements());
            for (AbstractButton button : list) {
                if (button.isSelected()) {
                    button.setSelected(false);
                }
                if (button.getText().equals(String.valueOf(bookReadSectionEntity.getAssessmentByAssessmentId().getGrade()))) {
                    button.setSelected(true);
                }
            }
        } else {
            buttonsPanel.add(addBookReadButton);
        }

        BookReadingSectionEntity bookReadingSectionEntity = bookReadingSectionEntityDao.findBookReadingByBookId(selectedBookEntity.getId());

        if (bookReadingSectionEntity != null) {
            buttonsPanel.add(addBookReadingButtonAlready);
            addBookReadButton.setEnabled(false);
            addBookToReadButton.setEnabled(false);
        } else {
            buttonsPanel.add(addBookReadingButton);
        }

        selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        selectedBookPanel.add(buttonsPanel);

        if (!addBookToReadButton.isEnabled() && !addBookReadingButton.isEnabled()) {
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 7)));
            selectedBookPanel.add(buttonsReadPanel);

            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            selectedBookPanel.add(assessmentButtons);
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            selectedBookPanel.add(quotePanel);
            updateQuoteList();
        }
    }

    public void initializeListeners() {
        addBookButtonCancel.addActionListener(actionEvent -> {
            updateBookList();
        });

        selectImageButton.addActionListener(actionEvent -> {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File source = fileopen.getSelectedFile();
                File dest = new File("src/main/resources/_" + bookTextField.getText() + ".jpg");

                try {
                    dest.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                InputStream is = null;
                OutputStream os = null;
                try {
                    try {
                        is = new FileInputStream(source);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        os = new FileOutputStream(dest);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        selectSmallImageButton.addActionListener(actionEvent -> {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File source = fileopen.getSelectedFile();
                File dest = new File("src/main/resources/" + bookTextField.getText() + ".jpg");

                try {
                    dest.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                InputStream is = null;
                OutputStream os = null;
                try {
                    try {
                        is = new FileInputStream(source);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        os = new FileOutputStream(dest);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        filterButton.addActionListener(actionEvent -> {
            createFilterList();
        });

        addBookButton.addActionListener(actionEvent -> {
            createAddBook();
        });

        addBookButtonOk.addActionListener(actionEvent -> {
            String bookName = bookTextField.getText();
            String genreName = genreTextField.getText();
            String authorName = authorTextField.getText();
            String cityName = cityTextField.getText();
            String countryName = countryTextField.getText();

            Triggers triggers = new Triggers(bookName, genreName, authorName, cityName, countryName);
            updateBookList();
        });

        filterButtonOk.addActionListener(actionEvent -> {
            bookListModel.removeAllElements();

            ArrayList<BookEntity> authorBookListModel = new ArrayList<>();
            ArrayList<BookEntity> genreBookListModel = new ArrayList<>();
            ArrayList<BookEntity> assessmentBookListModel = new ArrayList<>();

            int any1 = 0;
            for (Component checkBox : authorCheckBoxesPanel.getComponents()) {
                if (((JCheckBox) checkBox).isSelected()) {
                    int author_id = authorEntityDao.findAuthorIdByName(((JCheckBox) checkBox).getText());
                    authorBookListModel.addAll(bookEntityDao.findBooksByAuthorId(author_id));
                    any1 = 1;
                }
            }

            int any2 = 0;
            for (Component checkBox : genreCheckBoxesPanel.getComponents()) {
                if (((JCheckBox) checkBox).isSelected()) {
                    int genre_id = genreEntityDao.findGenreIdByName(((JCheckBox) checkBox).getText());
                    genreBookListModel.addAll(bookEntityDao.findBooksByGenreId(genre_id));
                    any2 = 1;
                }
            }

            int any3 = 0;
            for (Component checkBox : assessmentCheckBoxesPanel.getComponents()) {
                if (((JCheckBox) checkBox).isSelected()) {
                    int assessment_id = assessmentEntityDao.findAssessmentIdByGrade(Byte.parseByte(((JCheckBox) checkBox).getText()));
                    bookReadSectionEntityDao.findBooksReadByAssessmentId(assessment_id).forEach(it -> {
                        assessmentBookListModel.add(bookEntityDao.findBookById(it.getBookId()));
                    });

                    any3 = 1;
                }
            }

            ArrayList<BookEntity> intersectModelsAG = new ArrayList<>();
            ArrayList<BookEntity> intersectModelsAA = new ArrayList<>();
            ArrayList<BookEntity> intersectModelsGA = new ArrayList<>();
            ArrayList<BookEntity> intersectModelsAGA = new ArrayList<>();

            ArrayList<BookEntity> finalModel = new ArrayList<>();

            for (BookEntity bookEntity : authorBookListModel) {
                if (genreBookListModel.contains(bookEntity)) {
                    intersectModelsAG.add(bookEntity);
                }
            }

            for (BookEntity bookEntity : intersectModelsAG) {
                if (assessmentBookListModel.contains(bookEntity)) {
                    intersectModelsAGA.add(bookEntity);
                }
            }

            for (BookEntity bookEntity : authorBookListModel) {
                if (assessmentBookListModel.contains(bookEntity)) {
                    intersectModelsAA.add(bookEntity);
                }
            }

            for (BookEntity bookEntity : genreBookListModel) {
                if (assessmentBookListModel.contains(bookEntity)) {
                    intersectModelsGA.add(bookEntity);
                }
            }

            if (any1 == 0) {
                if (any2 == 0) {
                    finalModel = assessmentBookListModel;
                } else {
                    if (any3 == 0) {
                        finalModel = genreBookListModel;
                    } else {
                        finalModel = intersectModelsGA;
                    }
                }
            } else {
                if (any2 == 0) {
                    if (any3 == 0) {
                        finalModel = authorBookListModel;
                    } else {
                        finalModel = intersectModelsAA;
                    }
                } else {
                    if (any3 == 0) {
                        finalModel = intersectModelsAG;
                    } else {
                        finalModel = intersectModelsAGA;
                    }
                }
            }

            finalModel.sort(Comparator.comparing(BookEntity::getId));

            finalModel.forEach(bookListModel::addElement);

            bookList.setModel(bookListModel);

            drawBookList();

        });

        addFavouritesButton.addActionListener(actionEvent -> {
            FavouritesEntity favouritesEntity = new FavouritesEntity();
            favouritesEntity.setBookId(bookList.getSelectedValue().getId());

            favouritesEntityDao.saveFavourites(favouritesEntity);
            updateFavouritesList();
            updateSelectedBookArea();
        });

        addFavouritesButtonAlready.addActionListener(actionEvent -> {
            FavouritesEntity favouritesEntity = favouritesEntityDao.findFavouriteByBookId(bookList.getSelectedValue().getId());

            favouritesEntityDao.deleteFavourites(favouritesEntity);

            updateFavouritesList();
            updateSelectedBookArea();
        });

        addAssessmentButton.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();

            int assessment = 0;
            List<AbstractButton> list = Collections.list(assessmentButtonsGroup.getElements());
            for (AbstractButton button : list) {
                if (button.isSelected()) {
                    assessment = Integer.parseInt(button.getText());
                }
            }

            BookReadSectionEntity bookReadSectionEntity = bookReadSectionEntityDao.findBookReadByBookId(selectedBookEntity.getId());
            bookReadSectionEntity.setAssessmentId(assessment + 1);
            bookReadSectionEntityDao.updateBookRead(bookReadSectionEntity);

            updateBookToReadList();
            updateSelectedBookArea();
        });

        addQuoteButton.addActionListener(actionEvent -> {
            selectedBookPanel.remove(quotePanel);
            selectedBookPanel.remove(assessmentButtons);
            buttonsReadPanel.remove(addAssessmentButton);
            buttonsReadPanel.remove(addQuoteButton);
            buttonsReadPanel.add(saveQuoteButton);
            buttonsReadPanel.repaint();

            selectedBookPanel.add(quoteArea);
            selectedBookPanel.repaint();
            selectedBookPanel.revalidate();
        });

        saveQuoteButton.addActionListener(actionEvent -> {
            String quote = quoteArea.getText();

            quoteArea.setText("");
            QuoteEntity quoteEntity = new QuoteEntity();
            quoteEntity.setContent(quote);
            quoteEntityDao.saveQuote(quoteEntity);

            int index = quoteEntityDao.findQuoteByContent(quote).getId();

            BookEntity selectedBookEntity = bookList.getSelectedValue();

            BookReadSectionEntity bookReadSectionEntity = bookReadSectionEntityDao.findBookReadByBookId(selectedBookEntity.getId());
            bookReadSectionEntity.setQuoteId(index);
            bookReadSectionEntityDao.updateBookRead(bookReadSectionEntity);

            quoteEntityDao.deleteQuoteByContent(quoteReal);

            updateSelectedBookArea();

        });

        addBookToReadButton.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();
            List<BookToReadSectionEntity> booksToRead = bookToReadSectionEntityDao.findAllBooksToRead();

            BookToReadSectionEntity bookToReadSectionEntity = new BookToReadSectionEntity();
            bookToReadSectionEntity.setBookId(selectedBookEntity.getId());
            bookToReadSectionEntity.setQueueNumber(booksToRead.size() + 1);
            bookToReadSectionEntityDao.saveBookToRead(bookToReadSectionEntity);

            updateBookToReadList();
            updateSelectedBookArea();
        });

        addBookToReadButtonAlready.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();
            List<BookToReadSectionEntity> booksToRead = bookToReadSectionEntityDao.findAllBooksToRead();

            for (BookToReadSectionEntity bookToRead : booksToRead) {
                if (selectedBookEntity.getId() == bookToRead.getBookId()) {
                    bookToReadSectionEntityDao.deleteBookToRead(bookToRead);
                }
            }

            updateBookToReadList();
            updateSelectedBookArea();
        });


        addBookReadButton.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();

            BookReadSectionEntity bookReadSectionEntity = new BookReadSectionEntity();
            bookReadSectionEntity.setBookId(selectedBookEntity.getId());
            bookReadSectionEntity.setQuoteId(1);
            bookReadSectionEntity.setAssessmentId(1);

            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            bookReadSectionEntity.setDateOfCompletion(new Date(today.getTimeInMillis()));

            bookReadSectionEntityDao.saveBookRead(bookReadSectionEntity);

            updateBookReadList();
            updateReadMonthList();
            updateSelectedBookArea();
            updateGraphicPanel();
        });

        addBookReadButtonAlready.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();
            List<BookReadSectionEntity> booksRead = bookReadSectionEntityDao.findAllBooksRead();

            for (BookReadSectionEntity bookRead : booksRead) {
                if (selectedBookEntity.getId() == bookRead.getBookId()) {
                    bookReadSectionEntityDao.deleteBookRead(bookRead);
                }
            }

            updateBookReadList();
            updateReadMonthList();
            updateSelectedBookArea();
            updateGraphicPanel();
        });

        addBookReadingButton.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();

            BookReadingSectionEntity bookReadingSectionEntity = new BookReadingSectionEntity();
            bookReadingSectionEntity.setBookId(selectedBookEntity.getId());
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);

            bookReadingSectionEntity.setStartDate(new Date(today.getTimeInMillis()));
            bookReadingSectionEntityDao.saveBookReading(bookReadingSectionEntity);

            updateBookReadingList();
            updateSelectedBookArea();
        });

        addBookReadingButtonAlready.addActionListener(actionEvent -> {
            BookEntity selectedBookEntity = bookList.getSelectedValue();
            List<BookReadingSectionEntity> booksReading = bookReadingSectionEntityDao.findAllBooksReading();

            for (BookReadingSectionEntity bookReading : booksReading) {
                if (selectedBookEntity.getId() == bookReading.getBookId()) {
                    bookReadingSectionEntityDao.deleteBookReading(bookReading);
                }
            }

            updateBookReadingList();
            updateSelectedBookArea();
        });

        bookList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                updateSelectedBookArea();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void initialize() {
        bookPanel = new JPanel();
        bookPanel.setBackground(Color.white);
        bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
        bookPanel.setPreferredSize(new Dimension(305, 690));
        bookPanel.setBorder(BorderFactory.createTitledBorder("СПИСОК КНИГ"));

        addBookPanel = new JPanel();
        addBookPanel.setBackground(Color.white);
        addBookPanel.setLayout(new BoxLayout(addBookPanel, BoxLayout.Y_AXIS));

        bookToReadSectionPanel = new JPanel();
        bookToReadSectionPanel.setBackground(Color.white);
        bookToReadSectionPanel.setLayout(new BoxLayout(bookToReadSectionPanel, BoxLayout.Y_AXIS));
        bookToReadSectionPanel.setPreferredSize(new Dimension(365, 217));
        bookToReadSectionPanel.setBorder(BorderFactory.createTitledBorder("ХОЧУ ПРОЧИТАТЬ"));

        bookReadSectionPanel = new JPanel();
        bookReadSectionPanel.setBackground(Color.white);
        bookReadSectionPanel.setLayout(new BoxLayout(bookReadSectionPanel, BoxLayout.Y_AXIS));
        bookReadSectionPanel.setPreferredSize(new Dimension(365, 217));
        bookReadSectionPanel.setBorder(BorderFactory.createTitledBorder("ПРОЧИТАЛ"));

        bookReadingSectionPanel = new JPanel();
        bookReadingSectionPanel.setBackground(Color.white);
        bookReadingSectionPanel.setLayout(new BoxLayout(bookReadingSectionPanel, BoxLayout.Y_AXIS));
        bookReadingSectionPanel.setPreferredSize(new Dimension(365, 217));
        bookReadingSectionPanel.setBorder(BorderFactory.createTitledBorder("ЧИТАЮ"));

        bookList = new JList<>();
        bookList.setCellRenderer(new BookEntityRenderer());
        bookList.setLayoutOrientation(JList.VERTICAL);

        bookListModel = new DefaultListModel<>();
        bookToReadListModel = new DefaultListModel<>();
        bookReadingListModel = new DefaultListModel<>();
        bookReadListModel = new DefaultListModel<>();
        bookReadThisMonthListModel = new DefaultListModel<>();
        favouritesListModel = new DefaultListModel<>();

        bookToReadSectionEntityDao = new BookToReadSectionEntityDao();
        bookReadSectionEntityDao = new BookReadSectionEntityDao();
        bookReadingSectionEntityDao = new BookReadingSectionEntityDao();
        bookEntityDao = new BookEntityDao();
        quoteEntityDao = new QuoteEntityDao();
        authorEntityDao = new AuthorEntityDao();
        genreEntityDao = new GenreEntityDao();
        assessmentEntityDao = new AssessmentEntityDao();
        favouritesEntityDao = new FavouritesEntityDao();

        bookTextField = new JTextField();
        genreTextField = new JTextField();
        authorTextField = new JTextField();
        cityTextField = new JTextField();
        countryTextField = new JTextField();

        gameFrame = new JFrame("Книжная библиотека");
        gameFrame.getContentPane().setBackground(Color.white);
        gameFrame.setLayout(new FlowLayout());
        gameFrame.setSize(1415, 723);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addBookReadButton = new JButton("+ Прочитал");
        addBookReadButtonAlready = new JButton("- Прочитал");
        addBookReadingButton = new JButton(" + Читаю");
        addBookToReadButton = new JButton("+ Хочу прочитать");
        addBookToReadButtonAlready = new JButton(" - Хочу прочитать");
        addBookReadingButtonAlready = new JButton("- Читаю");

        addQuoteButton = new JButton("Изменить цитату");
        filterButton = new JButton("Фильтровать список");
        addBookButton = new JButton("Добавить новую книгу");
        selectImageButton = new JButton("Указать путь до изображения на диске");
        selectSmallImageButton = new JButton("Указать путь до изображения на диске");

        addBookButtonOk = new JButton("Сохранить данные новой книги в список");
        filterButtonOk = new JButton("Подтвердить параметры фильтрации");
        addBookButtonCancel = new JButton("Отменить добавление новой книги");
        saveQuoteButton = new JButton("Сохранить введённую цитату");
        addAssessmentButton = new JButton("Оценить");
        addFavouritesButton = new JButton("+ Избранное");
        addFavouritesButtonAlready = new JButton("- Избранное");

        quoteArea = new JTextArea("");
        quoteArea.setBorder(BorderFactory.createTitledBorder("ВВОД ЦИТАТЫ"));

        assessmentButtons = new JPanel();
        assessmentButtons.add(new JLabel("Ваша оценка: "));
        assessmentButtonsGroup = new ButtonGroup();
        assessmentButtons.setBackground(Color.white);
        assessmentButtons.setLayout(new BoxLayout(assessmentButtons, BoxLayout.X_AXIS));
        assessmentZero = new JRadioButton("0", false);
        assessmentButtons.add(assessmentZero);
        assessmentButtonsGroup.add(assessmentZero);
        assessmentOne = new JRadioButton("1", false);
        assessmentButtons.add(assessmentOne);
        assessmentButtonsGroup.add(assessmentOne);
        assessmentTwo = new JRadioButton("2", false);
        assessmentButtons.add(assessmentTwo);
        assessmentButtonsGroup.add(assessmentTwo);
        assessmentThree = new JRadioButton("3", false);
        assessmentButtons.add(assessmentThree);
        assessmentButtonsGroup.add(assessmentThree);
        assessmentFour = new JRadioButton("4", false);
        assessmentButtons.add(assessmentFour);
        assessmentButtonsGroup.add(assessmentFour);
        assessmentFive = new JRadioButton("5", false);
        assessmentButtons.add(assessmentFive);
        assessmentButtonsGroup.add(assessmentFive);

        noBookSelected = new JLabel("Книга не выбрана");
        noBookSelected.setAlignmentX(Component.CENTER_ALIGNMENT);
        noBookReading = new JLabel("Нет книг");
        noBookReading.setAlignmentX(Component.CENTER_ALIGNMENT);
        noBookToRead = new JLabel("Нет книг");
        noBookToRead.setAlignmentX(Component.CENTER_ALIGNMENT);
        noBookRead = new JLabel("Нет книг");
        noBookRead.setAlignmentX(Component.CENTER_ALIGNMENT);
        noQuote = new JLabel("Нет цитаты");
        noQuote.setAlignmentX(Component.CENTER_ALIGNMENT);

        assessmentCheckBoxesPanel = new JPanel();
        assessmentCheckBoxesPanel.setBackground(Color.white);
        assessmentCheckBoxesPanel.setLayout(new BoxLayout(assessmentCheckBoxesPanel, BoxLayout.Y_AXIS));

        graphicPanel = new JPanel();
        graphicPanel.setBackground(Color.white);
        graphicPanel.setLayout(new FlowLayout());

        genreCheckBoxesPanel = new JPanel();
        genreCheckBoxesPanel.setBackground(Color.white);
        genreCheckBoxesPanel.setLayout(new BoxLayout(genreCheckBoxesPanel, BoxLayout.Y_AXIS));

        authorCheckBoxesPanel = new JPanel();
        authorCheckBoxesPanel.setBackground(Color.white);
        authorCheckBoxesPanel.setLayout(new BoxLayout(authorCheckBoxesPanel, BoxLayout.Y_AXIS));

        selectedBookPanel = new JPanel();
        selectedBookPanel.setBackground(Color.white);
        selectedBookPanel.setLayout(new BoxLayout(selectedBookPanel, BoxLayout.Y_AXIS));
        selectedBookPanel.setPreferredSize(new Dimension(405, 690));
        selectedBookPanel.setBorder(BorderFactory.createTitledBorder("ВЫБРАННАЯ КНИГА"));
        selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 300)));
        selectedBookPanel.add(noBookSelected);

        buttonsReadPanel = new JPanel();
        buttonsReadPanel.setBackground(Color.white);
        buttonsReadPanel.setLayout(new BoxLayout(buttonsReadPanel, BoxLayout.X_AXIS));

        quotePanel = new JPanel();
        quotePanel.setBackground(Color.white);
        quotePanel.setLayout(new FlowLayout());
        quotePanel.setPreferredSize(new Dimension(405, 300));
        quotePanel.setBorder(BorderFactory.createTitledBorder("ЛЮБИМАЯ ЦИТАТА"));

        myBookSectionPanel = new JPanel();
        myBookSectionPanel.setBackground(Color.white);
        myBookSectionPanel.setLayout(new FlowLayout());
        myBookSectionPanel.setPreferredSize(new Dimension(375, 690));
        myBookSectionPanel.setBorder(BorderFactory.createTitledBorder("МОЯ ПОЛКА"));

        myStatsPanel = new JPanel();
        myStatsPanel.setBackground(Color.white);
        myStatsPanel.setLayout(new FlowLayout());
        myStatsPanel.setPreferredSize(new Dimension(305, 690));
        myStatsPanel.setBorder(BorderFactory.createTitledBorder("МОЯ СТАТИСТИКА"));

        favouritesPanel = new JPanel();
        favouritesPanel.setBackground(Color.white);
        favouritesPanel.setLayout(new BoxLayout(favouritesPanel, BoxLayout.Y_AXIS));
        favouritesPanel.setPreferredSize(new Dimension(295, 216));
        favouritesPanel.setBorder(BorderFactory.createTitledBorder("ИЗБРАННОЕ"));

        currentMonthReadPanel = new JPanel();
        currentMonthReadPanel.setBackground(Color.white);
        currentMonthReadPanel.setLayout(new BoxLayout(currentMonthReadPanel, BoxLayout.Y_AXIS));
        currentMonthReadPanel.setPreferredSize(new Dimension(295, 216));
        currentMonthReadPanel.setBorder(BorderFactory.createTitledBorder("ПРОЧИТАЛ В ЭТОМ МЕСЯЦЕ"));

        currentMonthReadGraphPanel = new JPanel();
        currentMonthReadGraphPanel.setBackground(Color.white);
        currentMonthReadGraphPanel.setLayout(new BoxLayout(currentMonthReadGraphPanel, BoxLayout.Y_AXIS));
        currentMonthReadGraphPanel.setPreferredSize(new Dimension(295, 218));
        currentMonthReadGraphPanel.setBorder(BorderFactory.createTitledBorder("ГРАФИК ПРОЧИТАННОГО ЗА ГОД"));

        bookToReadList = new JList<>();
        bookToReadList.setLayoutOrientation(JList.VERTICAL);
        bookToReadList.setCellRenderer(new BookToReadSectionEntityRenderer());

        bookReadingList = new JList<>();
        bookReadingList.setLayoutOrientation(JList.VERTICAL);
        bookReadingList.setCellRenderer(new BookReadingSectionEntityRenderer());

        bookReadList = new JList<>();
        bookReadList.setLayoutOrientation(JList.VERTICAL);
        bookReadList.setCellRenderer(new BookReadSectionEntityRenderer());

        bookReadThisMonthList = new JList<>();
        bookReadThisMonthList.setLayoutOrientation(JList.VERTICAL);
        bookReadThisMonthList.setCellRenderer(new BookReadThisMonthSectionEntityRenderer());

        favouritesList = new JList<>();
        favouritesList.setLayoutOrientation(JList.VERTICAL);
        favouritesList.setCellRenderer(new FavouritesEntityRenderer());

        quoteList = new JList<>();
        quoteList.setLayoutOrientation(JList.VERTICAL);
        quoteList.setCellRenderer(new QuoteEntityRenderer());
    }

    public void createFilterList() {
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();

        String[] assessments = {"0", "1", "2", "3", "4", "5"};
        authorEntityDao.findAllAuthors().forEach(author -> authors.add(author.getName()));
        genreEntityDao.findAllGenres().forEach(genre -> genres.add(genre.getName()));

        JLabel authorsLabel = new JLabel(" Авторы:");
        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 16);
        authorsLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        JPanel boxesPanel = new JPanel();
        boxesPanel.setBackground(Color.white);
        boxesPanel.setLayout(new BoxLayout(boxesPanel, BoxLayout.Y_AXIS));

        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        boxesPanel.add(authorsLabel);
        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        authorCheckBoxesPanel.removeAll();
        authorCheckBoxesPanel.repaint();
        authorCheckBoxesPanel.revalidate();

        for (String author : authors) {
            JCheckBox checkBox = new JCheckBox(author);
            authorCheckBoxesPanel.add(checkBox);
        }

        boxesPanel.add(authorCheckBoxesPanel);

        JLabel genresLabel = new JLabel(" Жанры:");
        genresLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        boxesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        boxesPanel.add(genresLabel);
        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        genreCheckBoxesPanel.removeAll();
        genreCheckBoxesPanel.repaint();
        genreCheckBoxesPanel.revalidate();

        for (String genre : genres) {
            JCheckBox checkBox = new JCheckBox(genre);
            genreCheckBoxesPanel.add(checkBox);
        }

        boxesPanel.add(genreCheckBoxesPanel);


        JLabel assessmentLabel = new JLabel(" Оценки:");
        assessmentLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        boxesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        boxesPanel.add(assessmentLabel);
        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        assessmentCheckBoxesPanel.removeAll();
        assessmentCheckBoxesPanel.repaint();
        assessmentCheckBoxesPanel.revalidate();

        for (String assessment : assessments) {
            JCheckBox checkBox = new JCheckBox(assessment);
            assessmentCheckBoxesPanel.add(checkBox);
        }

        boxesPanel.add(assessmentCheckBoxesPanel);

        bookPanel.removeAll();
        bookPanel.repaint();
        bookPanel.revalidate();

        bookPanel.add(boxesPanel);
        bookPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        bookPanel.add(filterButtonOk);
    }

    public void createAddBook() {
        addBookPanel.removeAll();
        addBookPanel.repaint();
        addBookPanel.revalidate();

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 16);

        JLabel bookName = new JLabel("Книга:");
        JLabel genreName = new JLabel("Жанр:");
        JLabel authorName = new JLabel("Автор:");
        JLabel cityName = new JLabel("Город:");
        JLabel countryName = new JLabel("Страна:");
        JLabel imageName = new JLabel("Полноразмерная обложка:");
        JLabel smallImageName = new JLabel("Усечённая обложка:");

        bookName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        genreName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        authorName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        cityName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        countryName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        imageName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        smallImageName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(bookName);
        addBookPanel.add(bookTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(genreName);
        addBookPanel.add(genreTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(authorName);
        addBookPanel.add(authorTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(cityName);
        addBookPanel.add(cityTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(countryName);
        addBookPanel.add(countryTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(imageName);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(selectImageButton);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(smallImageName);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(selectSmallImageButton);

        addBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        addBookPanel.add(addBookButtonOk);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addBookPanel.add(addBookButtonCancel);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 280)));

        bookPanel.removeAll();
        bookPanel.repaint();
        bookPanel.revalidate();

        bookPanel.add(addBookPanel);
    }

    public void drawBookList() {
        bookPanel.removeAll();
        bookPanel.repaint();
        bookPanel.revalidate();

        JScrollPane scrollPane = new JScrollPane(bookList);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        bookPanel.add(scrollPane);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.add(filterButton);
        buttonsPanel.add(addBookButton);

        bookPanel.add(buttonsPanel);
    }

    public void updateBookList() {
        bookListModel.removeAllElements();
        bookEntityDao.findAllBooks().forEach(bookListModel::addElement);
        bookList.setModel(bookListModel);

        drawBookList();
    }

    public void updateBookToReadList() {
        bookToReadListModel.removeAllElements();
        bookToReadSectionEntityDao.findAllBooksToRead().forEach(bookToReadListModel::addElement);

        bookToReadSectionPanel.removeAll();
        bookToReadSectionPanel.repaint();
        bookToReadSectionPanel.revalidate();

        if (bookToReadListModel.size() > 0) {
            bookToReadList.setModel(bookToReadListModel);

            JScrollPane scrollPane = new JScrollPane(bookToReadList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            bookToReadSectionPanel.add(scrollPane);
        } else {
            bookToReadSectionPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            bookToReadSectionPanel.add(noBookToRead);
        }
    }

    public void updateQuoteList() {
        BookEntity selectedBookEntity = bookList.getSelectedValue();

        quoteReal = "";
        int id = selectedBookEntity.getId();
        for (BookReadSectionEntity bookReadSectionEntity : bookReadSectionEntityDao.findAllBooksRead()) {
            if (bookReadSectionEntity.getBookId() == id) {
                quoteReal = bookReadSectionEntity.getQuoteByQuoteId().getContent();
                break;
            }
        }

        quotePanel.removeAll();
        quotePanel.add(Box.createRigidArea(new Dimension(0, 100)));
        quotePanel.add(new JTextArea(quoteReal));
        quotePanel.repaint();
        quotePanel.revalidate();
    }

    public void updateBookReadingList() {
        bookReadingListModel.removeAllElements();
        bookReadingSectionEntityDao.findAllBooksReading().forEach(bookReadingListModel::addElement);

        bookReadingSectionPanel.removeAll();
        bookReadingSectionPanel.repaint();
        bookReadingSectionPanel.revalidate();

        if (bookReadingListModel.size() > 0) {
            bookReadingList.setModel(bookReadingListModel);

            JScrollPane scrollPane = new JScrollPane(bookReadingList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            bookReadingSectionPanel.add(scrollPane);
        } else {
            bookReadingSectionPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            bookReadingSectionPanel.add(noBookReading);
        }
    }

    public void updateReadMonthList() {
        bookReadThisMonthListModel.removeAllElements();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        bookReadSectionEntityDao.findBooksReadByMonth(new Date(today.getTimeInMillis())).forEach(bookReadThisMonthListModel::addElement);

        currentMonthReadPanel.removeAll();
        currentMonthReadPanel.repaint();
        currentMonthReadPanel.revalidate();

        if (bookReadThisMonthListModel.size() > 0) {
            bookReadThisMonthList.setModel(bookReadThisMonthListModel);

            JScrollPane scrollPane = new JScrollPane(bookReadThisMonthList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            currentMonthReadPanel.add(scrollPane);
        } else {
            currentMonthReadPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            currentMonthReadPanel.add(noBookRead);
        }
    }

    public void updateGraphicPanel() {
        int n = 12;
        int val = 160;
        int x[] = {10, 35, 60, 83, 106, 129, 153, 177, 200, 223, 246, 270};
        int y[] = new int[n];

        Calendar everyMonth = Calendar.getInstance();
        everyMonth.set(Calendar.HOUR_OF_DAY, 0);
        everyMonth.set(Calendar.MINUTE, 0);
        everyMonth.set(Calendar.SECOND, 0);

        for (int i = 0; i < n; i++) {
            everyMonth.set(Calendar.MONTH, i);
            int amount = bookReadSectionEntityDao.findBooksReadByMonth(new Date(everyMonth.getTimeInMillis())).size();
            y[i] = val - amount * 10;
        }

        currentMonthReadGraphPanel.removeAll();
        currentMonthReadGraphPanel.repaint();
        currentMonthReadGraphPanel.revalidate();

        graphicPanel = new GraphDrawer(x, y, n);
        graphicPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        graphicPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentMonthReadGraphPanel.add(graphicPanel);

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 9);
        JLabel months = new JLabel("Янв  Фев  Мар  Апр  Май  Июн  Июл  Авг  Сен  Окт  Ноя  Дек");
        months.setFont(font.deriveFont(font.getStyle()));

        currentMonthReadGraphPanel.add(months);

    }

    public void updateFavouritesList() {
        favouritesListModel.removeAllElements();

        favouritesEntityDao.findAllFavourites().forEach(favouritesListModel::addElement);

        favouritesPanel.removeAll();
        favouritesPanel.repaint();
        favouritesPanel.revalidate();

        if (favouritesListModel.size() > 0) {
            favouritesList.setModel(favouritesListModel);

            JScrollPane scrollPane = new JScrollPane(favouritesList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            favouritesPanel.add(scrollPane);
        } else {
            favouritesPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            favouritesPanel.add(noBookRead);
        }
    }

    public void updateBookReadList() {
        bookReadListModel.removeAllElements();
        bookReadSectionEntityDao.findAllBooksRead().forEach(bookReadListModel::addElement);

        bookReadSectionPanel.removeAll();
        bookReadSectionPanel.repaint();
        bookReadSectionPanel.revalidate();

        if (bookReadListModel.size() > 0) {
            bookReadList.setModel(bookReadListModel);

            JScrollPane scrollPane = new JScrollPane(bookReadList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            bookReadSectionPanel.add(scrollPane);
        } else {
            bookReadSectionPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            bookReadSectionPanel.add(noBookRead);
        }
    }

    public void startBookLibraryWindow() {
        initialize();
        initializeListeners();
        updateBookList();
        updateReadMonthList();
        updateBookToReadList();
        updateBookReadingList();
        updateBookReadList();
        updateFavouritesList();
        updateGraphicPanel();

        myBookSectionPanel.add(bookReadingSectionPanel);
        myBookSectionPanel.add(bookToReadSectionPanel);
        myBookSectionPanel.add(bookReadSectionPanel);

        myStatsPanel.add(favouritesPanel);
        myStatsPanel.add(currentMonthReadPanel);
        myStatsPanel.add(currentMonthReadGraphPanel);

        gameFrame.add(bookPanel);
        gameFrame.add(selectedBookPanel);
        gameFrame.add(myBookSectionPanel);
        gameFrame.add(myStatsPanel);

        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}


