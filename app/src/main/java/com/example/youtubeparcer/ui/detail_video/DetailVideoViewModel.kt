package com.example.youtubeparcer.ui.detail_video

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeparcer.model.DetailPlaylistModel
import com.example.youtubeparcer.model.DetailVideoModel
import com.example.youtubeparcer.repository.MainRepository
import com.example.youtubeparcer.utils.App
import kotlinx.coroutines.launch

class DetailVideoViewModel : ViewModel() {

    val database = App().getInstance().getDatabase()
    fun getVideoData(id: String) : LiveData<DetailVideoModel>? {
        return MainRepository.fetchVideoData(id)
    }

    suspend fun getDataBase(): List<DetailVideoModel> {
        return database.ytVideoDao().getDetailVideo()
    }

    fun insertDetailPlaylistData(model: DetailVideoModel) {
        viewModelScope.launch {
            database.ytVideoDao().insertDetailVideoPlaylistData(model)
        }
    }
}