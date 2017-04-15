#pragma once
#include "site_luoyu_jni_JniHello.h"
#include "stdlib.h"
#include "stdio.h"
#include "FieldOpr.h"
#include "CharSetConvert.h"

//ȫ��clazz
static jclass clazz = 0;

JNIEXPORT jint JNICALL Java_site_luoyu_jni_JniHello_SayHellow(JNIEnv * env, jobject obj,jint data){
	printf("data From java is %d \n",data);
	jint ret = 1;
	fflush(stdout);
	return ret;
}

JNIEXPORT jstring JNICALL Java_site_luoyu_jni_JniHello_tellName(JNIEnv * env, jobject obj, jstring name){
	//��jstring���char*
	const char* jNameChar = env->GetStringUTFChars(name,NULL);
	//����ת��
	string jString = "��java ��������� ��%s\n"; 
	jString = CharSetConvert::ANSIToUTF8(jString);
	char* test = new char[100];
	sprintf(test,jString.data(),jNameChar);
	printf(test);

	string cString = "C++ ����";
	/*
	//////////////hex���
	for (int i = 0; i < cString.length(); i++)
	{
		printf("%x ",cString.at(i) & 0xff);
	}
	printf("\n");
	////////////////�鿴
	*/
	cString = CharSetConvert::ANSIToUTF8(cString);

	jstring ret = env->NewStringUTF(cString.data());
	fflush(stdout);
	return ret;
}

JNIEXPORT jbyteArray JNICALL Java_site_luoyu_jni_JniHello_getBytes(JNIEnv * env, jobject obj, jbyteArray bArray){
	//C++ ����תjava jbyte
	string cString = "����C++����";
	cString = CharSetConvert::ANSIToUTF8(cString);
	const char* data = cString.data();
	jbyte* myByte = (jbyte*)data;
	int cStringLen = cString.length();
	jbyteArray res = env->NewByteArray(cStringLen);
	env->SetByteArrayRegion(res,0,cStringLen,myByte);

	//java byteArray תC++
	jsize length = env->GetArrayLength(bArray);
	char* jData = new char[length];
	jData = (char *) env->GetByteArrayElements(bArray,NULL);
	//env->GetByteArrayRegion(bArray,0,length,(jbyte*)jData);
	jData[length] = '\0';
	printf("%s\n",jData);
	fflush(stdout);
	return res;
}

JNIEXPORT void JNICALL Java_site_luoyu_jni_JniHello_setField(JNIEnv * env, jobject obj){
	if(clazz == 0){
		clazz = env->GetObjectClass(obj);
		//clazz = env->NewGlobalRef(cx);
	}
	//��ȡ������
	getIntField(env,obj,clazz);
	//��ȡ�ַ�����
	getStringField(env,obj,clazz);
	//��ȡ������
	getArrayField(env,obj,clazz);
	//����java����
	callJava(env,obj,clazz);
}