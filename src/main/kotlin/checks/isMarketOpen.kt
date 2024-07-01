package checks

import kotlinx.datetime.Clock
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun isMarketOpen(clock: Clock): Boolean {
    val currentTime = clock.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .hour
    if (currentTime > 9.5 && currentTime < 16) {
        if (!isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.SATURDAY) && !isDayOfWeek(
                clock = clock,
                dayOfWeek = DayOfWeek.SUNDAY
            )
        ) {
            return true
        }
    }
    return false
}