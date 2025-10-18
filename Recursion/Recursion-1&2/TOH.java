class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
      
        if (n == 1) {
            return 1;  
        }

        int moves = towerOfHanoi(n - 1, from, aux, to);
        moves += 1;
        moves += towerOfHanoi(n - 1, aux, to, from);

        return moves;
    }
}