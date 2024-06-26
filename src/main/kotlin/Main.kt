import exceptions.EmptyKeyException
import exceptions.StupidUserException
import net.jacobpeterson.alpaca.*
import net.jacobpeterson.alpaca.model.util.apitype.MarketDataWebsocketSourceType
import net.jacobpeterson.alpaca.model.util.apitype.TraderAPIEndpointType
import kotlinx.datetime.*
import java.time.DayOfWeek


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Please enter your Key ID")
    var keyID : String = readln()
    println("Please enter your Secret Key")
    var secretKey : String = readln()
    val endpointType = TraderAPIEndpointType.PAPER
    val sourceType = MarketDataWebsocketSourceType.IEX
    val clock : Clock = Clock.System

    var monday : OrderManager? = null
    var tuesday : OrderManager? = null
    var wednesday : OrderManager? = null
    var thursday : OrderManager? = null
    var friday : OrderManager? = null
    var workingDate = clock.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date


        try {
            checkKeyValidity(keyID, secretKey)
        } catch (e: EmptyKeyException) {
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
    while(true){
         workingDate = clock.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
        if(isMarketOpen(clock)){
            if(isDayOfWeek(clock = clock, dayOfWeek = DayOfWeek.MONDAY)){
                if(monday == null){
                    monday = getManagerWith(symbol = selectStock(), alpacaAPI, clock)
                }; if(!monday.tradeHasBeenPlaced){
                    monday.placeOrder()
                } else {
                    if ()
                }


            }

        } else{
            Thread.sleep(120000)
        }


    }}


