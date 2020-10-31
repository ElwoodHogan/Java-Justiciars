import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cornSeedButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cornSeedButton extends SeedButtons
{
   private String seedName = "Corn";
   private int cost = 5;
   
   public void act() 
   {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      getWorld().showText(seedName, getX(), getY()-44);
      getWorld().showText(cost + "$", getX(), getY()+39);
      getWorld().showText("Owned: " + MainWorld.ownedCornSeeds, getX(), getY()+39+22);
      if (Greenfoot.mouseClicked(this) && MainWorld.money >= cost) {
            MainWorld.ownedCornSeeds++;
            MainWorld.money -= cost;
          }
   }    
}
