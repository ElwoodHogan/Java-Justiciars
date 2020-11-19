import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pigButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pigButton extends AnimalButtons
{
    //Edit these fields
    private final String tileName = "Pig";
    public double cost = 12;
    GreenfootImage pigImage = new GreenfootImage("pig sprite.png");
    
    public void act() 
    {
        setImage(pigImage);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
        //detects if it was clicked, and if so, spawns a blueprint for the pig on the mouse's location
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new pigTile(cost), mouse.getX(), mouse.getY());
            }
    }   
}
