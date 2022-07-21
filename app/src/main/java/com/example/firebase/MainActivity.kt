package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Firebase.auth.currentUser == null) { // 로그인이 되어있지 않는 상태일 때 (currentUser이 null이면 로그인이 안되어 있는 상태)
            startActivity(
                Intent(this, LoginActivity::class.java) // 다시 로그인 창을 띄움
            )
            finish()
        }

        binding.textUID.text = Firebase.auth.currentUser?.uid ?: "No User"

        binding.signoutButton.setOnClickListener { // 로그아웃 버튼을 누르면 로그아웃 후 로그인 창으로 돌아감
            Firebase.auth.signOut() // 로그아웃
            startActivity(
                Intent(this, LoginActivity::class.java) // LoginAcivity로 돌아감
            )
            finish()
        }

    }
}