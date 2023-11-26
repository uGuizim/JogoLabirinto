import greenfoot.*;

public class LabirintoFalsoFactory extends Actor implements LabirintoFactory
{
    public Labirinto criarLabirinto() {
        return new LabirintoFalso();
    }
}
