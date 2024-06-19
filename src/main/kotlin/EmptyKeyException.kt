class EmptyKeyException(message: String? = null, cause: Throwable? = null) : Exception(message) {
    constructor(cause: Throwable) : this(null, cause)
}