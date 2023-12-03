import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DecoradorSomVitoria extends DecoradorSom {
    public DecoradorSomVitoria(ComponenteSom componente) {
        super(componente);
    }

    public void reproduzirSom() {
        super.reproduzirSom();
        Greenfoot.playSound("victory-sound.mp3"); // Substitua "som_vitoria.mp3" pelo nome do seu arquivo de som de vitória
    }
}
