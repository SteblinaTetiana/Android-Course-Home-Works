package com.triare.p121quakealert

import androidx.annotation.StringRes

enum class Magnitude(
    @StringRes
    val title: Int,
    @StringRes
    val color: Int
) {
    SCARCELY_PARCEPTIBLE(R.string.scarcely_parceptible_title, R.color.scarcely_parceptible_color),
    WEAK(R.string.weak_title, R.color.weak_color),
    AVERAGE(R.string.average_title, R.color.average_color),
    STRONG(R.string.strong_title, R.color.strong_color),
    VERY_STRONG(R.string.very_strong_title, R.color.very_strong_color)

}