import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jogador extends Actor
{
    private GreenfootImage imgDireita1;
    private GreenfootImage imgDireita2;
    private GreenfootImage imgEsquerda1;
    private GreenfootImage imgEsquerda2;
    private boolean controleImg;
    private int passos = 3;
    private int cont;
    private boolean venceu = false;

    public Jogador(){
        this.imgDireita1 = new GreenfootImage("Coelho01.png");
        this.imgDireita2 = new GreenfootImage("Coelho02.png");
        this.imgEsquerda1 = new GreenfootImage("Coelho03.png");
        this.imgEsquerda2 = new GreenfootImage("Coelho04.png");
        this.setImage(imgDireita1);
        this.controleImg = false;
        this.cont = 0;
    }

    public void andarDireita(){
        setLocation(getX() +this.passos, getY());
        alteraImgDireita();
        if(bater() == true){
            setLocation(getX() -5, getY());
        }
    }

    public void andarEsquerda(){
        setLocation(getX() -this.passos, getY());
        alteraImgEsquerda();
        if(bater() == true){
            setLocation(getX()+5, getY());
        }
    }

    public void andarCima(){
        setLocation(getX(), getY() -this.passos);
        alteraImgDireita(); // Use as imagens da esquerda quando o jogador move para cima
        if(bater() == true){
            setLocation(getX(), getY()+5);
        }
    }

    public void andarBaixo(){
        setLocation(getX(), getY() +this.passos);
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
        if (isTouching(Labirinto.class)){
        return true;
        }else {
            return false;
        }
    }
    private void exibirMenuVencedor() {
        // Crie um novo ator para exibir o menu de vencedor
        Vencedor menuVencedor = new Vencedor();
        getWorld().addObject(menuVencedor, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    }
    public void act(){
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
                andarDireita();
            } else if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
                andarEsquerda();
            } else if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
                andarCima();
            } else if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
                andarBaixo();
            }
            if(isTouching(Objetivo.class) && !venceu){
            venceu = true;
            Greenfoot.stop(); // Encerra o jogo
            exibirMenuVencedor(); // Exibe o menu de vencedor
    }
    
        }
    }
    
    
