package algorithm;

public class Katalk_3 {
		
		
		public boolean dfs(int state, int[][] key, int[][] lock) {
			
			
			int keyLen = key.length;
			int lockLen = lock.length;
			int lockHole = 0;
			int keyHole = 0;
			
			
			for(int i = 0 ;i< keyLen;i++) {
				for(int j = 0 ;j < keyLen ;j++) {
					if(key[i][j] == 1) {
						keyHole++;
					}
				}
			}
			
			
			//키가 한개도 없으면 종료 조건
			if(keyHole == 0) {
				return false;
			}
			
			
			
			if(keyLen < lockLen) {
				//열쇠 체크 

				for(int i = 0;i<lockLen;i++) {
					for(int j = 0 ;j< lockLen;j++) {
						if(lock[i][j] == 0) {
							lockHole++;
						}
					}
				}
				
				for(int i = 0;i<keyLen;i++) {
					for(int j = 0 ;j< keyLen;j++) {
						if(key[i][j] == 1) {
							keyHole++;
						}
					}
				}
				
				if(lockHole != keyHole) {
					
				}else {//같을 경우 검사
					
					int temp = 1;//temp가 1이면 아직 승패 모름 
					int success = 0;
					
					for(int i = 0;i < lockLen ; i++) {
						
						if(i+ keyLen  > lockLen) {
							continue;
						}
							
						for(int j = 0 ;j < lockLen  ; j++) {
							
							if(j+ keyLen  > lockLen) {
								continue;
							}else {
								
								for(int k = 0; k <keyLen ;k++) {
									
									for(int l = 0; l < keyLen ; l++) {
										
										if(key[k][l] == 1 ) {
											
											if(lock[i+k][j+l] == 0) {
												
											}else {//락 홀이 아닐 떄 종료
												temp = 0;// 패배
											}
										}
										
									}
								}
								if(temp == 1) {//승리 
									return true;
								}else {
									temp = 1;
								}
								
								
								
							}
							
						}
					}
					
				}
				
				
				
			}else {
				
				for(int i = 0 ;i < lockLen;i++) {
					for(int j = 0 ;j < lockLen;j++) {
						if(lock[i][j] == 0) {
							lockHole++;
							if(key[i][j] == 1) {
								keyHole++;
							}else {
								keyHole = -9999;
							}
						}
					}
				}

				if(keyHole == lockHole) {//조기 종료 
					return true;
				}else {
					
				}
				
			}
			
			
			
			//우90도 0
			//좌90도 1
			//우측 이동 2
			//좌측 이동 3
			//상 이동 4
			//하 이동 5
			if(state != 0) {
				int[][] newKey = new int[keyLen][keyLen];

				
				//우 90도
				
				for(int i = 0 ;i<keyLen;i++) {
					for(int j = 0;j < keyLen;j++) {
						newKey[i][j] =  key[keyLen-1-j][i];
					}
				}
				
				if(dfs(0,newKey, lock) == true) {
					return true;
				}
			}
			
			//좌 90도 
			
			if(state != 1) {
				int[][] newKey = new int[keyLen][keyLen];

				for(int i = 0 ;i<keyLen;i++) {
					
					for(int j = 0;j < keyLen;j++) {
						newKey[i][j] =  key[j][keyLen-1-i];
					}
					
				}
				
				if(dfs(1,newKey, lock) == true) {
					return true;
				}
			}
			

			
			
			//오른쪽 한칸
			
			if(state != 2) {
				
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 0) {
							newKey[j][i] = 0;//맨 좌측에 생긴한칸
						}else {
							newKey[j][i] = key[j][i-1];
						}
					}
				}
				
				
				if(dfs(2,newKey, lock) == true) {
					return true;
				}

				
			}


			//왼쪽 한칸
			
			if(state != 3) {
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 2) {
							newKey[j][i] = 0;//맨 좌측에 생긴한칸
						}else {
							newKey[j][i] = key[j][i+1];
						}
					}
				}
				
				
				if(dfs(3,newKey, lock) == true) {
					return true;
				}

			}
			

			if(state != 4) {
				//위쪽 한칸
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 2) {
							newKey[i][j] = 0;//맨 좌측에 생긴한칸
						}else {
							newKey[i][j] = key[i+1][j];
						}
					}
				}
				
				
				if(dfs(4, newKey, lock) == true) {
					return true;
				}

			}
			

			if(state != 5) {
				//아래쪽 한칸 
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 0) {
							newKey[i][j] = 0;//맨 좌측에 생긴한칸
						}else {
							newKey[i][j] = key[i-1][j];
						}
					}
				}
				
				
				if(dfs(5, newKey, lock) == true) {
					return true;
				}

			}

			
			return false;
			
		}
	
	    public boolean solution(int[][] key, int[][] lock) {
	        boolean answer = true;
	        
	       
	        
	        return  dfs(-1, key, lock);
	    }
	public static void main(String[] args) {
		Katalk_3 katalk_3 = new Katalk_3();
		
		int [][] temp = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int [][] temp2 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(katalk_3.solution( temp, temp2));
	}
}
