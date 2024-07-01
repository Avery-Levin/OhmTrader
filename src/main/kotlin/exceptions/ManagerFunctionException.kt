package exceptions

class ManagerFunctionException :
    Exception("You either used placeOrder() twice or closePos() when you have no position to close.") {
}