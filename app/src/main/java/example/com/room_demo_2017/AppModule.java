package example.com.room_demo_2017;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kevintan on 20/07/2017.
 */
@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    AppDatabase provideDatabase(){
        if(BuildConfig.DEBUG){
            return Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();
        }else{
            return Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "room-demo").build();
        }
    }
}
