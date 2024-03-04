package database.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseUtilTest {

    @Test
    void sayDatabaseTest() {
        assertEquals("Database", DatabaseUtil.sayDatabase());
    }

}