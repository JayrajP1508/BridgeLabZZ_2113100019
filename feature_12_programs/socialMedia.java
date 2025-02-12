package Assignment14;

import java.util.*;

class User {
    int userID;
    String name;
    int age;
    LinkedList<Integer> friends;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new LinkedList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        newUser.next = head;
        head = newUser;
    }

    public User searchUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userID1, int userID2) {
        User user1 = searchUser(userID1);
        User user2 = searchUser(userID2);
        if (user1 != null && user2 != null && userID1 != userID2) {
            if (!user1.friends.contains(userID2)) user1.friends.add(userID2);
            if (!user2.friends.contains(userID1)) user2.friends.add(userID1);
        }
    }

    public void removeFriend(int userID1, int userID2) {
        User user1 = searchUser(userID1);
        User user2 = searchUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userID2));
            user2.friends.remove(Integer.valueOf(userID1));
        }
    }

    public List<Integer> findMutualFriends(int userID1, int userID2) {
        User user1 = searchUser(userID1);
        User user2 = searchUser(userID2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friend : user1.friends) {
                if (user2.friends.contains(friend)) {
                    mutualFriends.add(friend);
                }
            }
        }
        return mutualFriends;
    }

    public List<Integer> getFriends(int userID) {
        User user = searchUser(userID);
        return (user != null) ? user.friends : Collections.emptyList();
    }

    public void displayFriends(int userID) {
        User user = searchUser(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        } else {
            System.out.println("User not found");
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }
}


