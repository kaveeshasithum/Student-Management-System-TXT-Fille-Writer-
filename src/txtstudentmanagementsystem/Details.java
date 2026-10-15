/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package txtstudentmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Kaveesha
 */
public class Details {
    public static String genarateId(String mode,String batch) throws FileNotFoundException{
        File f1=new File("Student.txt");
        Scanner countStudent=new Scanner(f1);
       
        //Last Number
        int count=0;
        while(countStudent.hasNextLine()){
            String line=countStudent.nextLine();
            String[] rowData=line.split(",");
            if(rowData[0].substring(4,7).equals(batch)){
                count++;
            }
        }
        String id=(mode.equals("PHYSICAL") ? "PR" : "OR") + 24 + batch + String.format("%03d",++count);
        return id;
    }
    
    public static boolean isNicDuplicates(String nic) throws FileNotFoundException{
        File f1=new File("Student.txt");
        Scanner duplicateNic=new Scanner(f1);
        
        while(duplicateNic.hasNextLine()){
            String line=duplicateNic.nextLine();
            String[]rowData=line.split(",");
            if(rowData[1].equals(nic)){
                return true;
            }
        }
        return false;
    }


    public static int getPrfMarks(String[] rowData) {
        return Integer.parseInt(rowData[3]);
    }


    public static int getDbmsMarks(String[] rowData) {
        return Integer.parseInt(rowData[4]);
    }


    public static double calculateGPA(int marks) {

        if (marks >= 90) {
            return 4.25;
        } else if (marks >= 80) {
            return 4.00;
        } else if (marks >= 75) {
            return 3.70;
        } else if (marks >= 70) {
            return 3.30;
        } else if (marks >= 65) {
            return 3.00;
        } else if (marks >= 60) {
            return 2.70;
        } else if (marks >= 50) {
            return 2.00;
        } else {
            return 0.00;
        }
    }


    public static double getGPA(int prfMarks, int dbmsMarks) {

        if (prfMarks == -1 || dbmsMarks == -1) {
            return -1;
        }

        if (prfMarks == -2 || dbmsMarks == -2) {
            return -2;
        }

        double prfGpa = calculateGPA(prfMarks);
        double dbmsGpa = calculateGPA(dbmsMarks);

        return (prfGpa + dbmsGpa) / 2;
    }


    
    
    
    
}
