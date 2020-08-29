class Test4 {
    public static void main(String[] args) {

        String[] bicycleStation = {"E2","E5","E7","E10"};
        String start = "E2";
        String end = "E9";
        String departure = "12:00";
        int time = getTraveltimeWithoutShuttle(bicycleStation, start, end);

        System.out.println(time);

        time = getTraveltime(bicycleStation, start, end, departure);
        System.out.println(time);
        
    }

    public static int getTraveltimeWithoutShuttle(String[] bicycleStation, String start, String destination) {
        
        // 도보 이용시
        int minTime = 240*12;

        if(minTime > getTimeByWalk(start, destination))
            minTime = getTimeByWalk(start, destination);

        if (minTime > getTimeByBicycle(bicycleStation,start, destination))
            minTime = getTimeByBicycle(bicycleStation, start, destination);
        
        return minTime;

    }

    public static int getTimeByWalk(String start, String destination) {
        int dest = Integer.parseInt(destination.substring(1));
        int begin = Integer.parseInt(start.substring(1));

        return Math.abs(dest-begin)*240;
    }

    public static int getTimeByBicycle(String[] bicycleStation, String start, String destination) {
        int[] bicycleSt = new int[12];
        int dest = Integer.parseInt(destination.substring(1))-1;
        int begin = Integer.parseInt(start.substring(1))-1;
        int leftBegin  = -1;
        int rightBegin = -1;
        int leftDest = -1;
        int rightDest = -1;

        for(int i = 0; i< bicycleStation.length; i++) {
            bicycleSt[Integer.parseInt(bicycleStation[i].substring(1)) - 1] = 1;
        }

        for(int i = begin; i>= 0; i--) {    // 출발지 좌측 자전거
            if(bicycleSt[i] == 1) {
                leftBegin = i;
                break;
            }
        }

        for(int i = begin+1; i< 12; i++) {  // 출발지 우측 자전거
            if(bicycleSt[i] == 1){
                rightBegin = i;
                break;
            }
        }

        for (int i = dest; i >= 0; i--) { // 도착지 좌측 자전거
            if (bicycleSt[i] == 1) {
                leftDest = i;
                break;
            }
        }

        for (int i = dest + 1; i < 12; i++) {  // 도착지 우측 자전거
            if (bicycleSt[i] == 1) {
                rightDest = i;
                break;
            }
        }

       
        int totalTime = 240*12;
        // left to left
        if(leftBegin != -1 && leftDest != -1) {
            int tmp = (begin-leftBegin)*240;
            tmp += Math.abs(leftDest - leftBegin)*70;
            tmp += (dest-leftDest)*240;

            if(totalTime > tmp) {
                totalTime = tmp;
            }
        }
        if (leftBegin != -1 && rightDest != -1) {
            int tmp = (begin - leftBegin) * 240;
           // System.out.println(tmp);
            tmp += Math.abs(leftBegin - rightDest) * 70;
            //System.out.println(tmp);
            tmp += (rightDest-dest) * 240;
           // System.out.println(tmp);
            if (totalTime > tmp) {
                totalTime = tmp;
            }
        }
        if (rightBegin != -1 && leftDest != -1) {
            int tmp = (rightBegin-begin) * 240;
            tmp += Math.abs(leftDest - rightBegin) * 70;
            tmp += (dest - leftDest) * 240;

            if (totalTime > tmp) {
                totalTime = tmp;
            }
        }
        if (rightBegin != -1 && rightDest != -1) {
            int tmp = (rightBegin - begin) * 240;
            tmp += Math.abs(rightDest - rightBegin) * 70;
            tmp += (rightDest - dest) * 240;

            if (totalTime > tmp) {
                totalTime = tmp;
            }
        }

        return totalTime;
    }

    public static int getTravelwithBus(String[] bicycleStation, String start, String destination, String departure) {
        int totalTime = 0;
        int begin = Integer.parseInt(start.substring(1));
        //int dest = Integer.parseInt(destination.substring(1)); 
        if(begin> 6) {    //버스타로 12번으로 
            totalTime = Integer.min(getTimeByWalk(start, "E12"), getTimeByBicycle(bicycleStation, start, "E12")); 
            int waitingTime = (Integer.parseInt(departure.substring(3))*60 + totalTime)%600;
            waitingTime = 600 - waitingTime;    //대기시간
            totalTime += 220 + waitingTime;
            totalTime += Integer.min(getTimeByWalk("E1", destination), getTimeByBicycle(bicycleStation, "E1", destination));
        }else {
            totalTime = Integer.min(getTimeByWalk(start, "E1"), getTimeByBicycle(bicycleStation, start, "E1"));
            int waitingTime = (Integer.parseInt(departure.substring(3)) * 60 + totalTime) % 600;
            waitingTime = 600 - waitingTime; // 대기시간
            totalTime += 220 + waitingTime;
            totalTime += Integer.min(getTimeByWalk("E12", destination),
                    getTimeByBicycle(bicycleStation, "E12", destination));
        }

        return totalTime;
    }
    
    public static int getTraveltime(String[] bicycleStation, String start, String destination, String departure) {

        // 도보 이용시
        int minTime = 240 * 12;

        if (minTime > getTimeByWalk(start, destination))
            minTime = getTimeByWalk(start, destination);

        if (minTime > getTimeByBicycle(bicycleStation, start, destination))
            minTime = getTimeByBicycle(bicycleStation, start, destination);
        
        if (minTime > getTravelwithBus(bicycleStation, start, destination, departure))
            minTime = getTravelwithBus(bicycleStation, start, destination, departure);

        return minTime;

    }
}