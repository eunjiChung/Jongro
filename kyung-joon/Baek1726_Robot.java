import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-18.
 */
public class Baek1726_Robot {
    public static void main(String[] args) throws IOException {
        new Baek1726_Robot();
    }

    int N,M;
    int arr[][];
    RobotState startState, tempState, destState;
    PriorityQueue<RobotState> linkedList;
    final int RIGHT = 1;
    final int LEFT = 2;
    final int DOWN = 3;
    final int UP = 4;

    Baek1726_Robot() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        arr = new int[M+1][N+1];
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startState = new RobotState(Integer.valueOf(st.nextToken()),
                Integer.valueOf(st.nextToken()),
                Integer.valueOf(st.nextToken()),0);
        st = new StringTokenizer(br.readLine());
        destState = new RobotState(Integer.valueOf(st.nextToken()),
                Integer.valueOf(st.nextToken()),
                Integer.valueOf(st.nextToken()),0);

        bfs();
        System.out.println(tempState.orderNum);
    }

    void bfs() {
        linkedList = new PriorityQueue<>();
        linkedList.add(startState);
        while(!linkedList.isEmpty()) {
            RobotState cur = linkedList.poll();
            if(cur.m==destState.m && cur.n==destState.n) {
                setRotate(cur,destState.rotation);
                //if(tempState==null) tempState = cur; else if(tempState.orderNum > cur.orderNum)
                tempState = cur;
                break;
            }
            arr[cur.m][cur.n] = 1;
            goDown(new RobotState(cur.m,cur.n,cur.rotation,cur.orderNum));
            goRight(new RobotState(cur.m,cur.n,cur.rotation,cur.orderNum));
            goUp(new RobotState(cur.m,cur.n,cur.rotation,cur.orderNum));
            goLeft(new RobotState(cur.m,cur.n,cur.rotation,cur.orderNum));
        }
    }

    void setRotate(RobotState cur, int destRotation) {
        if(cur.rotation == destRotation) return;
        else if(cur.rotation == UP && destRotation == DOWN) cur.orderNum+=2;
        else if(cur.rotation == DOWN && destRotation == UP) cur.orderNum+=2;
        else if(cur.rotation == RIGHT && destRotation == LEFT) cur.orderNum+=2;
        else if(cur.rotation == LEFT && destRotation == RIGHT) cur.orderNum+=2;
        else cur.orderNum+=1;
        cur.rotation = destRotation;
    }

    void goDown(RobotState cur) {
        if(cur.m+1<=M && arr[cur.m +1][cur.n] == 0) {
            setRotate(cur, DOWN);
            linkedList.add(new RobotState(cur.m +1,cur.n,DOWN,cur.orderNum+1));
            if(cur.m+2<=M && arr[cur.m +2][cur.n] == 0) {
                linkedList.add(new RobotState(cur.m +2,cur.n,DOWN,cur.orderNum+1));
                if(cur.m +3<=M && arr[cur.m +3][cur.n] == 0) linkedList.add(new RobotState(cur.m +3,cur.n,DOWN,cur.orderNum+1));
            }
        }
    }
    void goRight(RobotState cur) {
        if(cur.n+1<=N && arr[cur.m][cur.n+1] == 0) {
            setRotate(cur,RIGHT);
            linkedList.add(new RobotState(cur.m,cur.n +1,RIGHT,cur.orderNum+1));
            if(cur.n +2<=N && arr[cur.m][cur.n +2] == 0) {
                linkedList.add(new RobotState(cur.m,cur.n +2,RIGHT,cur.orderNum+1));
                if(cur.n +3<=N && arr[cur.m][cur.n +3] == 0) linkedList.add(new RobotState(cur.m,cur.n +3,RIGHT,cur.orderNum+1));
            }
        }
    }
    void goUp(RobotState cur) {
        if(cur.m -1>0 && arr[cur.m -1][cur.n] == 0) {
            setRotate(cur,UP);
            linkedList.add(new RobotState(cur.m -1,cur.n,UP,cur.orderNum+1));
            if(cur.m -2>0 && arr[cur.m -2][cur.n] == 0) {
                linkedList.add(new RobotState(cur.m -2,cur.n,UP,cur.orderNum+1));
                if(cur.m -3>0 && arr[cur.m -3][cur.n] == 0) linkedList.add(new RobotState(cur.m -3,cur.n,UP,cur.orderNum+1));
            }
        }
    }
    void goLeft(RobotState cur) {
        if(cur.n -1>0 && arr[cur.m][cur.n -1] == 0) {
            setRotate(cur,LEFT);
            linkedList.add(new RobotState(cur.m,cur.n -1,LEFT,cur.orderNum+1));
            if(cur.n -2>0 && arr[cur.m][cur.n -2] == 0) {
                linkedList.add(new RobotState(cur.m,cur.n -2,LEFT,cur.orderNum+1));
                if(cur.n -3>0 && arr[cur.m][cur.n -3] == 0) linkedList.add(new RobotState(cur.m,cur.n -3,LEFT,cur.orderNum+1));
            }
        }
    }

    class RobotState implements Comparable<RobotState> {
        int m, n, rotation, orderNum;
        RobotState(int m, int n, int rotation, int orderNum) {
            this.m = m;
            this.n = n;
            this.rotation = rotation;
            this.orderNum = orderNum;
        }

        @Override
        public int compareTo(RobotState o) {
            return this.orderNum - o.orderNum;
        }
    }
}
