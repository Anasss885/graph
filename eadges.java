package com.mycompany.graph_drawing;
import java.util.Scanner;
 public class eadges extends graph
{
    public int weight, eadges_num, firstnode, secondnode;
    public static boolean checkofnode[]=new boolean [1000];
    public static boolean checkofdeletednode[]=new boolean [1000];
// ------------------    this is constructor
    public eadges(int node_num, int eadges_num)
    {
        super(node_num, eadges_num);
        this.eadges_num = eadges_num;
        for(int i=0;i<nodenumber;i++)
        {
            checkofnode[i]=false;
        }
        for(int i=0;i<nodenumber;i++)
        {
            checkofdeletednode[i]=false;
        }
    }

//    public int getWeight() { return weight; }
//
//    public void setWeight(int weight) {this.weight = weight;}
//
//    public int getEadges_num() {return eadges_num;}
//
//    public void setEadges_num(int eadges_num) {this.eadges_num = eadges_num;}
//
//    public int getFirstnode() { return firstnode;}
//
//    public void setFirstnode(int firstnode) { this.firstnode = firstnode; }
//
//    public int getSecondnode() { return secondnode; }
//
//    public void setSecondnode(int secondnode) { this.secondnode = secondnode;}
// --------------------  to take input of all edges
    
    public void input(int eadges_num)
    {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < eadges_num; i++)
        {
            System.out.println("enter the first node, second node and weight ");
            firstnode = input.nextInt();
            secondnode = input.nextInt();
            checkofnode[firstnode-1]=true;
            checkofnode[secondnode-1]=true;
            weight = input.nextInt();
            adj_graph[firstnode - 1][secondnode - 1] = weight;
        }
    }
// ------------------------------ Add Edge ------------------------------------------------
    public void add_edge() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the first node, second node and weight ");
        firstnode = input.nextInt();
        secondnode = input.nextInt();
        weight = input.nextInt();
        if (checkofnode[firstnode - 1] == true && checkofnode[secondnode - 1] == true)
        {
            adj_graph[firstnode - 1][secondnode - 1] = weight;
        }
        else
        {
            System.out.println("Those nodes aren't created or deleted!!");
        }
    }
    // ------------------------------ Delete_Edge ---------------------------------------------------------
    public void Delete_Edge()
    {
        System.out.println("enter the first node, second node ");
        Scanner input = new Scanner(System.in);
        firstnode=input.nextInt();
        secondnode = input.nextInt();
        firstnode--;
        secondnode--;
        adj_graph [firstnode][secondnode]=-1;
    }
    // -------------------------------- Delete Node  --------------------------------------------------
//    public void popnode()
//    {
//        Scanner input = new Scanner(System.in);
//        int deletednode;
//        deletednode=input.nextInt();
//        deletednode--;
//        checkofnode[deletednode] = false;
//        checkofdeletednode[deletednode] = true;
//        for(int i=0;i<nodenumber;i++)
//        {
//            adj_graph [i][deletednode]=-1;
//            adj_graph [deletednode][i]=-1;
//        }
//    }
    // ------------------------------- Add node ----------------------------------------------------
//    public void add_node(int node_value)
//    {
//        if (checkofnode[node_value - 2] == false)
//        {
//            System.out.println("The node before this node isn't created yet!! ");
//        }
//        else if(checkofnode[node_value-1]==false)
//        {
//            if (checkofdeletednode[node_value - 1] == true)
//            {
//                checkofnode[node_value - 1] = true;
//                checkofdeletednode[node_value - 1] = false;
//                for(int i=0;i<nodenumber;i++)
//                {
//                    adj_graph [i][node_value - 1] = 0;
//                    adj_graph [node_value - 1][i] = 0;
//                }
//            }
//            else
//            {
//                nodenumber++;
//                checkofnode[node_value - 1] = true;
//            }
//        }
//        else
//        {
//            System.out.println("this node is created before");
//        }
//    }
    // ---------------------------- Displaymatrix ---------------------------------------------------
   
//    public void displaymatrix()
//    {
//        System.out.println(nodenumber);
//        for (int i=0;i<nodenumber;i++)
//        {
//            for (int j=0;j<nodenumber;j++)
//            {
//                System.out.print(adj_graph[i][j]+"  ");
//            }
//            System.out.println(" ");
//        }
//    }
// ----------------------- showChildren --------------------------
     //@Override
public void showchildren()
{
    Scanner input = new Scanner(System.in);
    System.out.println("Enter node value to show its childrens.");
    int node = input.nextInt();
    if (checkofnode[node - 1] == true && checkofdeletednode[node - 1] == false)
    {
        for (int i = 0; i < nodenumber; i++)
        {
            if (adj_graph[node - 1][i] > 0)
            {
                System.out.println((i + 1) + " ");
            }
        }
    }
    else
    {
        System.out.println("This node isn't created or deleted!!");
    }
}
}