package algorithm;

public class Katalk_1 {

	
	
	public int solution(String s) {
		int answer = 0;
		
		int temp = 0;
		for(int i =1 ;i< s.length()/2;i++) {// i개로 자르기 
			temp = 0;// 잘라서 나온 길이
			for(int j = 0 ;j < s.length(); ) {//j 기준으로 비교하기
				int temp2 = 0;//덩어리당 더한 갯수  ---> aaa 
				for(int k = j ; k < s.length(); k++) {// 
					if(k+i <=s.length()) {//비교대상이 index안에 있을 때
						if(s.substring(j, j+i).equals(s.substring(k, k+i))) {
							temp2++;//자신부터 검사  i = 2 aaaa이면 temp는 2
							if(k == s.length()-1) {
								if(temp2 > 1)//aaaa면       
									temp = temp + 1 + i;//2aa의 길이 3 
								else if(temp2 == 1)//aa면
									temp = temp + i;// aa의 길이는 2 
								j = k;
								break;
							} 

						}else {// ex) ab면 a와 b가 다른 상태

							if(temp2 > 1)//aaaa면       
								temp = temp + 1 + i;//2aa의 길이 3 
							else if(temp2 == 1)//aa면
								temp = temp + i;// aa의 길이는 2 
							
							//기준점을 b로 잡는다.
							
							j = k;//b부터 다시 조사
							break;
						}
					}else {//index가 벗어났을 때  ex) i = 3 aa이면
						temp = s.length()- j; //j부터 끝까지 
					}
				}
				
			}
			if(temp < answer) {
				System.out.println(answer);
				answer = temp;
			}
		}
			
	    return answer;
	}

	public static void main(String[] args) {
		Katalk_1 a  =new Katalk_1();
		System.out.println(a.solution("aabbaccc"));
	}
}
