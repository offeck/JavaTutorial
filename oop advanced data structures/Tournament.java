import java.util.Iterator;

public class Tournament {


    public static void main(String[] args) {
        List<Player> playerList = new LinkedList<>();
        playerList.add(new Player("Shauli"));
        playerList.add(new Player("Karako"));
        playerList.add(new Player("Avi"));
        playerList.add(new Player("Amazia"));
        playerList.add(new Player("Hector"));
        System.out.println(simulateTournament(playerList));
    }


    public static Player simulateTournament(List<Player> playersList) {
        // Add all players to a queue
        Queue<Player> q = new QueueAsLinkedList<Player>();
        Iterator<Player> it = playersList.iterator();
        while (it.hasNext()) {  q.enqueue(it.next()); }

        // Start the tournament!
        Player winner = null;
        while (!q.isEmpty()) {
            Player first = q.dequeue();
            if (q.isEmpty()) {
                winner = first;  // Last player wins
            } else {
                Player second = q.dequeue();
                Player matchWinner = getWinner(first, second); // compete
                q.enqueue(matchWinner); // add winner to queue
            }
        }
        return winner;
    }



    public static Player getWinner(Player p1, Player p2) {
        if (Math.random() < 0.5)
            return p1;
        return p2;
    }
}
