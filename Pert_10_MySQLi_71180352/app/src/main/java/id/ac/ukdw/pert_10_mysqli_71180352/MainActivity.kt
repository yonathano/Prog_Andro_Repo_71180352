package id.ac.ukdw.pert_10_mysqli_71180352

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DatabaseHelper(this)
        db = dbHelper.writableDatabase
                10
         val etNama = findViewById<EditText>(R.id.etNama)
         val etUsia = findViewById<EditText>(R.id.etUsia)
         val btnSimpan = findViewById<Button>(R.id.btnSimpan)
         val btnHapus = findViewById<Button>(R.id.btnHapus)

         btnSimpan.setOnClickListener {
             saveData(etNama.text.toString(), etUsia.text.toString())
             }

         btnHapus.setOnClickListener {
             deleteData(etNama.text.toString(), etUsia.text.toString())
             }

         refreshData()
         }

     fun saveData(nama: String, usia: String){
         val values = ContentValues().apply {
             put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, nama)
             put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, usia)
             }
         db.insert(DatabaseContract.Penduduk.TABLE_NAME, null, values)
         refreshData()
         }

     fun deleteData(nama: String, usia: String){
         val selection = "${DatabaseContract.Penduduk.COLUMN_NAME_NAMA} LIKE ? OR "+
                 "${DatabaseContract.Penduduk.COLUMN_NAME_USIA} LIKE ?"
         val selectionArgs = arrayOf(nama, usia)
         val deletedRows = db.delete(DatabaseContract.Penduduk.TABLE_NAME, selection, selectionArgs)
         refreshData()
         }

     fun refreshData(){
         val columns = arrayOf(
             BaseColumns._ID,
             DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
             DatabaseContract.Penduduk.COLUMN_NAME_USIA
                     )

         val cursor = db.query(
             DatabaseContract.Penduduk.TABLE_NAME,
             columns,
             null,
             null,
             null,
             null,
             null
         )

          var result = ""
          with(cursor) {
              while (moveToNext()) {
              result += "${getString(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_NAMA))}"+
              "-${getString(getColumnIndex(DatabaseContract.Penduduk.COLUMN_NAME_USIA))}th\n"
              }
              }

          val tvHasil = findViewById<TextView>(R.id.tvHasil)
          tvHasil.text = result
        }
     }

}
}