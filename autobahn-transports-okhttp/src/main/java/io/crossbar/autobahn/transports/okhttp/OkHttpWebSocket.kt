package io.crossbar.autobahn.transports.okhttp


import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener

/**
 * Created by cgoldberg02 on 11/20/17.
 */
/*
class OkHttpWebSocket : IWebSocket {
    private lateinit var okHttpClient: OkHttpClient

    override fun connect(wsUri: String, wsHandler: IWebSocketConnectionHandler?) {
        connect(wsUri, wsHandler)
    }

    override fun connect(wsUri: String, wsHandler: IWebSocketConnectionHandler?, options: WebSocketOptions?) {
        connect(wsUri, wsHandler, options)
    }

    override fun connect(wsUri: String, wsSubprotocols: Array<out String>?, wsHandler: IWebSocketConnectionHandler?) {
        connect(wsUri, wsSubprotocols, wsHandler, null, null)
    }

    override fun connect(wsUri: String, wsSubprotocols: Array<out String>?, wsHandler: IWebSocketConnectionHandler?, options: WebSocketOptions?, headers: MutableMap<String, String>?) {
        val headerBuilder = Headers.Builder()

        if (wsSubprotocols?.isNotEmpty() == true) {
            headerBuilder.add("Sec-WebSocket-Protocol", wsSubprotocols.joinToString())
        }

        if (headers?.isNotEmpty() == true) {
            headers.forEach { headerBuilder.add(it.key, it.value) }
        }

        val request = Request.Builder()
                .url(wsUri)
                .headers(headerBuilder.build())
                .build()

        // TODO: WebSocketOptions are ignored!
        val client = OkHttpClient.Builder()
                .build()

        client.newWebSocket(request, object : WebSocketListener() {

        })
    }

    override fun sendClose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendClose(code: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendClose(code: Int, reason: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isConnected(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMessage(payload: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMessage(payload: ByteArray?, isBinary: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPing() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPing(payload: ByteArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPong() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendPong(payload: ByteArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}*/
