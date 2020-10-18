import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class buildingsButton extends MainButtons
{
    
    private final String buttonName = "Buildings";
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //detects if button was clicked/  if so, removes the main button menu and adds the buildings button menu
        getWorld().showText(buttonName, getX(), getY()-44);
        if (Greenfoot.mouseClicked(this)) {
                ((MainWorld)getWorld()).addBuildingsButtons();
                ((MainWorld)getWorld()).removeMainButtons(); 
                
            }
    }    
}
