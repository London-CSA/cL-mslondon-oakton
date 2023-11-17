import java.util.Scanner;

public class CombinationLock {
  private int combo1;
  private int combo2;
  private int combo3;
  private int dial1; //holds current position of dial 1
  private int dial2; //holds current position of dial 2
  private int dial3; //holds current position of dial 3
  private boolean isOpen; 
  private int numTries;
  private boolean isJammed; //for the security feature
  private int pIN;

  public CombinationLock() {
    combo1=(int)(Math.random()*10);
    combo2=(int)(Math.random()*10);
    combo3=(int)(Math.random()*10);
    numTries=0;
    isOpen=false;
    isJammed=false;
  }

  //constructor to initialize pin and combo
  public CombinationLock(int num1, int num2, int num3, Scanner userInput) {
    if (num1 <0 || num1 >9) dial1=9;
    else combo1=num1;
    if (num2 <0 || num2 >9) dial2=9;
    else combo2=num2;
    if (num3 <0 || num3 >9) dial3=9;
    else combo3=num3;
    numTries=0;
    isOpen=false;
    isJammed=false;
    do {
      System.out.println("Enter a four digit PIN number");
      pIN=userInput.nextInt();
    } while (pIN > 10000 || pIN < 1000);
    
  }

  /* precondition: none
  postcondition: represents the number of unsuccessul attempts to open the lock */
  public int getNumTries() {
    return numTries;
  }
  /* you could eliminate these getter methods if you want the combo to be private but were written for testing purposes*/
  public int getCombo1() {
    return combo1;
  }

  public int getCombo2() {
    return combo2;
  }

  public int getCombo3() {
    return combo3;
  }

  /*
   * no other setter methods than those below- the turn methods change the
   * dial positions, numTries should only be modified in the OpenLock method
   * isOpen is modified with OpenLock 
   * isJammed is modified with clearOnApp and OpenLock
   */

  /* precondition: 1<=dialNum<=3, clicks >0 
  postcondition: simulates a left turn of the dial with dialNum a given number of clicks */
  public void turnLeft(int dialNum, int clicks) {
    if (dialNum==1){
      dial1 = (dial1+clicks)%10;
    }
    else if(dialNum==2) {
      dial2 = (dial2+clicks)%10;
    }
    else if (dialNum==3){
      dial3 = (dial3+clicks)%10;
    }
}

  /* precondition: 1<=dialNum<=3, clicks >0 
  postcondition: simulates a left turn of the dial with dialNum a given number of clicks */
  public void turnRight(int dialNum, int clicks) {
    if (dialNum==1) dial1 = ((dial1-clicks)%10+10)%10;
    else if(dialNum==2) dial2 = ((dial2-clicks)%10+10)%10;
    else if (dialNum==3) dial3 = ((dial3-clicks)%10+10)%10;
}

  /* precondition: none
  postcondition: called after lock is closed to set dial positions to random values */
  public void scramble() {
    dial1 = (int) (Math.random() * 10);
    dial2 = (int) (Math.random() * 10);
    dial3 = (int) (Math.random() * 10);
  }

  /* precondition: pinN is value user enters in app to try to clear security feature
    postcondition: will unjam lock from security feature if user enters correct pIN
  */
  public void clearOnApp(int pinN) {
    if (pinN==pIN) {
    isJammed=false;
    numTries=0;
    }
  }

  /* precondition: num1 > 0, num2 >0, num3 >0
  postcondition: opens the lock if it is open, not jammed by the security feature, and the combination is input correctly */
  public boolean openLock(int num1, int num2, int num3) {
    if (!isOpen && !isJammed){
      if (numTries == 4) { // smart lock is jammed by security feature
        isJammed=true;
        return false;
      }
      turnLeft(1,num1);
      turnRight(2,num2);
      turnLeft(3,num3);
      if (dial1==combo1 && dial2==combo2 && dial3==combo3) isOpen=true;
      
      if (!isOpen) numTries++;
      else numTries=0;
      return isOpen;
    }
      return false;
  }

  /* preconditions: none
  postconditions: closes the lock if it is open and scrambles the dials */
  public boolean closeLock() {
    if (isOpen) {
      isOpen = false;
      scramble();
      return true;
    }
    return false;
  }

  public String toString() {
    String openClose="closed";
    if (this.isOpen) openClose="open";
    return "The lock with combination " + combo1+"-"+combo2+"-"+combo3 + " is "+openClose+".\nCurrently there have been "+numTries+" consecutive unsuccessful attempts to open it.\nThe PIN number is " + pIN +".";
  }

  //do not change, for testing purposes only
  public void printDialPositions() {
    System.out.println(dial1 + " " + dial2 + " " + dial3);
  }

  public void reset() {
    dial1=0;
    dial2=0;
    dial3=0;
  }

}

  
