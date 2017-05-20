package com.bjethwan;

import java.util.Hashtable;

public class LRUCache<K, V> {
	
	private int count;
	private int capacity;
	
	//Doubly LinkedList
	private Node<K, V> head, tail;
	
	//Hashtable with key and Doubly LinkedList Node
	private Hashtable<K, Node<K, V>> cache;	

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> pre;
		Node<K, V> next;
	}
	
	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new Node<>();
		head.pre = null;
		
		tail = new Node<>();
		tail.next = null;
		
		head.next = tail;
		tail.pre = head;
		
		cache = new Hashtable<>();
	}
	
	/*
	 * Always add the new node right after head;
	 */
	private void addNode(Node<K, V> node){
		node.pre = head;
		node.next = head.next;
		
		head.next.pre = node;
		head.next = node;
	}

	/*
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(Node<K, V> node){
		Node<K, V> preOfNode = node.pre;
		Node<K, V> nextOfNode = node.next;
		
		preOfNode.next = nextOfNode;
		nextOfNode.pre = preOfNode;
	}

	/*
	 * Move certain node in between to the head.
	 */
	private void moveToHead(Node<K, V> node){
		this.removeNode(node);
		this.addNode(node);
	}

	/*
	 *  pop the current tail. 
	 */
	private Node<K,V> popTail(){
		Node<K,V> res = tail.pre;
		this.removeNode(res);
		return res;
	}


	public V get(K key) {
	    
		Node<K,V> node = cache.get(key);
		if(node == null){
			return null; // should raise exception here.
		}
		
		// move the accessed node to the head;
		this.moveToHead(node);
		
		return node.value;
	}
	
	public void set(K key, V value) {
		
		Node<K,V> node = cache.get(key);
		
		if(node == null){
			Node<K,V> newNode = new Node<>();
			newNode.key = key;
			newNode.value = value;
			
			this.cache.put(key, newNode);
			this.addNode(newNode);
			
			++count;
			
			if(count > capacity){					// LRU in action
				Node<K,V> tail = this.popTail();		// pop the tail
				this.cache.remove(tail.key);			// clear it from hashtable
				--count;
			}
		}else{
			node.value = value;						// update the value
			this.moveToHead(node);
		}
	}

}

