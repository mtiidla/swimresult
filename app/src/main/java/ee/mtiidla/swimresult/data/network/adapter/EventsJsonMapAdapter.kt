package ee.mtiidla.swimresult.data.network.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import ee.mtiidla.swimresult.data.network.model.EventNetworkModel
import ee.mtiidla.swimresult.data.network.model.EventsNetworkModel

class EventsJsonMapAdapter {

    @FromJson
    fun fromJson(reader: JsonReader, adapter: JsonAdapter<EventNetworkModel>): EventsNetworkModel {

        @Suppress("UNCHECKED_CAST")
        val jsonMap = reader.readJsonValue() as Map<String, Any>

        val events = mutableListOf<EventNetworkModel>()

        for ((key, value) in jsonMap) {
            if (key != "lastupdate") {
                events.add(adapter.fromJsonValue(value)!!)
            }
        }

        return EventsNetworkModel(jsonMap["lastupdate"] as String, events)
    }
}