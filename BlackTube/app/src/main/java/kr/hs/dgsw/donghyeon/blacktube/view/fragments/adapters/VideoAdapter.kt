package kr.hs.dgsw.donghyeon.blacktube.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.VideoView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.donghyeon.blacktube.data.VideoData
import kr.hs.dgsw.donghyeon.blacktube.data.YoutubeResultData
import kr.hs.dgsw.donghyeon.blacktube.databinding.ItemVideoListBinding
import kr.hs.dgsw.donghyeon.blacktube.view.activites.VideoActivity

class VideoAdapter(private val arrayData : ArrayList<VideoData> = arrayListOf()) : RecyclerView.Adapter<VideoViewHolder>() {

    fun setData(arrayData: ArrayList<VideoData>) {
        this.arrayData.run {
            clear()
            addAll(arrayData)
        }
        notifyItemRangeInserted(0, arrayData.size)
    }

    fun addData(arrayData: ArrayList<VideoData>) {
        this.arrayData.run {
            addAll(arrayData)
        }
        notifyItemRangeInserted(this.arrayData.size, arrayData.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder
        = VideoViewHolder(ItemVideoListBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(arrayData[position])
    }

    override fun getItemCount(): Int = arrayData.size
}

class VideoViewHolder(val view : ItemVideoListBinding) : RecyclerView.ViewHolder(view.root) {
    fun bind(data : VideoData) {
        view.root.setOnClickListener {
            val videoIntent = Intent(view.root.context, VideoActivity::class.java).apply {
                putExtra("videoID", data.id?.id)
            }

            view.root.context.startActivity(videoIntent)
        }
        Glide.with(view.videoThumbnails.context).load(data.snippetData.thumbnailsData?.imageHigh!!.imageURL).centerCrop().into(view.videoThumbnails)
        view.channelName.text = data.snippetData.channelName
        view.videoTitle.text = data.snippetData.title
    }
}