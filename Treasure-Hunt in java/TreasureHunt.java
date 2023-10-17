import java.util.Scanner;

class Location{

    String name;
    Location next;
    public Location(String name){
        this.name = name;
        this.next = null;
    }
}

class TreasureHunt {
    
    Location head = null;

    void addLocation (String k) {
        Location n = new Location(k);
        if(head == null){
            head = n;
        }
        else{
            Location temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    void startHunt(){
       if(head == null)
        return;
        Location temp = head;
        while(temp.next != null){
            System.out.println("You are at "+temp.name);
            System.out.println("Press 1 to move forward, 0 to stop");
            Scanner s = new Scanner(System.in);
            int a = s.nextInt();
            if(a == 0)
                break;
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreasureHunt t = new TreasureHunt();
        int a = 1;
        do{
            System.out.println("1. Add Location\n2. Start Hunt\n0. Exit\nEnter Choice :");
            a = s.nextInt();
            switch(a){
                case 1 -> {
                    s.nextLine();
                    t.addLocation(s.nextLine());
                }
                case 2 -> t.startHunt();
            }
        }while(a != 0);
        
    }
}
