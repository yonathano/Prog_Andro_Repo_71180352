package id.ac.ukdw.pert_10_mysqli_71180352


class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
     override fun onCreate(db: SQLiteDatabase) {
         db.execSQL(DatabaseContract.Penduduk.SQL_CREATE_TABLE)
         }
     override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
         db.execSQL(DatabaseContract.Penduduk.SQL_DELETE_TABLE)
         onCreate(db)
         }
     override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
         onUpgrade(db, oldVersion, newVersion)
         }
     companion object {

         const val DATABASE_VERSION = 1
         const val DATABASE_NAME = "mydatabase.db"
         }
     }
