import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * trie-node
 * @author rakeshnarang
 *
 */
class TrieNode {
	// character
	char data;
	// linked list of trie nodes
	LinkedList<TrieNode> children;
	// parent of this trie node
	TrieNode parent;
	// is complete word
	boolean isCompleteWord;

	// constructor
	public TrieNode(char c) {
		data = c;
		children = new LinkedList<>();
		isCompleteWord = false;
	}

	// gets child that has character c
	public TrieNode getChild(char c) {
		// trie node to return
		TrieNode foundChild = null;
		// check if linkedlist is null
		// this check is not required because the constructor initializes linked-list
		if (null != this.children) {
			// iterate over the linkedlist and if the same character is found, return the trie-node
			for (TrieNode child : children) {
				if (c == child.data) {
					foundChild = child;
					break;
				}
			}
		}
		return foundChild;
	}

	// get all the words
	protected List<String> getWords() {
		List<String> list = new ArrayList<>();
		// if isCompleteWord true, then add toString() to list
		if (isCompleteWord) {
			list.add(toString());
		}
		if (this.children != null) {
			// recursive call to get words of all the children
			for (TrieNode child : this.children) {
				list.addAll(child.getWords());
			}
		}
		return list;
	}

	// recursive method of get word
	public String toString() {
		if (parent == null) {
			return "";
		} else {
			// initialize a String with char[]
//			return parent.toString() + new String(new char[] { data });
			// initialize a String with String util
			return parent.toString() + String.valueOf(this.data);
		}
	}
}

/**
 * trie
 * @author rakeshnarang
 *
 */
class Trie {
	// root node
	private TrieNode root;

	// construct with ' ' as root
	public Trie() {
		root = new TrieNode(' ');
	}

	// insert a collection
	// traverses over a collection of strings and calls insert-word method internally
	public void insertCollection(Collection<String> collection) {
		for (String word : collection) {
			this.insert(word);
		}
	}

	// insert method
	public void insert(String word) {
		// convert word to lower case at the time of insert
		word = word.toLowerCase();
		
		// search if word exists
		// if exists, why add new?
		if (search(word))
			return;

		// current ptr is set to root
		TrieNode current = root;
		// previous ptr
		TrieNode pre;
		
		// convert word to charArray and traverse over it
		for (char ch : word.toCharArray()) {
			// pre points to current
			pre = current;
			// get child trie-node with that character
			TrieNode child = current.getChild(ch);
			// if it exists
			// move ahead
			if (null != child) {
				// fetched child as current
				current = child;
				// set child's parent as previous current
				child.parent = pre;
			// if not exist
			} else {
				// add new trie-node with that character
				current.children.add(new TrieNode(ch));
				// make newly added child as current
				current = current.getChild(ch);
				// make that child's parent as previous current
				current.parent = pre;
			}
		}
		// after all the characters in the char array are stored
		// set boolean-isCompleteWord as true
		current.isCompleteWord = true;
	}

	// search for a word
	private boolean search(String word) {
		// start with root
		TrieNode current = root;
		// convert word to char array and start traversal
		for (char ch : word.toCharArray()) {
			// if current doesn't have the character to search
			// return false
			if (current.getChild(ch) == null) {
				return false;
			} else {
				// else set current to the child element and move forward
				current = current.getChild(ch);
			}
		}
		// all characters in the word were found
		// now if that is a word
		// ret true
		// else, wrong word
		return current.isCompleteWord;
	}

	// autocomplete functionality
	public List<String> autocomplete(String prefix) {
		// convert prefix to lower case
		prefix = prefix.toLowerCase();
		// start with root
		TrieNode lastNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			// if prefix found
			// call getWords() method of lastNode
			// if not found
			// ret empty arraylist
			lastNode = lastNode.getChild(prefix.charAt(i));
			if (lastNode == null)
				return new ArrayList<>();
		}
		return lastNode.getWords();
	}

}

public class TrieDataStructure {
	public static void main(String[] args) {
		// create a trie
		Trie trie = new Trie();
		// insert into tries
		trie.insert("Rakesh");
		trie.insert("Rakshata");
		trie.insert("Rakshita");
		trie.insert("Ruhani");
		trie.insert("Ramaya");
		trie.insert("Runan");
		trie.insert("Ruhan");
		trie.insert("Rakib");
		trie.insert("Rohan");
		trie.insert("Rohani");
		trie.insert("Raka");
		// call autocomplete with a prefix on the trie
		// and print all the values
		print(trie.autocomplete("Rak"));

	}

	private static void print(List<String> autocomplete) {
		for (String str : autocomplete) {
			System.out.println(str);
		}
	}

}
