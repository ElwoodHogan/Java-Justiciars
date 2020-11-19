import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mowerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mowerButton extends EquipmentButtons
{
    //Edit these fields
    private final String tileName = "Mower";
    public double cost = 10;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
       
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new mowerTile(cost), mouse.getX(), mouse.getY());
            }
    }   
}
