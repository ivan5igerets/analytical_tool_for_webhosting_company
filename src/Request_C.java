import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Request_C extends Request{

    private LocalDate date;
    private int time;

    public Request_C(String type, String services, String questions, String response, String date, String time) {
        super(type, services, questions, response);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateTime = LocalDate.parse(date, formatter);
        this.date = dateTime;
        this.time = Integer.parseInt(time);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Request_C{" +
                super.toString() + ", " +
                "date=" + date +
                ", time=" + time +
                '}';
    }
}
