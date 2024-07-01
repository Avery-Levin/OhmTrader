import checks.checkKeyValidity
import checks.isDayOfWeek
import checks.isMarketOpen
import exceptions.EmptyKeyException
import exceptions.StupidUserException
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import net.jacobpeterson.alpaca.AlpacaAPI
import net.jacobpeterson.alpaca.model.util.apitype.MarketDataWebsocketSourceType
import net.jacobpeterson.alpaca.model.util.apitype.TraderAPIEndpointType
import java.time.DayOfWeek


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Please enter your Key ID")
    var keyID: String = readln()
    println("Please enter your Secret Key")
    var secretKey: String = readln()
    val endpointType = TraderAPIEndpointType.PAPER
    val sourceType = MarketDataWebsocketSourceType.IEX
    val clock: Clock = Clock.System

    var monday: OrderManager? = null
    var tuesday: OrderManager? = null
    var wednesday: OrderManager? = null
    var thursday: OrderManager? = null
    var friday: OrderManager? = null
    var workingDate: LocalDate = clock.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date
    println("Ohm Trader activated at $workingDate")



    try {
        checkKeyValidity(keyID, secretKey)
    }
    catch (e: EmptyKeyException) {
        println("Type the keys in this time, please and thank you.")
        println("Please enter your Key ID")
        keyID = readln()
        println("Please enter your Secret Key")
        secretKey = readln()
        if (keyID == "" || secretKey == "") {
            throw StupidUserException()
        }
    }


    val alpacaAPI = AlpacaAPI(keyID, secretKey, endpointType, sourceType)
    while (true) {
        workingDate = clock.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
        if (isMarketOpen(clock)) {
            if (isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.MONDAY)) {
                if (monday == null) {
                    monday = OrderManager(symbol = selectStock(), alpacaAPI, clock)
                }; if (!monday.tradeHasBeenPlaced) {
                    monday.placeOrder()
                } else if (monday.sellDate == workingDate) {
                    monday.closePos()
                    monday = null
                    waitUntilDateChange(workingDate, DayOfWeek.TUESDAY)

                }


            } else if (isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.TUESDAY)) {
                if (tuesday == null) {
                    tuesday = OrderManager(symbol = selectStock(), alpacaAPI, clock)
                }; if (!tuesday.tradeHasBeenPlaced) {
                    tuesday.placeOrder()
                } else if (tuesday.sellDate == workingDate) {
                    tuesday.closePos()
                    tuesday = null
                    waitUntilDateChange(workingDate, DayOfWeek.WEDNESDAY)

                }


            } else if (isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.WEDNESDAY)) {
                if (wednesday == null) {
                    wednesday = OrderManager(symbol = selectStock(), alpacaAPI, clock)
                }; if (!wednesday.tradeHasBeenPlaced) {
                    wednesday.placeOrder()
                } else {
                    if (wednesday.sellDate == workingDate) {
                        wednesday.closePos()
                        wednesday = null
                        waitUntilDateChange(workingDate, DayOfWeek.THURSDAY)

                    }
                }
            } else if (isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.THURSDAY)) {
                if (thursday == null) {
                    thursday = OrderManager(symbol = selectStock(), alpacaAPI, clock)
                }; if (!thursday.tradeHasBeenPlaced) {
                    thursday.placeOrder()
                } else if (thursday.sellDate == workingDate) {
                    thursday.closePos()
                    thursday = null
                    waitUntilDateChange(workingDate, DayOfWeek.WEDNESDAY)

                }


            } else if (isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.FRIDAY)) {
                if (friday == null) {
                    friday = OrderManager(symbol = selectStock(), alpacaAPI, clock)
                }; if (!friday.tradeHasBeenPlaced) {
                    friday.placeOrder()
                } else {
                    if (friday.sellDate == workingDate) {
                        friday.closePos()
                        friday = null
                        waitUntilDateChange(workingDate, DayOfWeek.SATURDAY)

                    }
                }

            } else {
                println("Market is closed, will check again in 20 minutes. $workingDate")
                Thread.sleep(1200000)
            }


        }
    }
}


