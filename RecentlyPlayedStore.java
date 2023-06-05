package com.learning;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecentlyPlayedStore extends LinkedHashMap<String, String> {
    
	private static final long serialVersionUID = 1L;
	private int capacity;

    public RecentlyPlayedStore(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
        store.put("S1", "User1");
        store.put("S2", "User1");
        store.put("S3", "User1");
        System.out.println(store); // Output: {S1=User1, S2=User1, S3=User1}
        store.put("S4", "User1");
        System.out.println(store); // Output: {S2=User1, S3=User1, S4=User1}
        store.put("S2", "User1");
        System.out.println(store); // Output: {S3=User1, S4=User1, S2=User1}
        store.put("S1", "User1");
        System.out.println(store); // Output: {S4=User1, S2=User1, S1=User1}
    }
}