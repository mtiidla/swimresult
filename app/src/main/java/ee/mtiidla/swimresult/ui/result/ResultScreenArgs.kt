package ee.mtiidla.swimresult.ui.result

import android.os.Parcelable
import ee.mtiidla.swimresult.ui.event.EventScreenArgs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultScreenArgs(val eventScreenArgs: EventScreenArgs, val competitorId: Long) : Parcelable