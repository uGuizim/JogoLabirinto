import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Objetivo extends Actor
{
    private int timer = 0;
    private int tempoMaximo = 1000000; // Tempo máximo em milissegundos

    public void act()
    {
        timer = timer + 1;
        exibirTimer();
        
        if (timer == tempoMaximo) {
            encerrarJogo();
        }
    }

    // Método para exibir o timer no formato "mm:ss:ms"
    private void exibirTimer() {
        int minutos = timer / 6000; 
        int segundos = (timer % 6000) / 60; 

        String formatoTimer = String.format("%02d:%02d", minutos, segundos);
        getWorld().showText(formatoTimer, 30, 30);
    }

    // Método para configurar o tempo máximo
    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }

    // Método para encerrar o jogo e exibir uma mensagem
    private void encerrarJogo() {
        Greenfoot.stop();
        getWorld().showText("Tempo Esgotado!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }
}

