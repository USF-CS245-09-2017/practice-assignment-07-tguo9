/* This is the Hashtable class.
 * @author Tao Guo
 */

public class Hashtable<K, V> {

	class HashNode<K, V> {

		private K key;
		private V val;
		HashNode<K, V> next;

		public HashNode(K key, V val) {

			this.key = key;
			this.val = val;
			this.next = null;
		}
	}

	private HashNode[] arr;
	private int size;

	public Hashtable() {

		arr = new HashNode[314527];
		size = 0;

	}

	/*
	 * Helper method to get index.
	 */

	private int getIndex(K key) {

		int hashCode = Math.abs(key.hashCode());

		int index = hashCode % arr.length;

		return index;
	}

	/*
	 * Returns the value associated with the key which is passed as an argument;
	 * returns null if no key/value pair is contained by the Hashtable instance
	 */

	public String get(String key) {

		int pos = getIndex((K) key);
		String returnVal = null;
		HashNode start = arr[pos];

		while (start != null) {
			if (start.key == key) {
				returnVal = (String) start.val;
				return returnVal;
			}
			start = start.next;
		}

		return returnVal;
	}

	/*
	 * Returns “true” if a key/value object pair (with the key matching the argument
	 * and any value).
	 */

	public boolean containsKey(String key) {

		int index = getIndex((K) key);

		boolean returnVal = false;
		HashNode start = arr[index];
		while (start != null) {
			if (start.key.equals(key)) {
				returnVal = (boolean) start.val;
				return returnVal;
			}
			start = start.next;
		}
		return returnVal;

	}

	/*
	 * Adds the key/value pair into the Hashtable instance. If there is an existing
	 * key/value pair, the Hashtable instance replaces the stored value with the
	 * argument value.
	 */

	public void put(String key, String value) {

		int index = getIndex((K) key);
		if (arr[index] == null) {
			arr[index] = new HashNode(key, value);
		} else {
			HashNode start = arr[index];
			if (start.key.equals(key)) {
				arr[index].val = value;
			}
			while ((start.next != null) && (start.next.key != key)) {
				start = start.next;
			}
			if (start.next != null) {
				start.next.val = value;
			}
			HashNode hn = new HashNode(key, value);
			start.next = hn;
		}

	}

	/*
	 * Removes the key/value pair from the Hashtable instance and returns the value
	 * associated with the key to the caller. Throws an Exception instance if the
	 * key is not present in the Hashtable instance
	 */

	public String remove(String key) {

		int index = getIndex((K) key);

		HashNode temp = arr[index];
		if (temp.key.equals(key)) {
			arr[index] = temp.next;
			return (String) temp.val;
		}
		while ((temp.next != null) && (temp.next.key != key)) {
			temp = temp.next;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
			return (String) temp.next.val;
		}
		return null;

	}
}
