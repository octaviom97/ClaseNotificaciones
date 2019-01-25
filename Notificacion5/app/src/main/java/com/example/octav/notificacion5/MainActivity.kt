package com.example.octav.notificacion5

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (task.isSuccessful){
                        val token = task.result!!.token
                        textView.setText(token)
                        return@OnCompleteListener
                    }
                })
    }
    fun enviarEmail(view: View){
        val txt = textView.getText().toString().trim()
        val i = Intent(Intent.ACTION_SEND)
        i.type="text/plain"
        i.putExtra(Intent.EXTRA_EMAIL, arrayOf("octaviiom97@gmail.com"))
        i.putExtra(Intent.EXTRA_SUBJECT, arrayOf("TokenFB"))
        i.putExtra(Intent.EXTRA_TEXT,txt)
        val chooser = Intent.createChooser(i,"Enviar Correo")
        startActivity(chooser)
    }
}
