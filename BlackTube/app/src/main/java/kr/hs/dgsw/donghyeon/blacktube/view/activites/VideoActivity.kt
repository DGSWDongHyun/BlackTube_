package kr.hs.dgsw.donghyeon.blacktube.view.activites

import android.app.PictureInPictureParams
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.donghyeon.blacktube.R
import kr.hs.dgsw.donghyeon.blacktube.base.BaseActivity
import kr.hs.dgsw.donghyeon.blacktube.databinding.ActivityMainBinding
import kr.hs.dgsw.donghyeon.blacktube.databinding.ActivityVideoBinding
import kr.hs.dgsw.donghyeon.blacktube.viewmodel.MainViewModel
import kr.hs.dgsw.donghyeon.blacktube.viewmodel.VideoViewModel

@AndroidEntryPoint
class VideoActivity : BaseActivity<ActivityVideoBinding, VideoViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_video
    override val viewModel: VideoViewModel
        get() = ViewModelProvider(this)[VideoViewModel::class.java]

    override fun onViewCreated(view: ActivityVideoBinding) {
        lifecycle.addObserver(view.youtubePlayerView)

        view.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                if(intent.hasExtra("videoID")) {
                    youTubePlayer.loadVideo(intent.getStringExtra("videoID")!!, 0F)
                }
                super.onReady(youTubePlayer)
            }
        })
    }

    override fun onUserLeaveHint() {
        enterPipMode()
    }

    override fun onBackPressed() {
        enterPipMode()
    }

    private fun enterPipMode() {
        val params = PictureInPictureParams.Builder().build();
        enterPictureInPictureMode(params)
    }
}