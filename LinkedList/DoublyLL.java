public class DoublyLL { 

    private Node head;
    private int size;

    public DoublyLL(){      //constructor for the size of LL
        this.size = 0;
    }

    public void insertfirst(int val){
        Node node = new Node(val);
        node.next=head;       //pointing the new node next to current head
        node.prev= null;      //and new node prev to null
        if(head!=null){        //checking if head is not null then prev of head assigned to new node 
            head.prev=node;
        }
        head = node;    //head is reassigned to the new node
        }
//--------------------------------------------------------------

    public void insertatIndex(int val,int index){     //insert at any given index
        if(index == 0){
            insertfirst(val);
            return;

        }
        if(index == size){
            insertlast(val);
            return;
        }

        Node temp = head;
        for(int i = 1;i<index;i++){            //this will check till the index we need to insert element
            temp = temp.next;        
        }
        Node node = new Node(val,temp.next,temp);
        temp.next = node;
        temp.next.prev = node;            //When inserting in the middle, you must update four links (prev and next on both sides), not just one.
        size++ ;     
    }
//----------------------------------------------------------------------
    //This method searches for a node containing the given value.
    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.val==value){ //If the current node contains the required value, return that node itself.
                return node;
            }
            node = node.next;
        }
         return null;   //If the value isn't found, return null.
    }

    public void insertafter(int after,int val){
        Node p = find(after);   //Find the node containing after and store its reference in p.
        if(p == null){       //If 89 doesn't exist, stop the method.
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);  
        node.next = p.next;    //Connect new node to the next node
        p.next = node;     //Connect p to new node
        node.prev = p;      //Connect new node backward
        if(node.next != null){  //if theres exist a element after insertion
            node.next.prev = node;   //Fix the old next node's(node.next) --> prev(previous) 
        }
    }
//----------------------------------------------------------------------
    public void insertlast(int val){
        Node node = new Node(val);
        Node last  = head;

        node.next = null;

        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while(last.next != null){
           last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

//---------------------------------------------------------------
        public void display(){
            Node node = head;   //1st node
            Node last = null;   //last node
            while(node!=null){      //print forward
                System.out.print(node.val+ "->");
                last = node;  //Storeing the current node in last since node is now null, but last is pointing to 30.
                node = node.next;
            }
            System.out.println("END");

       //print reverse
            while(last!=null){
                System.out.print(last.val + "->");
                last =last.prev;
            }
            System.out.println("END");
        }


//------------------------------------------------------------

    
    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(int val,Node next,Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

//-------------------------------------------------
     public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertfirst(3);
        list.insertfirst(30);
        list.insertfirst(67);
        list.insertfirst(89);
        list.insertfirst(9);
        list.insertlast(66);
        list.insertatIndex(77, 3);
        list.insertafter(89, 6);

        list.display();
     }
    
}
