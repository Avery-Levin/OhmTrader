import kotlinx.datetime.*
fun isMarketOpen(clock: Clock) : Boolean {
    val currentTime = clock.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .hour
   if(currentTime > 9.5 && currentTime < 16) {
       return true
   } else {
       return false
   }
}