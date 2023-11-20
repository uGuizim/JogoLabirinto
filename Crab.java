import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Crab extends Actor
{
    private GreenfootImage imagem1;
    private GreenfootImage imagem2;
    private int passos = 5;
    private boolean controleImagem;
    private int contador;
    private int vida;
    
    public Crab(){
        this.imagem1 = new GreenfootImage("crab.png");
        this.imagem2 = new GreenfootImage("crab2.png");
        this.setImage(imagem1);
        this.controleImagem = false;
        this.contador = 0;
    }
    
    
    public void act(){
        Actor borboleta = getOneIntersectingObject(Inimigo.class);
        if(borboleta != null){
            getWorld().removeObject(borboleta);
        }
    }
    
    public void andarDireita(){
        setLocation(getX() + this.passos, getY());
        alteraImagem();
    }
    
    public void andarEsquerda(){
        setLocation(getX() - this.passos, getY());
        alteraImagem();
    }
    
    public void andarCima(){
        setLocation(getX(), getY() - this.passos);
        alteraImagem();
    }
    
    public void andarBaixo(){
        setLocation(getX(), getY() + this.passos);
        alteraImagem();
    }
    
    public void alteraImagem(){
        this.contador++;
        if (this.contador == 5){
            if(this.controleImagem){
                setImage(imagem1);
                this.controleImagem = false;
            } else {
            setImage(imagem2);
            this.controleImagem = true;
            }
            this.contador = 0;
        }
    }
}
