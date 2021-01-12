package com.mycompany.graph_drawing;

import static com.mycompany.graph_drawing.eadges.checkofdeletednode;
import static com.mycompany.graph_drawing.eadges.checkofnode;
import static com.mycompany.graph_drawing.graph.nodenumber;
import static com.mycompany.graph_drawing.graph.adj_graph;
import java.util.Scanner;


public class nodeee implements nodee
{
    //public int[][] adj_graph = new int[1000][1000];
    
      
     
       
        
  @Override
   public void add_node()
    {
         Scanner input = new Scanner(System.in);
        int node_value=input.nextInt();
        
        
        
        if (checkofnode[node_value - 2] == false)
        {
            System.out.println("The node before this node isn't created yet!! ");
        }
        else if(checkofnode[node_value-1]==false)
        {
            if (checkofdeletednode[node_value - 1] == true)
            {
                checkofnode[node_value - 1] = true;
                checkofdeletednode[node_value - 1] = false;
                for(int i=0;i<nodenumber;i++)
                {
                    adj_graph [i][node_value - 1] = 0;
                    adj_graph [node_value - 1][i] = 0;
                }
            }
            else
            {
                nodenumber++;
                checkofnode[node_value - 1] = true;
            }
        }
        else
        {
            System.out.println("this node is created before");
        }
    }
         public void popnode()
         {
              Scanner input = new Scanner(System.in);
        int deletednode;
        deletednode=input.nextInt();
        deletednode--;
        checkofnode[deletednode] = false;
        checkofdeletednode[deletednode] = true;
        for(int i=0;i<nodenumber;i++)
        {
            adj_graph [i][deletednode]=-1;
            adj_graph [deletednode][i]=-1;
        }
         }
}
