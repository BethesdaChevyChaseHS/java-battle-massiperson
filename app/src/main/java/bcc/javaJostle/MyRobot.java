package bcc.javaJostle;

import java.util.ArrayList;
public class MyRobot extends Robot{
    private int timer = 0;
    public MyRobot(int x, int y){
        super(x, y, 2, 1, 4, 3,"bob", "myRobotImage.png", "defaultProjectileImage.png");
        // Health: 2, Speed: 1, Attack Speed: 4, Projectile Strength: 3
        // Total = 10
        // Image name is "myRobotImage.png"
    }

    public void think(ArrayList<Robot> robots, ArrayList<Projectile> projectiles, Map map, ArrayList<PowerUp> powerups) {
       /* Implement your robot's logic here
         For example, you can move towards the nearest robot or shoot at a target
         to move, choose a direciton to go
         to move left - use xMovement = -1
         to move right - use xMovement = 1
         to move up - use yMovement = -1
         to move down - use yMovement = 1
         You can ONLY move in one direction at a time, if your output doesn't match the above you will get an error

         to shoot, use shootAtLocation(x, y) where x and y are the coordinates of the target
         only shoot when canAttack() is true!
        */
       // System.out.println("Thinking...");
       if (Math.random() < 0.5)
       {
        xMove();
       }
       else
       {
        yMove();
       }

       

       if(canAttack()){
            for(Robot robot : robots) {
                if (robot != this && robot.isAlive() ){
                    shootAtLocation(robot.getX() + Utilities.ROBOT_SIZE/2, robot.getY() + Utilities.ROBOT_SIZE/2);
                    break; // Shoot at the first target found
                }
            }
        }
    
    }

    public void xMove()
    {
       while (timer < 160)
       {
        if(timer %40 < 20)
        {
            xMovement = 1;
        }
        else 
        {
            xMovement = -1;
        }
        timer++;
       }
       timer = 0;
    }

    public void yMove()
    {
       while (timer < 160)
       {
        if(timer %40 < 20)
        {
            yMovement = -1;
        }
        else 
        {
            yMovement = 1;
        }
        timer++;
       }
       timer = 0;
    }
}
