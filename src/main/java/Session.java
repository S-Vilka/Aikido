import java.time.LocalDate;

public class Session {
    private LocalDate date;
    private int duration;

    public Session(LocalDate date, int duration) {
        this.date = date;
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}