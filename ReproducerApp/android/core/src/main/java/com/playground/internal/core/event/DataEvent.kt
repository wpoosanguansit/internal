package com.playground.internal.core.event

data class DataEvent(
    val data: String
): BaseEvent() {
    companion object{
        const val TAG = "TAG_DATA"
    }
}