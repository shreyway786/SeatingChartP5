import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The JoshFrendberg class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Josh Frendberg
 * @version 2.0 Aug 29, 2022
 */
public class JoshFrendberg extends Student implements StudentAthlete
{

    /**
     * Constructor for the JoshFrendberg class.
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
    
    
    public JoshFrendberg(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=r;
        mySeatY=s;
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
    public JoshFrendberg() {
        firstName="Josh";
        lastName="Frendberg";
        mySeatX=3;
        mySeatY=4;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".png";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+".png"; //-standing
       // soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
       
    /** 
     * rescales the actor to whatever dimensions you input
     * @authors: Josh Frendberg 
     * @version 1.0    **/
    public void rescale(int x, int y){
        GreenfootImage image = getImage();  
        image.scale(x, y);
        setImage(image);
    }
 
     /**
     * Act - do whatever the JoshFrendberg actor wants to do. This method is called whenever
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
                //sayName(soundFile);
            
                mySport("I play ice hockey");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * This is a local method specific to the JoshFrendberg class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        setLocation(4,2);
        Greenfoot.delay(7);
        int speed = 2;
        // move down
        for (int i=2;i<=11;i++){
            setLocation(4,i);
            Greenfoot.delay(speed);
        }
        // move right to allign with column
        for (int i = 5; i <=7; i++){
            setLocation(i,11);
            Greenfoot.delay(speed);
        }
        // move back up
        for (int i=10;i>=2;i--){
            setLocation(7,i);
            Greenfoot.delay(speed);
        }     
        //move right to allign with end
        for (int i = 8; i <= 10; i++){
            setLocation(i, 2);
            Greenfoot.delay(speed);
        }
        //move down to allign with top row
        for (int i = 3; i <= 5; i++){
            setLocation(10, i);
            Greenfoot.delay(speed);
            
        }
         // move left
        for (int i=9;i>=1;i--){
            setLocation(i,5);
            Greenfoot.delay(speed);
        }     
        //move down to allign with bottom row
        for (int i=6; i<=7; i++){
            setLocation(1,i);
            Greenfoot.delay(speed);
        }
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,8);
            Greenfoot.delay(speed);
        }   
        Greenfoot.delay(20);
        setLocation(6, 6);
        for (int i = 104; i <= 500; i+=40){
           rescale(i, i);
           Greenfoot.delay(15);
        }
        rescale(32, 32);
        getWorld().addObject(new debris(0), 6, 6);
        getWorld().addObject(new debris(1), 6, 6);
        getWorld().addObject(new debris(2), 6, 6);
        getWorld().addObject(new debris(3), 6, 6);
        getWorld().addObject(new debris(4), 6, 6);
        getWorld().addObject(new debris(5), 6, 6);
        getWorld().addObject(new debris(6), 6, 6);
        getWorld().addObject(new debris(7), 6, 6);
        returnToSeat();
    }
    
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void mySport(String s) {
         System.out.println(s);
}

}