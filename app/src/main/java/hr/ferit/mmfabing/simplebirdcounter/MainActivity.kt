package hr.ferit.mmfabing.simplebirdcounter

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvCount: TextView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var yellow = findViewById<Button>(R.id.yellow_bird)
        var red = findViewById<Button>(R.id.red_bird)
        var gray = findViewById<Button>(R.id.gray_bird)
        var blue = findViewById<Button>(R.id.blue_bird)
        tvCount = findViewById<TextView>(R.id.birds)
        var res = findViewById<Button>(R.id.reset)



        yellow.setOnClickListener{
            yellowBirdSeen("#FDFF00")
        }

        red.setOnClickListener{
            redBirdSeen("#D71E1E")
        }

        gray.setOnClickListener{
            grayBirdSeen("#A0A0A0")
        }

        blue.setOnClickListener{
            blueBirdSeen("#1a1aff")
        }

        res.setOnClickListener {
            reset()
        }
    }


     private fun yellowBirdSeen(color: String) {
        count++
        tvCount.text = "$count"
        tvCount.setBackgroundColor(Color.YELLOW)

        Log.i("data", count.toString())
        Log.i("color", color)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("color", color)
            putInt("tvCount", count)
        }.apply()
    }

    private fun redBirdSeen(color: String) {
        count++
        tvCount.text = "$count"
        tvCount.setBackgroundColor(Color.RED)

        Log.i("data", count.toString())
        Log.i("color", color)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("color", color)
            putInt("tvCount", count)
        }.apply()
    }

    private fun grayBirdSeen(color: String) {
        count++
        tvCount.text = "$count"
        tvCount.setBackgroundColor(Color.GRAY)

        Log.i("data", count.toString())
        Log.i("color", color)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("color", color)
            putInt("tvCount", count)
        }.apply()
    }

    private fun blueBirdSeen(color: String) {

        count++
        tvCount.text = "$count"
        tvCount.setBackgroundColor(Color.BLUE)

        Log.i("color", color)
        Log.i("data", count.toString())

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("color", color)
            putInt("tvCount", count)
        }.apply()
    }

    private fun reset(){
        count = 0
        tvCount.text = "0"
        tvCount.setBackgroundColor(Color.WHITE)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()

        editor.clear()
        editor.apply()

    }
}