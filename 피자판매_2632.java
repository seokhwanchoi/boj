import java.io.*;
import java.util.*;

public class Main{
	
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stz;
	static int want,n,m,a,b,sum;
	static int[] aSlice,bSlice,aList,bList;
	
	public static void main(String[] args) throws IOException {
		want=Integer.parseInt(bf.readLine());
		stz=new StringTokenizer(bf.readLine());
		n=Integer.parseInt(stz.nextToken());
		m=Integer.parseInt(stz.nextToken());
		aSlice=new int[n];bSlice=new int[m];
		
		for(int i=0;i<n;i++) {
			aSlice[i]=Integer.parseInt(bf.readLine());
			a+=aSlice[i];
		}
		aList=new int[a+1];
		aList[0]=1;
		aList[a]=1;
		for(int i=0;i<m;i++) {
			bSlice[i]=Integer.parseInt(bf.readLine());
			b+=bSlice[i];
		}
		bList=new int[b+1];
		bList[0]=1;
		bList[b]=1;
		for(int i=0;i<n;i++) {
			sum=0;
			for(int j=i;(i+n-1)%n!=j;j=(j+1)%n) {
				sum+=aSlice[j];
				aList[sum]++;
			}
		}
		for(int i=0;i<m;i++) {
			sum=0;
			for(int j=i;(i+m-1)%m!=j;j=(j+1)%m) {
				sum+=bSlice[j];
				bList[sum]++;
			}
		}
		int result=0;
		for(int i=0;i<aList.length;i++) {
			if(want-i<0) break;
			if(want-i>=bList.length) continue;
			result+=aList[i]*bList[want-i];
		}
		System.out.println(result);

	}

}
