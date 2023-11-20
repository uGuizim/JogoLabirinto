import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{

    private Crab crab;
    private Greenfoot controle;
    private Inimigo inimigo1;
    private Inimigo inimigo2;
    
    
    public MyWorld()
    {    
        super(600, 400, 1); 
        this.crab = new Crab();
        this.controle = new Greenfoot();
        this.inimigo1 = new Inimigo();
        this.inimigo2 = new Inimigo();
        addObject(this.crab, getWidth()/2, getHeight()/2);
        addObject(this.inimigo1, 500, 100);
        addObject(this.inimigo2, 100, 380);
    }
    
    public void act(){
        if(this.controle.isKeyDown("right") || this.controle.isKeyDown("d")){
            this.crab.andarDireita();
        } else if (this.controle.isKeyDown("left") || this.controle.isKeyDown("a")){
            this.crab.andarEsquerda();
        } 
        
        if (this.controle.isKeyDown("up") || this.controle.isKeyDown("w")){
            this.crab.andarCima();
        } else if (this.controle.isKeyDown("down") || this.controle.isKeyDown("s")){
            this.crab.andarBaixo();
        } 
    }
}
