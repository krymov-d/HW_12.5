package kz.kd.hw_125

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Here is my profile")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
        val btnSend: Button = findViewById(R.id.btn_send)
        btnSend.setOnClickListener {
            val emailIntent = Intent()
            emailIntent.action = Intent.ACTION_SENDTO
            intent.data = Uri.parse("mailto:")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Here is my profile")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }
        }
        val btnCall: Button = findViewById(R.id.btn_call)
        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+7 777 777 77 77"))
            startActivity(callIntent)
        }
        val btnCamera: Button = findViewById(R.id.btn_camera)
        btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
    }
}