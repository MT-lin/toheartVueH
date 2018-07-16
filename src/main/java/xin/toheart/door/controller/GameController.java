package xin.toheart.door.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {
    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);

    @RequestMapping("/gameHome")
    public String gameHome() {
        return "game/gameHome";
    }
    @RequestMapping("/2048")
    public String game2048(){
        return "game/2048";
    }
}

