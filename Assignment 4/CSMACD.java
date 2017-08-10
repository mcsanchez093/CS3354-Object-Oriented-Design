/*****************************
 * Author: Maria Sanchez
 * CS3354 Summer II
 *****************************/

import java.util.Random;
public class CSMACD
{
    static boolean randomBool()
    {
        Random random = new Random();
        int num = random.nextInt();
        return num%2 == 1;
    }
    public static void main(String[] args)
    {
    	Station s1,s2,s3; 
      double r1, r2 , r3, r4; 
      boolean carrierStatus;
      
      for(int i = 0; i<1500; i++) 
      {
      	for(int j = 0; j<3; j++) 
      	{
      		carrierStatus = randomBool(); 
          r1 = Math.random();
          s1 = new Station((int) r1,carrierStatus);
          
          carrierStatus = randomBool();
          r1 = Math.random(); 
          s2 = new Station((int) r1,carrierStatus);
          
          carrierStatus = randomBool();
          r1 = Math.random(); 
          s3 = new Station((int) r1,carrierStatus);
          
          System.out.println("-> sending message from s1 to s2");
          
          /********************************************************************/
         
          if(s1.isCarrierStatus() && s2.isCarrierStatus())
          {
          	System.out.println("Collision occur! Transition Stopped!");
          	r4 = Math.random();
          	}
          
          else if(s1.isCarrierStatus() == false && s2.isCarrierStatus() == false)
          {
          	r2 = Math.random();
          	s2.setMessage((int) r2);
          	System.out.println("Data has been transmited successfully!");
          	}
          
          else
          {
          	System.out.println("s1 or s2 are busy!");
          	r3 = Math.random();
          	}
          System.out.println("-> sending message from s2 to s3");
          
          /********************************************************************/

          if(s2.isCarrierStatus() && s3.isCarrierStatus())
          {
          	System.out.println("Collision occur! Transmiss stop!");
          	r4 = Math.random();
          	}
          else if(s2.isCarrierStatus() == false && s3.isCarrierStatus() == false)
          {
          	r2 = Math.random();
          	s3.setMessage((int) r2);
            System.out.println("Data has been transmited successfully!");
            }
          else
          {
          	System.out.println("s2 or s3 are busy!");
          	}
          System.out.println("-> sending message from s3 to s1");
          
          /********************************************************************/         
          
          if(s3.isCarrierStatus() && s1.isCarrierStatus())
          {
          	System.out.println("Collision occur! Transition Stopped!");
            r4 = Math.random();
            }
          else if(s3.isCarrierStatus() == false && s1.isCarrierStatus() == false)
          {
          	r2 = Math.random();
            s1.setMessage((int) r2);
            System.out.println("Data has been transmited successfully!");
            }
          else
          {
          	System.out.println("s3 or s1 are busy!");
            r3 = Math.random();
            }
          }
      	}
      }
    }
