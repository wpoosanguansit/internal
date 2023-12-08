package com.playground.internal.core.utils

import android.util.Log
import com.playground.internal.core.event.BaseEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * [EventBus] is a pipeline that receives events. It triggers
 * subscriptions if any posted event subscribed the posted event's tag.
 * It can be used in different scopes, developer can pass desired
 * scope in [EventBus.subscribe] method.
 *
 *      // Subscribing an event
 *      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
 *           super.onViewCreated(view, savedInstanceState)
 *           EventBus.subscribe<DataEvent>(
 *               scope = CoroutineScope(Dispatchers.IO),
 *               tag = EventType.TAG_DATA
 *           ){
 *               data = it.data
 *            }
 *
 *      ...
 *
 *      // Posting an event
 *      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
 *           super.onViewCreated(view, savedInstanceState)
 *           EventBus.post(event = DataEvent(str), tag = EventType.TAG_DATA)
 *
 *      ...
 *
 * Look for [DataEvent][com.tsci.coroutinesbus.event.DataEvent] for passed event in the example above.
 *
 */
object EventBus {


    private val _flow = MutableSharedFlow<Pair<String, BaseEvent>>()
    val flow = _flow.asSharedFlow()

    // scope to use for data emitting.
    private val ioScope = CoroutineScope(Dispatchers.IO)

    // it is like a buffer queue that suspends until consume so it can overflow
    val channel = Channel<Pair<String, BaseEvent>>()

    /**
     * Sends data to shared flow which named [flow]. Bus contains
     * a pair of [tag] and [event] data.
     *
     * @param tag event's id
     * @param event the event to send
     */
    fun publish(tag: String, event: BaseEvent) {
        val value = Pair(tag ,event)
        ioScope.launch {
            _flow.emit(value)
        }
    }

    /**
     * Subscribes the event tagged by passed [tag]. Uses default coroutine
     * scope if any [scope] not passed. Invokes higher order function
     * if tagged event triggered and its type compromises with triggered event.
     *
     * @param scope defines the scope that [action] will launch
     * @param tag event's tag to filter with other events
     * @param action higher order function to be invoked if event triggered
     */
    inline fun <reified T : BaseEvent> subscribe(
        scope: CoroutineScope = CoroutineScope(Dispatchers.Default),
        tag: String,
        crossinline action: (T) -> Unit
    ) {
        scope.launch {
            flow.collectLatest {
                if (tag == it.first && it.second is T)
                    action(it.second as T)
            }
        }
    }

    /**
     * Sends data using Producer-Consumer Pattern [channel]. Bus contains
     * a pair of [tag] and [event] data.
     * Channel plays the role of a communication mechanism for synchronization
     * points in two or more concurrent executions
     *
     * @param tag event's id
     * @param event the event to send
     */
    fun produce(tag: String, event: BaseEvent) {
        val value = Pair(tag ,event)
        ioScope.launch {
            Log.i("com.playground.internal", "------ produce ${value.first} ${value.second}")
            channel.send(value)
        }
    }

    /**
     * Consume the event tagged by passed [tag]. Uses default coroutine
     * scope if any [scope] not passed. Invokes higher order function
     * if tagged event triggered and its type compromises with triggered event.
     * Be cautious in using this as it can cause buffer overflow when there no
     * consumer while producer keeps producing the event.
     *
     * @param scope defines the scope that [action] will launch
     * @param tag event's tag to filter with other events
     * @param action higher order function to be invoked if event triggered
     */
    inline fun <reified T : BaseEvent> consume(
        scope: CoroutineScope = CoroutineScope(Dispatchers.Default),
        tag: String,
        crossinline action: (T) -> Unit
    ) {
        scope.launch {
            channel.consumeEach {
                Log.i("com.playground.internal", "------ consumeEach ${it.first} ${it.second}")
                if (tag == it.first && it.second is T)
                    action(it.second as T)
            }
        }
    }
}