import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PracticeTracker {

    private List<Session> sessions;

    public PracticeTracker() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session practiceSession) {
        sessions.add(practiceSession);
    }

    public int getTotalPracticeTime() {
        int totalPracticeTime = 0;
        for (Session practiceSession : sessions) {
            totalPracticeTime += practiceSession.getDuration();
        }
        return totalPracticeTime;
    }

    public int getTotalSessionCount() {
        return sessions.size();
    }

    public boolean isEligibleForGraduation() {
        if (sessions.size() >= 100) {
            return true;
        }

        if (sessions.isEmpty()) {
            return false;
        }

        LocalDate firstSessionDate = sessions.get(0).getDate();
        LocalDate today = LocalDate.now();

        long monthsSinceFirstSession = ChronoUnit.MONTHS.between(firstSessionDate, today);
        return monthsSinceFirstSession >= 6;
    }
}