package id.ac.ukdw.pert5_71180352_activity_intent

import android.os.Bundle
import  android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val Uname = intent.getStringExtra("Username")

        val txtHasil = findViewById<TextView>(R.id.textHasil)
        txtHasil.text = "Selamat Datang ${Uname}"
    }
}