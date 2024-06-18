package org.example
import net.jacobpeterson.alpaca.*
import net.jacobpeterson.alpaca.model.util.apitype.MarketDataWebsocketSourceType
import net.jacobpeterson.alpaca.model.util.apitype.TraderAPIEndpointType
import net.jacobpeterson.alpaca.openapi.trader.api.ClockApi


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Please enter your Key ID")
    val keyID : String = readln()
    println("Please enter your Secret Key")
    val secretKey : String = readln()
    val endpointType = TraderAPIEndpointType.PAPER
    val sourceType = MarketDataWebsocketSourceType.IEX
    val alpacaAPI = AlpacaAPI(keyID, secretKey, endpointType, sourceType)
    val clock = ClockApi()

    var selectableStocks = listOf("AAPL","ABBV","ABT","ACN","AGN","AIG","ALL","AMGN","AMZN,AXP","BA","BAC","BIIB","BK","BLK","BMY","C","CAT","CELG","CL","CMCSA","COF","COP","COST","CSCO","CVS","CVX","DD","DHR","DIS","DOW","DUK","EMC"
        ,"EMR","EXC","F","FB","FDX","FOX","FOXA","GD","GE","GILD","GM","GOOG","GOOGL","GS","HAL","HD","HON","IBM","INTC","JNJ","JPM","KMI","KO","LLY","LMT","LOW","MA","MCD","MDLZ","MDT","MET","MMM","MO","MON","MRK","MS","MSFT","NEE","NKE"
        ,"ORCL","OXY","PCLN","PEP","PFE","PG","PM","PYPL","QCOM","RTN","SBUX","SLB","SO","SPG","T","TGT","TWX","TXN","UNH","UNP","UPS","USB","USD","UTX","V","VZ","WBA","WFC","GME","AMC","TSLA","NVDA")






}