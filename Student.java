import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    
     /**This method is to develop a short animation that goes around in circles and rotate whilst doing so. 
       The method takes no parameters. 
       Developed by Pranav Pabbisetty, Pranav Palagummi, Manasvi Pula, Uttara Rai*/
    public void animation()
    {
        setLocation(0,0); //set original location
        Greenfoot.delay(10); //set the speed of the animation
        int rotation=getRotation(); //get initial rotation state of the picture
        // move right and spin around
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            setRotation(getRotation()+90);
            Greenfoot.delay(10);
        }
        // move back and spin around
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            setRotation(getRotation()+90);
            Greenfoot.delay(10);
        }      
        // move left and spin around
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            setRotation(getRotation()+90);
            Greenfoot.delay(10);
        }      
        // move Forward and spin around
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            setRotation(getRotation()+90);
            Greenfoot.delay(10);
        }   
        
        for (int i=0;i<=5;i++){
            setRotation(getRotation()+90);
        }
        setRotation(rotation); //set the rotation to the original one that was saved
        returnToSeat(); //return to seat
        
    }
    }
 

