package com.mirhoseini.quandoo.util;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Mohsen on 24/10/2016.
 */

public class AppSchedulerProvider implements SchedulerProvider {

    @Inject
    public AppSchedulerProvider() {
    }

    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler backgroundThread() {
        return Schedulers.io();
    }

}
