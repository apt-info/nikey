package com.samsung.clab.nikey.viewModel

import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.samsung.clab.nikey.R

class KatalkViewModel : ViewModel() {
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
        itemsMap["코로나"] = arrayOf(
            ItemViewModel(R.drawable.ic_news, "여행 뉴스", "코로나로 여행객 어쩌구 저쩌구"),
            ItemViewModel(R.drawable.ic_naver, "여행 블로그", "남해 여행 어디까지 가봤니"),
            ItemViewModel(R.drawable.ic_instagram, "남해 카페", "#아난티,#여행,#인생카페"),
            ItemViewModel(R.drawable.ic_facebook, "페북", "페북 여행 콘텐츠")
        )
        itemsMap["휴가"] = arrayOf(
            ItemViewModel(R.drawable.ic_instagram, "남해 여행", "#아난티,#여행,#플렉스"),
            ItemViewModel(R.drawable.ic_naver, "블로그", "전주 한옥마을 휴가 리얼후기"),
            ItemViewModel(R.drawable.ic_round_calendar_today_24, "일정", "하계휴가 7.12~7.15"),
            ItemViewModel(R.drawable.ic_gallery, "사진", "갤러리에서 #여행 사진보기")
        )
    }
}