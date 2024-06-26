package exceptions

class ClosedMarketException : Exception("Market is not open, but a trade was attempted anyways.") {
}