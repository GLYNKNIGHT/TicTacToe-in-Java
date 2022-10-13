import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe{

    static ArrayList<Integer> playerPostions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPostions = new ArrayList<Integer>();

    public static void main (String[] args){
        char[][] gameboard = {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}
    };
    printGameBoard(gameboard);

    while(true){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter you move (1-9):");
    int playerPos = scan.nextInt();
    
    while(playerPostions.contains(playerPos) || cpuPostions.contains(playerPos)){
        System.out.println("position taken, choose again");
        playerPos = scan.nextInt();
    }
    System.out.println(playerPos);
    placeMove(gameboard ,playerPos, "player");
    String result = checkWinner();

    Random rand = new Random();
    int cpuPos = rand.nextInt(9) +1;
    while(playerPostions.contains(cpuPos) || cpuPostions.contains(cpuPos)){
        cpuPos = rand.nextInt(9) +1;
    }

    placeMove(gameboard ,cpuPos ,"cpu");
    printGameBoard(gameboard);
    result = checkWinner();

    if (result.length() > 0){
    System.out.println(result);
    break;
    }
}
    }



public static void placeMove(char[][] gameboard, int pos, String user){

char symbol = ' ';

if(user.equals("player")){
symbol = 'X';
playerPostions.add(pos);
}else if (user.equals("cpu")) {
    symbol = 'O';
    cpuPostions.add(pos);
}

switch(pos){
    case 1:
    gameboard[0][0] = symbol;
    break;
    case 2:
    gameboard[0][2] = symbol;
    break;
    case 3:
    gameboard[0][4] = symbol;
    break;
    case 4:
    gameboard[2][0] = symbol;
    break;
    case 5:
    gameboard[2][2] = symbol;
    break;
    case 6:
    gameboard[2][4] = symbol;
    break;
    case 7:
    gameboard[4][0] = symbol;
    break;
    case 8:
    gameboard[4][2] = symbol;
    break;
    case 9:
    gameboard[4][4] = symbol;
    break;
    default:
    break;
    }
}

public static String checkWinner(){

    List topRow = Arrays.asList(1,2,3);
    List midRow = Arrays.asList(4,5,6);
    List botRow = Arrays.asList(7,8,9);
    List leftCol = Arrays.asList(1,4,7);
    List midCol = Arrays.asList(2,5,8);
    List rightCol = Arrays.asList(3,6,9);
    List leftDiag = Arrays.asList(1,5,9);
    List rightDiag = Arrays.asList(3,5,7);
    
    List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(rightCol);
        winning.add(midCol);
        winning.add(leftDiag);
        winning.add(rightDiag);

    for(List l : winning){
        if(playerPostions.containsAll(l)){
            return "Congrats you won";
        }else if (cpuPostions.containsAll(l)){
            return "Sorry you lose";
        }else if (playerPostions.size() + cpuPostions.size() == 9){
            return "Draw";
        }
    }
    return "";
}


 public static void printGameBoard(char[][] gameboard){
    for(char[] row: gameboard){
        for(char c : row){
            System.out.print(c);
        }
        System.out.println();
    }
 }


}