package samsung;

import java.util.regex.Pattern;

public class n14889 {

    public static void main(String[] args) {
        String[] emails = {"d@co@m.org", "a@abc.org", "b@def.org", "c@ghi.net"};
        String namePattern = "[a-z.]+@[a-z]+.(com)?(net)?(org)?";
        String domainPattern = "[a-z]+";

        int answer = 0;
        for (String email : emails) {
            if (Pattern.matches(namePattern, email)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
