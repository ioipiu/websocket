package cn.kgc.tangcco.websocket.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: websocket
 * @description: TODO
 * @author: cuihao
 * @create: 2020-01-10 10:36
 * @version: V1.0
 **/

@ServerEndpoint("/websocket")
@Component
public class WebSocket {

    private Session session;

    private static CopyOnWriteArrayList<WebSocket> webSockets=new CopyOnWriteArrayList<>();


    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        System.out.println("连上了一个，现在总共有："+webSockets.size()+"个连接");
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("关闭了一个，现在总共有："+webSockets.size()+"个连接");
    }

    @OnMessage
    public void onMessage(String message) {
        webSockets.forEach(x-> {
            try {
                x.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @OnError
    public void onError(Throwable throwable) {
        System.out.println("error");
    }
}
