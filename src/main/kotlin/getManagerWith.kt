import kotlinx.datetime.Clock
import net.jacobpeterson.alpaca.AlpacaAPI


fun getManagerWith(symbol: String, api: AlpacaAPI, clock: Clock): OrderManager {
    println("Better not use this method, as this is completely redundant.")
    return OrderManager(symbol = symbol, alpacaAPI = api, clock = clock)

}





