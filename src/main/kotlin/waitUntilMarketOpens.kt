import kotlinx.datetime.*
fun waitUntilMarketOpens(clock: Clock) {
    var time = clock.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .time
    while (true) {
       check@ if (time.hour > 9.5 && time.hour > 16) {
            return
        } else {
            Thread.sleep(10000)
            break@check
        }
    }
}