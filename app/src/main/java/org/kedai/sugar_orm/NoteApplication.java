package org.kedai.sugar_orm;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by Lenovo on 03/04/2016.
 */
public class NoteApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
