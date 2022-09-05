import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
/**
 * The StudentDesk was added with a OnTouch method that adds seats upon a new student
 * arriving or the teacher wanting to replan the classroom. Whenever the user presses  
 * down the n key. The seats can continue to be added until an entire column fills up.
 * @author
 * @version 8/29/2022
 * Coded by Michael Wang, Jeia So, Aaryan Sinha, Sanjay Veeraraghavan
 */
public class StudentDesk extends Actor
{
    private int deskGroup;
    public int x = 0;
    public void act() 
    {
        if(Greenfoot.isKeyDown("n")){
            onTouch();
        }    
    } 
    public void onTouch(){
        String newStudent = Greenfoot.ask("Is there a new student?");
        String SeatPlan1 = Greenfoot.ask("What x-coordinate would you like the seat to appear on?");
        String SeatPlan2 = Greenfoot.ask("What y-coordinate would you like the seat to appear on?");
        String test = "Yes";
        if (newStudent.equals(test)){
            StudentDesk studentdesk33 = new StudentDesk();
            World world = getWorld();
            world.addObject(studentdesk33,Integer.parseInt(SeatPlan1),Integer.parseInt(SeatPlan2));
        }
        else{
        }
    }
    public void setDeskGroup(int i){
        if (i>0 && i<9)
           deskGroup=i;
        }
     public int getDeskGroup(){
        
           return deskGroup;
        }

}
