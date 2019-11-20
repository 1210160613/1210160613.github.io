
public class JANKEN {
	
	public static int JankenCount = 10;
	
	
		
		
	
		  public static void main(String[] args) {
		    Player player1 = new Player("shio");
		    Player player2 = new Player("co");
		    player2.setStrategy(new wiseStrategy());

		    int player1win = 0;
		    int player2win = 0;

		    for (int i = 0; i < JankenCount; i++) {
		      Jankenrekkyo hand1 = player1.hand();
		      Jankenrekkyo hand2 = player2.hand();

		      String result = hand1.winTo(hand2) ?
		        								player1.getName() + "の勝利" :
		        							hand1.loseTo(hand2) ? 
		                        player2.getName() + "の勝利" : "あいこ";
		      
		                        
		                      
		      System.out.println(
		        String.format("%s: %s - %s :%s (%s)", 
		          player1.getName(), hand1, 
		          hand2, player2.getName(),
		          result
		        )
		      );
		      if (hand1.winTo(hand2)) {
		        player1win++;
		      }
		      if (hand2.winTo(hand1)) {
		        player2win++;
		      }
		      player1.prevHands(hand1, hand2);
		      player2.prevHands(hand2, hand1);
		    }
		    String finalResult = player2win < player1win ?
		    						player1.getName() + "の勝利" :
		    					   player1win < player2win ?
    							    player2.getName() + "の勝利" : "引き分け";
	    									
		 
		    
		    System.out.println(
		      String.format("%s!!!(%s: %d - %d :%s)", 
		        finalResult,
		        player1.getName(), player1win, 
		        player2win, player2.getName()
		      )
		    );
		  }
		}



		
		