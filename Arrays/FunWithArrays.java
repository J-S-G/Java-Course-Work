/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.funwitharrays;

/**
 * Title:  Fun With Arrays
 * Desc:   We need to explore what Arrays are and how they are stored
 * @author Joseph G.
 */

import java.util.Scanner;
import java.util.Arrays;    // Cool array methods
import java.util.ArrayList; // The ArrayList class for ease of use 
import java.util.Collections;

public class FunWithArrays 
{

    public static void main(String[] args) 
    {
        Scanner stdin = new Scanner(System.in);
        
        // Arrays are objects
        int[] yourInts; // 
        String[] yourStrs;
        
        int[] myInts = new int[10]; // This creates space for 10 integers
        String[] myStr = new String[10]; // 
        System.out.println("How many ints and strings in your arrays?");
        //int size = stdin.nextInt();
        int size = 5;
        yourInts = new int[size];   // This is created on the fly
        yourStrs = new String[size]; // This is created on the fly
        int[] pupsInts = {1, 2, 8, 3, 4, 9};
        String[] pupsString = {"one", "two", "three", "fetch"};
        
        for(int i = 0; i < 10; i++) // i is the index. Mr. Meacham calls i the offset.
        {
            // myInts and myStr are the base addresses for the array in memory
            myInts[i] = (int)(Math.random() * 100 + 1);
            myStr[i] = "String: " + (i + 1);
        }
        
        for(int i = 0; i < 10; i++)
        {
            System.out.println(myInts[i]);
            System.out.println(myStr[i]);
        }
        
        int[][] nums1; // nums1 will the hold the address of a 2-Dimensional Array
        int[][] nums2 = new int[5][]; // allocated 5 rows
        int[][] nums3 = new int[3][4]; // 1 array that addresses 3 integer arrays
        int[][] nums4 = {{1,2,3},{4,5},{6,7,8,9}}; // Ragged array -> 1 array that holds memory for 3 arrays : 4 Arrays
        
        for(int i = 0; i < nums4.length; i++)
        {
            for(int j = 0; j < nums4[i].length; j++)
            {
                System.out.print(nums4[i][j] + " ");
            }
            System.out.println("");
        }
        
        // Let's play with the static methods in the Array Class 
        int[] scores = new int[30];
        
        Arrays.fill(scores,100);
        for(int i : scores)
        {
            System.out.print(i + " ");
        }
        System.out.println("");
        
        // 
        scores[11] = 27; 
        scores[3] = 8; 
        scores[15] = 123; 
        
        Arrays.sort(scores);
         for(int i : scores)
         {
             System.out.print(i+ " ");
         }
        System.out.println("");
        
        // Last Topic : ArrayList
        // Specify the data type for Arrays and then you are restricted to that data

        ArrayList<String> nameList = new ArrayList<String>(); // Default of 10 holding places
        ArrayList<Integer> intList = new ArrayList<Integer>(100); // Wrapper Class
        
        nameList.add("Student1");
        nameList.add("Student2");
        nameList.add("Student3");
        nameList.add("Student4");
        
        for(String i : nameList)
        {
            System.out.print(i + " ");
        }
        
        // Use Java API methods for manipulating Arrays 
        nameList.add(1,"Student5");
        
        for(String i : nameList)
        {
            System.out.print(i + " ");
        }
        
        nameList.set(2,"Stafford");
        
        Collections.sort(nameList);
        
        for(String i : nameList)
        {
            System.out.print(i + " ");
        }
        
    }

}

    // yourints -> holds an address which points to somewhere in the heap

    // What is an Array? 
    // One reference variable that holds the address of a collection of one data type.
    // Is it a primitive type or object? A: Object

    // An Array is an object that holds data
    // But, it also provides some cool functionality that we don't think about 
