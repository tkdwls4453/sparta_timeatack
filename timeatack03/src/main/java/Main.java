import java.util.*;
import java.util.stream.Stream;


abstract class Player{
    private String name;
    private String initNumber;
    private List<String> fightList = new LinkedList<String>();
    private Boolean isEnd;
    public Player(String name, String initNumber) {
        this.name = name;
        this.initNumber = initNumber;
        this.isEnd = false;
    }
    public abstract void play(String number) throws Exception;
    public void addFightList(String number) { fightList.add(number); }
    public Boolean getIsEnd() { return isEnd; }
    public void setIsEnd(Boolean isEnd) { this.isEnd = isEnd; }
    public String getInitNumber() { return initNumber; }
    public String getName() { return name; }
    public void printFightList() {
        // TODO
    }
}
class PlayerATeam extends Player
{
    public PlayerATeam(String name, String number) {
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;
        // TODO
        char[] answers = this.getInitNumber().toCharArray();
        char[] numbers = number.toCharArray();
        //strike
        for (int i=0; i<answers.length; i++){
            if(answers[i] == numbers[i]){
                strike++;
                numbers[i] = 'x';

            }
        }

        //ball
        for(char num: numbers){
            if(Arrays.asList(answers).contains(num)){
                ball++;

            }
        }
        out = 4 - strike - ball;

        System.out.println(Arrays.toString(numbers));
        if(strike == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

class PlayerBTeam extends Player
{
    public PlayerBTeam(String name, String number) {
        super(name, number);
    }
    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        // TODO
        char[] answers = this.getInitNumber().toCharArray();
        char[] numbers = number.toCharArray();
        //strike
        for (int i=0; i<answers.length; i++){
            if(answers[i] == numbers[i]){
                strike++;
                numbers[i] = 'x';

            }
        }

        //ball
        for(char num: numbers){
            if(Arrays.asList(answers).contains(num)){
                ball++;

            }
        }
        out = 4 - strike - ball;

        System.out.println(Arrays.toString(numbers));

        if(ball == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Player playerArray[] = {new PlayerATeam("A Team","1234"), new PlayerBTeam("B Team","5678")};
        int checkPlayer = 0;

        while(true) {
            checkPlayer = 0;
            for(Player player : playerArray) {
                if (player.getIsEnd() == false) {
                    System.out.print("Please enter a 4 digit number (" + player.getName() + ") defence : ");
                    String number = scanner.nextLine();
                    try {
                        player.play(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    checkPlayer++;
                }
            }
            if(checkPlayer == playerArray.length) break;
        }

        for(Player player : playerArray) {
            player.printFightList();
        }
    }
}
