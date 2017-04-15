#include "stdio.h"
#include <jni.h>
#include "string"
#include "CharSetConvert.h"

void getIntField(JNIEnv* env,jobject obj,jclass clazz);

void getStringField(JNIEnv* env,jobject obj,jclass clazz);

void getArrayField(JNIEnv* env,jobject obj,jclass clazz);

void callJava(JNIEnv* env,jobject obj,jclass clazz);
