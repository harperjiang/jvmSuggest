/*
 * main.cpp
 *
 *  Created on: Feb 23, 2012
 *      Author: jianghao
 */

#include "jni.h"
#include "jvmti.h"

jvmtiEnv* tiEnv;

void checkError(jint retval) {

}

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM* vm, char* options, void* reserved) {

}

JNIEXPORT jint JNICALL Agent_OnAttach(JavaVM* vm, char *options,
		void *reserved) {
	checkError(vm->GetEnv((void**) &tiEnv, JVMTI_VERSION));
	return 0;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm) {
	checkError(tiEnv->DisposeEnvironment());
	return;
}

