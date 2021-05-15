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
public class PasswordGenerator {
    
    public String generatePassword(){
            // create a string of uppercase and lowercase characters and numbers
            String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";

            // combine all strings
            String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

            // create random string builder
            StringBuilder sb = new StringBuilder();

            // create an object of Random class
            Random random = new Random();

            // specify length of random string
            int length = 10;

            for(int i = 0; i < length; i++) {

              // generate random index number
              int index = random.nextInt(alphaNumeric.length());

              // get character specified by index
              // from the string
              char randomChar = alphaNumeric.charAt(index);

              // append the character to string builder
              sb.append(randomChar);
            }

            String randomString = sb.toString();
            
            return randomString;
          }
    
    
}
