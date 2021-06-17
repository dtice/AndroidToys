package com.dtice.fortunecookie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dtice.fortunecookie.api.FortuneAPIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FortuneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fortune, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fortuneTextView: TextView = view.findViewById(R.id.fortune_text)

        view.findViewById<Button>(R.id.new_fortune_button).setOnClickListener { view ->
            FortuneAPIClient.apiService.fetchFortune().enqueue(object: Callback<String?> {
                override fun onResponse(call: Call<String?>, response: Response<String?>) {
                    fortuneTextView.text = response.body().toString()
                }

                override fun onFailure(call: Call<String?>, t: Throwable) {
                    Log.e("VH:MainActivity", t.localizedMessage)
                }
            })
        }
    }

    fun fetchFortune(){

    }
}