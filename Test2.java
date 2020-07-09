class Test2 {
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30, 40},
            {40, 50, 60, 70},
            {70, 80, 90, 80}
        };

    
        int[][] horizontalSum = getHorizontalSum(arr);

        for(int[] i: horizontalSum) {
            for(int j: i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println("----------------");
        horizontalSum = getVerticalSum(horizontalSum);
        
        for (int[] i : horizontalSum) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getHorizontalSum(int[][] inputData) {
        int[][] newArr = new int[inputData.length][inputData[0].length+1];

        for(int i = 0; i< inputData.length; i++) {
            int sum = 0;
            for(int j = 0; j< inputData[i].length; j++) {
                sum += inputData[i][j];
                newArr[i][j] = inputData[i][j];
            }
            newArr[i][inputData[i].length] = sum;
        }

        return newArr;
    }

    public static int[][] getVerticalSum(int[][] inputData) {
        int[][] newArr = new int[inputData.length + 1][inputData[0].length];

        for (int i = 0; i < inputData[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < inputData.length; j++) {
                sum += inputData[j][i];
                newArr[j][i] = inputData[j][i];
            }
            newArr[inputData.length][i] = sum;
        }

        if(inputData[0].length %2 == 0) {   //짝수
            int center = inputData[0].length/2;
            for(int i = 0; i < newArr.length; i++) {
                for(int j = 0; j< newArr[i].length/2; j++) {
                    int tmp = newArr[i][j];
                    newArr[i][j] = newArr[i][j+center];
                    newArr[i][j+center] = tmp;
                }
            } 
        }else {
            int center = inputData[0].length / 2;
            for (int i = 0; i < newArr.length; i++) {
                for (int j = 0; j < newArr[i].length / 2; j++) {
                    int tmp = newArr[i][j];
                    newArr[i][j] = newArr[i][j + center+1];
                    newArr[i][j + center+1] = tmp;
                }
            }

        }

        return newArr;
    }
}