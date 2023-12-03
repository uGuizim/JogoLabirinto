import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class DecoradorSom implements ComponenteSom {
    protected ComponenteSom componente;

    public DecoradorSom(ComponenteSom componente) {
        this.componente = componente;
    }

    public void reproduzirSom() {
        componente.reproduzirSom();
    }
}
