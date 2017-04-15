#include "FieldOpr.h"

void getIntField(JNIEnv* env,jobject obj,jclass clazz){
	jfieldID fieldId = env->GetFieldID(clazz,"field","I");
	jint fieldObj =env->GetIntField(obj,fieldId);
	printf(" Int field is %d \n",fieldObj);

	// 设置java域;
	fflush(stdout);
	env->SetIntField(obj,fieldId,2);
}

void getStringField(JNIEnv* env,jobject obj,jclass clazz){
	//获取java域
	jfieldID strFieldId = env->GetFieldID(clazz,"sField","Ljava/lang/String;");
	jstring strField =(jstring) env->GetObjectField(obj,strFieldId);
	printf(" String field from java is %s \n",env->GetStringUTFChars(strField,NULL));

	//设置java string 域
	string cString = "我是C++设置的域";
	cString = CharSetConvert::ANSIToUTF8(cString);
	const char* data = cString.data();
	jstring jString = env->NewStringUTF(data);
	//env->ReleaseStringUTFChars(jString,data);
	env->SetObjectField(obj,strFieldId,jString);
}

void getArrayField(JNIEnv* env,jobject obj,jclass clazz){
	jfieldID arrayId = env->GetFieldID(clazz,"aField","[B");
	jbyteArray arrayField =(jbyteArray) env->GetObjectField(obj,arrayId);
	jboolean copy;
	char* byteArray =(char*) env->GetByteArrayElements(arrayField,&copy);
	printf("byteArray field from java is %d\n",byteArray[0]);
	if(copy)printf("byte array is copy from java \n");
	else printf("byte array is direct get java \n");
	byteArray[0] = 18;
	jbyteArray newArray = env->NewByteArray(1);
	env->SetByteArrayRegion(newArray,0,1,(jbyte*)byteArray);
	env->SetObjectField(obj,arrayId,newArray);
}

void callJava(JNIEnv* env,jobject obj,jclass clazz){
	//jclass clazz = env->GetObjectClass(obj);
	jstring arg = env->NewStringUTF(CharSetConvert::ANSIToUTF8("C++张洋").data());
	jmethodID mID = env->GetMethodID(clazz,"javaSayHello","(Ljava/lang/String;)V");
	env->CallVoidMethod(obj,mID,arg);
	fflush(stdout);
}