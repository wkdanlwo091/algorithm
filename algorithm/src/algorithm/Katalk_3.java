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
			
			
			//Ű�� �Ѱ��� ������ ���� ����
			if(keyHole == 0) {
				return false;
			}
			
			
			
			if(keyLen < lockLen) {
				//���� üũ 

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
					
				}else {//���� ��� �˻�
					
					int temp = 1;//temp�� 1�̸� ���� ���� �� 
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
												
											}else {//�� Ȧ�� �ƴ� �� ����
												temp = 0;// �й�
											}
										}
										
									}
								}
								if(temp == 1) {//�¸� 
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

				if(keyHole == lockHole) {//���� ���� 
					return true;
				}else {
					
				}
				
			}
			
			
			
			//��90�� 0
			//��90�� 1
			//���� �̵� 2
			//���� �̵� 3
			//�� �̵� 4
			//�� �̵� 5
			if(state != 0) {
				int[][] newKey = new int[keyLen][keyLen];

				
				//�� 90��
				
				for(int i = 0 ;i<keyLen;i++) {
					for(int j = 0;j < keyLen;j++) {
						newKey[i][j] =  key[keyLen-1-j][i];
					}
				}
				
				if(dfs(0,newKey, lock) == true) {
					return true;
				}
			}
			
			//�� 90�� 
			
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
			

			
			
			//������ ��ĭ
			
			if(state != 2) {
				
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 0) {
							newKey[j][i] = 0;//�� ������ ������ĭ
						}else {
							newKey[j][i] = key[j][i-1];
						}
					}
				}
				
				
				if(dfs(2,newKey, lock) == true) {
					return true;
				}

				
			}


			//���� ��ĭ
			
			if(state != 3) {
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 2) {
							newKey[j][i] = 0;//�� ������ ������ĭ
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
				//���� ��ĭ
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 2) {
							newKey[i][j] = 0;//�� ������ ������ĭ
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
				//�Ʒ��� ��ĭ 
				int [][] newKey = new int[keyLen][keyLen];

				for(int i= 0;i < keyLen;i++) {
					for(int j = 0; j< keyLen;j++) {
						if(i == 0) {
							newKey[i][j] = 0;//�� ������ ������ĭ
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