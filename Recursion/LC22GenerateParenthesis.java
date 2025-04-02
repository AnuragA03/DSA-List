class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        form(0,0,"",n,res);

        return res;

    }

    public void form(int left, int right, String s, int n, List<String> res){
        if(left == right && left + right == n*2){
            res.add(s);
        }

        if(left < n){
            form(left + 1, right, s + "(", n, res);
        }

        if(right < left){
            form(left, right + 1, s + ")", n, res);
        }
    }
}