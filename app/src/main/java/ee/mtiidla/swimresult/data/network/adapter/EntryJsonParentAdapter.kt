package ee.mtiidla.swimresult.data.network.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.ToJson
import ee.mtiidla.swimresult.data.network.model.EntryNetworkModel

class EntryJsonParentAdapter {

    @FromJson
    fun fromJson(
        reader: JsonReader,
        athleteAdapter: JsonAdapter<EntryNetworkModel.AthleteEntryNetworkModel>,
        clubAdapter: JsonAdapter<EntryNetworkModel.ClubEntryNetworkModel>
    ): EntryNetworkModel {

        @Suppress("UNCHECKED_CAST")
        val jsonMap = reader.readJsonValue() as Map<String, Any>

        return if (jsonMap.containsKey("athletes")) {
            clubAdapter.fromJsonValue(jsonMap)!!
        } else {
            athleteAdapter.fromJsonValue(jsonMap)!!
        }
    }

    @ToJson
    fun toJson(entryNetworkModel: EntryNetworkModel): String =
        throw UnsupportedOperationException("Mapping $entryNetworkModel to json is not implemented")
}