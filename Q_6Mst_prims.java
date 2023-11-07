import java.util.*;
public class Q_6Mst_prims{

    static class Edges{
        int src;
        int des;
        int wt;

        public Edges(int s, int d, int w){
            this.src=s;
            this.des=d;
            this.wt=w;
        }
    }

    static class Pairs implements Comparable<Pairs>{
        int v;
        int cost;

        public Pairs(int v, int c){
            this.v=v;
            this.cost=c;
        }

        @Override
        public int compareTo(Pairs p2){
            return this.cost-p2.cost;
        }
    }

    public static void prims(ArrayList<Edges> graph[]){

        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pairs> pq=new PriorityQueue<>();
        pq.add(new Pairs(0,0));

        int final_cost=0;

        while(!pq.isEmpty()){

            Pairs temp=pq.remove();

            if(vis[temp.v]!=true){

                vis[temp.v]=true;
                final_cost+=temp.cost;

                for(int i=0;i<graph[temp.v].size();i++){
                    Edges ter=graph[temp.v].get(i);

                    pq.add(new Pairs(ter.des, ter.wt));
                }
            }
        }

        System.out.println("the cost is : "+ final_cost);
    }

    public static void main(String args[]){

        int vertex=4;
        ArrayList<Edges> graph[]=new ArrayList[vertex];
        for(int i=0;i<vertex;i++){
            graph[i]=new ArrayList();
        }

        graph[0].add(new Edges(0,1,10));
        graph[0].add(new Edges(0,2,15));
        graph[0].add(new Edges(0,3,30));

        graph[1].add(new Edges(1,0,10));
        graph[1].add(new Edges(1,3,40));

        graph[2].add(new Edges(2,0,15));
        graph[2].add(new Edges(2,3,50));

        graph[3].add(new Edges(3,0,30));
        graph[3].add(new Edges(3,1,40));
        graph[3].add(new Edges(3,2,50));

        prims(graph);
}
}