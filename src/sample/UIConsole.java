package sample;

import java.util.Scanner;

public class UIConsole {

    public static void main(String[] args) {
        System.out.println("---------------------------");
        System.out.println("Welcome to Double IT Fitness GYM MANAGER!! ");
        System.out.println("Select a favor from below!!");



        while (true){

            System.out.println("---------------------------");
            System.out.println("                           ");
            System.out.println("Enter 1 to Add a member..");
            System.out.println("Enter 2 to Delete/Remove a member..");
            System.out.println("Enter 3 to Print the List Of Members..");
            System.out.println("Enter 4 to Sort the members..");
            System.out.println("Enter 5 to Save the members..");
            System.out.println("Enter 6 to Open the GUI..");
            System.out.println("Enter 7 to End the program..");
            System.out.println("                            ");
            System.out.println("---------------------------");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice==1){
                System.out.println("----------");
                System.out.println("ADD MEMBER");
                System.out.println("----------");
                System.out.println("");
                System.out.println("Enter 1 to select default member");
                System.out.println("Enter 2 to select student member");
                System.out.println("Enter 3 to select Over 60 member");

                System.out.println("Enter your choice: ");
                Scanner scanner2 = new Scanner(System.in);
                int choice1 = scanner2.nextInt();
                if (choice1==1){
                    System.out.println("----------");
                    System.out.println("DEFAULT MEMBER");
                    System.out.println("----------");
                    System.out.print("Enter your First Name: ");
                    String fNameDMember = scanner2.next();
                    System.out.print("Enter your Last Name: ");
                    String lNameDMember = scanner2.next();
                    System.out.print("Enter your Member ID: ");
                    String mIDDMember = scanner2.next();
                    System.out.println("Member added!!");

                    MyGymManager myGymManager = new MyGymManager();
                    myGymManager.addDefaultMember(fNameDMember,lNameDMember,mIDDMember);



                }else if (choice1==2){
                    System.out.println("----------");
                    System.out.println("STUDENT MEMBER");
                    System.out.println("----------");
                    System.out.print("Enter your First Name: ");
                    String fNameSMember = scanner2.next();
                    System.out.print("Enter your Last Name: ");
                    String lNameSMember = scanner2.next();
                    System.out.print("Enter your Member ID: ");
                    String mIDSMember = scanner2.next();
                    System.out.print("Enter your school: ");
                    String schoolMember = scanner2.next();
                    System.out.println("Member added!!");

                    MyGymManager myGymManager = new MyGymManager();
                    myGymManager.addStudentMember(fNameSMember,lNameSMember,mIDSMember,schoolMember);

                }else if (choice1==3){
                    System.out.println("----------");
                    System.out.println("OVER 60 MEMBER");
                    System.out.println("----------");

                    System.out.print("Enter your First Name: ");
                    String fName60Member = scanner2.next();
                    System.out.print("Enter your Last Name: ");
                    String lName60Member = scanner2.next();
                    System.out.print("Enter your Member ID: ");
                    String mID60Member = scanner2.next();
                    System.out.print("Enter your age: ");
                    int ageMember = scanner2.nextInt();
                    System.out.println("Member added!!");

                    MyGymManager myGymManager = new MyGymManager();
                    myGymManager.addOver60Member(fName60Member,lName60Member,mID60Member,ageMember);

                }else {
                    System.out.println("Invalid Input!!!!!!!");
                }

            }else if (choice==2){
                System.out.println("----------");
                System.out.println("Enter member ID to remove a member");
                System.out.println("----------");

                System.out.print("Enter Member ID: ");
                Scanner scanner3 = new Scanner(System.in);
                String choice2 = scanner3.next();

                MyGymManager myGymManager = new MyGymManager();
                myGymManager.deleteMember(choice2);

            }else if (choice==3){
                MyGymManager myGymManager = new MyGymManager();
                myGymManager.printListOfMembers();


            }else if (choice==4){
                MyGymManager myGymManager = new MyGymManager();
                myGymManager.sortMembers();

            }else if (choice==5){
                MyGymManager myGymManager = new MyGymManager();
                myGymManager.save();

            }else if (choice==6){

                Main.main(args);

            }else if (choice==7){
                System.out.println("Thank you! Have a nice day!!");
                break;
            }else {
                System.out.println("Invalid Input Try again!!");
            }
        }



    }
}
