/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yw433
 */
public class Largest {
    /** 
    * Return the largest element in a list. 
    * 
    * @param list A list of integers 
    * @return The largest number in the given list 
    */

    public static int largest(int[] list) { 
//        int index, max=Integer.MAX_VALUE;
        int index, max=0;
        
        if (list.length == 0) { 
            throw new RuntimeException("Empty list");
        }

        for (index = 0; index <= list.length-1; index++) { 
            if (list[index] > max) {
                max = list[index];
            }
        } 
        return max;
    }
}