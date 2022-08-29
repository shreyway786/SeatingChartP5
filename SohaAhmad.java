import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SohaAhmad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SohaAhmad extends Student
{
    /**
     * Constructor for the KilgoreTrout class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public SohaAhmad(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        winFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-win.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public SohaAhmad() {
        firstName="Soha";
        lastName="Ahmad";
        mySeatX=1;
        mySeatY=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       winFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-win.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public boolean ghost1=false;
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to play sports!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                //circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
                //getWorld().addObject(new ghost1(), 7, 3);
                fight();
                //allowmove();
                
                sitDown();
            }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */

   
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    
    
    
    public void fight(){
        setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=7;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
            // (7,0)
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(7,i);
            Greenfoot.delay(10);
            // (7,5)
        }      
         // move left
        for (int i=7;i>=4;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
            // (3,5)
        }     
        // move right
        for (int i=3;i<=10;i++){
            setLocation(i,5);
            Greenfoot.delay(10);
            // (10,5)
        }  
        // move back
        for (int i=5;i<=8;i++){
            setLocation(10,i);
            Greenfoot.delay(10);
            // (10,8)
        }    
         // move left
        for (int i=10;i>=4;i--){
            setLocation(i,8);
            Greenfoot.delay(10);
            // (4,8)
        } 
        // move Forward
        for (int i=8;i>=5;i--){
            setLocation(4,i);
            Greenfoot.delay(10);
            // (4,5)
        }   
        // move left
        for (int i=4;i>=1;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
            // (1,5)
        } 
        // move back
        for (int i=5;i<=8;i++){
            setLocation(1,i);
            Greenfoot.delay(10);
            // (1,8)
        } 
        // move right
        for (int i=1;i<=5;i++){
            setLocation(i,8);
            Greenfoot.delay(10);
            // (5,8)
        }  
           Greenfoot.delay(20);
           setLocation(6,6);
           setImage(winFile);
           Greenfoot.delay(100);
           returnToSeat();
    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
}

}
