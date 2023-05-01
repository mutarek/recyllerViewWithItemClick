package com.example.recyllerviewbatch2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var dataSource: ArrayList<MyModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.myRecyllerView)
        loadData()
        initRecyllerVIew()

    }

    private fun initRecyllerVIew() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = MyAdapter(dataSource)
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : MyAdapter.OnClickListener {
            override fun onClick(position: Int, model: MyModelClass) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                // Passing the data to the
                // EmployeeDetails Activity
                intent.putExtra("name", model.name)
                intent.putExtra("number", model.number)
                intent.putExtra("profile", model.profile)
                startActivity(intent)
            }

        })
    }

    private fun loadData() {
        dataSource = arrayListOf()
        dataSource.add(
            MyModelClass(
                "Rahim",
                "489384983494834389",
                "https://media.licdn.com/dms/image/C5603AQH1gy__fdmPWg/profile-displayphoto-shrink_800_800/0/1639676571693?e=2147483647&v=beta&t=Y2BGer5-XbHXf3ZVJLHje3g86tDzISn4wgEv3z-iqkA"
            )
        )
        dataSource.add(
            MyModelClass(
                "Karim",
                "4343434367777",
                "https://media.licdn.com/dms/image/C5603AQH1gy__fdmPWg/profile-displayphoto-shrink_800_800/0/1639676571693?e=2147483647&v=beta&t=Y2BGer5-XbHXf3ZVJLHje3g86tDzISn4wgEv3z-iqkA"
            )
        )
    }
}