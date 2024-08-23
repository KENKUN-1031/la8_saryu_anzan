package app.yoshida.saryu.anzan

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.yoshida.saryu.anzan.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        binding = ActivityAnswerBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val displayQuestion = intent.getStringExtra("question")
        val yourAnswer = intent.getStringExtra("answer")
        val correctAnswer = intent.getStringExtra("correct")

        binding.questionText.text = displayQuestion
        binding.yourAnswerText.text = yourAnswer

        if (yourAnswer == correctAnswer) {
            binding.markImage.setImageResource(R.drawable.correct_image)
            binding.randyImage.setImageResource(R.drawable.randy_happy_image)
        }else {
            binding.markImage.setImageResource(R.drawable.miss_image)
            binding.randyImage.setImageResource(R.drawable.randy_sad_image)
        }

        binding.backButton.setOnClickListener {
            val questionPage = Intent(this, MainActivity::class.java)
            startActivity(questionPage)
            finish()
        }
    }
}