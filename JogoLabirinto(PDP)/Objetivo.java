import greenfoot.*;

// Interface para os estados
interface Estado {
    void executar(Objetivo objetivo);
}

// Implementação do estado inicial
class EstadoInicial implements Estado {
    public void executar(Objetivo objetivo) {
        long tempoDecorrido = System.currentTimeMillis() - objetivo.getStartTime();
        int segundos = (int) tempoDecorrido / 10000;

        objetivo.displayTimer(segundos);

        if (segundos >= objetivo.getNum()) {
            objetivo.mudarEstado(new EstadoEncerrado());
        }
    }
}

// Implementação do estado encerrado
class EstadoEncerrado implements Estado {
    public void executar(Objetivo objetivo) {
        objetivo.setJogoEncerrado(true);
        Greenfoot.stop();
        objetivo.getWorld().showText("Tempo Esgotado!", objetivo.getWorld().getWidth() / 2, objetivo.getWorld().getHeight() / 2);
    }
}

public class Objetivo extends Actor {
    private Estado estadoAtual;
    private long startTime = System.currentTimeMillis();
    private boolean jogoEncerrado = false;
    private int num = 100;
    private int minutos;
    private int seg;

    public Objetivo() {
        // Inicializa o estado como EstadoInicial
        estadoAtual = new EstadoInicial();
    }

    public void act() {
        // Executa o comportamento do estado atual
        estadoAtual.executar(this);
        
    }

    public void mudarEstado(Estado novoEstado) {
        // Muda para um novo estado
        estadoAtual = novoEstado;
    }

    public void displayTimer(int segundos) {
        long tempoDecorrido = (System.currentTimeMillis() - startTime) / 1000;
        minutos = (int) (tempoDecorrido / 60);
        seg = (int) (tempoDecorrido % 60);
        String formatoTimer = String.format("%02d:%02d", minutos, seg);
        getWorld().showText(formatoTimer, 70, 545);
    }

    // Métodos getter e setter adicionados para acesso aos membros privados
    public long getStartTime() {
        return startTime;
    }

    public boolean isJogoEncerrado() {
        return jogoEncerrado;
    }

    public void setJogoEncerrado(boolean jogoEncerrado) {
        this.jogoEncerrado = jogoEncerrado;
    }
   
    public int getNum() {
        return num;
    }
}