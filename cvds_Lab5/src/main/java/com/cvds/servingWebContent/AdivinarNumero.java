package com.cvds.servingWebContent;


import org.springframework.stereotype.Service;

@Service
public class AdivinarNumero {

    private int precio = 100000;

    public int generateRandomNumber() {
      return (int) (Math.random() * 10) + 1;
    }

    public void reducePrize() {
        precio -= 10000;
    }

    public int getPrize() {
        return precio;
    }

    public void resetGame() {
        precio = 100000;
    }

   
    public boolean checknum(int playerNumb, int randomNumber) {
        return playerNumb == randomNumber;
    }
}
