/*****************************
 * Author: Maria Sanchez
 * CS3354 Summer II
 *****************************/
import java.io.*;
import java.util.*;
public class TwinPrime {
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    int maxIndex = 1229;
    Hashtable<Integer, Integer> primesHT = new Hashtable<Integer,Integer>();
    
    String csvFileIn = "prime.csv";
    String csvFileOut = "output.csv";
    
    public TwinPrime() {
        
        createOutputCSV(csvFileOut);
        fillPrimeHT(csvFileIn);
        if(primesHT == null){
            System.out.println("hash table is not built");
        }
        
        /*	Scanner scan = new Scanner(System.in);
         System.out.println("please enter N: ");
         int n = scan.nextInt();
         
         int res  = primality(n);
         printResult(n, res);
         
         writeToOutCSV(n, res, csvFileOut);*/
    }
    
    public  void createOutputCSV(String csvFileOut) {
        FileWriter writer = null;
        try{
            writer = new FileWriter(csvFileOut);
            writer.append("Query");
            writer.append(COMMA_DELIMITER);
            writer.append("Numbers");
            writer.append(NEW_LINE_SEPARATOR);
            
            System.out.println("output.csv is created");
        } catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                writer.flush();
                writer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public void writeToOutCSV(int n,int res){
        
        FileWriter writer = null;
        try{
            writer = new FileWriter(csvFileOut,true);
            
            writer.append(String.valueOf(n));
            writer.append(COMMA_DELIMITER);
            if(res==0)
                writer.append(String.valueOf(primesHT.get(n)));
            else if(res == -1){
                writer.append(String.valueOf(primesHT.get(n-1)));
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(primesHT.get(n)));
            }
            else if(res == 1){
                writer.append(String.valueOf(primesHT.get(n)));
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(primesHT.get(n+1)));
            }
            else if(res ==2){
                writer.append(String.valueOf(primesHT.get(n-1)));
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(primesHT.get(n)));
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(primesHT.get(n+1)));
            }
            
            writer.append(NEW_LINE_SEPARATOR);
            System.out.println("entry is added to output.csv");
        } catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                writer.flush();
                writer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public String printResult(int n,int res) {
        StringBuilder str = new StringBuilder();
        if(res==0)
            str.append(primesHT.get(n));
        else if(res == -1)
            str.append(primesHT.get(n-1)+", "+ primesHT.get(n));
        else if(res == 1)
            str.append(primesHT.get(n)+", "+ primesHT.get(n+1));
        else if(res==2)
            str.append(primesHT.get(n-1)+", "+ primesHT.get(n)
                       +", "+ primesHT.get(n+1));
        return str.toString();
    }
    
    // Q-1
    public void fillPrimeHT(String csvFile){
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(csvFile));
            for(int i=1;i<=maxIndex &&(line = br.readLine()) != null;i++){
                String[] p = line.split(COMMA_DELIMITER);
                int key = Integer.parseInt(p[0]);
                int val = Integer.parseInt(p[1]);
                primesHT.put(key, val);
            }
        } catch (FileNotFoundException e){
            System.out.println("PRIME.CSV is not present");
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            if(br != null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public int primality (int n){
        int ans =0;
        int both =0;
        if(n>maxIndex){
            System.out.println("n is out of bounds");
            return 0;
        }
        int primeNum = primesHT.get(n);
        int tprime1 = primeNum -2;
        int tprime2 = primeNum +2;
        if(primesHT.containsValue(tprime1)){
            ans = -1;
            both++;
        }
        if(primesHT.containsValue(tprime2)){
            ans = 1;
            both++;
        }
        if(both==2){
            ans = 2;
        }
        return ans;	
    }
}
