package p1_aaf8553;

import java.util.ArrayList;
import java.util.Random;


public class bugFarm extends bug{
    
    int initialBugs = 0;
    int livingMales = 0;
    int initialMales = 0;
    int deadMales = 0;
    
    int livingFemales = 0;
    int initialFemales = 0;
    int deadFemales = 0;

    public bugFarm(int gender, int x, int y) {
        super(gender, x, y);
    }

    
    public void initializeBugFarm(int initialBugs, int farmSize, int movements, String reportFile){
        this.initialBugs = initialBugs;
        ArrayList<bug> bugsList = new ArrayList<>();
        
        
        for(int i = 0; i < initialBugs; i ++){
            Random rand = new Random();
            int gender = rand.nextInt((9 - 0) + 1);
            int x = rand.nextInt((farmSize - 1) + 1) + 1;
            int y = rand.nextInt((farmSize - 1) + 1) + 1;

            bugsList.add(new bug(gender, x, y));
            
            if(bugsList.get(i).getGender().equals("Female")){
                livingFemales ++; 
                initialMales++;
            }
            else{
                livingMales++;
                initialFemales++;
            }

        }
        
        
        
        //Simulation
        for (int a = 0; a < movements; a++) {
            
            
            int dummy = bugsList.size();
            for (int b = 0; b < dummy; b++) {
                for (int c = b + 1; c < dummy; c++) {
                    if (bugsList.get(b).compareTo(bugsList.get(c)) == 0) {
                        
                        //Checks if mating is neccessary
                        if (!bugsList.get(b).getGender().equals(bugsList.get(c).getGender())) {
                            
                            //Bugs get it on
                            Random rand = new Random();
                            int gender = rand.nextInt((9 - 0) + 1);
                            int x = rand.nextInt((farmSize - 1) + 1) + 1;
                            int y = rand.nextInt((farmSize - 1) + 1) + 1;

                            bugsList.add(new bug(gender, x, y));
                            
                            if (gender >= 5) 
                                livingFemales++;

                            if (gender < 5) 
                                livingMales++;
                        }
                        
                        else { //Fight to the ded

                            Random rand = new Random();
                            int victor = rand.nextInt((9 - 0) + 1);

                            if (victor > 5) {
                                bugsList.get(b).setDed();
                                if(bugsList.get(b).getGender().equals("Male")){
                                    deadMales++; livingMales--;
                                }
                                
                                if(bugsList.get(b).getGender().equals("Female")){
                                    deadFemales++; livingFemales--;
                                }
                                
                            }

                            if (victor <= 5) {
                                bugsList.get(c).setDed();
                                
                                if(bugsList.get(c).getGender().equals("Male")){
                                    deadMales++; livingMales--;
                                }
                                
                                if(bugsList.get(c).getGender().equals("Female")){
                                    deadFemales++; livingFemales--;
                                }
                            }
                        }
                    }
                }

            }
        }

//        for(int i=0; i<array1.size(); i++){
//          for(int j=i + 1; j<array1.size(); j++){
//              if(arr[i] != arr[j]){
//                  ..do stuff..
//              }
//          }
//      }
        
        wrapup(reportFile);
  
    }
    
    
    
    public void wrapup(String fileName){
        java.io.File outFile=new java.io.File("src/"+fileName+".txt");
        if(!outFile.exists()){
            java.io.PrintWriter printer;
            try{
                printer=new java.io.PrintWriter(outFile);
            }catch (Exception e){
                System.out.println("IOException error: "+e);
                return;
            }
            printer.println("Initial: ");
            printer.println("Bugs: "+ initialBugs);
            printer.println("Male Bugs: "+initialMales);
            printer.println("Female Bugs: "+initialFemales);
            printer.println("\n\nEnd Results: ");
            printer.println("Alive Bugs:"+(livingFemales+livingMales));
            printer.println("Dead Bugs: "+(deadMales+deadFemales));
            printer.println("Male Bugs: "+initialMales);
            printer.println("Alive Male Bugs: "+livingMales);
            printer.println("Dead Male Bugs: "+deadMales);
            printer.println("Female Bugs: "+initialFemales);
            printer.println("Alive Female Bugs: "+livingFemales);
            printer.println("Dead Female Bugs: "+deadFemales);
            printer.close();
        }//end if
    }//end EndBugFarm()
    
}


