import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class backButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class backButton extends Buttons
{
    
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mouseClicked(this)) {
                switch(((MainWorld)getWorld()).currentButtons) {
                        case "main":
                            ((MainWorld)getWorld()).removeMainButtons();
                            break;
                        case "buildings":
                            ((MainWorld)getWorld()).removeBuildingsButtons();
                            break;
                        case "farms":
                            ((MainWorld)getWorld()).removeFarmsButtons();
                            break;
                        case "animals":
                            ((MainWorld)getWorld()).removeAnimalsButtons();
                            break;
                        case "paths":
                            ((MainWorld)getWorld()).removePathsButtons();
                            break;
                        case "fencing":
                            ((MainWorld)getWorld()).removeFencingButtons();
                            break;
                        case "decor":
                            ((MainWorld)getWorld()).removeDecorButtons();
                            break;
                    }
                ((MainWorld)getWorld()).addMainButtons();
            }
    }    
}
