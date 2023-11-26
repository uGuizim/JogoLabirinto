import greenfoot.*;

public class LabirintoVerdadeiro extends Actor implements Labirinto
{
     public void tipo() {
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null) {
            jogador.bloquearMovimento(true);
            jogador.retornarPosicao();
        }
    }

    public boolean podeAtravessar() {
        return false; 
    }
}
