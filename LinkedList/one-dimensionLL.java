public class LL {
    //initialization part
    private Node head;
    private Node tail;

    private int size;

    public LL(){      //constructor for the size of LL
        this.size = 0;
    }
//--------------------------------------------------------------------------------------
    public void insertfirst(int val){       //inserting from first 
        Node node = new Node(val);
        node.next = head;                 
        head = node;

        if(tail==null){                //if theres only one element
            tail = head;
        }
         
        size += 1;
    }
//-------------------------------------------------------------------------------------------

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
        Node node = new Node(val,temp.next);
        temp.next = node;            
        size++ ;     
    }
//--------------------------------------------------------------------------------------------------------

    public void insertlast(int val){         //inserting at the last in O(1) TC
        if(tail ==null){                      //benefit of taking an extra node tail 
            insertfirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next=node;
        tail = node;
        size++;

    }
//------------------------------------------------------------------------------------------
 public int deletefirst(){            //deleting from first 
    int val = head.value;
    head = head.next;
    if(head == null){
        tail = null;
    }
    size--;
    return val;
 }
//-----------------------------------------------
public int deletelast(){            //deleting from last
    if(size<=1){                  //if it's the first element
        return deletefirst();
    }
    Node secondlast = get(size-2);    //getting the second last digit so that the new element is inserted
    int val = tail.value;
    tail=secondlast;            //here we have to assign tail to the secondlast element so that the last digit doesn't appear on the LL
    tail.next = null;
    return val;
}

public Node get(int index){       //taking the reference or index of the node where element is to be inserted
    Node node = head;
    for(int i = 0;i<index;i++){
        node = node.next;
    }
    return node;

}
//--------------------------------------------------------------------------

public int delete(int index){         //deleting nth index 
    if(index==0){
        return deletefirst();
    }
    if(index==size-1){
        return deletelast();
    }

    Node prev = get(index-1);
    int value = prev.next.value;
    prev.next = prev.next.next;
    return value;  
}
//------------------------------------------------------------------------------------------

    //display the LL
    public void display(){
        Node temp = head;   //temp is pointing to head changing the temp will not change the head 
        //here we are jst reassigning the temp node to display the whole linkedlist 
        while(temp != null){
            System.out.print(temp.value + " -> ");         //remember no new line needed here since we want the LL in the actual format
            temp = temp.next;       //next is just a pointer or ref var that is going to point the objects provided
        }
        System.out.println("END");
    }



//----------------------------------------------------------------------------
    private class Node{                //(constructors for the values and ref pointers of LL)
        private int value;
        private Node next;    //this actually link the two nodes
    

    public Node(int value){   //the consturctors should be inside the Node class
        this.value = value;
    }

    public Node(int value,Node next){
        this.value = value;
        this.next = next;
    }
}
//------------------------------------------------------------------------------------
     public static void main(String[] args) {  //main
        LL list = new LL();
        list.insertfirst(3);     //3 is the first element to be inserted but will appear at the end since each element
        list.insertfirst(4);     //will be inserted from the front so head will point the last element to be inserted 
        list.insertfirst(5);
        list.insertfirst(6);
        list.insertlast(90);
        list.insertatIndex(50, 2);

        System.out.println(list.deletefirst()); //deletes the first element
        System.out.println(list.deletelast());  //deletes the last element
        System.out.println(list.delete(1));  //deletes the nth element

        list.display();
    }
}
  
