import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 *
 * @author (Richard Wu)
 * @version (final)
 */
public class Projectile extends RichardWu
{
    private int timer;

    public Projectile(int direction) {
        setRotation(direction);
    }
     /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //System.out.println("alll");
        int x = getX();
        int y = getY();
        if (!((x < 13) && (x > 0) && (y > 0) && (y < 13))){
            timer ++;
            if (timer > 3)
            getWorld().removeObject(this);

        } else {
             move(1);
        }
    }

}
