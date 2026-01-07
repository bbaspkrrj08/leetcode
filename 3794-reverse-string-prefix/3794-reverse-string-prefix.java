class Solution{
public String reversePrefix(String s,int k){
    char[] a=s.toCharArray();
    int i=0,j=k-1;
    while(i<j){
        char t=a[i];
        a[i]=a[j];
        a[j]=t;
        i++;
        j--;
    }
        return new String(a);
        }
}
