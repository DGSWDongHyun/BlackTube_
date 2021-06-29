package kr.hs.dgsw.donghyeon.blacktube.widget

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BindingAdapter {
    @BindingAdapter("bind:setAdapter")
    @JvmStatic
    fun setAdapter(recyclerView: RecyclerView?, adapter : RecyclerView.Adapter<*>?) {
        recyclerView?.run {
            this.adapter = adapter
            layoutManager = GridLayoutManager(recyclerView.context, 1)
        }
    }

    @BindingAdapter("bind:onScrolled")
    @JvmStatic
    fun onScrolled(recyclerView : RecyclerView?, isEnded : MutableLiveData<Boolean>) {
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)


                val lastVisibleItemPosition = (recyclerView.layoutManager as GridLayoutManager).findLastVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter?.itemCount?.minus(1)
                if (lastVisibleItemPosition == itemTotalCount) {
                    isEnded.value = true
                }

            }
        })
    }
}