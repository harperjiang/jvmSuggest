/*
 * main.cpp
 *
 *  Created on: Feb 23, 2012
 *      Author: jianghao
 */

#include <jni.h>
#include <jvmti.h>

JNIEXPORT jint JNICALL Agent_OnAttach(JavaVM* vm, char *options,
		void *reserved) {
	return 0;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm) {
	return;
}

