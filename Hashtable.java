
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

	public int getIndex(K key) {

		int hashCode = Math.abs(key.hashCode());

		int index = hashCode % arr.length;

		return index;
	}

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

	public String remove(String key) throws Exception {

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
		throw new Exception();

	}
}
