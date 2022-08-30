import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PranavPabbisetty class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class PranavPabbisetty extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the PranavPabbisetty class.
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
    public PranavPabbisetty(String f, String l, int r, int s) {
        firstName="Pranav";
        lastName="Pabbisetty";
        mySeatX=8;
        mySeatY=5;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public PranavPabbisetty() {
        firstName="Pranav";
        lastName="Pabbisetty";
        mySeatX=8;
        mySeatY=5;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the PranavPabbisetty actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
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
            
                myHobby("I like to play the piano!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                animation();  // Pranav Pabbisetty's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
}

}
