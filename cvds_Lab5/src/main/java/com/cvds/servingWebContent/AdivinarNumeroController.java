package com.cvds.servingWebContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/juego")
public class AdivinarNumeroController {

    private final AdivinarNumero guessNumber;

    @Autowired
    public AdivinarNumeroController(AdivinarNumero guessNumber) {
        this.guessNumber = guessNumber;
    }

    @GetMapping
    public String showGamePage(Model model) {
        model.addAttribute("prize", guessNumber.getPrize());
        return "juego";
    }

    @GetMapping("/reset")
    public String resetGame() {
        guessNumber.resetGame();
        return "redirect:/juego";
    }

    @PostMapping
    public String playGame(@RequestParam("numero") int userGuess, Model model) {
        int randomNumber = guessNumber.generateRandomNumber();

        // El usuario acertó, gana el premio
        if (guessNumber.checknum(userGuess, randomNumber)&& guessNumber.getPrize()>0) {
            model.addAttribute("message", "¡Felicidades! Ganaste $" + guessNumber.getPrize()+ " :D");
        } else {
            if (guessNumber.checknum(userGuess, randomNumber)&& guessNumber.getPrize()<0){
                
                 model.addAttribute("message", "¡Felicidades! nos debes  $" + guessNumber.getPrize()+ " D:");
            }else {
                guessNumber.reducePrize();
                model.addAttribute("message", "¡Sigue intentando! tu premio actual es de $" + guessNumber.getPrize());
            }
        }

  
        return "resultado";
    }


  
}