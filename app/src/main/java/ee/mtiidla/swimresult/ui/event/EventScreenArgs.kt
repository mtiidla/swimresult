package ee.mtiidla.swimresult.ui.event

import android.os.Parcelable
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventScreenArgs(val meetScreenArgs: MeetScreenArgs, val eventId: Long) : Parcelable
