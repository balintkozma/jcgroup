package me.haosdent.cgroup.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Threads {

  private interface  CLibrary extends Library {
    CLibrary INSTANCE = (CLibrary) Native.loadLibrary(Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);
    int syscall(int api);
  }

  private static final int __NR_gettid = Platform.is64Bit() ? 186 : 224;

  public static int getThreadId() {
    return CLibrary.INSTANCE.syscall(__NR_gettid);
  }

  /*public static native int getThreadId();

  static {
    System.loadLibrary("Threads");
  }*/
}
