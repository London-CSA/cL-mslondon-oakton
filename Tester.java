import java.util.Scanner;

 public class Main{
     public static void main(String[] args) {

       Scanner in = new Scanner(System.in);

       int testNum=in.nextInt();

       if (testNum==0) {
       //for you to test your code, hit the run button and type 0
       //your testing code here







       } else if (testNum==1) {
         //test constructors
         CombinationLock cDef = new CombinationLock();
         int c1= cDef.getCombo1();
         int c2 = cDef.getCombo2();
         int c3 = cDef.getCombo3();
         System.out.println("Is combo1 correctly initialized: " + (c1<10 && c1>=0));
         System.out.println("Is combo2 correctly initialized: " + (c2<10 && c2>=0));
         System.out.println("Is combo3 correctly initialized: " + (c3<10 && c3>=0));

         CombinationLock cL2 = new CombinationLock(3,9,8, in);
         System.out.println(cL2);

       }

       else if (testNum==2) {
         CombinationLock c = new CombinationLock(1,2,3, in);
         c.turnLeft(1,8);
         c.printDialPositions();
         c.turnLeft(1,5);
         c.printDialPositions();
         c.turnLeft(1,14);
         c.printDialPositions();
         c.turnLeft(2,1);
         c.printDialPositions();
         c.turnLeft(2,20);
         c.printDialPositions();
         c.turnLeft(3,9);
         c.printDialPositions();
         c.turnLeft(1,9);
         c.printDialPositions();
         c.turnLeft(3,19);
         c.printDialPositions();
         c.turnLeft(2,5);
         c.printDialPositions();
         c.turnLeft(4,8);
         c.printDialPositions();  
       
       } else if (testNum==3) {
         CombinationLock c = new CombinationLock(9,1,1, in);
         c.turnRight(2,4);
         c.printDialPositions();
         c.turnRight(2,9);
         c.printDialPositions();
         c.turnRight(3,45);
         c.printDialPositions();
         c.turnRight(3,1);
         c.printDialPositions();
         c.turnRight(3,20);
         c.printDialPositions();
         c.turnRight(1,1);
         c.printDialPositions();
         c.turnRight(1,2);
         c.printDialPositions();  
         c.turnRight(0,2);
         c.printDialPositions();  
         
       } else if (testNum==4) {
         //test closeLock
         CombinationLock c2 = new CombinationLock(1,1,1, in);
         System.out.println(c2.closeLock());
         c2.openLock(1,9,1);
         System.out.println(c2.closeLock());

       }else if(testNum==5) {
         //test openLock
         CombinationLock c = new CombinationLock(1,2,3, in);
         c.printDialPositions();
         boolean notOpen=c.openLock(5,5,5);
         System.out.println("Did it open?: " + notOpen);
         c.printDialPositions();
         boolean open=c.openLock(6,13,28);
         System.out.println("Did it open?: " + open);
         boolean notOpen2=c.openLock(10,10,10);
         System.out.println("Did it open?: " + notOpen2);
         c.printDialPositions();
         c.closeLock();
         c.reset();
         boolean notOpen3=c.openLock(1,0,29);
         System.out.println("Did it open?: " + notOpen3);
         c.printDialPositions();
         boolean open3=c.openLock(0,8,4);
         System.out.println("Did it open?: " + open3);

       } else if (testNum==6) {
         //test security feature
         CombinationLock c5 = new CombinationLock(9,9,9, in);
         for (int i=0; i<4; i++) {
           System.out.println("opened?:"+c5.openLock(1,1,1)); //unsuccessful
         }
         for (int i=0; i<5; i++) {
           System.out.println("this is jammed! opened:" + c5.openLock(5,7,5)); //jammed
         }
         System.out.println(c5);
         c5.clearOnApp(1233); //no return value
         System.out.println("still jammed! opened:"+c5.openLock(5,7,5)); //still jammed
         c5.clearOnApp(1234); //no return value, unjammed

         System.out.println(c5.openLock(9,1,9));//successful
         c5.closeLock();
         c5.reset();
         System.out.println(c5.openLock(9,1,9));//successful
         c5.closeLock();
         c5.reset();
         System.out.println(c5.openLock(9,1,9));//successful
         c5.closeLock();
         c5.reset();
         System.out.println(c5.openLock(9,1,9));//successful
         c5.closeLock();
         c5.reset();
         System.out.println(c5);

         System.out.println(c5.openLock(1,1,1));//unsuccessful
         System.out.println(c5.openLock(1,1,1));//unsuccessful
         System.out.println(c5.openLock(8,0,8));//successful
         c5.closeLock();
         System.out.println(c5);
         c5.reset();
         System.out.println(c5.openLock(1,1,1));//unsuccessful
         System.out.println(c5.openLock(1,1,1));//unsuccessful
         System.out.println(c5.openLock(1,1,1));//unsuccessful

       } else if (testNum==7) {
         CombinationLock c7= new CombinationLock(9,8,7, in);
         System.out.println(c7);
       } 
       System.out.println("end of main");


     }
 }
