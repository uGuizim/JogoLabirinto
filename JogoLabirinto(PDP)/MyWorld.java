import greenfoot.*;

public class MyWorld extends World {
    private Greenfoot controle;
    private Jogador jogador;
    private Objetivo objetivo;

    String[] textMap = {
        "J*******************",
        ".O*........*.....*.*",
        "*.*.********.**.**.*",
        "*.*...........*....*",
        "*...*.*.*.*.***.**.*",
        "*.*.***.***.*.*.**.*",
        "*.*......*..*.*.*..*",
        "*.*.**.*.****.*.**.*",
        "*....*.*........*..*",
        "*.****.*.*.****.*.**",
        "*......*.**.***.*..*",
        "*.*.****........*.**",
        "*.**.*.**********.**",
        "*...............F..*",
        "******************.."
    };

    public MyWorld() {
        super(800, 600, 1);
        this.controle = new Greenfoot();
        this.jogador = new Jogador();
        this.objetivo = new Objetivo();
        addObject(this.objetivo, 780, 580);
        desenhoMapa();
    }

    private void desenhoMapa() {
        for (int i = 0; i < textMap.length; i++) {
            String mapLine = textMap[i];
            for (int j = 0; j < mapLine.length(); j++) {
                char mapChar = mapLine.charAt(j);
                int y = i * 40 + 20;
                int x = j * 40 + 20;
                switch (mapChar) {
                    case '*':
                        addObject(new LabirintoVerdadeiro(), x, y);
                        break;
                    case '.':
                        break;
                    case 'F':
                        addObject(new LabirintoFalso(), x, y);
                        break;
                    case 'J':
                        addObject(this.jogador, x, y);
                        break;
                    case 'O':
                        addObject(this.objetivo, x, y);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void act() {
        if (this.controle.isKeyDown("right") || this.controle.isKeyDown("d")) {
            this.jogador.andarDireita();
        } else if (this.controle.isKeyDown("left") || this.controle.isKeyDown("a")) {
            this.jogador.andarEsquerda();
        } else if (this.controle.isKeyDown("up") || this.controle.isKeyDown("w")) {
            this.jogador.andarCima();
        } else if (this.controle.isKeyDown("down") || this.controle.isKeyDown("s")) {
            this.jogador.andarBaixo();
        }
    }
}
