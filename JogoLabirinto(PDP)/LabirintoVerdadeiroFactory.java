import greenfoot.*;  

public class LabirintoVerdadeiroFactory extends Actor implements LabirintoFactory
{
  public Labirinto criarLabirinto() {
        return new LabirintoVerdadeiro();
    }
}
