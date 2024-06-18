import net.jacobpeterson.alpaca.AlpacaAPI
import org.example.OrderManager

class Instantiator {
    fun getManagerWith(symbol : String, api : AlpacaAPI) : OrderManager {
        return OrderManager(symbol = symbol, alpacaAPI = api )

    }





}