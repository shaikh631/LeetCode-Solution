import com.sun.source.tree.BinaryTree;
import java.util.Scanner ;
public class Tree {

    private static class Node{
        int value ; 
        Node left ;
        Node right ;

        public Node(int value){
            this.value= value;
        }
    }
    private static  Node root ; 
      public static void populate(Scanner sc){
        System.out.println("Enter the root Node : ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);

      }
      public static void populate(Scanner sc , Node node){
        System.out.println("Do you want to enter left of "+node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the Value of the left of :"+ node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to enter right of "+ node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of :" + node.value);
            int value = sc.nextInt();
            node.right  =  new Node (value);
            populate(sc, node.right);
        }
      }

    //   Displaying 
    private static void Display(Node node , int level){
         if(node == null) return ;
         Display(node.left , level + 1);
         if(level != 0){
            for(int i = 0 ; i < level -1 ; i++){
                System.out.print("|\t");
            }
            System.out.println("|------>"+node.value);
         }
         else{
            System.out.println(node.value);
         }
         Display(node.right , level + 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        populate(sc);
        Display(root, 0);
    }
}
//   public class Main{
//         public static void main(String[] args) {
//             Scanner sc = new Scanner(System.in);
//             BinaryTree tree = new BinaryTree();
//             tree.populate(sc);
//         }
//     }
