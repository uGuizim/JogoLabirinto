import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LabirintoVerdadeiro extends Actor implements Labirinto
{
     public void tipo() {
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null) {
            jogador.bloquearMovimento(true); // Bloqueia apenas atravessar o LabirintoVerdadeiro
            jogador.retornarPosicao(); // Chama o método para retornar o jogador à posição anterior
        }
    }

    public boolean podeAtravessar() {
        return false; // Não pode atravessar LabirintoVerdadeiro
    }
}
