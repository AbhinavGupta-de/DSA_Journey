package contest.leetcode.biweekly132;


public class FirstPlayerToWinKGames {
    public int findWinningPlayer(int[] skills, int k) {

//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < skills.length; i++) {
//            map.put(skills[i], i);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        int first = skills[0];
//
//        for(int i = 1; i < skills.length; i++) {
//            queue.add(skills[i]);
//        }
//
//        int count = 0;
//
//        while(count < k) {
//            int second = queue.poll();
//
//            if(first > second) {
//                queue.add(second);
//                queue.add(first);
//                count++;
//            } else {
//                queue.add(first);
//                first = second;
//                count = 1;
//            }
//        }
//
//        return map.get(first);
//    }

//        using two pointers

        int win = 0;
        int compt = 1;

        int n = skills.length;

        int count = 0;

        while(compt < n) {
            if(skills[win] > skills[compt]) {
                count++;
                compt++;
            } else {
                win = compt;
                compt++;
                count = 1;
            }

            if(count == k) {
                return win;
            }
        }

        return win;

    }
}