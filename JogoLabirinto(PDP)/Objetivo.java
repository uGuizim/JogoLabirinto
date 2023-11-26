import greenfoot.*;  // 

public class Objetivo extends Actor {
    private int timer = 0;
    private long startTime = System.currentTimeMillis();
    private boolean jogoEncerrado = false;
    int num = 100;
    int tempoDecorrido;
    int minutos;
    int seg;

    public int getTimer() {
        long tempoDecorrido = System.currentTimeMillis() - startTime;
        return (int) tempoDecorrido / 1000;
    }

    public void act() {
        if (!jogoEncerrado) {
            tempoDecorrido = getTimer();
            // int num = 10;
            displayTimer(tempoDecorrido);
            if (tempoDecorrido >= num) {
                encerrarJogo();
            }
        }
    }

    private void displayTimer(int segundos) {
    
        minutos = segundos / 60;
        seg = segundos % 60;
        String formatoTimer = String.format("%02d:%02d", minutos, seg);
        getWorld().showText(formatoTimer, 70, 545);
       
    }

    private void encerrarJogo() {
        jogoEncerrado = true;
        Greenfoot.stop();
        getWorld().showText("Tempo Esgotado!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }
}
