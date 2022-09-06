import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */

public class SiddharthaMangamuri extends Student implements SpecialInterestOrHobby
{

    /**
     Main constructor that uses input for first name, last name, and then seat position according to where I sit
     on the actual seating chart. After this, it uses these same variables and creates firstName, lastName, mySeatX,
     and mySeatY which is used later on in the program. After this, it calls the portrait file which is a picture
     of me and then the standing file alongside the sound file. All of these files are already inside of the 
     directory, and it just used code to call it and then set the starting image as the portrait file. Also put the
     boolean variable, sitting, to true. 
     */
    public SiddharthaMangamuri(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // starting picture
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg"; // standing picture
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // sound file
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
      This next method, act(), allows the actor to move. When the mouse is clicked, the image is no longer
      sitting and then the image is set to the standing file. It allows the image to then move with my own
      unique abstract method as well as my unique animation,and printing information to the console. 
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
              if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName(); // Writes my name to the console 
                myHobby("I like to play basketball, tennis, and football!"); // Writes my hobby to the console
                sayName(soundFile); // Says the file using the sayName() method
                // Below here is an abstract method that I created specialized to me, and made the actor rotate, then go back to the original spot
                rotate();
                sitDown();
                Greenfoot.delay(40);
                setImage(standingFile);
                
                animation(2, 1, 3);// Animation method that animates and moves the image
           
                sitDown(); // makes the character sit down 
            }
        }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     Method allows the user to put their input back into console if they want to after the name. 
     */
   
    /**
     This animation method takes 3 variables and then animates the actor by moving it in a specific way
     */
    public void animation(int x, int y, int z){
        Greenfoot.delay(10);
    
        // Diagonal movement code that moves the image diagonally
        for (int i=9; i >=1; i--){ 
            setLocation(x, y);
            Greenfoot.delay(10);
            x++;
            y++;
        
        }
        
        // Up movement code that moves the image up
        for (int i=5; i>=1; i--) {
            setLocation (x, y);
            Greenfoot.delay(10);
            y--;
            
        }
        
        // Left movement code that moves the image left
        for (int i=6; i>=1; i--) {
            setLocation (x, y);
            Greenfoot.delay(10);
            x--;
        }
        
        // Teleportation movement which basically teleports the image to different spots
        setLocation(x, y+3);
        Greenfoot.delay(10);
        setLocation(x+3, y);
        Greenfoot.delay(10);
        setLocation(x, y-3);
        Greenfoot.delay(10);
        setLocation(x-3, y);
        
        
            
    }
     /**
     * myHobby is an interface that I used to show my hobby.
     */
     public void myHobby(String s) {
         System.out.println(s);
}
    /**
     * My abstract class which first rotates the standingFile image, then prints to the console. 
     */
    public void rotate() {
        setImage(standingFile);
        System.out.println("Look at me! I just rotated");
        for (int i = 0; i<=3; i++) {
            getImage().rotate(90);
            Greenfoot.delay(10);
        }
    
    }

}