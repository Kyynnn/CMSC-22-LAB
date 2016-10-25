import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RPSLS extends Frame {
    private static final int DEFAULT_SCORE = 0;
        
    private int playerScore;
    private int computerScore;
        
    private Label playerChoice, scorePlayer, scoreComputer, gameOver;
    private CheckboxGroup choiceGroup;
    private Checkbox rock, paper, scissors, lizard, spock;
    private TextArea result;
    private TextField PlayerScore, ComputerScore;
    private Button action, reset;
    private Dialog GameOver;
   
    RPSLS() {
        playerScore = DEFAULT_SCORE;
        computerScore = DEFAULT_SCORE;
        
        setLayout(new FlowLayout());
        
        playerChoice = new Label("Your choice:");
        choiceGroup = new CheckboxGroup();
        rock = new Checkbox("Rock", choiceGroup, true);
        paper = new Checkbox("Paper", choiceGroup, false);
        scissors = new Checkbox("Scissors", choiceGroup, false);
        lizard = new Checkbox("Lizard", choiceGroup, false);
        spock = new Checkbox("Spock", choiceGroup, false);
        result = new TextArea(" Results:", 4, 25, TextArea.SCROLLBARS_NONE);
        scorePlayer = new Label("Player's Score");
        PlayerScore = new TextField(String.valueOf(DEFAULT_SCORE), 30);
        scoreComputer = new Label("Computer's Score");
        ComputerScore = new TextField(String.valueOf(DEFAULT_SCORE), 30);
        action = new Button("RockPaperScissorsLizardSpock!");
        GameOver = new Dialog(this);
        gameOver = new Label();
        reset = new Button("OK");
        
        action.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText(" Results:");
                String playerAction = choiceGroup.getSelectedCheckbox().getLabel();
                String computerAction = computerSelectAction();
                int roundWinID = roundVictor(playerAction, computerAction);
                result.append("\n Player chose: " + playerAction.toUpperCase());
		            result.append("\n Computer chose: " + computerAction.toUpperCase());
				
		            if (roundWinID == 1) {
                    PlayerScore.setText(String.valueOf(++playerScore));
               			result.append("\n\n YOU WIN THIS ROUND!");
	            	} else if (roundWinID == 0) {
                    ComputerScore.setText(String.valueOf(++computerScore));
                    result.append("\n\n YOU LOSE THIS ROUND!");
            		} else {
                    result.append("\n\n IT'S A TIE!");
                }
				
		            if (isGameOver()) {
                    action.setEnabled(false);
                    if (roundWinID == 1) {
		                  	gameOver.setText("Game Over! Player won.");
                    } else {
		                  	gameOver.setText("Game Over! Computer won.");
                    }
                    GameOver.setVisible(true);
		            }
            }
        });
        
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameOver.setVisible(false);
                reset();
                action.setEnabled(true);
            }
        });
        
        GameOver.setLayout(new FlowLayout());
        GameOver.add(gameOver);
	      GameOver.add(reset);
	      GameOver.setTitle("Game Over!");
	      GameOver.setSize(200, 120);
		
      	add(playerChoice);
	      add(rock);
	      add(paper);
	      add(scissors);
      	add(lizard);
	      add(spock);
	      add(result);
	      add(action);
      	add(scorePlayer);
	      add(PlayerScore);
	      add(scoreComputer);
	      add(ComputerScore);
		
	      setTitle("Rock Paper Scissors Lizard Spock!");
	      setSize(300, 370);
	      setVisible(true);
		
	      addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
		            System.exit(0);
            }
        });
    } 
    
    private Random r = new Random();
    public int randomInt(int a, int b) {
        int randomNumber = r.nextInt((b - a) + 1) + a;
        return randomNumber;
    }

    public String computerSelectAction() {
        int x = randomInt(1, 5);
        if (x == 1) {
            return "Rock";
        } else if (x == 2) {
            return "Paper";
        } else if (x == 3) {
            return "Scissors";
        } else if (x == 4) {
            return "Lizard";
        } else {
            return "Spock";
        }
    }
    
    public int roundVictor(String playerChoice, String computerChoice) {
        if (playerChoice.equals("Rock")) {
            if (computerChoice.equals("Scissors") || computerChoice.equals("Lizard")) {
                return 1;
            } else if (computerChoice.equals("Paper") || computerChoice.equals("Spock")) {
                return 0;
            } else {
                return -1;
            }
        } else if (playerChoice.equals("Paper")) {
            if (computerChoice.equals("Rock") || computerChoice.equals("Spock")) {
                return 1;
            } else if (computerChoice.equals("Scissors") || computerChoice.equals("Lizard")) {
                return 0;
            } else {
                return -1;                
            }
        } else if (playerChoice.equals("Scissors")) {
            if (computerChoice.equals("Paper") || computerChoice.equals("Lizard")) {
                return 1;
            } else if (computerChoice.equals("Rock") || computerChoice.equals("Spock")) {
                return 0;
            } else {
                return -1;                
            }
        } else if (playerChoice.equals("Lizard")) {
            if (computerChoice.equals("Paper") || computerChoice.equals("Spock")) {
                return 1;
            } else if (computerChoice.equals("Rock") || computerChoice.equals("Scissors")) {
                return 0;
            } else {
                return -1;                
            }
        } else if (playerChoice.equals("Spock")) {
            if (computerChoice.equals("Rock") || computerChoice.equals("Scissors")) {
                return 1;
            } else if (computerChoice.equals("Paper") || computerChoice.equals("Lizard")) {
                return 0;
            } else {
                return -1;                
            }
        }
        return -1;
    }
    
    public boolean isGameOver() {
        return playerScore == 5 || computerScore == 5;
    }

    public void reset() {
        playerScore = DEFAULT_SCORE;
        computerScore = DEFAULT_SCORE;
        result.setText(" Results:");
        PlayerScore.setText(String.valueOf(DEFAULT_SCORE));
        ComputerScore.setText(String.valueOf(DEFAULT_SCORE));
    }

    public static void main(String[] args) {
        new RPSLS();
    }
}
