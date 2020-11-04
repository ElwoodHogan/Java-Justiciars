import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a template for makeing your own Button to access your custom tile
 *
 * 1. Duplicate this class by right clicking it in the class tree and hitting "duplicate"
 * 
 * 2. Make an image that is 44x44
 *    Make sure it is in the "images" folder that is in the same folder as the .greenfoot file.
 *    Set it to this class by right clicking this class in the class tree and hitting "set image"
 *    
 * 3. Add the class to the addToBuildingsList() method in the MainWorld class
 *    To do so, use this code line, and replace the "className" with your classes name
 *    buildingsButtonList.add(new className());
 *    
 * 4. Edit the variables to the name of the building, as well as the cost of the building
 *    Edit the last line of code to include the name of your custom tile
 *    For reference, see the "barnButton" class
 *    
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StableButton extends BuildingButtons
{
    //Edit these fields
    private final String tileName = "Horse Stable";
    public double cost = 60;
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().showText(tileName, getX(), getY()-44);
        getWorld().showText(cost + "$", getX(), getY()+39);
        //detects if it was clicked, and if so, spawns a blueprint for the barn building on the mouse's location
        if (Greenfoot.mouseClicked(this) && ((MainWorld)getWorld()).money > cost) {
                //                               Edit this with the tile class' name
                //                                    VVVVVVVVVVVV
                ((MainWorld)getWorld()).addObject(new StableTile(cost), mouse.getX(), mouse.getY());
            }
    }    
}
