class Test3 {
    private static final int minlen = 6;
    private static final int maxlen = 15;

    private static String[] impoStrings = {
        "123","321","456","654","789","987",
        "147","741","258","852","025","520","369","963",
        "159","951","357","753"
    };
    public static void main(String[] args) {
        String inputdata = "2688812";
        String inputdata2 = "6482917350";
        String inputdata3 = "262610912";
        String inputdata4 = "2613213212";
        String inputdata5 = "12459865";
        String inputdata6 = "137988137988";

        System.out.println(checkComplexValidate(inputdata));
        System.out.println(checkComplexValidate(inputdata2));
        System.out.println(checkComplexValidate(inputdata3));
        System.out.println(checkComplexValidate(inputdata4));
        System.out.println(checkComplexValidate(inputdata5));
        System.out.println(checkComplexValidate(inputdata6));

    }

    public static boolean checkSimpleValidate(String inputdata) {
        if(inputdata.length() < minlen || inputdata.length() > maxlen) {
            return false;
        }
        if(inputdata.contains("*") || inputdata.contains("#")) {
            return false;
        }
        for(int i = 0; i< impoStrings.length; i++) {
            if(inputdata.contains(impoStrings[i])) {
                return false;
            }
        }
        return true;

    }

    public static boolean checkComplexValidate(String inputdata) {
        if (inputdata.contains("*") || inputdata.contains("#")) {
            return false;
        }
        int recurFlag = 1;
        for(int i =0; i< inputdata.length()-1; i++) {
            if(inputdata.charAt(i) == inputdata.charAt(i+1)) {
                recurFlag ++;
            }else {
                recurFlag = 1;
            }

            if(recurFlag == 3) {
                return false;
            }
        }
        
        
        for(int i = 0; i< inputdata.length()-1; i++) {
            for(int j = i+1; j < inputdata.length(); j++) {
                //inputdata.substring(beginIndex, endIndex)
                if(inputdata.charAt(i) == inputdata.charAt(j)) {
                    if(j+j-i-1 < inputdata.length() && inputdata.substring(i,j-1).equals(inputdata.substring(j,j+j-i-1)) && j-i>=2) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}