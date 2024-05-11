package org.d3if3130.assessment2mobpro1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3130.assessment2mobpro1.model.Pengunjung

@Database(entities = [Pengunjung::class], version = 1, exportSchema = false)
abstract class PengunjungDb : RoomDatabase() {
    abstract val dao: PengunjungDao

    companion object {

        @Volatile
        private var INSTANCES: PengunjungDb? = null

        fun getInstance(context: Context): PengunjungDb {
            synchronized(this) {
                var instances = INSTANCES
                if (instances == null) {
                    instances = Room.databaseBuilder(context.applicationContext,
                        PengunjungDb::class.java, "pengunjung.db").build()
                    INSTANCES = instances
                }
                return instances
            }
        }
    }

}