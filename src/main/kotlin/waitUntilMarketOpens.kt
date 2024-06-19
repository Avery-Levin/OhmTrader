import kotlinx.datetime.*
fun waitUntilMarketOpens(clock: Clock) {

    while (true) {
        var time = clock.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .time
        if (time.hour > 9.5 && time.hour > 16) {
            break
        } else {
            Thread.sleep(10000)
        }
    }

}