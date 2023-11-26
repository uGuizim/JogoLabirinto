import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LabirintoFalsoFactory extends Actor implements LabirintoFactory
{
    public Labirinto criarLabirinto() {
        return new LabirintoFalso();
    }
}
