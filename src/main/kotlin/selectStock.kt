fun selectStock() : String{
    val selectableStocks = listOf("AAPL","ABBV","ABT","ACN","AGN","AIG","ALL","AMGN","AMZN,AXP","BA","BAC","BIIB","BK","BLK","BMY","C","CAT","CELG","CL","CMCSA","COF","COP","COST","CSCO","CVS","CVX","DD","DHR","DIS","DOW","DUK","EMC"
        ,"EMR","EXC","F","FB","FDX","FOX","FOXA","GD","GE","GILD","GM","GOOG","GOOGL","GS","HAL","HD","HON","IBM","INTC","JNJ","JPM","KMI","KO","LLY","LMT","LOW","MA","MCD","MDLZ","MDT","MET","MMM","MO","MON","MRK","MS","MSFT","NEE","NKE"
        ,"ORCL","OXY","PCLN","PEP","PFE","PG","PM","PYPL","QCOM","RTN","SBUX","SLB","SO","SPG","T","TGT","TWX","TXN","UNH","UNP","UPS","USB","USD","UTX","V","VZ","WBA","WFC")
    return selectableStocks.random()


}