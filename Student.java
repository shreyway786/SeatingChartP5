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
   public String readingFile; // image used when reading

   public String standingFile; // image used when standing
   public String goingFile; // image used when going back to seat
   public String winFile; // image used at the end before being seated
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
 /**The spin image method essentially chnages the location of the image. 
 It first moves the image up 3 spaces. After that, it will move it 3 spaces 
 to the left and then 3 spaces to the right. After that it will move the 
 center of the screen. While it is moving location, it is spinning to the 
 right until the incrementation is done. 
 By Anit Annadi, Samyutha, Brandon, Vihaan**/
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
    /**
        * creates specified number of projectiles at the coordinate of the student,
        * to be fired after student returns to seat
        *
        * authors: Richard Wu's group
        * @param  num, number of projectiles sent at once
        * @return      void

    */
    public void sendProjectiles(int num) {
        for (int i=0; i< num; i++) {
            Projectile proj = new Projectile((360/(i+1)));
            getWorld().addObject(proj,getX(),getY());
        }
    }
    /**
     * Table Members : Srish, Mahathi, Rishav, Maya
     * Image travels diagonally from the top right to bottom left and top left to bottom right 
     * creating an X while spinning in a circle
     */
    public void spinAndExpand(){
        setLocation(0,0);
        int x = 10;
        for (int i = 1; i<=8;i++){
            // starts at top right
            setLocation(x,i);
            // spins in circle while traveling to bottom left
            for (int j=1;j<=12;j++){
            setRotation(30+30*j);
            Greenfoot.delay(3);
            }
            x--;
        }
        for (int i = 1; i<=8;i++){
            // starts at top left
            setLocation(x,i);
            // spins in circles while traveling to bottom right
            for (int j=1;j<=12;j++){
            setRotation(30+30*j);
            Greenfoot.delay(3);
            }
            x++;
        }
        // rotation set back to 0 and returned to original seat
        setRotation(0);
        returnToSeat();
        GreenfootImage file = getImage();
        file.scale(300, 200);
        Greenfoot.delay(20);
        returnToSeat();
    }
    
    /** 
     * rescales the actor to whatever dimensions you input
     * @authors: Josh Frendberg, Soha Ahmad, Sanjana Alluri, Yanin Charoenpornsawat 
     * @version 2.0  8/30/22 
     * @param x takes in width of rescaled image
     * @param y takes in height of rescaled image
       **/
    public void rescale(int x, int y){
        GreenfootImage image = getImage();  
        image.scale(x, y);
        setImage(image);
    }
    /** This method zooms in into a student picture and then zooms out of the student picture gradually. 
    It takes in user inputs and performs the action for a certain amount of time. 
    Developed by Sid, Samarth, Diego, and Brandon. **/
    public void zoomIn(int x, int y, int increments) {
        for (int i = 0; i<=increments; i++) {
            int firstHalf = increments/2;
            
            if (i <= firstHalf) {
                x = x + 10;
                y = y + 10;
                getImage().scale(x, y);
                Greenfoot.delay(10);
            } else {
                x = x -10;
                y = y -10;
                getImage().scale(x,y);
                Greenfoot.delay(10);
            }
        }
    }
        /**
     * This is a local method that moves the actor up, down, left, right, down, up, left, and right
     * 
     */
    public void t36Met(int a, int b){
        int s=3;
        setRotation(getRotation()+90);
        Greenfoot.delay(s);
        setLocation(a+s, b);
        Greenfoot.delay(s);
        setLocation(a-s, b);
        Greenfoot.delay(s);
        setRotation(getRotation()+90);
        Greenfoot.delay(s);
        setLocation(a, b-s);
        Greenfoot.delay(s);
        setLocation(a, b+s);
        Greenfoot.delay(s);
        setRotation(getRotation()+90);
        Greenfoot.delay(s);
        setLocation(a-s, b);
        Greenfoot.delay(s);
        setLocation(a+s, b);
        Greenfoot.delay(s);
        setRotation(getRotation()+90);
        Greenfoot.delay(s);
        setLocation(a, b+s);
        Greenfoot.delay(s);
        setLocation(a, b-s);
        Greenfoot.delay(s);
    }

        
}
