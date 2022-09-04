import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
                      // Your code here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long []a=new long[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextLong();
		}
		long ans=inversioncount(a,0,n-1);
		System.out.println(ans);
	}
	static long inversionCount(long a[],int n){
		long count=0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[i]>a[j]){
					count++;
				}
			}
		}
		return count;
	}
	 static long inversioncount(long a[],int l,int r){
        long ans=0;
        if(l<r){
            int mid=l+(r-l)/2;
            ans+=inversioncount(a,l,mid);
            ans+=inversioncount(a,mid+1,r);
            ans+=merge(a,l,mid,r);
        }
        return ans;
    }
    static long merge(long a[],int l,int mid,int r){
        long inv=0;
        int n1=mid-l+1;
        int n2=r-mid;
        long []a1=new long[n1];
        long []b1=new long[n2];
        for(int i=0;i<n1;i++){
            a1[i]=a[l+i];
        }
        for(int j=0;j<n2;j++){
            b1[j]=a[j+mid+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
           if(a1[i]<=b1[j]){
               a[k]=a1[i];
               i++;
           }
           else{
               a[k]=b1[j];
               j++;
               inv+= n1-i;
           }
           k++;
        }
        while(i<n1){
            a[k]=a1[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=b1[j];
            j++;
            k++;
        }
        return inv;
    }
}