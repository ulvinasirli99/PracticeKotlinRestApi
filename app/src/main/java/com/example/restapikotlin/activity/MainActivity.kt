package com.example.restapikotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.restapikotlin.R
import com.example.restapikotlin.`interface`.JsonInterface
import com.example.restapikotlin.model.model
import com.example.restapikotlin.service.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val idLine: TextView = findViewById(R.id.idLine)

        val titleLine: TextView = findViewById(R.id.titleLine)

        val bodyLine: TextView = findViewById(R.id.bodyLine)


        val retrofit = Retrofit.Builder()

            .addConverterFactory(GsonConverterFactory.create())

            .baseUrl("https://jsonplaceholder.typicode.com/")

            .build();

        val JsonInterface = retrofit.create(JsonInterface::class.java)

        val mCall: Call<List<model>> = JsonInterface.getInfo();

        mCall.enqueue(object : Callback<List<model>> {

            override fun onFailure(call: Call<List<model>>, t: Throwable) {

                Log.e("Error", "onFailure: ", t)

            }

            override fun onResponse(call: Call<List<model>>, response: Response<List<model>>) {

                val mmodel: List<model> = response.body()!!
//
//                val stringBuilder = StringBuilder()

                for (i in mmodel) {

                    idLine.setText(i.id)

                    titleLine.setText(i.title)

                    bodyLine.setText(i.mBody)

                }
            }

        }
        )

    }
}