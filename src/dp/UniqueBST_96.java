package dp;

/**
 * Created by sisyphuspan on 16/4/15.
 */
public class UniqueBST_96 {
    /*
   计算n个节点的二叉搜索树的个数: 卡特兰数
   f(n+1) = sigma{f(i)*f(n-i)}
   含义: 左边 i 个节点, 右边 n-i 个节点, 根节点就固定了(根节点为第 i+1 大的数).
     */
    public int numTrees(int n) {
        int count[] = new int[n+1];
        count[0] = count[1] = 1;
        for(int i=2; i<=n; i++) {
            for (int left=0; left < i; left++) {
                count[i] += count[left] + count[i-1-left];
            }
        }
        return count[n];
    }

}
