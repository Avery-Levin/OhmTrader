import kotlinx.datetime.Clock
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun isDayOfWeek(clock: Clock, dayOfWeek: DayOfWeek) : Boolean {
    val currentDate = clock.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .dayOfWeek

    return dayOfWeek == currentDate

}