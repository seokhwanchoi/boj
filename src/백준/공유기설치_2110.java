package 백준;

// 27496KB	252ms

import java.io.*;
import java.util.*;
public class 공유기설치_2110 {
	static int N,C,house[];
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		house = new int[N];
		
		for(int i=0;i<N;++i)
			house[i]= Integer.parseInt(br.readLine());
		
		Arrays.sort(house);
		
		int start = 1;
		int end = house[N-1]-house[0]+1;
		
		while(start<end) {
			int mid = (start + end)/2;
			
			if(solve(mid)<C)
				end = mid;
			else
				start = mid + 1;
		}
		
		System.out.println(start -1);
	
	}
	static int solve(int dist) {
		int cnt = 1;
		int last = house[0];
		
		for(int i=1;i<house.length;++i) {
			int curr = house[i];
			
			if(curr-last >= dist) {
				cnt++;
				last=curr;
				
			}
		}
		return cnt;
	}
}
