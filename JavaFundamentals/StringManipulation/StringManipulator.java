class StringManipulator{
    public String trimAndConcat(String string1, String string2){
        String trimmedString1 = string1.trim();
        String trimmedString2 = string2.trim();
        String output = trimmedString1.concat(trimmedString2);
        return output; 
    }
    // return type is class Integer which allows us to return either an int or null. return type int will not allow us to return null
    public Integer getIndexOrNull(String string, char character){
        int result = string.indexOf(character);
        if(result == -1){
            return null;
        } else{
            return result; 
        }
    }
    public Integer getIndexOrNull(String string1, String string2){
        int result = string1.indexOf(string2);
        if(result == -1){
            return null;
        } else{
            return result;
        }
    }
    public String concatSubstring(String string1, int start, int end, String string2){
        String newSubString = string1.substring(start, end);
        String output = newSubString.concat(string2);
        return output;
    }
}