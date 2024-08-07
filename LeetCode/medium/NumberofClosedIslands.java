package LeetCode.medium;

import java.util.LinkedList;

//1254. Number of Closed Islands

public class NumberofClosedIslands {

    public int closedIsland(int[][] grid) {

        LinkedList<Node> al = new LinkedList<>();

        int r = grid.length;
        int c = grid[0].length;


        int islands = 0;

        for(int i= 0; i<r-1; i++) {
            for(int j=0; j<c-1; j++) {

                if(grid[i][j]==0){
                    if(markAll(grid, r, c, new Node(i,j)))
                        islands++;
                }
            }
        }

        return islands;
    }

    public boolean markAll(int[][] grid, int r, int c, Node nd) {
        boolean flag = true;
        LinkedList<Node> al = new LinkedList<>();
        al.add(nd);
        while(al.size() > 0) {

            Node node = al.remove();

            grid[node.x][node.y] = 2;

            if(node.x == 0 || node.x==r-1 || node.y==0 || node.y==c-1)
                flag = false;


            if((node.x + 1) < r) {
                if(grid[node.x+1][node.y]==0)
                    al.add(new Node(node.x+1, node.y));
            }

            if((node.x - 1) >= 0) {
                if(grid[node.x-1][node.y]==0)
                    al.add(new Node(node.x-1, node.y));
            }

            if((node.y + 1) < c) {
                if(grid[node.x][node.y+1]==0)
                    al.add(new Node(node.x, node.y+1));
            }

            if((node.y - 1) >= 0) {
                if(grid[node.x][node.y-1]==0)
                    al.add(new Node(node.x, node.y-1));
            }

        }

        return flag;
    }

    class Node{
        public int x;
        public int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
