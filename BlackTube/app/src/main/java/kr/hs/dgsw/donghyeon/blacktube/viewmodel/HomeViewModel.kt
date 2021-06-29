package kr.hs.dgsw.donghyeon.blacktube.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.donghyeon.blacktube.base.BaseViewModel
import kr.hs.dgsw.donghyeon.blacktube.data.YoutubeResultData
import kr.hs.dgsw.donghyeon.blacktube.network.api.YoutubeAPI
import kr.hs.dgsw.donghyeon.blacktube.repo.YoutubeRepository
import kr.hs.dgsw.donghyeon.blacktube.view.VideoAdapter
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : YoutubeRepository
) : BaseViewModel() {

    var nextPageToken = ""
    val videoAdapter = MutableLiveData<VideoAdapter>()
    val isEnded = MutableLiveData<Boolean>()

    init {
        videoAdapter.value = VideoAdapter()
        onLoadVideoList()
    }

    fun onMoreVideoList() {
        addDisposable(repository.parseNextYoutubeList(pageToken = nextPageToken),
            object : DisposableSingleObserver<retrofit2.Response<YoutubeResultData>>() {
                override fun onSuccess(response : Response<YoutubeResultData>) {
                    if(response.isSuccessful) {
                        if(response.code() == 200) {
                            nextPageToken = response.body()?.nextTokenName!!
                            Log.d("Response", "$nextPageToken , ${response.body()?.itemList!!}")
                            videoAdapter.value?.addData(response.body()?.itemList!!)
                        }
                    }
                }

                override fun onError(error : Throwable) {
                    Log.d("Error", "${error.message}")
                }

            }
        )
    }

    private fun onLoadVideoList() {
        addDisposable(repository.parseYoutubeList(),
            object : DisposableSingleObserver<retrofit2.Response<YoutubeResultData>>() {
                override fun onSuccess(response: Response<YoutubeResultData>) {
                    if(response.isSuccessful) {
                        if(response.code() == 200) {
                            nextPageToken = response.body()?.nextTokenName!!
                            Log.d("Response", "${response.body()?.itemList!!}")
                            videoAdapter.value?.setData(response.body()?.itemList!!)
                        }
                    }
                }

                override fun onError(error: Throwable) {
                    Log.d("Error", "${error.message}")
                }

            }
        )
    }
}