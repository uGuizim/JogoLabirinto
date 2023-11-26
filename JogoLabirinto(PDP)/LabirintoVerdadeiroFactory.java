import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LabirintoVerdadeiroFactory extends Actor implements LabirintoFactory
{
  public Labirinto criarLabirinto() {
        return new LabirintoVerdadeiro();
    }
}
