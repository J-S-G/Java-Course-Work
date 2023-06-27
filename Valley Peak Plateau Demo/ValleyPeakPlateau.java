/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.valleypeakplateau;

/**
 *
 * @author User
 */
public class ValleyPeakPlateau {

public static void main(String[] argv) {

int[][] arrays = { { 3, 5, 4, 4, 4, 4, 2, 6, 5, 5, 5, 5, 4, 4, 4, 4, 7, 2, 4, 6, 5 },

{ 9, 9, 9, 9, 9, 4, 7, 9, 9, 9, 9, 2, 9, 9, 9, 9, 9 }, { 0, 5, 7, 7, 7, 4, 8, 7, 7, 7, 10, 2, 6 },

{ 2, 8, 8, 8, 7, 9, 9, 9, 9, 9, 3, }, { 1, 9, 3, 5, 2, 7, 3, 5, 1, }, { 2, 5, 3, 2, 1, 9, 7, 8, },

{ 4, 4, 7, 4, 4, 4, 2, }, { 2, 5, 3, 3, 7, 2, }, { 1, 1, 1, 2, 0, 9, }, { 9, 0, 2, 1, 1, 1, },

{ 1, 2, 3, 3, 2, 1, }, { 1, 2, 5, 9, 10, }, { 4, 3, 2, 1, 0, }, { 7, 7, 7, 7, }, { 6, 5, 5, 5 },

{ 3, 3, 3, 9 }, { 1, 3, 2, }, { 3, 2, 1, }, { 1, 2, }, { 7, 5, }, { 6, 6, }, { 1, }, {}, };

for (int i = 0; i < arrays.length; i++)

valley_peak_plateau(arrays[i]);

}

/*

* TBI (To Be Implemented)...

*

*

*/

static void valley_peak_plateau(int[] a) 
{
    int n,i;
    n=a.length;
    System.out.print("\n\narray: {");
    for (i=0;i<n;i++)
    {
    System.out.print(a[i]+",");
    }
    System.out.print("}\n");
    if (n<2)
    System.out.println("(Skipped)");
    else if (n==2){
    for (i=0;i<n;i++){
    if (i==0){
    if (a[i]<a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a valley");
    else if (a[i]>a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a peak");
    }
    else{
    if (a[i]<a[i-1])
    System.out.println("["+i+"]="+a[i]+" is a valley");
    else if (a[i]>a[i-1])
    System.out.println("["+i+"]="+a[i]+" is a peak");
    }
    }
    }
    else{
    for (i=0;i<n;i++){
    if (i==0){
    if (a[i]<a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a valley");
    else if (a[i]>a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a peak");
    else if (a[i]==a[i+1] && a[i]==a[i+2])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    }
    else if (i<n-1){
    if (a[i]<a[i-1] && a[i]<a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a valley");
    else if (a[i]>a[i-1] && a[i]>a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a peak");
    else
    {
    if (i<n-2 && a[i]==a[i+1] && a[i]==a[i+2] || i>1 && a[i]==a[i-1] && a[i]==a[i-2])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    else if (i>1 && a[i]==a[i-1] && a[i]==a[i-2])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    else if (a[i]==a[i-1] && a[i]==a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    }
    }
    else{
    if (a[i]<a[i-1])
    System.out.println("["+i+"]="+a[i]+" is a valley");
    else if (a[i]>a[i-1])
    System.out.println("["+i+"]="+a[i]+" is a peak");
    else
    {
    if (i<n-2 && a[i]==a[i+1] && a[i]==a[i+2] || i>1 && a[i]==a[i-1] && a[i]==a[i-2])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    else if (i>1 && a[i]==a[i-1] && a[i]==a[i-2])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    else if (a[i]==a[i-1] && a[i]==a[i+1])
    System.out.println("["+i+"]="+a[i]+" is a plateau");
    }
    }
    }
}

}

}