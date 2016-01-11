package me.haosdent.cgroup.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Threads {
  static {
    if (Platform.isMac()) {
      System.load("libNativeThreadId.dylib");
    }
  }

  private interface CLibrary extends Library {
    int syscall(int api);
  }

  private interface MLibrary extends Library {
    int getThreadId();
  }

  private static final int __NR_gettid = Platform.is64Bit() ? 186 : 224;

  private static final Library INSTANCE = (Library) Native.loadLibrary(Platform.isMac() ? "NativeThreadId"
          : (Platform.isWindows() ? "msvcrt" : "c"), Platform.isMac() ? MLibrary.class : CLibrary.class);


  public static int getThreadId() {
    System.out.println(INSTANCE);
    if (Platform.isMac()) {
      return ((MLibrary)INSTANCE).getThreadId();
    } else {
      return ((CLibrary)INSTANCE).syscall(__NR_gettid);
    }
  }

}
