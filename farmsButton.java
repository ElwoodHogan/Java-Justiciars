import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cornButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class farmsButton extends MainButtons
{
    
    private final String buttonName = "Soils";
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //detects if button was clicked/  if so, removes the main button menu and adds the buildings button menu
        getWorld().showText(buttonName, getX(), getY()-44);
        getWorld().showText("", getX(), getY()+39);
        if (Greenfoot.mouseClicked(this)) {
                ((MainWorld)getWorld()).addSoilsButtons();
                ((MainWorld)getWorld()).removeMainButtons(); 
                
            }
    }    
}
