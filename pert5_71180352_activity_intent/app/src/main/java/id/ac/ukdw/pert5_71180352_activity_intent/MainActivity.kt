package id.ac.ukdw.pert5_71180352_activity_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtUname = findViewById<EditText>(R.id.edtUname)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener(){
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("Username", edtUname.text.toString())
            startActivity(intent)
        }
    }
}