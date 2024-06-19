fun checkKeyValidity(keyID : String , secretKey : String) {
    if(keyID == "" || secretKey == "") {
        throw EmptyKeyException("Make sure to type in the keys. This is a threat.")
    }

}