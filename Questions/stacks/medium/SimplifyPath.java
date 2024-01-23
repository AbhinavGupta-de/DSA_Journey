package questions.stacks.medium;

public class SimplifyPath {
 public String simplifyPath(String path) {

  String[] paths = path.split("/");
  StringBuilder stb = new StringBuilder();

  for (String str : paths) {
   if (str.isEmpty() || str.equals("."))
    continue;

   else if (str.equals("..")) {
    if (stb.length() > 0) {
     int lastIndex = stb.lastIndexOf("/");
     stb.delete(lastIndex, stb.length());
    }
   } else {
    stb.append("/").append(str);
   }
  }

  if (stb.length() == 0)
   stb.append("/");

  return stb.toString();
 }
}
