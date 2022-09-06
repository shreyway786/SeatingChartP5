import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RishavNairProfile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RishavNairProfile extends RishavNair
{
    /**
     * Act - do whatever the RishavNairProfile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (clicked == false){
            setImage(portraitFile); 
            for (int i=1;i<=3;i++){
                setLocation(this.getX(),this.getY()+1);
                Greenfoot.delay(30);
            }
            for (int i=1;i<=3;i++){
                setLocation(this.getX()+1,this.getY()+1);
                Greenfoot.delay(30);
            }
            for (int i=1;i<=2;i++){
                setLocation(this.getX(),this.getY()+1);
                Greenfoot.delay(30);
            }
            for (int i=1;i<=2;i++){
                setLocation(this.getX()-1,this.getY());
                Greenfoot.delay(30);
            }
            for (int i=1;i<=1;i++){
                setLocation(this.getX()-1,this.getY()+1);
                Greenfoot.delay(30);
            }
            for (int i=1;i<=2;i++){
                setLocation(this.getX()-1,this.getY());
                Greenfoot.delay(30);
            }
            for (int i=1;i<=2;i++){
                setLocation(this.getX(),this.getY()-1);
                Greenfoot.delay(30);
            }
            for (int i=1;i<=1;i++){
                setLocation(this.getX()+1,this.getY()-1);
                Greenfoot.delay(30);
            }
            Greenfoot.delay(30);
            RishavNair.clicked=true; 
            setImage((GreenfootImage)null);
        }
    }
}
