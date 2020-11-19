import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class planterButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class planterButton extends EquipmentButtons
{
    //Edit these fields
    private final String tileName = "Planter";
    public double cost = 10;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
       
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new planterTile(cost), mouse.getX(), mouse.getY());
            }
    }   
}
