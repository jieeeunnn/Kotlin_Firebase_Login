package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.firebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinButton.setOnClickListener { // signin버튼 (로그인 버튼)
            val userEmail = binding.username.text.toString() // userEmail 입력
            val password = binding.password.text.toString() // password 입력
            doLogin(userEmail, password) // 로그인 함수 호출
        }

        binding.signupButton.setOnClickListener{ // signup버튼 (계정 생성 버튼)
            val userEmail = binding.username.text.toString() // userEmail 입력
            val password = binding.password.text.toString() // password 입력
            doSignup(userEmail, password) // 계정 생성 함수 호출
        }
    }

    private fun doLogin(userEmail: String, password: String) { // 로그인 함수
        Firebase.auth.signInWithEmailAndPassword(userEmail, password) // 입력받은 email과 password로 sign in
            .addOnCompleteListener(this) {
                if (it.isSuccessful) { // 로그인 성공 시 MainActivity 실행
                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )
                    finish()
                } else { // 로그인 실패 시
                    Log.w("LoginActivity", "signInWithEmail", it.exception)
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun doSignup(userEmail: String, password: String) { // 새로운 계정을 생성하는 함수
        Firebase.auth.createUserWithEmailAndPassword(userEmail,password) // 입력받은 email과 password로 새로운 계정 생성
            .addOnCompleteListener {
                if(it.isSuccessful) { // 로그인 성공시 MainAcrivity 호출
                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )
                    finish()
                } else { // 로그인 실패 시
                    Log.w("LoginActivity", "signUpWithEmail", it.exception)
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}