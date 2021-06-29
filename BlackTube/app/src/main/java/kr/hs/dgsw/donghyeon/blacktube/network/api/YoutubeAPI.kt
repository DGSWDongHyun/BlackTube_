package kr.hs.dgsw.donghyeon.blacktube.network.api

import io.reactivex.Single
import kr.hs.dgsw.donghyeon.blacktube.base.constants.Constants
import kr.hs.dgsw.donghyeon.blacktube.data.YoutubeResultData
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeAPI {
    @GET("search")
    fun getList(@Query("channelId") channelName : String = Constants.BASIC_CHANNEL,
                @Query("key") key : String = Constants.BASIC_KEY,
                @Query("type") type : String = Constants.BASIC_TYPE,
                @Query("order") order : String = Constants.BASIC_ORDER,
                @Query("part") part : String = Constants.BASIC_PART,
                @Query("maxResults") result : String = Constants.BASIC_RESULT
    ) : Single<retrofit2.Response<YoutubeResultData>>

    @GET("search")
    fun getList(@Query("channelId") channelName : String = Constants.BASIC_CHANNEL,
                @Query("key") key : String = Constants.BASIC_KEY,
                @Query("type") type : String = Constants.BASIC_TYPE,
                @Query("page") page : String = "",
                @Query("order") order : String = Constants.BASIC_ORDER,
                @Query("part") part : String = Constants.BASIC_PART,
                @Query("maxResults") result : String = Constants.BASIC_RESULT
    ) : Single<retrofit2.Response<YoutubeResultData>>
}