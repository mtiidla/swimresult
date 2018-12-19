package ee.mtiidla.swimresult.ui.resultlist

import ee.mtiidla.swimresult.domain.model.AgeGroup

object AgeGroupDisplayer {

    fun getTitle(ageGroup: AgeGroup): String = with(ageGroup) {
        name ?: with(AgeGroupFormatterFactory.getFormatter(key[0])) {
            when (Character.getNumericValue(key[1])) {
                1 -> equalMinMax(min)
                2 -> openMin(max)
                3 -> openMax(min)
                4 -> rangeMinMax(min, max)
                else -> {
                    "Unknown age group"
                }
            }
        }
    }

    object AgeGroupFormatterFactory {

        fun getFormatter(type: Char) = when (type) {
            'a' -> AgeOldFormatter()
            'y' -> YearOfBirthFormatter()
            'r' -> TotalAgeFormatter()
            else -> throw IllegalArgumentException("Unknown age group formatting type $type")
        }
    }

    interface AgeGroupFormatter {

        fun equalMinMax(age: Int): String
        fun openMin(max: Int): String
        fun openMax(min: Int): String
        fun rangeMinMax(min: Int, max: Int): String
    }

    class YearOfBirthFormatter : AgeGroupFormatter {

        override fun equalMinMax(age: Int): String = "YOB $age"

        override fun openMin(max: Int): String = "$max and younger"

        override fun openMax(min: Int): String = "$min and older"

        override fun rangeMinMax(min: Int, max: Int): String = "YOB $min - $max"
    }

    class AgeOldFormatter : AgeGroupFormatter {

        override fun equalMinMax(age: Int): String = "$age years"

        override fun openMin(max: Int): String = "$max years and younger"

        override fun openMax(min: Int): String = "$min years and older"

        override fun rangeMinMax(min: Int, max: Int): String = "$min - $max years"
    }

    class TotalAgeFormatter : AgeGroupFormatter {
        override fun equalMinMax(age: Int): String {
            TODO("not implemented")
        }

        override fun openMin(max: Int): String {
            TODO("not implemented")
        }

        override fun openMax(min: Int): String {
            TODO("not implemented")
        }

        override fun rangeMinMax(min: Int, max: Int): String = "AG $min - $max"
    }

}
