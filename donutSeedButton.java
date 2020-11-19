import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class donutSeedButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class donutSeedButton extends SeedButtons
{
   private String seedName = "Donut";
   private int cost = 1000;
   private int selectedSeed = MainWorld.player.selectedSeed;
   //Creates green
   Color greenColor = new Color (0, 255, 0);
   //saves image
   GreenfootImage rectImage = getImage();
   GreenfootImage ogImage = new GreenfootImage(rectImage);
   
   
   public void act() 
   {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      getWorld().showText(seedName, getX(), getY()-44);
      getWorld().showText(cost + "$", getX(), getY()+39);
      getWorld().showText("Owned: " + MainWorld.ownedDonutSeeds, getX(), getY()+39+22);
      selectedSeed = MainWorld.player.selectedSeed;
      if (selectedSeed == 4) {
         rectImage.setColor(greenColor);
         rectImage.drawRect(0, 0, rectImage.getWidth()-1, rectImage.getHeight()-1);
         setImage(rectImage);
      } else {
         setImage(ogImage);
      }
      if (Greenfoot.mouseClicked(this) && MainWorld.money >= cost) {
         MainWorld.ownedDonutSeeds++;
         MainWorld.money -= cost;
      }
   }
   
   public void deleteText() {
      getWorld().showText("", getX(), getY()-44);
      getWorld().showText("", getX(), getY()+39);
      getWorld().showText("", getX(), getY()+39+22);
   }
}
