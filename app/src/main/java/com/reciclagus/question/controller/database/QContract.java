package com.reciclagus.question.controller.database;

import android.provider.BaseColumns;

public final class QContract {

    private QContract(){}

    public static class Note implements BaseColumns {

        public static final String NAME = "name";
        public static final String TITLE = "title";
        public static final String CONTENT = "content";

    }
    public static class Reminder implements BaseColumns {

        public static final String NAME = "name";
        public static final String TITLE = "title";
        public static final String CONTENT = "content";
        public static final String DATE = "date";
        public static final String ACTIVE = "active";

    }

}
