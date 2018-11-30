package ee.mtiidla.swimresult.ui

import android.view.ViewGroup

interface Screen {
    // TODO: Marko 30.11.2018 ensure LayoutContainer views are actually cleared
    fun getRootView(): ViewGroup
}