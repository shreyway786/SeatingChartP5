
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The TeacherDesk was converted into a method that adds seats upon a new student
 * arriving or the teacher wanting to replan the classroom. The user can add desks  
 * whenever they press down the n key. The user gives the coordinates of where
 * they would like the desks to be placed.
 * @author
 * @version 8/29/2022
 * Coded by Michael Wang, Jeia So, Aaryan Sinha, Sanjay Veeraraghavan
 */
public class TeacherDesk extends Actor
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
            String SeatPlan1 = Greenfoot.ask("What x-coordinate would you like the seat to appear on?");
            String SeatPlan2 = Greenfoot.ask("What y-coordinate would you like the seat to appear on?");
            String test = "Yes";
            if (newStudent.equals(test)){
                StudentDesk studentdesk33 = new StudentDesk();
                World world = getWorld();
                world.addObject(studentdesk33,Integer.parseInt(SeatPlan1),Integer.parseInt(SeatPlan2));
                x += 1;
            }
            else{
            }
        }
        }
}
