package ee.mtiidla.swimresult.ui.athlete

import android.os.Parcelable
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AthleteScreenArgs(val meetScreenArgs: MeetScreenArgs, val athleteId: Long) : Parcelable