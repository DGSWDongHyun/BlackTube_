package kr.hs.dgsw.donghyeon.blacktube.repo

import android.util.Log
import io.reactivex.Single
import kr.hs.dgsw.donghyeon.blacktube.data.YoutubeResultData
import kr.hs.dgsw.donghyeon.blacktube.network.api.YoutubeAPI
import javax.inject.Inject

class YoutubeRepository @Inject constructor(
    private val youtubeAPI: YoutubeAPI
) {
    fun parseYoutubeList() : Single<retrofit2.Response<YoutubeResultData>> = youtubeAPI.getList()

    fun parseNextYoutubeList(pageToken : String) : Single<retrofit2.Response<YoutubeResultData>> = youtubeAPI.getNextList(page = pageToken)

}