package p1_aaf8553;

import java.util.ArrayList;
import java.util.Random;


public class bugFarm extends bug{

    
    public bugFarm(int bugs, int farmSize, int movements){
        super(bugs,farmSize,movements);
        ArrayList<bug> bugsList = new ArrayList<bug>();
        
        for(int i = 0; i < bugs; i ++){
            Random rand = new Random();
            int gender = rand.nextInt((9 - 0) + 1);
            int x = rand.nextInt((farmSize - 1) + 1) + 1;
            int y = rand.nextInt((farmSize - 1) + 1) + 1;

            bugsList.add(new bug(gender, x, y));

        }
    }

    bugFarm() {
        
    }
    
    public void bugMoveEvent(){
        
    }
    
    public void bugFightEvent(){
        
    }
    
    public void bugMateEvent(){
        
    }
    
}
