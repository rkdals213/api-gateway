package com.example.gateway

import java.time.LocalDateTime

data class Payload(
//    val exp: LocalDateTime,
    val memberPayload: MemberPayload
)

data class MemberPayload(
    val id: Long,
    val email: String,
    val name: String
)