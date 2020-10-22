import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a template for makeing your own Tile
 * 
 * 1. Duplicate this class by right clicking it in the class tree and hitting "duplicate"
 * 
 * 2. Make an image that is rectangular, and has a resolution divisible by 32.
 *    for example: 32x32, 32x64, 64x64, 80x32
 *    Make sure it is in the "images" folder that is in the same folder as the .greenfoot file.
 *    Set it to this class by right clicking this class in the class tree and hitting "set image"
 *    
 * 3. Add any needed variables for the actions of this building in the designated space below.
 *    The cost and name of this building should have already been set in the TemplateButton class.
 *    Change the name of the Class and the Constructor to the name you desire
 *    
 * 4. Go down to the "Else" section of the Act mehod to add your custom code
 *    For reference, see the "barnTile" class
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToolShedTile extends Buildings
{
    //the cost of the building
    public double cost;
    
    //add any needed variables here
    
    //creates the current image for use in making a border, and a new un-edited copy of the current image.
    GreenfootImage rectImage = getImage();
    GreenfootImage ogImage = new GreenfootImage(rectImage);
    
    //Creates the red and green colors used in drawing a rectangle
    Color redColor = new Color (255, 0, 0);
    Color greenColor = new Color (0, 255, 0);
    
    //Initally is unplaced for the purposes of checking where the player wants to place the building
    //it will have a green border if it can be place, red if not
    private boolean placed = false;
    
    //Dont forget to change this to the class name!!!
    public ToolShedTile(double costIn) {
            cost = costIn;
        }
        
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //sets current location to the mouse
        if (placed == false) {
            //This section is for actions before the building is fully placed
            
            //follows the mouse
              if (Greenfoot.mouseMoved(null)) {
                //subtracts a left over number by 16 to make the tile snap to a grid
                setLocation(mouse.getX()-((mouse.getX() % 32) - (ogImage.getWidth() / 2)), 
                    mouse.getY()-((mouse.getY() % 32) - (ogImage.getHeight() / 2)));
            }
            //detects if there is something in the way of the placement, and turns red if there is
            if (isTouching(null)) {
                //makes a red border around the image, showing it can not be placed
                rectImage.setColor(redColor);
                rectImage.drawRect(0, 0, rectImage.getWidth()-1, rectImage.getHeight()-1);
                setImage(rectImage);
            } else {
                //makes the border green
                rectImage.setColor(greenColor);
                rectImage.drawRect(0, 0, rectImage.getWidth()-1, rectImage.getHeight()-1);
                setImage(rectImage);
                }
                //detects if it was clicked, if something is in the way of placement, and if the player has at least money equal to cost.
                //if all is true, then it spawns the barn building on the mouse location and subtracts the appropriate cost.
            if (Greenfoot.mouseClicked(this) && isTouching(null) != true && ((MainWorld)getWorld()).money >= cost) {
                placed = true;
                setImage(ogImage);
                ((MainWorld)getWorld()).money -= cost;
            }  
        } else {
            //This is where you tell the building what it does
            
        }
        
    }
}
