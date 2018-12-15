package ee.mtiidla.swimresult.util

import android.widget.ImageView
import com.squareup.picasso.Picasso
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.CountryCodes
import java.util.Locale

object CountryFlagImageLoader {

    fun loadFlag(countryCodeFina3: String, imageView: ImageView) {
        if (CountryCodes.isValidFinaCountry(countryCodeFina3)) {
            val countryCode = CountryCodes.toIso2(countryCodeFina3).toLowerCase(Locale.US)

            // "https://flagpedia.net/data/flags/normal/$countryCode.png"
            Picasso.get().load("https://allianceone.coop/files/assets/default/images/iso-country-flags/png-country-4x3/res-640x480/$countryCode.png")
                .resizeDimen(R.dimen.spacing_32, R.dimen.spacing_24)
                .centerInside()
                .into(imageView)
        } else {
            imageView.setImageResource(R.drawable.ic_olympic_flag)
        }
    }
}