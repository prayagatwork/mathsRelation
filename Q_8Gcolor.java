import java.util.*;
public class Q_8Gcolor{

    static class Edges{
        int src;
        int des;
        static int wt=1;

        public Edges(int s, int d){
            this.src=s;
            this.des=d;
        }
    }

    public static boolean bip(ArrayList<Edges> graph[]){
        int col[]=new int[graph.length];

        for(int i=0;i<graph.length;i++){
            col[i]= -1;
        }

        for(int i=0;i<graph.length;i++){

            if(col[i]==-1){
                if(bip_log(graph, col, i)){
                    return true;
                }
            }    
        }
        return false;
    }

    public static boolean bip_log(ArrayList<Edges> graph[], int col[], int cur){

        Queue<Integer> qu=new LinkedList<>();
        qu.add(cur);
        col[cur]=0; // yellow

        while(!qu.isEmpty()){

            int temp=qu.remove();

            for(int i=0;i<graph[temp].size();i++){
                Edges ter=graph[temp].get(i);

                // case-1
                // no color in neighour then assign contradict color
                if(col[ter.des]==-1){
                    int t_col= col[temp]==0?1:0;
                    col[ter.des]=t_col;
                    qu.add(ter.des);
                }

                // case-2
                // if color is asssigned 
                if(col[ter.des]==col[temp]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String args[]){
        int vertex=5;
        ArrayList<Edges> graph[]=new ArrayList[vertex];
        for(int i=0;i<vertex;i++){
            graph[i]=new ArrayList<>();
        }

        //0-vertex
        graph[0].add(new Edges(0,1));
        graph[0].add(new Edges(0,4));

        //1-vertex
        graph[1].add(new Edges(1,0));
        graph[1].add(new Edges(1,2));

        //2-vertex
        graph[2].add(new Edges(2,1));
        graph[2].add(new Edges(2,3));

        //3-vertex
        graph[3].add(new Edges(3,2));
        graph[3].add(new Edges(3,4));

        //4-vertex
        graph[4].add(new Edges(4,0));
        graph[4].add(new Edges(4,3));

        System.out.println(bip(graph));

}
}