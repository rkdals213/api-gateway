package com.example.gateway

object BearerHeader {
    private const val DELIMITER = " "
    private const val BEARER = "Bearer "

    fun splitToTokenFormat(authorization: String?): Pair<String, String> {
        if (authorization == null || authorization.isEmpty()) {
            throw IllegalAccessException()
        }
        val split = authorization.split(DELIMITER.toRegex()).toTypedArray()
        return Pair(split[0], split[1])
    }

    fun of(token: String): String {
        return BEARER + token
    }
}