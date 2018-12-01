package ee.mtiidla.swimresult.ui.club

import android.os.Parcelable
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClubScreenArgs(val meetScreenArgs: MeetScreenArgs, val clubId: Long) : Parcelable