package com.xv.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class GuessController {

    private int prize = 100000;

    @GetMapping("/guess")
    public String showGuessForm(Model model) {
        model.addAttribute("prize", prize);
        return "guess";
    }

    @PostMapping("/guess")
    public String processGuess(@RequestParam("number") int number, Model model) {
        int targetNumber = new Random().nextInt(10) + 1; // Generate a random number between 1 and 10
        if (number == targetNumber) {
            model.addAttribute("message", "¡Felicidades! Ganaste $" + prize);
        } else {
            prize -= 10000; // Reduce prize by $10,000 for each failed attempt
            model.addAttribute("message", "Intenta de nuevo. Saldo restante: $" + prize);
        }
        model.addAttribute("prize", prize);
        return "guess";
    }

    @PostMapping("/reset")
    public String resetGame() {
        prize = 100000;
        return "redirect:/guess";
    }
}
