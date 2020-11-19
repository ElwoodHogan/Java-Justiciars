import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class loaderButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class loaderButton extends EquipmentButtons
{
    //Edit these fields
    private final String tileName = "Loader";
    public double cost = 15;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
       
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new loaderTile(cost), mouse.getX(), mouse.getY());
            }
    }   
}
