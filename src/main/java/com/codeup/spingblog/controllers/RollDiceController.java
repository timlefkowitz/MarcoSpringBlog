package com.codeup.spingblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String home() {
        return "RollDice";
    }

    @PostMapping("/roll-dice/{number}")
    public String result(@RequestParam(name = "number") int number, Model model){
        int random = (int) (Math.random() * 6 + 1);

        model.addAttribute("diceFace", random);
        model.addAttribute("number", number);
        return "diceResult";


    }
}
