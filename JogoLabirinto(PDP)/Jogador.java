import greenfoot.*;

public class Jogador extends Actor
{
    private int xAnterior;
    private int yAnterior;
    private boolean podeMover = true;

    private GreenfootImage imgDireita1;
    private GreenfootImage imgDireita2;
    private GreenfootImage imgEsquerda1;
    private GreenfootImage imgEsquerda2;
    private boolean controleImg;
    private int passos = 1;
    private int cont;
    private boolean venceu = false;

    public Jogador(){
        double number = 0.75;
        this.imgDireita1 = new GreenfootImage("Coelho01.png");
        this.imgDireita1.scale((int)(this.imgDireita1.getWidth() * number), (int)(this.imgDireita1.getHeight() * number));

        this.imgDireita2 = new GreenfootImage("Coelho02.png");
        this.imgDireita2.scale((int)(this.imgDireita2.getWidth() * number), (int)(this.imgDireita2.getHeight() * number));

        this.imgEsquerda1 = new GreenfootImage("Coelho03.png");
        this.imgEsquerda1.scale((int)(this.imgEsquerda1.getWidth() * number), (int)(this.imgEsquerda1.getHeight() * number));

        this.imgEsquerda2 = new GreenfootImage("Coelho04.png");
        this.imgEsquerda2.scale((int)(this.imgEsquerda2.getWidth() * number), (int)(this.imgEsquerda2.getHeight() * number));

        this.setImage(imgDireita1);
        this.controleImg = false;
        this.cont = 0;
    }

    public void retornarPosicao() {
        setLocation(xAnterior, yAnterior);
    }

    public void bloquearMovimento(boolean bloquear) {
        podeMover = !bloquear;
    }

    public void andarDireita(){
        setLocation(getX() +(int)this.passos, getY());
        alteraImgDireita();
        if(bater() == true){
            setLocation(getX() -5, getY());
        }
    }

    public void andarEsquerda(){
        setLocation(getX() -(int)this.passos, getY());
        alteraImgEsquerda();
        if(bater() == true){
            setLocation(getX()+5, getY());
        }
    }

    public void andarCima(){
        setLocation(getX(), getY() -(int)this.passos);
        alteraImgDireita(); // Use as imagens da esquerda quando o jogador move para cima
        if(bater() == true){
            setLocation(getX(), getY()+5);
        }
    }

    public void andarBaixo(){
        setLocation(getX(), getY() +(int)this.passos);
        alteraImgDireita(); // Use as imagens da esquerda quando o jogador move para baixo
        if(bater() == true){
            setLocation(getX(), getY()-5);
        }
    }

    public void alteraImgEsquerda(){
        this.cont++;
        if (this.cont == 5){
            if(this.controleImg){
                setImage(imgEsquerda1);
                this.controleImg = false;
            } else {
                setImage(imgEsquerda2);
                this.controleImg = true;
            }
            this.cont= 0;
        }
    }

    public void alteraImgDireita(){
        this.cont++;
        if (this.cont == 5){
            if(this.controleImg){
                setImage(imgDireita1);
                this.controleImg = false;
            } else {
                setImage(imgDireita2);
                this.controleImg = true;
            }
            this.cont= 0;
        }
    }

    public boolean bater(){
        if (isTouching(LabirintoVerdadeiro.class)){
            return true;
        } else {
            return false;
        }
    }

    private void exibirMenuVencedor() {
        Vencedor menuVencedor = new Vencedor();
        getWorld().addObject(menuVencedor, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }

    public void act(){
        xAnterior = getX();
        yAnterior = getY();

        if (podeMover) {
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
                andarDireita();
            } else if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
                andarEsquerda();
            } else if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
                andarCima();
            } else if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
                andarBaixo();
            }
        }
         if(isTouching(Objetivo.class) && !venceu){
            venceu = true;
            Objetivo objetivo = (Objetivo)getWorld().getObjects(Objetivo.class).get(0);
            int tempoDecorrido = objetivo.getTimer();
            Greenfoot.stop();
            exibirMenuVencedor();
            Vencedor menuVencedor = new Vencedor();
            getWorld().addObject(menuVencedor, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
           getWorld().showText("Tempo: " + tempoDecorrido + " segundos", 120, 40);// Exibe o menu de vencedor
           getWorld().showText("", 70, 545);  // Remove o texto do temporizador
        }
    }
}
