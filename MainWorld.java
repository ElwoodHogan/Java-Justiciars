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
    public static List<Object> soilsButtonList = new ArrayList<Object>();
    public static List<Object> animalsButtonList = new ArrayList<Object>();
    public static List<Object> pathsButtonList = new ArrayList<Object>();
    public static List<Object> fencingButtonList = new ArrayList<Object>();
    public static List<Object> decorButtonList = new ArrayList<Object>();
    
    //Initializing the global seed variables
    public static int ownedCornSeeds = 0;
    public static int ownedPotatoSeeds = 0;
    public static int ownedCottonSeeds = 0;
    public static int ownedDonutSeeds = 0;
    public static int ownedMoneySeeds = 0;
    
    //Storing which set of buttons are loaded
    public String currentButtons = "main";
    //initializing starting money
    public static double money = 200;
    //initializing objects for spawning
    mainButtonMenu mainButtonMenu = new mainButtonMenu();
    backButton backButton = new backButton();
    public static Player player = new Player();
    public static seedShopButton seedShop = new seedShopButton();
    public static waterMeter waterMeter = new waterMeter();
    
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
        addObject(player, 990, 540);
        //spawns the ocean, ocean rocks, and forest area
        spawnOcean();
        addObject(new rock(), 1888, 48);
        addObject(new rock(), 1888-32, 48+16);
        spawnRocks();
        spawnForest();
        
        addObject(mainButtonMenu, 660, 1080-60);
        addObject(backButton, 1255, 1024);
        if (!mainButtonList.isEmpty()) {
                removeMainButtons();
            }
            //spawns the opening set of main buttons
        addMainButtons();
        addObject(seedShop, 1980-120, 1080-60);
        addObject(waterMeter, 1980-220, 1080-60);
        //addObject(new seedShopMenu(), 1980-120, 540);
        money = 200;
        
        //Clears the lists so the lists do not increase on a reset
        buildingsButtonList.clear();
        soilsButtonList.clear();
        animalsButtonList.clear();
        pathsButtonList.clear();
        fencingButtonList.clear();
        decorButtonList.clear();
    }
    
    public void act() {
            //displays the players current money
            showText("Money: " + money, 120, 50);
            showText("" + buildingsButtonList.size(), 120, 100);
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
    
        public void spawnRocks() {
         addObject( new rock(), 32, 32);  
         addObject( new rock(), 384, 512);
         addObject( new rock(), 288, 128);
         addObject( new rock(), 608, 704);
         addObject( new rock(), 64, 896);
         addObject( new rock(), 160, 576);
         addObject( new rock(), 704, 64);
         addObject( new rock(), 768, 640);
         addObject( new rock(), 512, 546);
         addObject( new rock(), 800, 160);
         addObject( new rock(), 864, 672);
         addObject( new rock(), 896, 800);
         addObject( new rock(), 960, 128);
         addObject( new rock(), 1024, 96);
         addObject( new rock(), 1024, 704);
         addObject( new rock(), 1152, 32);
         addObject( new rock(), 1184, 832);
         addObject( new rock(), 1280, 736);
         addObject( new rock(), 1312, 64);
         addObject( new rock(), 1312, 512);
         addObject( new rock(), 1376, 896);
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
            spawnOceanLane(6, 3, 3, 2, 56);
            spawnOceanLane(7, 2, 3, 59, 0);
            spawnOceanLane(8, 1, 3, 60, 0);
            spawnOceanLane(9, 0, 3, 61, 0);
            spawnOceanLane(10, 0, 1, 3, 60);
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
        currentButtons = "main";
        int i = 0;
            for (Object button : mainButtonList) {
                //testing if i is more than 5, because Greenfoor refuses to re-initalize the i variable
                if (i>5) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
    }
    //removes the pre-made list of objects
    public void removeMainButtons() {
        int i;
           for (i = 0; i < mainButtonList.size(); i++) {
                removeObject((Actor)mainButtonList.get(i));
                
               }
        mainButtonList.clear();       
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
        currentButtons = "buildings";
        int i = 0;
            for (Object button : buildingsButtonList) {
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;
            } 
    }
        
    public void removeBuildingsButtons() {
           for (Object button : buildingsButtonList) {
                removeObject((Actor)button);
           }
           buildingsButtonList.clear(); 
        }
    
    public void addToBuildingsList() {
            buildingsButtonList.add(new barnButton());
            //add your class here
            buildingsButtonList.add(new siloButton());
            buildingsButtonList.add(new GarageButton());
            buildingsButtonList.add(new ToolShedButton());
            buildingsButtonList.add(new wellButton());
            buildingsButtonList.add(new WindmillButton());
            buildingsButtonList.add(new StableButton());
            buildingsButtonList.add(new FarmHouseButton());
        }
      
    //====================
    //Farms Buttons
    //==================== 
    
    public void addSoilsButtons() {
        addToSoilsList();
        currentButtons = "farms";
        int i = 0;
            for (Object button : soilsButtonList) {
                if (i>soilsButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
        }
        
    public void removeSoilsButtons() {
           for (Object button : soilsButtonList) {
                removeObject((Actor)button);
           }
           soilsButtonList.clear();
        }
     
    public void addToSoilsList() {
            soilsButtonList.add(new basicSoilButton());
            soilsButtonList.add(new richSoilButton());
            //add your class here
            
        }
     
    //====================
    //Animals Buttons
    //==================== 
    
    public void addAnimalsButtons() {
        addToAnimalsList();
        currentButtons = "animals";
        int size = animalsButtonList.size();
        int i = 0;
            for (Object button : animalsButtonList) {
                if (i>animalsButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            } 
        }
        
    public void removeAnimalsButtons() {
           for (Object button : animalsButtonList) {
                removeObject((Actor)button);
           }
           animalsButtonList.clear();
        }
    
    public void addToAnimalsList() {
            animalsButtonList.add(new animalsButton());
            //add your class here
            
        }    
        
    //====================
    //Paths Buttons
    //==================== 
    
    public void addPathsButtons() {
        addToPathsList();
        currentButtons = "paths";
        int size = pathsButtonList.size();
        int i = 0;
            for (Object button : pathsButtonList) {
                if (i>pathsButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }  
        }
        
    public void removePathsButtons() {
           for (Object button : pathsButtonList) {
                removeObject((Actor)button);
           }
           pathsButtonList.clear();
        }
      
    public void addToPathsList() {
            pathsButtonList.add(new pathsButton());
            //add your class here
            
        }     
        
    //====================
    //Fencing Buttons
    //==================== 
    
    public void addFencingButtons() {
        addToFencingList();
        currentButtons = "fencing";
        int size = fencingButtonList.size();
        int i = 0;
            for (Object button : fencingButtonList) {
                if (i>fencingButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
        }
        
    public void removeFencingButtons() {
           for (Object button : fencingButtonList) {
                removeObject((Actor)button);
           }
           fencingButtonList.clear();
        }
    
    public void addToFencingList() {
            fencingButtonList.add(new fencingButton());
            //add your class here
            
        }    
        
    //====================
    //Decor Buttons
    //==================== 
    
    public void addDecorButtons() {
        addToDecorList();
        currentButtons = "decor";
        int size = decorButtonList.size();
        int i = 0;
            for (Object button : decorButtonList) {
                if (i>decorButtonList.size()) {i=0;};
                addObject((Actor)button, 36+22+(i*109), 1024);
                i++;        
            }
        }
        
    public void removeDecorButtons() {
           for (Object button : decorButtonList) {
                removeObject((Actor)button);
           }
           decorButtonList.clear();
        }
       
    public void addToDecorList() {
            decorButtonList.add(new decorButton());
            //add your class here
            
        }     
     
        
        
    //returns the money variable    
    public double getMoney() {
            return money;
        }

    }

