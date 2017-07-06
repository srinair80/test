package net.gouline.dagger2demo;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import net.gouline.dagger2demo.di.component.DaggerDemoApplicationComponent;
import net.gouline.dagger2demo.di.component.DemoApplicationComponent;
import net.gouline.dagger2demo.di.module.ApplicationModule;

/**
 * Custom application definition.
 * <p/>
 * Created by mgouline on 23/04/15.
 */
public class DemoApplication extends Application {
    private DemoApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerDemoApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mComponent.inject(this);
    }

    public DemoApplicationComponent getComponent() {
        return mComponent;
    }

    /**
     * Extracts application from support context types.
     *
     * @param context Source context.
     * @return Application instance or {@code null}.
     */
    public static DemoApplication from(@NonNull Context context) {
        return (DemoApplication) context.getApplicationContext();
    }
}
