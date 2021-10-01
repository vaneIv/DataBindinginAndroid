package com.vane.android.databindinginandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * A simple VM for [com.example.android.databinding.basicsample.ui.PlainOldActivity].
 */
class SimpleViewModel : ViewModel() {

    private val _name = MutableLiveData("Ada")
    private val _lastName = MutableLiveData("Lovelace")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    /**
     * Increments the number of likes.
     */
    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }

    /**
     * Returns popularity in buckets: [Popularity.NORMAL], [Popularity.POPULAR] or [Popularity.STAR]
     */
    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}