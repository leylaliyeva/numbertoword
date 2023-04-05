/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.numbertoword;
import java.util.*;  

/**
 *
 * @author leyla
 */
public class ConvertToWord {
   private static String ConvertInteger(long n){
        
        HashMap<String, String> numberMap = new HashMap<>();
        numberMap.put("0", "");
        numberMap.put("1", "bir");
        numberMap.put("2", "iki");
        numberMap.put("3", "üç");
        numberMap.put("4", "dörd");
        numberMap.put("5", "beş");
        numberMap.put("6", "altı");
        numberMap.put("7", "yeddi");
        numberMap.put("8", "səkkiz");
        numberMap.put("9", "doqquz");
        numberMap.put("10", "on");
        numberMap.put("20", "iyirmi");
        numberMap.put("30", "otuz");
        numberMap.put("40", "qırx");
        numberMap.put("50", "əlli");
        numberMap.put("60", "altmış");
        numberMap.put("70", "yetmiş");
        numberMap.put("80", "səksən");
        numberMap.put("90", "doxsan");
        numberMap.put("100", "yüz");
        numberMap.put("1000", "min");
        numberMap.put("1000000", "milyon");
        numberMap.put("1000000000", "milyard");
        numberMap.put("1000000000000", "trilyon");

        
        String result = new String();
        
        int k=1;
        long q = 0;
        while(n>0){
            if(n>10){
              q=n%10;
            }
            else{
                q=n;
            }
            if(k==1){
                result = numberMap.get(Long.toString(q))+ " "+ result;
            }
            if(k==2 || k==5 || k==8 || k==11 || k==14){
                result = numberMap.get(Long.toString(q*10) )+ " " + result;
            }
            if(k==3 || k==6 || k==9 || k==12 || k==15){
               result = numberMap.get(Long.toString(q))+ " " + numberMap.get("100" )+ " " +result;
            }
            if(k==4){
               result = numberMap.get(Long.toString(q))+ " "+ numberMap.get("1000") + " " +result;
            }
            if(k==7){
                result = numberMap.get(Long.toString(q))+ " "+numberMap.get("1000000") + " " +result;
            }
            if(k==10){
                result = numberMap.get(Long.toString(q))+ " "+ numberMap.get("1000000000") + " " +result;
            }
            if(k==13){
                result = numberMap.get(Long.toString(q))+ " "+ numberMap.get("1000000000000") + " " +result;
            }
                       
            n=n/10;
            k++;
            }
            
        return result;
        
    }

   public static String Convert(double n){
        String result = "";

       if((n % 1) == 0){
          result=ConvertInteger( Double.valueOf(Math.abs(n)).longValue());
       }
       else{
        String str = Double.toString(Math.abs(n));
        String[] res = str.split("[.]", 0);
        long intPart= Long.parseLong(res[0]);
        long decimalPart= Long.parseLong(res[1]);
        
        String intResult = ConvertInteger(intPart);
        String decimalResult = ConvertInteger(decimalPart);
        
        if(intResult.isEmpty() || intResult.isBlank()){
            intResult = "sıfır";
        }
        
        int numDigits = (int) Math.floor(Math.log10(Math.abs(decimalPart))) + 1;

        String descString = "tam ";
        switch (numDigits) {
            case 1 -> descString = descString + "onda";
            case 2 -> descString = descString + "yüzdə";
            case 3 -> descString = descString + "mində";
            case 4 -> descString = descString + "on minde";
            case 5 -> descString = descString + "yüz mində";
            case 6 -> descString = descString + "bir milyonda";
            case 7 -> descString = descString + "on milyonda";
            case 8 -> descString = descString + "yüz milyonda";
            case 9 -> descString = descString + "on milyardda";
            case 10 -> descString = descString + "yüz milyardda";
            case 11 -> descString = descString + "bir trilyonda";
            case 12 -> descString = descString + "on trilyonda";
            case 13 -> descString = descString + "yüz trilyonda";
       }
        
        result = intResult + " " + descString + " " + decimalResult;
       }
       if(n<0){
           result = "mənfi " + result;
       }
       return result;
   }

}
