import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Student extends Actor
{
   //Instance variables
   public String firstName;
   public String lastName;
   public int mySeatX;         // rows start in the front of class (1), and end in the back of class
   public int mySeatY;        // seats are left to right, 1-8
   public boolean isActive;  // can you think of an algorithm that would allow you to use this
                             // variable to use keyboard entry for all the instance of a student
                             // that we will create?
   public boolean sitting;   // Is the student sitting or standing (default sitting)

 //  public String imgFile;   // These will be created in subclass as firstName.toLowerCase()+
   public String portraitFile; // image used when sitting
   public String standingFile; // image used when standing
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   Classroom clas = (Classroom) getWorld();
   public void setSeatX(int r){
       mySeatX=r;
    }

    public void setSeatY(int s){
       mySeatY=s;
    }

    public abstract void  getName(); //This is an abstract methods. You will have to implement it
                                     // in your own class file. See KilgoreTrout for an example

    /**
     * Plays a sound file when called
     * @param String myNameFile  is the name of the sound file to play, ex "mySound.wav",
     */

    public int GetSeatX(){
        return mySeatX;
    }

    public int GetSeatY(){
        return mySeatY;
    }
    public String getFirstName(){
        return firstName;
    }
     public String getLastName(){
        return lastName;
    }

    public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
    }

    public void returnToSeat(){
        setLocation(mySeatX,mySeatY);
    }
    public void sitDown(){
        returnToSeat();
        setImage(portraitFile);
        sitting=true;
    }
    public void assignSeat(){
        mySeatX=getX();
        mySeatY=getY();
    }


    /**
        * creates specified number of projectiles at the coordinate of the student,
        * to be fired after student returns to seat
        *
        * @authors Richard Wu's group
        * @param  num, number of projectiles sent at once
        * @return      void

    */
    public void sendProjectiles(int num) {
        for (int i=0; i< num; i++) {
            Projectile proj = new Projectile((360/(i+1)));
            getWorld().addObject(proj,getX(),getY());
        }
    }


 //The spin image method essentially chnages the location of the image.
 //It first moves the image up 3 spaces. After that, it will move it 3 spaces
 //to the left and then 3 spaces to the right. After that it will move the
 //center of the screen. While it is moving location, it is spinning to the
 //right until the incrementation is done.
 //By Anit Annadi, Samyutha, Brandon, Vihaan
    public void spinImage(int degrees, int increments){
        int spin=degrees/increments;
        int addX = 3;
        int addY = 0;
        boolean moveImage = true;
        for (int i=0; i<=increments; i++){
            getImage().rotate(spin);
            Greenfoot.delay(10);
            if (i == 1) {
                addX=0;
                addY=3;
            } else if (i==2){
                addX=-3;
                addY=0;
            } else if (i==3){
                addX=0;
                addY=-3;
            } else if (i>3) {
                moveImage = false;
                setLocation(6,7);
            }

            if (moveImage) {
                    setLocation(GetSeatX() + addX,GetSeatY() + addY);
            }
            Greenfoot.delay(5);
        }
    }
}
