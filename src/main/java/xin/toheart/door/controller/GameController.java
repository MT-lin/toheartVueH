package xin.toheart.door.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {
    @RequestMapping("/gameHome")
    public String gameHome() {
        return "game/gameHome";
    }
    @RequestMapping("/2048")
    public String game2048(){
        return "game/2048";
    }
}

