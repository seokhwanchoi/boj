package 백준;

import java.io.*;
import java.util.*;
public class 나무자르기_2805{
    static int n,m;
    static long start,end,mid,sum,ans;
    static int[] dat;
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        start=0; end=-1; dat=new int[n];
        for(int i=0;i<n;++i) {
            dat[i]=Integer.parseInt(st.nextToken());
            if(end<dat[i]) end=dat[i];
        }
        ans=0;
        while(start<=end) {
            mid=(start+end)/2;
            sum=0;
            for(int i=0;i<n;++i) {
                if(dat[i]>mid)
                    sum+=(dat[i]-mid);
            }

            if(sum>=m) {
                if(ans<mid)
                    ans=mid;
                start=mid+1;//다음 중앙값을 더키운다
                //즉 sum이 더 작게 나오게
            }
            else {
                end=mid-1;
            }
        }
        System.out.println(ans);
    }
}
