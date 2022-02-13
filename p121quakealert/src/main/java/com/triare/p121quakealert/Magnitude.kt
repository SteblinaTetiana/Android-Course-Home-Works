package com.triare.p121quakealert

enum class Magnitude {
    SCARCELY_PARCEPTIBLE,
    WEAK,
    AVERAGE,
    STRONG,
    VERY_STRONG;

    val title: Int
        get() = when (this) {
            SCARCELY_PARCEPTIBLE -> R.string.magnitude_scarcely_parceptible_title
            WEAK -> R.string.magnitude_weak_title
            AVERAGE -> R.string.magnitude_average_title
            STRONG -> R.string.magnitude_strong_title
            VERY_STRONG -> R.string.magnitude_very_strong_title
        }
    val color: Int
        get() = when (this) {
            SCARCELY_PARCEPTIBLE -> R.string.magnitude_scarcely_parceptible_title
            WEAK -> R.color.green
            AVERAGE -> R.color.yellow
            STRONG -> R.color.orange
            VERY_STRONG -> R.color.very_strong_color
        }
    val icon: Int
        get() = when (this) {
            SCARCELY_PARCEPTIBLE -> R.drawable.ic_magnitude_scarcely_parceptible
            WEAK -> R.drawable.ic_magnitude_weak
            AVERAGE -> R.drawable.ic_magnitude_average
            STRONG -> R.drawable.ic_magnitude_strong
            VERY_STRONG -> R.drawable.ic_magnitude_very_strong
        }

    companion object {
        fun getMagnitude(magnitude: Double): Magnitude {
            return when (magnitude) {
                in 1.0..1.99 -> SCARCELY_PARCEPTIBLE
                in 2.0..2.99 -> WEAK
                in 3.0..4.49 -> AVERAGE
                in 4.5..5.99 -> STRONG
                else -> VERY_STRONG
            }
        }
    }
}