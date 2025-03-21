package com.example.yeojeong

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.PlanRcvDateAdapter
import com.example.yeojeong.Adapter.PlanRcvDateDecoration
import com.example.yeojeong.Adapter.PlanViewRcvAdapter
import com.example.yeojeong.databinding.ActivityPlanViewBinding

class PlanViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding=ActivityPlanViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //계획 목록 리사이클러뷰
        binding.planViewRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.planViewRecyclerView.adapter = PlanViewRcvAdapter(savedInstanceState, mutableListOf<String>("테스트","테스트"));

        //날짜 리사이클러뷰
        binding.planViewDateRecyclerView.layoutManager = LinearLayoutManager(this).apply {orientation=LinearLayoutManager.HORIZONTAL}
        binding.planViewDateRecyclerView.adapter = PlanRcvDateAdapter(mutableListOf<String>("2/4","2/5","2/6","2/7","2/8"))
        binding.planViewDateRecyclerView.addItemDecoration(PlanRcvDateDecoration())

        //지도 버튼 눌렀을 때 맵뷰 액티비티 표시
        binding.planViewMapButton.setOnClickListener {
            val intent: Intent =Intent(this,MapViewActivity::class.java)
            startActivity(intent)
        }

        //인포카드 버튼 눌렀을 때 인포카드 액티비티 표시
        binding.planViewInfoCard.setOnClickListener {
            val intent: Intent =Intent(this,InfoCardActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}