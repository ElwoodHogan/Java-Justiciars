
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Main World
 * 
 * @author Elwood Hogan
 * @version 0.0.2.1
 */
public class MainWorld extends World {
    //initializes lists for the buttons
    public static List<Object> mainButtonList = new ArrayList<Object>();
    public static List<Object> buildingsButtonList = new ArrayList<Object>();
    public static List<Object> farmsButtonList = new ArrayList<Object>();
    //initializing starting money
    public static double money = 200;
    //initializing objects for 
    mainButtonMenu mainButtonMenu = new mainButtonMenu();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainWorld()
    {    
        // Create a new world with 1920x1080 cells with a cell size of 1x1 pixels, and true means it had a boerder.
        super(1920, 1080, 1, true);
        setPaintOrder(Buttons.class, HUD.class, Player.class, Environment.class, Buildings.class);
        //spawns the player
        addObject(new Player(), 990, 540);
        //spawns the ocean, ocean rocks, and forest area
        spawnOcean();
        addObject(new rock(), 1888, 48);
        addObject(new rock(), 1888-32, 48+16);
        spawnForest();
        //spawns the opening set of main buttons
        addMainButtons();
        addObject(mainButtonMenu, 660, 1080-60);
    }
    
    public void act() {
            //displays the players current money
            showText("Money: " + money, 120, 50);
        }
        
    //========================
    //Spawning the Environment
    //========================
    
    //spawns a horizontal lane of forest tiles.
    //The first two params dictate where from the top left the grid of trees go
    //The third param dictates how many tree tiles are spawned
    public void spawnForestLane(int rowFromTop, int columnFromLeft, 
                                 int amountOfTrees) {
        //initializing the i for the for loop
        int i;
        //turning the lane input into grid input my multiplying the inpit by 32, which is the size of the tiles
        rowFromTop = -16 + (rowFromTop * 32);
        columnFromLeft = -16 + (columnFromLeft * 32);
        for(i = amountOfTrees; i > 0; i--) {
                addObject(new forest(), (columnFromLeft+(i*32)), rowFromTop);
            }
    }
    
    //Spawns multiple lanes of trees
    public void spawnForest() {
            spawnForestLane(22, 5, 5);
            spawnForestLane(23, 4, 7);
            spawnForestLane(24, 4, 7);
            spawnForestLane(25, 4, 7);
            spawnForestLane(26, 5, 5);
        }
    
    //Spawns the top right ocean
    //The first param dictates from the top, which lane of tiles you want to spawn the ocean tiles on
    //The next four params dictate how many deep, medium, shallow, and sandy tiles to spawn
    public void spawnOceanLane(int rowFromTop, int amountDeep, 
                                int amountMedium, int amountShallow, 
                                 int amountSand) {
           int i;
           //turns lane input into pixels from top: ex: 2 = 48 pixels fromt op
           rowFromTop = -16 + (rowFromTop * 32);
           //calculates the total tiles
           int totalTiles = amountDeep + amountMedium 
                            + amountShallow + amountSand;
           for(i=1904; i > (1904 - (32*totalTiles)); i -= 32) {
                if (i > (1904 - (32*amountDeep))){
                    addObject(new deepWater(), i, rowFromTop);
                } else if (i > (1904 - (32*(amountDeep+amountMedium)))) {
                    addObject(new mediumWater(), i, rowFromTop);    
                } else if (i > (1904 - (32*(amountDeep+amountMedium+amountShallow)))) {
                    addObject(new shallowWater(), i, rowFromTop);    
                } else  {
                    addObject(new sand(), i, rowFromTop);    
                }
           }
            
        }
        
    //spawns the top right ocean section
    public void spawnOcean() {
            spawnOceanLane(1, 5, 4, 3, 2);
            spawnOceanLane(2, 4, 4, 3, 3);
            spawnOceanLane(3, 4, 3, 3, 3);
            spawnOceanLane(4, 4, 3, 2, 3);
            spawnOceanLane(5, 3, 3, 2, 3);
            spawnOceanLane(6, 3, 3, 2, 3);
            spawnOceanLane(7, 2, 3, 2, 3);
            spawnOceanLane(8, 1, 3, 2, 3);
            spawnOceanLane(9, 0, 3, 2, 2);
            spawnOceanLane(10, 0, 1, 3, 2);
            spawnOceanLane(11, 0, 0, 2, 3);
            spawnOceanLane(12, 0, 0, 1, 3);
            spawnOceanLane(13, 0, 0, 0, 3);
    }    
    
    //============================    
    //Buttons
    //============================
    
    
    //====================
    //Main Buttons
    //====================
    //spawns the main buttons 
    public void addMainButtons() {
        //calls the method to add the list of buttons to the arrayList
        addToMainList();
        
        
        int i = 0;
            for (Object button : mainButtonList) {
                //testing if i is more than 5, because Greenfoor refuses to re-initalize the i variable
                if (i>mainButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
    }
    
    //removes the pre-made list of objects
    public void removeMainButtons() {
           for (Object button : mainButtonList) {
                removeObject((Actor)button);
            } 
        }
    //Stores a new set of main button objects to the pre-initialized list
    public void addToMainList() {
            mainButtonList.add(new buildingsButton());
            mainButtonList.add(new farmsButton());
            mainButtonList.add(new animalsButton());
            mainButtonList.add(new pathsButton());
            mainButtonList.add(new fencingButton());
            mainButtonList.add(new decorButton());
            
            
        } 
        
    //====================
    //Building Buttons
    //==================== 
    
    //same as last set, but with building buttons instead of main buttons
    public void addBuildingsButtons() {
        addToBuildingsList();
        int size = buildingsButtonList.size();
        int i = 0;
            for (Object button : buildingsButtonList) {
                if (i>buildingsButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
            
            
        }
        
    public void removeBuildingsButtons() {
           for (Object button : buildingsButtonList) {
                removeObject((Actor)button);
            } 
        }
        
    //Stores a new set of buildings button objects to the pre-initialized list    
    public void addToBuildingsList() {
            buildingsButtonList.add(new barnButton());
            //add your class here
            buildingsButtonList.add(new siloButton());
            buildingsButtonList.add(new GarageButton());
            buildingsButtonList.add(new ToolShedButton());
        }
      
    //====================
    //Farms Buttons
    //==================== 
    
    public void addFarmsButtons() {
        addToFarmsList();
        int size = farmsButtonList.size();
        int i = 0;
            for (Object button : farmsButtonList) {
                if (i>farmsButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
            
            
        }
        
    public void removeFarmsButtons() {
           for (Object button : farmsButtonList) {
                removeObject((Actor)button);
            } 
        }
        
    //Stores a new set of buildings button objects to the pre-initialized list    
    public void addToFarmsList() {
            buildingsButtonList.add(new farmsButton());
            //add your class here
            
        }
        
        
        
        
        
        
        
        
    //returns the money variable    
    public double getMoney() {
            return money;
        }

    }

