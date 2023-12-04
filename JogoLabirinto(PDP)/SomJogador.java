import greenfoot.*;  

public class SomJogador implements ComponenteSom {
    private GreenfootSound somPassos;

    public SomJogador() {
        somPassos = new GreenfootSound("footstep.mp3");
        somPassos.setVolume(50); // Define o volume para 50%
    }

    public void reproduzirSom() {
        if (!somPassos.isPlaying()) {
            somPassos.play();
        }
    }

    public void pararSom() {
        somPassos.stop();
    }
}
