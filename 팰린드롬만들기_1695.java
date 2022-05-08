package 백준;

import java.io.*;
import java.util.*;

public class 팰린드롬만들기_1695 {
	static int n,dat[],dp[][];
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine().trim());
		st=new StringTokenizer(br.readLine());
		
		dat=new int[n+2];
		dp=new int[n+2][n+2];
		for(int i=0;i<n;++i) {
			dat[i]=Integer.parseInt(st.nextToken());
			for(int j=0;j<n;++j) {
				dp[i][j]=-1;
			}
		}
		
		for(int i=0;i<n-1;++i) {
			for(int j=i+1;j<n;++j) {
				solve(i,j);
			}
		}
		
		System.out.println(dp[0][n-1]);
	}
	static int solve(int x, int y) {
		if(dp[x][y] != -1) return dp[x][y];
		if(x>=y) {
			dp[x][y]=0;
			return dp[x][y];
		}
		
		if(dat[x]==dat[y]) dp[x][y]=solve(x+1,y-1);
		else 
			dp[x][y]=Math.min(solve(x,y-1), solve(x+1,y))+1;
		
		return dp[x][y];
	}
}
