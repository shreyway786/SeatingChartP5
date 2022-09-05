import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The StudentDeskGroup was converted into a method that adds a seat upon a new student arriving. This triggers
 * whenever the user presses down the n key. The seats can continue to be added until an entire column fills up.
 * @author 
 * @version 8/29/2022
 * Coded by Michael Wang, Jeia So, Aaryan Sinha, Sanjay Veeraraghavan
 */
public class StudentDeskGroup extends Actor
{
    /**
     * Act - do whatever the TeacherDesk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int x = 0;
    public void act() 
    {
        if(Greenfoot.isKeyDown("n")){
            String newStudent = Greenfoot.ask("Is there a new student?");
            String test = "Yes";
            if (newStudent.equals(test)){
                StudentDesk studentdesk33 = new StudentDesk();
                World world = getWorld();
                world.addObject(studentdesk33,11,(3 + x));
                x += 1;
            }
            else{
            }
        }
        }
}
