import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The RichardWu class
 * 
 * @author Richard Wu
 * @version 2.0 Aug 2022
 */
public class RichardWu extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the RichardWu class.
     *edit note: In Classroom class used putObject method to put the objects properly with offset
     *edit note2: in this class, it reads from "student_list" csv file to get the seat number (this is in the 
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
    private GreenfootImage standingFil_scaled;
    private GreenfootImage img;
    public RichardWu(String f, String l, int r, int s) {
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
    public RichardWu() {
        firstName="Richard";
        lastName="Wu";
        HashMap<String,String> student_map = getMap();
        for (String student: student_map.keySet()) {
            //System.out.print(student);
            if ((student.toLowerCase()).equals((firstName+lastName).toLowerCase())) {
                String[] coords = (student_map.get(student)).split("-");
                mySeatX=Integer.parseInt(coords[0]);
                mySeatY=Integer.parseInt(coords[1]);
            }
            
            //System.out.print(coords[0]);
            //System.out.println(coords[1]);
        }

       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       img = new GreenfootImage(portraitFile);
       img.scale(60,60);
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       standingFil_scaled = new GreenfootImage(standingFile);
       standingFil_scaled.scale(100,205);
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        //System.out.println(soundFile);
        setImage(img);
        sitting=true;
    }
    public HashMap<String,String> getMap() {
        String line;
        HashMap<String,String> student_map = new HashMap<String,String>();
        try (BufferedReader br = new BufferedReader(new FileReader("student_list.csv"))) {
            while ( (line = br.readLine()) != null) {
               String[] student_table = line.split(",");
               student_map.put(student_table[0], student_table[1]);
               //System.out.println(student_map);
               
            }
            br.close();
          } catch (FileNotFoundException ex){
               System.out.println(ex);
          }
          catch (IOException ex){
              System.out.println(ex);
          }
        return student_map;


    }
     /**
     * Act - do whatever the RichardWu actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                setImage(standingFil_scaled);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to read!");
            
                bounce();  // Richard Wu's special method
           
                sitDown();
            }
        
    } 
    public void sitDown(){
        returnToSeat();
        setImage(img);
        setRotation(0);
        sitting=true;
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

    public void sp() {
        sendProjectiles(3);
    }
    /**
     * This is the bounce method which allows an image of the standing user to randomly move and 
     * turn direction, stopping after 6- iterations. It will also call the student method sendProjectiles (which I created) randomly
     */
    public void bounce(){
        Integer add_rotation = 20;
        setLocation(0,0);
        Greenfoot.delay(5);
        Integer x = 0;
        Integer y = 0;
        // move right
        for (int i=1;i<=60;i++){
            
            if(Greenfoot.getRandomNumber(10) == 1) {
                turn(add_rotation);
                sendProjectiles(3);
            }
            else if (Greenfoot.getRandomNumber(15) == 1) {
                turn(-add_rotation);
                sendProjectiles(3);
            }
            x = getX();
            y = getY();
            //System.out.print(String.format("x: %s",getY()));
            if (!(x > 12) && !(x < 1) && !(y < 0) && !(y > 11) ){
                move(2);
            }
            else {
                turn(90);
                move(1);
            }
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
     public void myHobby(String s) {
         System.out.println(s);
}

}