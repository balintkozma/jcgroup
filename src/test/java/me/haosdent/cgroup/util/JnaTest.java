package me.haosdent.cgroup.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jiaojianfeng on 16/1/11.
 */
public class JnaTest {
    private static final Logger LOG = LoggerFactory.getLogger(JnaTest.class);

    @Test
    public void testCLibrary() {
        CLibrary.INSTANCE.printf("Hello World\n");
    }

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);

        void printf(String format, Object... args);
    }
    
}
