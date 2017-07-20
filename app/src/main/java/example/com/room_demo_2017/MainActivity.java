package example.com.room_demo_2017;

import android.arch.lifecycle.LifecycleActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import example.com.room_demo_2017.domain.Book;

public class MainActivity extends LifecycleActivity {


    @Inject
    AppDatabase appDatabase;

    private static final String TAG = "MainActivity";

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoomDemoApplication application = (RoomDemoApplication) getApplication();
        application.getAppComponent().inject(this);

        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(view -> {
            count++;
            Book book = new Book("Test title "+count, "Test description");
            appDatabase.bookModel().insertBook(book);
        });

        Button allBooksButton = findViewById(R.id.button_findbooks);
        allBooksButton.setOnClickListener(view -> {
            appDatabase.bookModel().getAllBooks().observe(this, books -> {
                Log.d(TAG, "books "+books);
            });
        });
    }
}
