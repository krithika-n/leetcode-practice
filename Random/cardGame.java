import java.util.*;

public class cardGame {
    public Player[] placement;

    public static String placeBots(int humans, int bots){
        int quotient = humans / bots; // 1
        int remainder = humans % bots; // 3
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < bots; i++){
            if(remainder != 0 && i % remainder == 0){
                answer.append("H");
            }
            for(int j = 0; j < quotient; j++){
                answer.append("H");
            }
            answer.append("B");
        }
        return answer.toString();
    }

    public static void main(String[] args){
        String placement = placeBots(3,4);
        System.out.println(placement);
    }
}


enum Player{
    HUMAN('H'),
    BOT('B');

    Player(final Character val){
        value = val;
    }

    private final Character value;

    public Character getValue(){
        return value;
    }
}