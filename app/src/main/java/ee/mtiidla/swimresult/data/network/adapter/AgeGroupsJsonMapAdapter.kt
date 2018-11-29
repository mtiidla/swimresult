package ee.mtiidla.swimresult.data.network.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import ee.mtiidla.swimresult.data.network.model.AgeGroupNetworkModel
import ee.mtiidla.swimresult.data.network.model.AgeGroupsNetworkModel

class AgeGroupsJsonMapAdapter {

    @FromJson
    fun fromJson(reader: JsonReader, adapter: JsonAdapter<AgeGroupNetworkModel>): AgeGroupsNetworkModel {

        @Suppress("UNCHECKED_CAST")
        val jsonMap = reader.readJsonValue() as Map<String, Any>

        val ageGroups = mutableListOf<AgeGroupNetworkModel>()

        for ((key, value) in jsonMap) {
            if (key != "lastupdate") {
                ageGroups.add(adapter.fromJsonValue(value)!!)
            }
        }

        return AgeGroupsNetworkModel(jsonMap["lastupdate"] as String, ageGroups)
    }
}