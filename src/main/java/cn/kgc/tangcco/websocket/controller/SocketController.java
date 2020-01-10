package cn.kgc.tangcco.websocket.controller;

import cn.kgc.tangcco.websocket.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: websocket
 * @description: TODO
 * @author: cuihao
 * @create: 2020-01-10 10:48
 * @version: V1.0
 **/
@Controller
public class SocketController {

    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/")
    public String socket() {
        return "websocket";
    }

    @RequestMapping("/web")
    public String web() {
        return "home";
    }
}
