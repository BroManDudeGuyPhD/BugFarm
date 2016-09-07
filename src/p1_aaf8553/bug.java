package p1_aaf8553;

import java.util.Random;


public class bug implements Comparable<bug>{
    
    private boolean alive;
    private int gender;
    private int x;
    private int y;
    private int z;
    
    public bug(){
        
    }
    
    public bug(int gender, int x, int y){
        this.gender = gender;
        this.x = x;
        this.y = y;
        alive = true;

    }
    
    public boolean isAlive(){
        return this.alive;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String getGender(){
        if(gender >= 5)
            return "Female";
        if(gender <5)
            return "Male";
        
        return "None";
    }
    
    public void setLimit(int limit){
        z = limit;
    }

    @Override
    public int compareTo(bug o) {
        if(o.x == this.x && o.y == this.y)
            return 0;
        if(o.x < this.x && o.y < this.y)
            return 1;
        
        return -1;
    }
    
    

    
}
