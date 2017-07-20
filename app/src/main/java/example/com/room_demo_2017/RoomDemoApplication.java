package example.com.room_demo_2017;

import android.app.Application;

/**
 * Created by kevintan on 20/07/2017.
 */

public class RoomDemoApplication extends Application {


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
