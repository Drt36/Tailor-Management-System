/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Random.Generator;

import java.util.Random;

/**
 *
 * @author dharm
 */
public class OtpCodeGenerator {
    public String generateOtpcode(){
        
        //instance of random class      
        Random rand = new Random();   
        
        int upperbound = 10000000;                    
        //generate random values from 0-10000000
                                        
        int random= rand.nextInt(upperbound);
                                        
        String randompassword=Integer.toString(random);
        return randompassword;
    }
}
