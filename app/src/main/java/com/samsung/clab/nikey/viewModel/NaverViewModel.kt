package com.samsung.clab.nikey.viewModel

import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.samsung.clab.nikey.R

class NaverViewModel : ViewModel() {
    val items = ObservableArrayList<ItemViewModel>()
    val itemsVisible = ObservableInt(View.GONE)
    private val itemsMap = HashMap<String, Array<ItemViewModel>>()
    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        @RequiresApi(Build.VERSION_CODES.N)
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val text = p0.toString()
            var viewModels: Array<ItemViewModel>? = null

            Log.i("Nikey", "text: $text")

            itemsMap.forEach { (key, items) ->
                if (text.contains(key)) {
                    viewModels = items
                    return@forEach
                }
            }
            if (viewModels != null) {
                itemsVisible.set(View.VISIBLE)
                updateItems(viewModels!!)
            } else {
                itemsVisible.set(View.GONE)
            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }
    }

    init {
        initItems()
    }

    private fun updateItems(newItems: Array<ItemViewModel>) {
        items.clear()
        newItems.forEach {
            items.add(it)
        }
    }

    private fun initItems() {
        // 4번째 아이템은 잘 안보이기 때문에 중복과 상관없이 대충 함
        
//        // 음악앱을 많이 사용하는 사용하는 대학생:
//        // 여수밤바다 노래 바로듣기 피드 / 여수 인스타 태그 검색 링크 / 여수 날씨 / 여수 맛집
//        itemsMap["여수"] = arrayOf(
//            ItemViewModel(R.drawable.ic_music, "멜론", "여수밤바다 노래 피드 바로듣기"),
//            ItemViewModel(R.drawable.ic_instagram, "인스타그램", "#여수 태그 보기"),
//            ItemViewModel(R.drawable.ic_weather, "날씨", "여수 주간 날씨 보기"),
//            ItemViewModel(R.drawable.ic_naver, "네이버", "여수 맛집 (플레이스) 바로 보기")
//        )

//        // 여행을 좋아하는 자차를가진 직장인 남성:
//        // 여수 날씨 / 여수까지 네비게이션 앱 링크 / 숙박앱 링크
//        itemsMap["여수"] = arrayOf(
//            ItemViewModel(R.drawable.ic_weather, "날씨", "여수 주간 날씨 보기"),
//            ItemViewModel(R.drawable.ic_navi, "카카오네비", "여수까지 길찾기"),
//            ItemViewModel(R.drawable.ic_hotel, "호텔검색", "여수호텔, 호텔스컴바인 - 오늘의 핫딜 호텔 추천"),
//            ItemViewModel(R.drawable.ic_air_bnb, "에어비엔비", "여수시 휴가용 임대 숙소 & 숙박시설")
//        )

//        // 차량이 없는, 미혼 20대 여성, 바다 좋아함
//        // 여수 날씨 / 여수 바닷가 맛집 /  요즘 날씨 코디 / 랜터카앱 링크 피드 / 쏘카앱 링크 피드 / 여수기차예매정보 피드 / 여수고속버스예매정보 피드,
//        itemsMap["여수"] = arrayOf(
//            ItemViewModel(R.drawable.ic_codi, "오늘의코디", "바다여행 갈땐 이렇게 입으세요"),
//            ItemViewModel(R.drawable.ic_weather, "날씨", "여수 주간 날씨 보기"),
//            ItemViewModel(R.drawable.ic_naver, "네이버", "여수 바닷기 맛집 바로 보기"),
//            ItemViewModel(R.drawable.ic_air_bnb, "에어비엔비", "여수시 휴가용 임대 숙소 & 숙박시설")
//        )

        // 아이가 있는 30대 기혼여성
        // 아이랑 갈만한 여수 관광지 피드 / 여수 호텔 예약 링크 / 아이 수영복 / 여수 해수욕장 정보 피드
        itemsMap["여수"] = arrayOf(
            ItemViewModel(R.drawable.ic_travel, "여수여행", "아이와 함께하는 여수 관광지 확인"),
            ItemViewModel(R.drawable.ic_hotel, "호텔검색", "여수호텔, 호텔스컴바인 - 오늘의 핫딜 호텔 추천"),
            ItemViewModel(R.drawable.ic_coupang, "쿠팡", "아이 수영복 찾으시나요?"),
            ItemViewModel(R.drawable.ic_navi, "카카오네비", "여수까지 길찾기"),
        )
    }
}
