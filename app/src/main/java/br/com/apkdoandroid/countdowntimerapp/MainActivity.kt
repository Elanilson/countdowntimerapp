package br.com.apkdoandroid.countdowntimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import br.com.apkdoandroid.countdowntimerapp.databinding.ActivityMainBinding
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var timer : Timer
    private lateinit var countDownTimer: CountDownTimer
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            countDownTimer = object : CountDownTimer(5000,1000){
                override fun onTick(p0: Long) {
                    runOnUiThread {
                        binding.textView.text = p0.toString()
                    }
                }

                override fun onFinish() {
                    binding.textView.text = "Finalizado"
                }

            }
            countDownTimer.start()
        }

        binding.button2.setOnClickListener {
            binding.textView.text = "Finalizou"
            timer.cancel() }
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }
    }