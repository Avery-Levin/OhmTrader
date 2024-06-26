import exceptions.ClosedMarketException
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.Instant

fun checkMarketStatus(timestamp : Instant) {
    if (timestamp.toLocalDateTime(TimeZone.currentSystemDefault()).hour < 9.5 && timestamp.toLocalDateTime(TimeZone.currentSystemDefault()).hour > 16 ){
        throw ClosedMarketException()
    }
}