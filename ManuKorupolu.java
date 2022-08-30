import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ManuKorupolu class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class ManuKorupolu extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the ManuKorupolu class.
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
    public ManuKorupolu(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        mySeatX=5;
        mySeatY=1;
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
    public ManuKorupolu() {
        firstName="Manu";
        lastName="Korupolu";
        mySeatX=5;
        mySeatY=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the ManuKorupolu actor wants to do. This method is called whenever
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
            
          myHobby("I love building scale models of murderous robots designed to repress the revolution of an underrepresented and oppressed group of people!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
          setLocation(0,0);
          for (int x=0;x<=10;x=x+2){
                mgzMet(x,x);  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            } 
          setLocation(12,0);
          for (int x=10;x>=0;x=x-2){
                mgzMet(x,10-x);  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            } 
          t36Met(8,4);
          returnToSeat();
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
     * This is a local method specific to the ManuKorupolu class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void mgzMet(int a, int b){
        int s= 1;
         Greenfoot.delay(2*s);
        // move right
        setRotation(getRotation()+90);
        for (int i=1;i<=3;i++){
            setLocation(a+i,b+0);
            Greenfoot.delay(s);
        }
        // move back
        setRotation(getRotation()+90);
        for (int i=1;i<=3;i++){
            setLocation(a+3,b+i);
            Greenfoot.delay(s);
        }      
        // move left
        setRotation(getRotation()+90);
        for (int i=3;i>=0;i--){
            setLocation(a+i,b+3);
            Greenfoot.delay(s);
        }      
        // move Forward
        setRotation(getRotation()+90);
        for (int i=3;i>=0;i--){
            setLocation(a+0,b+i);
            Greenfoot.delay(s);
        } 
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
