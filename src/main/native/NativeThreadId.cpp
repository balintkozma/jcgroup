#include "NativeThreadId.h"
#include <pthread.h>

/**
 *  gcc -c NativeThreadId.cpp
 *  gcc -dynamiclib -o libNativeTest.dylib NativeTest.o
 */
int getThreadId() {
	return pthread_mach_thread_np(pthread_self());
}