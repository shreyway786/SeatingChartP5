import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * The ManaPula class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class ManaPula extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the ManaPula class.
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
    public ManaPula(String f, String l, int r, int s) {
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
    public ManaPula() {
        firstName="Mana";
        lastName="Pula";
        mySeatX=8;
        mySeatY=7;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile = "manapula.jpg";
       //portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile= "manapula.wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the ManaPula actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                //setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to bake, go on hikes, and play the ukulele");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                manaClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
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
     * This is a local method specific to the ManaPula class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void manaClass(){
        Greenfoot.delay(10);
        GreenfootImage image = getImage();
        setImage(image);
        
        int transparency = 255;
        
        setLocation(2,2);

        for (int i=1;i<=10;i++){
            setLocation(i,2);
            Greenfoot.delay(2);
        }
        for (int i=2;i<6;i++){
            setLocation(10,i);
            Greenfoot.delay(1);
        }
        for (int i=10;i>=1;i--){
            setLocation(i,5);
            Greenfoot.delay(2);
        }
        for (int i=5;i<9;i++){
            setLocation(1,i);
            Greenfoot.delay(2);
        }
        for (int i=1;i<=10;i++){
            setLocation(i,8);
            Greenfoot.delay(2);
        }
        for (int i=8;i<12;i++){
            setLocation(10,i);
            Greenfoot.delay(2);
        }
        for (int i=10;i>=1;i--){
            setLocation(i,11);
            Greenfoot.delay(2);
        }
        
        
        for (int j=1;j<=8;j++){
            setLocation(Greenfoot.getRandomNumber(12),Greenfoot.getRandomNumber(12));
            for (int i=1;i<=16;i++){ 
            transparency = transparency-15;
            image.setTransparency(transparency);
            Greenfoot.delay(2);
            }
            image.setTransparency(0);
            for (int i=1;i<=16;i++){ 
            transparency = transparency+15;
            image.setTransparency(transparency);
            Greenfoot.delay(2);
            }
            image.setTransparency(255);
            turn(90);
        }
        
        setLocation(6,6);
        image.setTransparency(255);
        Greenfoot.delay(1);
        
        for (int j=1;j<=14;j++){
            for (int i=1;i<=5;i++){ 
              image.scale(50+(i*50),50+(i*50));
              turn(5);
              Greenfoot.delay(1);
            }
            image.scale(image.getWidth()+10, image.getHeight()+10);
            
            for (int i=1;i<=5;i++){ 
              image.scale(image.getWidth()-(50), image.getHeight()-(50));
              turn(5);
              Greenfoot.delay(1);
            }
            turn(1);
        }
           Greenfoot.delay(1);
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

