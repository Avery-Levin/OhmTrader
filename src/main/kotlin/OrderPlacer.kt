package org.example

import net.jacobpeterson.alpaca.AlpacaAPI
import net.jacobpeterson.alpaca.openapi.trader.model.*


class OrderPlacer(val symbol : String, val qty : String, val alpacaAPI : AlpacaAPI) {

    fun placeOrder() {
        val openingOrder: Order = alpacaAPI.trader().orders()
            .postOrder(
                PostOrderRequest()
                    .symbol(symbol)
                    .qty(qty)
                    .side(OrderSide.BUY)
                    .type(OrderType.MARKET)
                    .timeInForce(TimeInForce.GTC)
            )
    }


}