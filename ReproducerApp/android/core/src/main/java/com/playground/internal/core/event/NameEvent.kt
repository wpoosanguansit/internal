package com.playground.internal.core.event

data class NameEvent(
    val name: String
): BaseEvent() {
    companion object{
        const val TAG = "TAG_NAME"
    }
}
