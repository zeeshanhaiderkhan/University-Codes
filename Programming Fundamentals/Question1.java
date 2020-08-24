
import java.util.Scanner;

public class Question1 {


    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        int n;
        
        while(true){
            n= kb.nextInt();
        if (n>99){
            break;
        }
        else if (n/10==1){
            if(n%10==1){
                System.out.println("Eleven");
            } 
            else if(n%10==2){
                System.out.println("Twelve");
            }
            else if(n%10==3){
                System.out.println("Thirteen");
            }
            else if(n%10==4){
                System.out.println("Fourteen");
            }
            else if(n%10==5){
                System.out.println("Fifteen");
            }
            else if(n%10==6){
                System.out.println("Sixteen");
            }
            else if(n%10==7){
                System.out.println("Seventeen");
            }
            else if(n%10==8){
                System.out.println("Eighteen");
            }
            else if(n%10==9){
                System.out.println("Nineteen");
            }
            
        }
        else if(n%10>=0 ){

                if ((n/10)==2){
                    System.out.print("Twenty ");
                }
                else if ((n/10)==3){
                    System.out.print("Thirty ");
                }
                else if ((n/10)==4){
                    System.out.print("Forty ");
                }
                else if ((n/10)==5){
                    System.out.print("Fifty ");
                }
                else if ((n/10)==6){
                    System.out.print("Sixty ");
                }
                else if ((n/10)==7){
                    System.out.print("Seventy ");
                }
                else if ((n/10)==8){
                    System.out.print("Eighty ");
                }
                else if ((n/10)==9){
                    System.out.print("Ninety ");
                }
                
                if ((n%10)==1){
                    System.out.print("One ");
                }
                else if ((n%10)==2){
                    System.out.print("Two ");
                }
                else if ((n%10)==3){
                    System.out.print("Three ");
                }
                else if ((n%10)==4){
                    System.out.print("Four ");
                }
                else if ((n%10)==5){
                    System.out.print("Five ");
                }
                else if ((n%10)==6){
                    System.out.print("Six ");
                }
                else if ((n%10)==7){
                    System.out.print("Seven ");
                }
                else if ((n%10)==8){
                    System.out.print("Eight ");
                }
                else if ((n%10)==9){
                    System.out.print("Nine ");
                }
            }
        
    }
    
}
}
