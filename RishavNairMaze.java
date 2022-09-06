import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RishavNairMaze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RishavNairMaze extends RishavNair
{
    /**
     * Act - do whatever the RishavNairMaze wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        //clicked = false;
        if (clicked == false){
            setImage(mazeFile);
        }
        if (clicked == true){
            setLocation(6,7);
            setImage(standingFile);
            Greenfoot.delay(30); 
            setImage((GreenfootImage)null);
            getWorld().removeObjects(getWorld().getObjects(RishavNairProfile.class));
            getWorld().removeObjects(getWorld().getObjects(RishavNairMaze.class));
        }
    }
}
