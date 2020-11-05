import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class seedShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class seedShopButton extends MainButtons
{
    private boolean menuOpen = false;
    public int seedMax = 10;
    private int selectedSeed = MainWorld.player.selectedSeed;
    seedShopMenu seedMenu = new seedShopMenu();
    cornSeedButton cornSeed = new cornSeedButton();
    javaSeedButton javaSeed = new javaSeedButton();
    //public static List<Object> seedButtonList = new ArrayList<Object>();
    
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();
        selectedSeed = MainWorld.player.selectedSeed;
        if (Greenfoot.mouseClicked(this) && menuOpen == false) {
                menuOpen = true;
                this.getWorld().addObject(seedMenu, 1980-120, 540);
                this.getWorld().addObject(cornSeed, 1980-120, 140+23);
                this.getWorld().addObject(javaSeed, 1980-120, 140+23+128+44);
        } else if (Greenfoot.mouseClicked(this) && menuOpen == true) {
                menuOpen = false;
                this.getWorld().removeObject(seedMenu);
                cornSeed.deleteText();
                this.getWorld().removeObject(cornSeed);
            }
    }
    
    public Object getSeedObject() {
            switch(selectedSeed) {
                    case 1:
                    return new cornSeedTile();
                    case 2:
                    selectedSeed = 2;
                    return new JavaSeedTile();
                    case 3:
                    selectedSeed = 3;
                    break;
                    case 4:
                    selectedSeed = 4;
                    break;
                    case 5:
                    selectedSeed = 5;
                    break;
                }
            return cornSeed;
        }
    
    public int getSeedAmount() {
            switch(selectedSeed) {
                    case 1:
                    return MainWorld.ownedCornSeeds;
                    case 2:
                    return MainWorld.ownedJavaSeeds;
                    case 3:
                    return MainWorld.ownedCottonSeeds;
                    case 4:
                    return MainWorld.ownedDonutSeeds;
                    case 5:
                    return MainWorld.ownedMoneySeeds;
                }
            return 0;
        }
        
    public void suptractSeedAmount() {
            switch(selectedSeed) {
                    case 1:
                    MainWorld.ownedCornSeeds--;
                    break;
                    case 2:
                    MainWorld.ownedJavaSeeds--;
                    break;
                    case 3:
                    MainWorld.ownedCottonSeeds--;
                    break;
                    case 4:
                    MainWorld.ownedDonutSeeds--;
                    break;
                    case 5:
                    MainWorld.ownedMoneySeeds--;
                    break;
                }
        }      
    public void getPlayer() {
            
        }
}
