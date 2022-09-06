import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */

public class JeiaSo extends Student implements StudentLeadership
{

    /**
     * Constructor for the JeiaSo class.
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
    public JeiaSo(String f, String l, int r, int s) {
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
    public JeiaSo() {
        firstName="Jeia";
        lastName="So";
        mySeatX=5;
        mySeatY=9;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the JeiaSo actor wants to do. This method is called whenever
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
                //introduction("junior");
                sayName(soundFile);
            
                myRoleInLeadership("class treasurer");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleTable();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
           
                sitDown();
                
                spin();
                
                resizeImage();
                
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
//    public void spin(int numSpins){
//        int spins = numSpins;
//        int i = 0;
//        while (i < spins)
 //       {
           // setRotation(getRotation()+90);
 //           i++;
  //      }
    //}
    
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void circleTable(){
        setLocation(4,8);
         Greenfoot.delay(15);
        // move right
        for (int i=5;i<=7;i++){
            setLocation(i,8);
            Greenfoot.delay(10);
        }
        // move down
        for (int i=8;i<=11;i++){
            setLocation(7,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=7;i>=4;i--){
            setLocation(i,11);
            Greenfoot.delay(10);
        }      
              // move up
        for (int i=11;i>=8;i--){
            setLocation(4,i);
            Greenfoot.delay(10);
        }   
           Greenfoot.delay(15);
           returnToSeat();
    }
    
    public void resizeImage(){
        setImage(firstName.toLowerCase()+ lastName.toLowerCase()+"2.jpg"); // each increases the dimensions by 10x10
        Greenfoot.delay(10);
        setImage(firstName.toLowerCase()+ lastName.toLowerCase()+"3.jpg");
        Greenfoot.delay(10);
        setImage(firstName.toLowerCase()+ lastName.toLowerCase()+"4.jpg");
        Greenfoot.delay(10);
        setImage(portraitFile); // resets back to original size
    }
    
    public void spin(){
        for (int i = 1; i<=4; i++) {
            setRotation(getRotation() + 90);
            Greenfoot.delay(10);
        }
        setRotation(0);
    }
    
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
           Greenfoot.delay(20);
           returnToSeat();
    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */

    public void myRoleInLeadership(String s) {
         System.out.println("In leadership I am the "+s+"!");
}

//public void introduction(String s){
        //System.out.println("I am a " + s + " in high school this year.");
    //}

}
