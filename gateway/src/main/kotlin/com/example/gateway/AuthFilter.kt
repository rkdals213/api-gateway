package com.example.gateway

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange

@Component
class AuthFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : AbstractGatewayFilterFactory<AuthFilter.Companion.Config>(Config::class.java) {
    override fun apply(config: Config): GatewayFilter {
        return (GatewayFilter { exchange: ServerWebExchange, chain: GatewayFilterChain ->
            val request: ServerHttpRequest = exchange.request

            val header = request.headers["Authorization"]?.first()

            val token = BearerHeader.splitToTokenFormat(header).second
            val usable = jwtTokenProvider.isValidToken(token)
            println(usable)

            chain.filter(exchange)
        })
    }

    companion object {
        class Config {
        }
    }
}