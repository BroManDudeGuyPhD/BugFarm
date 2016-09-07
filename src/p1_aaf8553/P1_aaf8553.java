// Andrew Fossier
// aaf8553
// CMPS 360
// Programming Project : 
// Due Date : 
// Started Sep 2, 2016, 3:58:15 PM 
// Program Description: Recursion things

// Certificate of Authenticity:
// I certify that the code in the method functions including method function main
// of this project are entirely my own work. 

package p1_aaf8553;

import java.util.Random;
import java.util.Scanner;


public class P1_aaf8553 {
    static bugFarm bugfarm = new bugFarm();


    public static void main(String[] args) { 
        
//        • the number of bugs initially in the bug farm.
//        • the upper bounds of the range (99 or less, but greater than zero).
//        • the number of times the alive bugs will move (and potentially fight and mate).
//        • the name of the report file.
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number of bugs: ");
        int bugs = sc.nextInt();
        
        System.out.print("Size of bug farm: ");
        int farmSize = sc.nextInt();
        while(farmSize < 0 || farmSize > 99){
            System.out.print(farmSize+" is not an acceptable value! Must be between 0 - 99: ");
            farmSize = sc.nextInt();
        }
        
        
        System.out.print("Number of bug movements: ");
        int movements = sc.nextInt();
        
        
        System.out.print("Report file name: ");
        Scanner sc2 = new Scanner(System.in);
        String reportFile= sc2.nextLine();
        
        bugfarm(bugs, farmSize, movements);
        
        
        
    
    }

}
