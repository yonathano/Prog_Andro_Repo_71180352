package id.ac.ukdw.final_71180352

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firestore = FirebaseFirestore.getInstance()

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtGenre = findViewById<EditText>(R.id.edtGenre)
        val edtThnRilis = findViewById<EditText>(R.id.edtThnRilis)
        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnCari = findViewById<Button>(R.id.btnCari)
        val txtKeluaran = findViewById<TextView>(R.id.txtKeluaran)
        val btnUbah = findViewById<Button>(R.id.btnUbah)



        btnTambah.setOnClickListener {
            val film = Film(edtNama.text.toString(), edtGenre.text.toString(), edtThnRilis.text.toString().toInt())
            edtNama.setText("")
            edtGenre.setText("")
            edtThnRilis.setText("")
            firestore?.collection("film")?.document(film.nama)?.set(film)
        }

        btnCari.setOnClickListener {
            firestore?.collection("film")?.document(edtNama.text.toString())?.get()!!
                .addOnSuccessListener { doc ->
                    txtKeluaran.setText(doc.data.toString())
                }
        
        }
    }
}