import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class horseButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class horseButton extends AnimalButtons
{
   
    //Edit these fields
    private final String tileName = "Horse";
    public double cost = 22;
    GreenfootImage horseImage = new GreenfootImage("horse sprite.png");
    
    public void act() 
    {
        setImage(horseImage);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
        //detects if it was clicked, and if so, spawns a blueprint for the horse on the mouse's location
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                ((MainWorld)getWorld()).addObject(new horseTile(cost), mouse.getX(), mouse.getY());
            }
    }    
}
