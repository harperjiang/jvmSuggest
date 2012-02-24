/*
 * thread_info.h
 *
 *  Created on: Feb 23, 2012
 *      Author: jianghao
 */

#ifndef THREAD_INFO_H_
#define THREAD_INFO_H_

class ThreadInfo {
private:
	// The thread this ThreadInfo associated to
	jthread* thread;
	// The bytes allocated by this thread
	jint allocated;
	// The thread counts this thread blocked
	jint blocked;
public:
	ThreadInfo();
	virtual ~ThreadInfo();
};

#endif /* THREAD_INFO_H_ */
