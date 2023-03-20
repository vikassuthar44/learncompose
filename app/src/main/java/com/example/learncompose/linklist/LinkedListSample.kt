package com.example.learncompose.linklist

internal class LinkedListSample {
    var head: Node? = null

    /* Linked list Node*/
    internal inner class Node(var data: Int) {
        var next: Node? = null
    }

    /* Function to get Union of 2 Linked Lists */
    fun getUnion(head1: Node?, head2: Node?) {
        var t1 = head1
        var t2 = head2

        // insert all elements of list1 in the result
        while (t1 != null) {
            push(t1.data)
            t1 = t1.next
        }

        // insert those elements of list2
        // that are not present
        while (t2 != null) {
            if (!isPresent(head, t2.data)) push(t2.data)
            t2 = t2.next
        }
    }

    fun getIntersection(head1: Node?, head2: Node?) {
        val result: Node? = null
        var t1 = head1

        // Traverse list1 and search each
        // element of it in list2.
        // If the element is present in
        // list 2, then insert the
        // element to result
        while (t1 != null) {
            if (isPresent(head2, t1.data)) push(t1.data)
            t1 = t1.next
        }
    }

    /* Utility function to print list */
    fun printList() {
        var temp = head
        while (temp != null) {
            print(temp.data.toString() + " ")
            temp = temp.next
        }
        println()
    }

    /*  Inserts a node at start of linked list */
    fun push(new_data: Int) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        val new_node: Node = Node(new_data)

        /* 3. Make next of new Node as head */new_node.next = head

        /* 4. Move the head to point to new Node */head = new_node
    }

    /* A utility function that returns true
       if data is present in linked list
       else return false */
    fun isPresent(head: Node?, data: Int): Boolean {
        var t = head
        while (t != null) {
            if (t.data == data) return true
            t = t.next
        }
        return false
    }

    companion object {
        /* Driver program to test above functions */
        @JvmStatic
        fun main(args: Array<String>) {
            val llist1 = LinkedListSample()
            val llist2 = LinkedListSample()
            val unin = LinkedListSample()
            val intersecn = LinkedListSample()

            /*create a linked lists 10->15->4->20 */llist1.push(20)
            llist1.push(4)
            llist1.push(15)
            llist1.push(10)

            /*create a linked lists 8->4->2->10 */llist2.push(10)
            llist2.push(2)
            llist2.push(4)
            llist2.push(8)
            intersecn.getIntersection(llist1.head, llist2.head)
            unin.getUnion(llist1.head, llist2.head)
            println("First List is")
            llist1.printList()
            println("Second List is")
            llist2.printList()
            println("Intersection List is")
            intersecn.printList()
            println("Union List is")
            unin.printList()
        }
    }
}