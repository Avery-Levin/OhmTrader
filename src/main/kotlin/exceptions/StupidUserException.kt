package exceptions

class StupidUserException(cause: Throwable? = null) : Exception("I told you to put the fucking keys in, and you didn't. Now, you get to reopen the program like a loser. Think about what you did before you waste my time again. ") {
}