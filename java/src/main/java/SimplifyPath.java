import java.util.LinkedList;

/**
 * @created: 2015/2/3
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return null;
        path = path.trim();
        LinkedList<String> pathNodes = new LinkedList<String>();
        String[] tokens = path.substring(1).split("/");
        for (String token : tokens) {
            if (token.equals(".") || token.equals("")) {
                continue;
            } else if (token.equals("..")) {
                if (!pathNodes.isEmpty()) {
                    pathNodes.pollLast();
                }
            } else {
                pathNodes.addLast(token);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (pathNodes.isEmpty()) builder.append("/");
        else {
            for (String pathNode : pathNodes) {
                builder.append("/").append(pathNode);
            }
        }
        return builder.toString();
    }

    public static void main(String args[]) {
        SimplifyPath s = new SimplifyPath();
        String tp1 = "/home/";
        String tp2 = "/a/./b/../../c/";
        String tp3 = "/../";
        String tp4 = "/home//foo/";
        System.out.println(s.simplifyPath(tp1));
        System.out.println(s.simplifyPath(tp2));
        System.out.println(s.simplifyPath(tp3));
        System.out.println(s.simplifyPath(tp4));
    }
}
