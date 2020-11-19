import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class plowButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class plowButton extends EquipmentButtons
{
    //Edit these fields
    private final String tileName = "Plow";
    public double cost = 10;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
       
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new plowTile(cost), mouse.getX(), mouse.getY());
            }
    }   
}
