import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The UttaraRai class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class UttaraRai extends Student implements SpecialInterestOrHobby
{
    private GreenfootImage myImage = null;
    /**
     * Constructor for the UttaraRai class.
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
    public UttaraRai(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        //standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public UttaraRai() {
        firstName="Uttara";
        lastName="Rai";
        mySeatX=4;
        mySeatY=6;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        myImage = new GreenfootImage(portraitFile);
        myImage.scale(60,60);
        //standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(myImage);
        sitting=true;
    }
    
     /**
     * Act - do whatever the UttaraRai actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            getName();
            sayName(soundFile);
            System.out.println("");
            myHobby("I like to do make art!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            

            rotateClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * This is a local method specific to the UttaraRai class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void rotateClass(){
        int centerX = 100;
        int centerY = 100;
        int radius = 50;
        int rotation = 20;
        int turnSpeed = 100;
        // in act
        //setLocation(centerX, centerY);
        setRotation(rotation);
        turn(turnSpeed);
        rotation = getRotation();
        move(radius);
        setRotation(0);
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
