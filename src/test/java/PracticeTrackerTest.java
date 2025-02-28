import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class PracticeTrackerTest {
    private PracticeTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new PracticeTracker();
    }

    @Test
    void addSession() {
        Session session = new Session(LocalDate.now(), 60);
        tracker.addSession(session);
        assertEquals(1, tracker.getTotalSessionCount());
    }

    @Test
    void getTotalPracticeTime() {
        tracker.addSession(new Session(LocalDate.now(), 60));
        tracker.addSession(new Session(LocalDate.now(), 60));
        assertEquals(120, tracker.getTotalPracticeTime());
    }

    @Test
    void getTotalSessionCount() {
        tracker.addSession(new Session(LocalDate.now(), 60));
        tracker.addSession(new Session(LocalDate.now(), 60));
        assertEquals(2, tracker.getTotalSessionCount());
    }

    @Test
    void EligibleForGraduationSessions() {
        for (int i=0; i <100; i++) {
            tracker.addSession(new Session(LocalDate.now(), 10));
        }
        assertTrue(tracker.isEligibleForGraduation());
    }

    @Test
    void EligibleForGraduationTime() {
        tracker.addSession(new Session(LocalDate.now().minusMonths(6), 60));
        assertTrue(tracker.isEligibleForGraduation());
    }

    @Test
    void NotEligibleForGraduation() {
        tracker.addSession(new Session(LocalDate.now().minusMonths(5), 60));
        tracker.addSession(new Session(LocalDate.now(), 60));
        assertFalse(tracker.isEligibleForGraduation());
    }

    @Test
    void NotEligibleWhenNoSessions() {
        assertFalse(tracker.isEligibleForGraduation());
    }

}