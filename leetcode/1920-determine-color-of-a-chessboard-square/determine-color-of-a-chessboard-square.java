class Solution {
    public boolean squareIsWhite(String coordinates) {
        int horizontal = (coordinates.charAt(0) -'a' );
        int vertical = coordinates.charAt(1) - '0'- 1;

        if (horizontal % 2 == 0 ) return vertical % 2 == 1;
        else return vertical %2 == 0; 
    }
}