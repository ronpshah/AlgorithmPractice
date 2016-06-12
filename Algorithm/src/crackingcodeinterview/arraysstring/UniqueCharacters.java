package crackingcodeinterview.arraysstring;

/**
 * Created by shah_ on 5/28/2016.
 */
public class UniqueCharacters {

    public boolean isUniqueChar1(String str){

        if (str.length()>256)
            return false;
        else{
            int len = str.length();
            boolean bool[] = new boolean[256];
            for (int i=0;i<len;i++){
                int val = str.charAt(i);
                if (bool[val]){
                    return false;
                }else{
                    bool[val] = true;
                }
            }
        }
        return true;
    }

    //Assuming all small characters
    public boolean isUniqueChar2(String str){
        int bool = 0;
        String lowercase = str.toLowerCase();
        for (int i=0;i<str.length();i++){
            int val = str.charAt(i) - 'a';
            if ((bool & (1<<val)) > 0){
                return false;
            }else{
                bool = bool | (1<<val);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        UniqueCharacters UC = new UniqueCharacters();

        System.out.println(UC.isUniqueChar1("Ronak"));
        System.out.println(UC.isUniqueChar1("RRonaksdo"));

        System.out.println(UC.isUniqueChar2("Ronak"));
        System.out.println(UC.isUniqueChar2("RRonaksdo"));
    }
}
