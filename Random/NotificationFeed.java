import java.lang.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.*;

/**
 * 
 * 
 * 
 * 
Implement a notifications feed based on the following stub
The notification feed only shows the most recent notification.
The user can dismiss it (pop) to see the next one.
The notification engine can add new ones on top or move an old notification back to the top.
It can also remove any notification in the feed.
Optimize for runtime complexity O(1) for all operations except evict(Duration timeInFeed)

 * This is a notifications feed.
 * The feed maintains a "Last-In-First-Out" (LIFO) retrieve policy.
 */
class NotificationFeed {

    HashMap<String, NotificationListNode> notifDict;
    NotificationListNode topOfFeed;
    NotificationListNode bottomStack;

    NotificationFeed(){
        this.notifDict = new HashMap<>();
        this.topOfFeed = new NotificationListNode(null);
        this.bottomStack = new NotificationListNode(null);
        this.bottomStack.next = this.topOfFeed;
        this.topOfFeed.prev = this.bottomStack;
    }

	/**
	* Adds an element to the feed.
	* An element can exist only once in the feed.
	* Each call to add behaves as if the element was added for the first time.
	*/
	 void add(Notification element) {
        NotificationListNode node = new NotificationListNode(element);
        addToFeedStack(node);
        this.notifDict.put(element.getId(), node);
	 }
	 
	private void addToFeedStack(NotificationListNode node) {
        
    }

    private void removeFromFeedStack(NotificationListNode node) {
        
    }

    /**
	* @return true if the element is in the feed, false otherwise
	*/

	boolean contains(Notification element) {     
        return this.notifDict.containsKey(element.getId());
	}

	/**
	* Removes the given element from the feed.
	*/
  
	void remove(Notification element) {
        if(this.notifDict.containsKey(element.getId())){
            NotificationListNode node = this.notifDict.get(element.getId());

        }
	}

	/**
	* Retrieves and removes the most recently added element, following the LIFO policy.
	*
	* @return the most recently added element or null if the feed is empty.
	*/
	//O(1)
	Notification pop() { 
        NotificationListNode node = this.topOfFeed.prev;
		node.prev.next = this.topOfFeed;
        return node.notif;
	}

	/**
	* @return The number of elements in the feed
	*/
	int size() {
		return this.notifDict.size();
	}
	
	// evict(Duration.ofHours(1)) would remove any elements that have been in the feed for >= 1 hour
	public void evict(Duration timeInFeed) {
		
	}
}

class Notification {
	private final String id;
   
	Notification(String id) {
		this.id = id;        
	}
	
	String getId() {
		return id;
	}
}

class NotificationListNode{
    public  Notification notif;
    public NotificationListNode prev;
    public NotificationListNode next;
    public Timestamp creationTime;

    NotificationListNode(Notification notif){
        this.notif = notif;
        this.prev = null;
        this.next = null;
        this.creationTime = new Timestamp(System.currentTimeMillis());
    }
}
