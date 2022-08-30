import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class debris here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class debris extends JoshFrendberg
{
    public int speedh;
    public int speedv;
    public int x2 = 6;
    public int y2 = 6;
    public int time;
    
    
    /**
     * Act - do whatever the debris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public debris(int direction){
        if (direction == 0){
            speedh = 1;
            speedv = 0;
        }
        else if (direction == 1){
            speedh = -1;
            speedv = 0;
        }
        else if (direction == 2){
            speedv = 1;
            speedh = 0;
        }
        else if (direction == 3){
            speedv = -1;
            speedh = 0;
        }
        else if (direction == 4){
            speedv = -1;
            speedh = 1;
        }
        else if (direction == 5){
            speedv = -1;
            speedh = -1;
        }
        else if (direction == 6){
            speedv = 1;
            speedh = -1;
        }
        else if (direction == 7){
            speedv = 1;
            speedh = 1;
        }
    }
    public void act()
    {
        onExplode();
        time++;
    }
    
    public void onExplode(){
        rescale(32, 32);
        x2 += speedh;
        y2 += speedv;
        setLocation(x2, y2);
        Greenfoot.delay(1);
        if (time >= 8){
            getWorld().removeObject(this);
        }
        
    }
}
