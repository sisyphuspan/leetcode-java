package DynamicProgramming;

import java.util.Stack;

/**
 * Created by sisyphuspan on 2016/4/26.
 */
public class HMMViterbi {
    public static void main(String[] args) {
        double[][] A = {{0.5, 0.2, 0.3}, {0.3, 0.5, 0.2}, {0.2, 0.3, 0.5}};
        double[][] B = {{0.5, 0.5}, {0.4, 0.6}, {0.7, 0.3}};
        double[] pi = {0.2, 0.4, 0.4};

        int[] O = {0, 1, 0};

       double max = viterbi(A, B, pi, O);

        System.out.println("max prob: " + max);
    }

    /**
     *
     * @param A: 状态转移矩阵
     * @param B: 状态 --> 观测 矩阵
     * @param pi: 初始状态概率分布
     * @param O: 观测序列
     * @return
     *
     *   根据 HMM 和 观测序列， 求最大概率中间隐层序列
     */
    public static double viterbi(double[][] A, double[][] B, double[] pi, int[] O) {
        double[][] prob = new double[O.length][A.length];
        int[][] path = new int[O.length-1][A.length];
        for(int i=0; i<A.length; i++) {
            prob[0][i] = pi[i] * B[i][0];
        }

        for(int i=1; i<O.length; i++) { // 每一步
            for(int j=0; j<A.length; j++) { // 每个状态
                double max = Double.MIN_VALUE;
                int last = -1;
                for(int k=0; k<A.length; k++) { // 其它状态到 j 状态的概率
                    double p = prob[i-1][k] * A[k][j] * B[j][O[i]];
                    if( p > max) {
                        max = p;
                        last = k;
                    }

                }
                prob[i][j] = max;
                path[i-1][j] = last;
            }
        }

        double max = Double.MIN_VALUE;
        int maxNode = -1;
        for(int i=0; i<A.length; i++) {
            if( prob[O.length-1][i] > max) {
                max = prob[O.length - 1][i];
                maxNode = i;
            }
        }

        Stack<Integer> maxPath = new Stack<Integer>();
        maxPath.push(maxNode);
        int step = O.length -2;
        int last = maxNode;
        while(step >=0) {
            maxPath.push(path[step][last]);
            last = path[step][last];
            step--;
        }

        System.out.print("max prob path: ");
        while(maxPath.size() > 1) {
            System.out.print(maxPath.pop()+1 + " --> ");
        }
        System.out.print(maxPath.pop()+1 + "\n");
        return max;
    }
}
