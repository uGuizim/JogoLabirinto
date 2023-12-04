import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DecoradorSomVitoria extends DecoradorSom {
    public DecoradorSomVitoria(ComponenteSom componente) {
        super(componente);
    }

    public void reproduzirSom() {
        super.reproduzirSom();
        Greenfoot.playSound("victory-sound.mp3");
    }
}
