package com.example.viewbindinginrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindinginrecycler.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity() {
    private var _binding:ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvAdapter: RvAdapter
    private lateinit var languageList: List<Language>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadlanguage()

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvList.setLayoutManager(layoutManager)
        rvAdapter = RvAdapter(languageList)
        binding.rvList.adapter = rvAdapter

    }
    private fun loadlanguage(){
        languageList= listOf(
            Language("Java","Exp: 3years"),
            Language("C","Exp: 1years"),
            Language("Python","Exp: 4years"),
            Language("C++","Exp: 5years"),
            Language("Kotlin","Exp: 3years"),
            Language("Shell Scripting","Exp: 1years"),
            Language("Docker","Exp: 1years"),
            Language("Kubernetes","Exp: 1years")
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}