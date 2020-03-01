package module4.bst;

import java.util.*;

class Task1 {

    private static class User {

        String surname, name, pass;
        TreeSet<String> set;

        public User(String surname, String name, String pass) {
            this.surname = surname;
            this.name = name;
            this.pass = pass;
            set = new TreeSet<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(surname).append(' ')
                    .append(name)
                    .append(' ')
                    .append(pass)
                    .append(' ');
            for (String num : set) {
                sb.append(num).append(' ');
            }
            return sb.toString();
        }

        public void addNum(String num) {
            set.add(num);
        }
    }

    public static void main(String[] args) {
        TreeMap<String, User> map = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String surname = in.next(), name = in.next(),
                    pass = in.next(), num = in.next();
            if (map.containsKey(pass)) {
                map.get(pass).addNum(num);
            } else {
                User user = new User(surname, name, pass);
                user.addNum(num);
                map.put(pass, user);
            }
        }
        for (Map.Entry<String, User> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
