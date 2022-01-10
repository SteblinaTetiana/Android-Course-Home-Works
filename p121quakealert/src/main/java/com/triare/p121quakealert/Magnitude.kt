package com.triare.p121quakealert

enum class Magnitude(
    val title: String,
    val color: Int
) {
    SCARCELY_PARCEPTIBLE("Ледь відчутний", R.color.scarcely_parceptible_color),
    WEAK("Слабкий", R.color.weak_color),
    AVERAGE("Середній", R.color.average_color),
    STRONG("Сильний", R.color.strong_color),
    VERY_STRONG("Дуже сильний", R.color.very_strong_color)
}