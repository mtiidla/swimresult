package ee.mtiidla.swimresult.data.network.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.ToJson
import ee.mtiidla.swimresult.data.network.model.ResultNetworkModel

class ResultJsonParentAdapter {

    @FromJson
    fun fromJson(
        reader: JsonReader,
        athleteAdapter: JsonAdapter<ResultNetworkModel.AthleteResultNetworkModel>,
        clubAdapter: JsonAdapter<ResultNetworkModel.ClubResultNetworkModel>
    ): ResultNetworkModel {

        @Suppress("UNCHECKED_CAST")
        val jsonMap = reader.readJsonValue() as Map<String, Any>

        return if (jsonMap.containsKey("athleteid")) {
            athleteAdapter.fromJsonValue(jsonMap)!!
        } else {
            clubAdapter.fromJsonValue(jsonMap)!!
        }
    }

    @ToJson
    fun toJson(resultNetworkModel: ResultNetworkModel): String =
        throw UnsupportedOperationException("Mapping $resultNetworkModel to json is not implemented")
}