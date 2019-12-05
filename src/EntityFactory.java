import processing.core.PApplet;
import processing.core.PImage;
import java.util.List;
import java.awt.*;
import java.util.Random;

public class EntityFactory {
    private static final String ASTEROID_KEY = "Asteroid";
    private static final String ASTEROID_ID_SUFFIX = " -- asteroid";
    private static final int ASTEROID_PERIOD_SCALE = 6;
    private static final int ASTEROID_ANIMATION_MIN = 50;
    private static int Acount = 1;

    private static final Random rand = new Random();




    public static Asteroid createAsteroid(Meteor meteor, Point pos, ImageStore imageStore)
    {
        EntityFactory.Acount += 1;
        Asteroid asteroid = new Asteroid(meteor.getId() + ASTEROID_ID_SUFFIX, pos,
                meteor.getActionPeriod() / ASTEROID_PERIOD_SCALE + Acount,
                ASTEROID_ANIMATION_MIN + Acount,
                imageStore.getImageList(ASTEROID_KEY));
        return asteroid;
    }
    public static Star createStar(String id, Point pos, List<PImage> images, ImageStore imageStore, int actionPeriod, int animationPeriod, int dsx, int dsy, int shiptrack)
    {
        return new Star(id, pos, images, actionPeriod, animationPeriod, dsx, dsy,shiptrack);
    }
    public static Down createDown(String id, Point pt, List<PImage> images)
    {
        return new Down(id, pt, images);
    }
    public static Meteor createMeteor(String id, Point position, int actionPeriod, List<PImage> images) {
        return new Meteor(id, position, actionPeriod, images);
    }

    public static Earth createEarth(String id, Point pos, List<PImage> images)
    {
        return new Earth(id, pos, images);
    }

    public static Planet createPlanet(String id, Point pos, int actionPeriod, List<PImage> images)
    {
        return new Planet(id, pos, actionPeriod, images);
    }
    public static UfoNotFull createUfoNotFull(String id, int resourceLimit, Point position, int actionPeriod, int animationPeriod,
                      List<PImage> images)
    {
        Class kind = Asteroid.class;
        int type = rand.nextInt(3);
        System.out.print(type);
        if (type == 1)
        {
            kind = Meteor.class;
        }
        return new UfoNotFull(id, resourceLimit, position, actionPeriod, animationPeriod, images, kind);
    }
    public static UfoFull createUfoFull(String id, int resourceLimit, Point position, int actionPeriod, int animationPeriod,
                                              List<PImage> images)
    {
        return new UfoFull(id, resourceLimit, position, actionPeriod, animationPeriod, images);
    }

}
