#ifndef _CharSetConvert_
#define _CharSetConvert_
#include "string"
#include <windows.h>
#include <malloc.h>

using std::string;
using std::wstring;

class CharSetConvert
{
public:
	static string UnicodeToUTF8 ( const wstring& str );
	static string UnicodeToANSI ( const wstring& str );
	static wstring ANSIToUnicode ( const string& str );
	static wstring UTF8ToUnicode ( const string& str );
	static string ANSIToUTF8(const string& str);
	static string UTF8ToANSI(const string& str);
public:
	CharSetConvert();
	~CharSetConvert();
};
#endif