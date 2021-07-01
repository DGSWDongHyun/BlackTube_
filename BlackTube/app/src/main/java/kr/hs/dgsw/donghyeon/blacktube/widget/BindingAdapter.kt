package kr.hs.dgsw.donghyeon.blacktube.widget

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.donghyeon.blacktube.data.VideoData
import kr.hs.dgsw.donghyeon.blacktube.view.VideoAdapter

@BindingAdapter("onScrolled")
fun onBottom(recyclerView: RecyclerView?, isEnd : MutableLiveData<Boolean>) {
    recyclerView?.setOnScrollChangeListener(object : View.OnScrollChangeListener {
        override fun onScrollChange(
            v: View?,
            scrollX: Int,
            scrollY: Int,
            oldScrollX: Int,
            oldScrollY: Int
        ) {
            if(!recyclerView.canScrollVertically(1)) {
                isEnd.value = true
            }
        }

    })
}
