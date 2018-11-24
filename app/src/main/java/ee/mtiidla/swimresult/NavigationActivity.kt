package ee.mtiidla.swimresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ee.mtiidla.swimresult.ui.meetlist.MeetListFragment

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            replaceFragment(MeetListFragment())
        }
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        with(supportFragmentManager.beginTransaction()) {
            replace(android.R.id.content, fragment)
            if (addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }
}
