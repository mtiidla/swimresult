package ee.mtiidla.swimresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ee.mtiidla.swimresult.ui.meetlist.MeetListFragment

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, MeetListFragment()).commit()
        }
    }
}
