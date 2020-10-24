import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Request_D extends Request{

    private LocalDate beginTime, endTime;
    private boolean timeInterval;

    public Request_D(String type, String services, String questions, String response, boolean timeInterval, String beginTime, String endTime) {
        super(type, services, questions, response);
        this.timeInterval = timeInterval;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        this.beginTime = LocalDate.parse(beginTime, formatter);
        this.endTime = LocalDate.parse(endTime, formatter);
    }

    public void analytical(List<Request_C> requestList) {
        int sum = 0,
                divider = 0;
        for (Request_C request:requestList) {
            int temp = this.compare(request);
            if (temp != 0) {
                sum += temp;
                divider += 1;
            }
        }

        if (divider != 0) {
            System.out.println(sum/divider);
        } else {
            System.out.println('-');
        }

    }

    private int compare(Request_C request) {

        // type
        if (request.getType().charAt(0) == 'D') {
            return 0;
        }

        // service
        if (!this.arraysCompare(super.getServices(), request.getServices())) {
            return 0;
        }

        // questions
        if (!this.arraysCompare(super.getQuestions(), request.getQuestions())) {
            return 0;
        }

        // response
        if (!super.getResponse().equals(request.getResponse())) {
            return 0;
        }

        // data
        if (timeInterval) {
            if ( !(request.getDate().isAfter(beginTime.minusDays(1)) && request.getDate().isBefore(endTime.plusDays(1))) ) {
                return 0;
            }
        } else {
            if (!this.beginTime.isEqual(request.getDate())) {
                return 0;
            }
        }

        // time
        return request.getTime();

    }

    private boolean arraysCompare(char[] arrD, char[] arrC) {
        boolean out = false;
        if (arrD[0] == '*') {
            out = true;
        } else if(arrC.length < arrD.length) {
            out =  false;
        } else if (arrC.length >= arrD.length) {
            out = true;
            for (int i = 0; i < arrD.length; ++i) {
                if (arrD[i] != arrC[i]) {
                    out = false;
                }
            }
        }
        return out;
    }



    @Override
    public String toString() {
        return "Request_D{" +
                super.toString() + ", " +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", timeInterval=" + timeInterval +
                '}';
    }
}