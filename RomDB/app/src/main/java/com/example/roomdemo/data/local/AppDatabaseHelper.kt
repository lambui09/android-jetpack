package com.example.roomdemo.data.local

import android.content.Context

class AppDatabaseHelper private constructor(
    val database: AppDatabase?
) {
    companion object {
        @Volatile
        private var INSTANCE: AppDatabaseHelper? = null

        /**
         * To get an AppDataHelper:
         * AppDatabaseHelper.getInstance(getContext)
         *
         * @param context the context where we need AppDataHelper
         */
        fun getInstance(context: Context): AppDatabaseHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: AppDatabaseHelper(AppDatabase.getInstance(context))
                    .also { INSTANCE = it }
            }
    }

}