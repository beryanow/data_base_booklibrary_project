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

//        CityEntityDao cityEntityDao = new CityEntityDao();
//        CityEntity cityEntity = new CityEntity();
//        cityEntity.setName("Новосибирск");
//        cityEntityDao.saveCity(cityEntity);

//        BookEntityDao bookEntityDao = new BookEntityDao();
//
//        List<BookEntity> books = bookEntityDao.findAllBooks();
//        System.out.println();
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setName("Нож");
//        bookEntity.setAuthorId(1);
//        bookEntity.setGenreId(1);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(0);
//        calendar.set(2019, Calendar.JANUARY, 1, 0, 0, 0);
//        bookEntity.setDateOfPublication(new Date(calendar.getTimeInMillis()));
//        bookEntityDao.saveBook(bookEntity);

//        GenreEntityDao genreEntityDao = new GenreEntityDao();
//        GenreEntity genreEntity = new GenreEntity();
//        genreEntity.setName("Фантастика");
//        genreEntityDao.saveGenre(genreEntity);

//        CityEntityDao cityEntityDao = new CityEntityDao();
//
//        CountryEntityDao countryEntityDao = new CountryEntityDao();
//        AuthorEntityDao authorEntityDao = new AuthorEntityDao();
//        AuthorEntity authorEntity = new AuthorEntity();
//        authorEntity.setName("Энди Вейер");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(0);
//        calendar.set(1972, Calendar.JUNE, 16, 0, 0, 0);
//        authorEntity.setDateOfBirth(new Date(calendar.getTimeInMillis()));
//        authorEntity.setAddressId(2);
////
//        authorEntityDao.saveAuthor(authorEntity);


//        CityEntity cityEntity = new CityEntity("Дейвис");
//        cityEntityDao.saveCity(cityEntity);
//
//        CountryEntity countryEntity = new CountryEntity("США");
//        countryEntityDao.saveCountry(countryEntity);
//
//        AddressEntity addressEntity = new AddressEntity();
//        addressEntity.setCityId(2);
//        addressEntity.setCountryId(2);
//        AddressEntityDao addressEntityDao = new AddressEntityDao();
//        addressEntityDao.saveAddress(addressEntity);

//        Collection<AuthorEntity> collection = authorEntityDao.findAllAuthors();
//        System.out.println();
//

//        UserDao dao = new UserDao();
//
//        // Add new user
//        User user = new User();
//        user.setFirstName("Daniel");
//        user.setLastName("NikoJdbc");
//        try {
//            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1986-01-02");
//            user.setDob(dob);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        user.setEmail("daniel@example.com");
//        dao.addUser(user);
////
////        // Update user
//        user.setEmail("daniel@updatedJdbc.com");
//        user.setUserid(1);
//        dao.updateUser(user);
//
//        // Delete user
//        //dao.deleteUser(2);
//
//        // Get all users
//        for (User iter : dao.getAllUsers()) {
//            System.out.println(iter);
//        }
//
//        // Get user by id
//        System.out.println(dao.getUserById(8));
//
//        try {
//            DbUtil.getConnection().close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }





//        BookEntityService bookEntityService = new BookEntityService();
//        BookEntity book = new BookEntity();
//        book.setName("Снеговик");
//        bookEntityService.saveBook(book);
//        bookEntityService.findAllBooks().forEach(System.out::println);
//        bookEntityService.findAllUsers().forEach(bookEntityService::deleteUser);
//        System.out.println("CLEARED");
//        bookEntityService.findAllUsers().forEach(System.out::println);
    }
}