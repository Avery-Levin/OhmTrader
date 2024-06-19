

import kotlinx.datetime.*
import kotlinx.datetime.Clock
import net.jacobpeterson.alpaca.AlpacaAPI
import net.jacobpeterson.alpaca.openapi.trader.model.*
import java.math.BigDecimal


class OrderManager(val symbol : String, val alpacaAPI : AlpacaAPI, val clock: Clock) {
    var timestamp = clock.now()

    var sellDate : LocalDate? = null

    fun placeOrder() {

        val openingOrder: Order = alpacaAPI.trader().orders()
            .postOrder(
                PostOrderRequest()
                    .symbol(symbol)
                    .qty("1")
                    .side(OrderSide.BUY)
                    .type(OrderType.MARKET)
                    .timeInForce(TimeInForce.GTC)
            )


             sellDate = timestamp.plus(7, DateTimeUnit.DAY, TimeZone.currentSystemDefault() )
                .toLocalDateTime(TimeZone.currentSystemDefault())
                .date






        println("One share of $symbol has been purchased at $timestamp. This will be sold in roughly 24 hours")
    }
    fun closePos() {
        val closingOrder : Order = alpacaAPI.trader().positions()
            .deleteOpenPosition(symbol, null, BigDecimal("100"))
    }


}