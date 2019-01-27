/*Shisokuは四則演算をランダムで10題出題する。
 * 正誤判定をおこない、正答数と正答率を表示するプログラムである。
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shisoku {
	

	public static final int MAX_QUESTION = 10;
	/*MAX_QUESTION 回繰り返して出題する
	*最後に正答率を出題する
	*/
	
		public static void main(String[] args) {
			int goodAnswers = 0;    //正答数
			System.out.println("これから四則演算を"+MAX_QUESTION+"問出題します");
			/*以下、問題を繰り返し表示し、ユーザからの解答を判断する
			 * その後、正答数を数える。
			 *  
			 */
			for(int i =0 ; i < MAX_QUESTION; i++) {
			
				/*
				 *四則演算をランダムで選ぶ 
				 */
				
				
				boolean ok ;
				int questby = (int)(Math.random() * 4);
				
				switch(questby) {
				case 0 : ok = showAdditionalQuestion(i + 1);//足し算
						break;
				case 1 : ok = showSubstractionalQuestion(i +1);//引き算
						break;
				case 2 : ok = showMultiplyQuestion(i + 1);//掛け算
						break;
				case 3 : ok = showDividalQuestion(i + 1); //割り算		
						break;
				default : ok = false;
						break;
				}
				
				if(ok) {
					goodAnswers++;
				}
			}
			
			double rate = goodAnswers * 100.0 / MAX_QUESTION;
			 System.out.println("");
			 System.out.println("問題は" + MAX_QUESTION + "問ありました。");
			 System.out.println("正しく答えられたのは" + goodAnswers + "問、");
			 System.out.println("間違えてしまったのは" + (MAX_QUESTION - goodAnswers ) + "問です。");
			 System.out.println("正答率は" + rate + "% です。" );
			 System.out.println("");
		}	 
		//足し算
		public static boolean showAdditionalQuestion(int questno) {
			int x = (int)(Math.random() * 9 ) + 1;
			int y = (int)(Math.random() * 9 ) + 1;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("第["+questno +"]問 " + x+ "+"+y+"= ?");
				String line = reader.readLine();
				int result = Integer.parseInt(line);
					if(x + y == result) {
						System.out.println("正解");
					}else{
						System.out.println("不正解");
						return false;
					}
			} catch (IOException e) {
				System.out.println(e);
			} catch (NumberFormatException e) {
				System.out.println("入力が正しくありません。");
			}
			return false;
			
		}
		
		//引き算
		public static boolean showSubstractionalQuestion(int questno) {
			int x = (int)(Math.random() * 9 ) + 1;
			int y = (int)(Math.random() * 9 ) + 1;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("第["+questno +"]問 " + x+ "-"+y+"= ?");
				String line = reader.readLine();
				int result = Integer.parseInt(line);
					if(x-y==result) {
						System.out.println("正解");
					}else {
						System.out.println("不正解");
					return false;
					}		
					
			} catch (IOException e) {
				System.out.println(e);
			} catch (NumberFormatException e) {
				System.out.println("入力が正しくありません。");
			}
			return false;
		}
		
		//掛け算
		public static boolean showMultiplyQuestion(int questno) { 
			int x = (int)(Math.random() * 9 ) + 1;
			int y = (int)(Math.random() * 9 ) + 1;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					System.out.println("第[" + questno + "]問  " + x + "×" + y + "= ?");
					String line = reader.readLine();
					int result = Integer.parseInt(line);
						if(x * y ==result) {
							System.out.println("正解");
							return true;
						} else {
							System.out.println("不正解");
							return false;
						}
				} catch (IOException e) {
					System.out.println(e);
				} catch (NumberFormatException e) {
					System.out.println("入力が正しくありません。");
				}
					return false;
				}
		
		//割り算
		public static boolean showDividalQuestion(int questno) {
			int x =(int)(Math.random() * 9 ) + 1;
			int y =(int)(Math.random() * 9 ) + 1;	
			int a1, a2;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					System.out.println("第[" + questno + "]問  " + x + "÷" + y + "= ?");
					System.out.println("あまりは-で区切って入力してください");	
					System.out.println("記入例)１あまり２のときは1-2");
					String line = reader.readLine();
					String results[] = line.split("-"); //1-2という入力を(1,2)という形で返す。
					
					//あまりがある場合は上、割り切れる場合は０を代入
					if(results.length == 2) {
						a1 = Integer.parseInt(results[0]);
						a2 = Integer.parseInt(results[1]);	
					}else {
						a1 =  Integer.parseInt(results[0]);
						a2 = 0;
					}
					 if (x / y == a1 && x % y == a2) {	
						 System.out.println("正解");
						 return true;
					 } else {
						 System.out.println("不正解");
			                
			                
			         if (x % y > 0) { // 余りが含まれるときは答えをだす
			        	 System.out.println("答えは" + (x / y) + "あまり" + (x % y));                	
			         }
			                return false;
			            }
			        } catch (IOException e) {
			            System.out.println(e);
			        } catch (NumberFormatException e) {
			            System.out.println("入力が正しくありません。");
			        }
			        return false;
			    
			}
			
}	