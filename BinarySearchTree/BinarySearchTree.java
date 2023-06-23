package BinarySearchTree;
import java.math.*;
import java.util.LinkedList;
import BinarySearchTree.bNode;

/*
*  Documentation at bottom of file for complex methods
*  Ctrl-f and search method name for detailed explanation
*  Methods:
*       insert      min     dfs successor
*       search      max     bfs
*/
public class BinarySearchTree {
    private bNode root;
    public int numNodes = 0;
    public void insert(int k){
        //case 1: root is null
        if(root == null ){
            root = new bNode(k);
            return;
        }
        bNode curr = root;
        bNode prev = null;
        //iterate left/right down tree until null
        while(curr != null){
            if( curr.key == k){
                System.out.println("Key to be inserted is duplicate. Operation aborted.");
                return;
            }
            else if( k < curr.key ){
                prev = curr;
                curr = curr.left;
            }
            else if( k > curr.key){
                prev = curr;
                curr = curr.right;
            }
        }
        if( k < prev.key)
            prev.left = new bNode(k);
        else if( k > prev.key)
            prev.right = new bNode(k);
    }
    public bNode search(int k){
        if( root == null ){
            System.out.println("Tree is empty");
            return null;
        }
        bNode curr = root;
        while(curr != null){
            if( k == curr.key){
                System.out.println("Found "  + k);
                return curr;
            }
            else if( k < curr.key){
                curr = curr.left;
            }
            else if( k > curr.key ){
                curr = curr.right;
            }
        }
        System.out.println(k + " not found");
        return null;
    }

    public void max(){
        if( root == null){
            System.out.println("Tree is empty");
            return;
        }
        bNode curr = root;
        while( curr.right != null){
            curr = curr.right;
        }
        System.out.println("Max is "+curr.key);
    }
    public void min(){
        if( root == null){
            System.out.println("Tree is empty");
            return;
        }
        bNode curr = root;
        while( curr.left != null){
            curr = curr.left;
        }
        System.out.println("Min is "+curr.key);
    }

    public void preorder(){
        bNode curr = root;
        pre(root);
        System.out.println();
    }
    private void pre(bNode curr){
        if( curr == null ) return;
        System.out.print(curr.key + " ");
        pre(curr.left);
        pre(curr.right);
    }
    public void inorder(){
        bNode curr = root;
        in(root);
        System.out.println();
    }
    private void in(bNode curr){
        if( curr == null ) return;
        in(curr.left);
        System.out.print(curr.key + " ");
        in(curr.right);
    }
    public void postorder(){
        bNode curr = root;
        post(root);
        System.out.println();
    }
    private void post(bNode curr){
        if( curr == null ) return;
        post(curr.left);
        post(curr.right);
        System.out.print(curr.key + " ");
    }
    public void bfs(){
        if( root == null ){
            System.out.println("Tree is empty");
            return;
        }
        bNode curr = root;
        LinkedList<bNode> queue = new LinkedList<>();
        queue.addFirst(curr);
        while( queue.size() > 0){
            curr = queue.getLast();
            if( curr.left != null )
                queue.addFirst(curr.left);
            if( curr.right != null)
                queue.addFirst(curr.right);
            queue.removeLast();
            System.out.print(curr.key +" ");
        }
        System.out.println();
    }
    public bNode successor(int k) throws NullPointerException{
        if( root == null ){
            System.out.println("Tree is empty");
            throw new NullPointerException("Tree is empty");
        }
        bNode curr = root;
        bNode leftTurn = null;
        // iterate to k
        while( curr != null){
            if( k == curr.key){
                break;
            }
            else if( k < curr.key){
                leftTurn = curr;
                curr = curr.left;
            }
            else if( k > curr.key){
                curr = curr.right;
            }
        }
        // if curr is null, then key does not exist
        if( curr == null){
            throw new NullPointerException("Key " + k + " does not exist");
        }
        // Case 1. Node is max of the tree
        if( curr.right == null && leftTurn == null){
            throw new NullPointerException("\n"+k + " is the maximum of the tree. Successor does not exist");
        }
        // Case 2. Successor is an ancestor. No right sub tree.
        if( curr.right == null && leftTurn != null){
            return leftTurn;
        }
        // Case 3. Successor is minimum of right sub tree
        curr = curr.right;
        while( curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    public bNode delete(int k) throws NullPointerException {
        bNode curr = root;
        bNode prev = null;
        if( root == null){
            throw new NullPointerException("Tree is empty");
        }
        while( curr != null){
            if( k == curr.key){
                break;
            }
            else if ( k < curr.key){
                prev = curr;
                curr = curr.left;
            }
            else if ( k > curr.key){
                prev = curr;
                curr = curr.right;
            }
        }
        // key doesn not exist
        if( curr == null){
            throw new NullPointerException("\n Key " + k + " does not exist");
        }
        // Case 1: Single node tree. return new node with key and set root to null
        if( curr.left == null && curr.right == null && prev == null){
            bNode result = new bNode(k);
            root = null;
            return result;
        }
        // Case 2: Node is a leaf
        if( curr.left == null && curr.right == null){
            if( k < prev.key )
                prev.left = null;
            else if( k > prev.key)
                prev.right = null;
            return new bNode(k);
        }
        // Case 3: Current node has a single child
        if( curr.left == null ^ curr.right == null){
            // save existing child node
            bNode child = null;
            if( curr.left == null )
                child = curr.right;
            else if( curr.right == null)
                child = curr.left;
            // Current node is the root node with a single child. Replace root with child
            if( prev == null ){
                root = child;
                return new bNode(k);
            }
            // Intermediate node has one child. Point the existing prev.child to curr.child
            else if(prev.left == curr ){
                prev.left = child;
                return new bNode(k);
            }
            else if( prev.right == curr){
                prev.right = child;
                return new bNode(k);
            }
        }
        // Case 4. Node has two children
        if( curr.left != null && curr.right != null){
            //replace curr with its successor
            bNode succ = curr.right;
            //track successor parent in case successor has a right sub tree
            bNode succParent = curr;
            while( succ.left != null){
                succParent  = succ;
                succ = succ.left;
            }
            //replace curr key with succ key (effectively deleting current node)
            curr.key = succ.key;
            //Perform single-child delete case on successor node
            if( succ == succParent.left){
                succParent.left = succ.right;
                return new bNode(k);
            }
            else if( succ == succParent.right){
                succParent.right = succ.right;
                return new bNode(k);
            }
        }
        return new bNode(k);
    }
}

/*
    [Insert]
    1) Check if tree empty
    2) Move left/right down the tree until curr hits null
    3) Replace prev left/right with key

    General Case: O(logn)
    Worst Case:   O(n) when inserted vals asc or desc
 */

/*
    [bfs]
    1) Add root to queue
    2) while queue not empty
        2.1) Dequeue
        2.2) Enqueue right and left if they are not null
 */

/*
    [successor] find the next largest value after int k (find next largest by 1 spot)
    Summary:
        "Sub tree" is the sub tree below int k
        The successor is
            A) the max of the right sub tree
            B) Or the next largest is the immediate ancestor
               Track leftTurn
    1) Search until k found (or not found)
    2) If int k the max val of the subtree, no successor
    3) If no right sub tree, successor is ancestor
    4) If right sub tree, then max of right sub tree
 */

/*
    [test data]
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8); bst.insert(4); bst.insert(2); bst.insert(1);
        bst.insert(3); bst.insert(6); bst.insert(5); bst.insert(7);
        bst.insert(12); bst.insert(10); bst.insert(9); bst.insert(11);
        bst.insert(14); bst.insert(13); bst.insert(15);

        for( int i = 0 ; i < 17; i ++){
            try{
                bNode res = bst.successor(i);
                System.out.print(res.key + " ");
            } catch( NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
 */


