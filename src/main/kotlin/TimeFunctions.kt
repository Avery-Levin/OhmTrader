package org.example
import kotlinx.datetime.*

class TimeFunctions(val clock: Clock) {
    var currentInstant : Instant
    val systemTZ = TimeZone.currentSystemDefault()
    var currentLocal : LocalDateTime
    var currentDay : DayOfWeek
    var canTrade : Boolean

    init{

            currentInstant = clock.now()
            currentLocal = currentInstant.toLocalDateTime(systemTZ)
            currentDay = currentLocal.dayOfWeek
            canTrade = false



    }
    fun refreshTime(tradeMadeYet : Boolean){
        currentInstant = clock.now()
        currentLocal = currentInstant.toLocalDateTime(systemTZ)
        currentDay = currentLocal.dayOfWeek
     if(!tradeMadeYet) {
         if ((currentLocal.hour > 9.5)) {
             if (currentLocal.hour < 16) {
                 canTrade = true
             }
         } else {
             canTrade = false
         }
     }
    }


}