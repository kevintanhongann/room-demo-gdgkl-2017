package example.com.room_demo_2017;

import dagger.Component;

/**
 * Created by kevintan on 20/07/2017.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
