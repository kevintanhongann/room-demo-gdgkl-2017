package example.com.room_demo_2017.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.Update;

import java.util.List;

import example.com.room_demo_2017.domain.Book;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by kevintan on 19/07/2017.
 */
@Dao
public interface BookDao {

    @Query("SELECT * from books")
    List<Book> getAllBooksSync();

    @Query("SELECT * from books")
    LiveData<List<Book>> getAllBooks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBook(Book book);

    @Insert()
    void insertThreeBooks(Book... books);

    @Update(onConflict = REPLACE)
    void updateBook(Book book);


}
