package kr.hs.dgsw.donghyeon.blacktube.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.donghyeon.blacktube.base.constants.Constants
import kr.hs.dgsw.donghyeon.blacktube.network.api.YoutubeAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun getAPI() : YoutubeAPI
        = Retrofit.Builder()
        .baseUrl(Constants.BASIC_ADDRESS)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(YoutubeAPI::class.java)
}