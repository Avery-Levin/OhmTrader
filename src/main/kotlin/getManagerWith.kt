import kotlinx.datetime.Clock
import net.jacobpeterson.alpaca.AlpacaAPI



    fun getManagerWith(symbol : String, api : AlpacaAPI, clock: Clock) : OrderManager {
        return OrderManager(symbol = symbol, alpacaAPI = api, clock = clock)

    }





