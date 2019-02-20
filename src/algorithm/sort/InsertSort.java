package algorithm.sort;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/22 15:09
 */

/**
 * 插入排序
 * 基本逻辑：
 *      遍历数组，遍历到i的时候，0-i-1之间的数据都是已经排好序的
 *      第i个元素与前面的每个元素一次比较确定其位置，然后插入
 * 复杂度是O(n^2)
 * 是稳定的排序算法
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] a=new int[]{1,4,5,11,2,1,3,4,54,6};
        a=insertSortDesc(a);
        for (int aa:a)
            System.out.println(aa);
        a=inserSortAsc(a);
        for (int aa:a)
            System.out.println(aa);
    }
    //降序排序
    public static int[] insertSortDesc(int [] a){
        int i,j,v;
        for (i=0;i<a.length;i++){
            for (j=i-1,v=a[i];j>=0 && v>a[j];j--){
                a[j+1]=a[j];
            }
            a[j+1]=v;
        }
        return a;
    }
    //升序排序
    public static int[] inserSortAsc(int[] a){
        int i,j,v;
        for(i=0;i<a.length;i++){
            for (j=i-1,v=a[i];j>=0&& a[j]>v;j--){
                a[j+1]=a[j];
            }
            a[j+1]=v;
        }
        return a;
    }
}
