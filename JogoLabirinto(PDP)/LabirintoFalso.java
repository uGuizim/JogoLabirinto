import greenfoot.*;
public class LabirintoFalso extends Actor implements Labirinto
{
     public void tipo() {
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null) {
            jogador.bloquearMovimento(false); // Não bloqueia o movimento do jogador
            jogador.retornarPosicao(); // Chama o método para retornar o jogador à posição anterior
        }
    }

    public boolean podeAtravessar() {
        return true; // Pode atravessar LabirintoFalso
    }
}
