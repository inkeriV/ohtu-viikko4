package ohtu;

public class TennisGame {
    
    private int player1Scores = 0;
    private int player2Scores = 0;
    private String player1Name;
    private String player2Name;
    private String score;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.score="";
    }

    public void wonPoint(String playerName) {
        
        if (playerName.equals("player1")) {
            player1Scores += 1;
        } else {
            player2Scores += 1;
        }    
    }

    public String getScore() {
        
        if (isTie()) {
            goThroughP1Score();
            
        } else if (isGameWon()) {
            wonGame();
        }
        else {
            goThroughP2Score();
        }
        return score;
    }
    
    public String wonGame() {
            
        int minusResult = player1Scores - player2Scores; //minusResult on erotus pelaaja1-pelaaja2 pisteet
        if (minusResult==1) {
            score ="Advantage player1";
        
        } else if (minusResult ==-1) {
            score ="Advantage player2";
        
        } else if (minusResult>=2) {
            score = "Win for player1";
        
        } else score ="Win for player2";

        return score;
    }
    
    public String goThroughP1Score() {
        switch (player1Scores) {
            
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            case 3:
                    score = "Forty-All";
                break;
            default:
                    score = "Deuce";
                break;                
        }
        return score;
    }
    
    public String goThroughP2Score() {
        int tempScore=0;
        for (int i=1; i<3; i++) {
            
            if (i==1) tempScore = player1Scores; //väliaikanen score on p1 pisteet
            else { score+="-"; tempScore = player2Scores;} //pelaajan2 pisteet
            switch(tempScore) 
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
    
    public boolean isGameWon() {
        return (player1Scores>=4 || player2Scores>=4);
    }
    public boolean isTie() {
        return (player1Scores == player2Scores);
    }
    
}