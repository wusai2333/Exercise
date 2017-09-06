import java.util.HashSet;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir: path.split("/")) {
            if (dir.equals("..") && !stack.empty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for(String dir: stack) res += "/" + dir;
        return res.isEmpty() ? "/" : res;
    }
}