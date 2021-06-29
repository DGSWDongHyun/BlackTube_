package kr.hs.dgsw.donghyeon.blacktube.data

import com.google.gson.annotations.SerializedName

data class YoutubeResultData(
    @SerializedName("nextPageToken")
    var nextTokenName : String?,
    @SerializedName("prevPageToken")
    var prevPageName : String?,
    @SerializedName("items")
    var itemList : ArrayList<VideoData>?

)

data class VideoData(
    @SerializedName("snippet")
    var snippetData: SnippetData
)

data class SnippetData(
    @SerializedName("publishedAt")
    var publishedTime : String?,
    @SerializedName("title")
    var title : String?,
    @SerializedName("thumbnails")
    var thumbnailsData: ThumbnailsData?,
    @SerializedName("channelTitle")
    var channelName : String?
)

data class ThumbnailsData(
    @SerializedName("high")
    var imageHigh : Thumbnails?
)

data class Thumbnails(
    @SerializedName("url")
    var imageURL : String?
)