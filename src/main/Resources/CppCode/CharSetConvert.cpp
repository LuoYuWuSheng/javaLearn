#include "CharSetConvert.h"


CharSetConvert::CharSetConvert()
{
}


CharSetConvert::~CharSetConvert()
{
}


string CharSetConvert::UnicodeToUTF8 ( const wstring& str )
{
	char* pElementText;
	int iTextLen;
	// wide char to multi char
	iTextLen = WideCharToMultiByte ( CP_UTF8, 0, str.c_str(), -1, NULL, 0, NULL, NULL );
	pElementText = new char[iTextLen + 1];
	memset ( ( void* ) pElementText, 0, sizeof ( char ) * ( iTextLen + 1 ) );
	::WideCharToMultiByte ( CP_UTF8, 0, str.c_str(), -1, pElementText, iTextLen, NULL, NULL );
	string strText;
	strText = pElementText;
	delete[] pElementText;
	return strText;
}


wstring CharSetConvert::ANSIToUnicode ( const string& str )
{
	int len = 0;
	len = str.length();
	int  unicodeLen = ::MultiByteToWideChar ( CP_ACP, 0, str.c_str(), -1, NULL, 0 );
	wchar_t *  pUnicode;
	pUnicode = new wchar_t[unicodeLen + 1];
	memset ( pUnicode, 0, ( unicodeLen + 1 ) *sizeof ( wchar_t ) );
	::MultiByteToWideChar ( CP_ACP, 0, str.c_str(), -1, ( LPWSTR ) pUnicode, unicodeLen );
	wstring  rt;
	rt = ( wchar_t* ) pUnicode;
	delete[] pUnicode;
	return  rt;
}


wstring CharSetConvert::UTF8ToUnicode ( const string& str )
{
	int  len = 0;
	len = str.length();
	int  unicodeLen = ::MultiByteToWideChar ( CP_UTF8, 0, str.c_str(), -1, NULL, 0 );
	wchar_t *  pUnicode;
	pUnicode = new wchar_t[unicodeLen + 1];
	memset ( pUnicode, 0, ( unicodeLen + 1 ) *sizeof ( wchar_t ) );
	::MultiByteToWideChar ( CP_UTF8, 0, str.c_str(), -1, ( LPWSTR ) pUnicode, unicodeLen );
	wstring  rt;
	rt = ( wchar_t* ) pUnicode;
	delete[] pUnicode;
	return  rt;
}


string CharSetConvert::UnicodeToANSI ( const wstring& str )
{
	char* pElementText;
	int iTextLen;
	// wide char to multi char
	iTextLen = WideCharToMultiByte ( CP_ACP, 0, str.c_str(), -1, NULL, 0, NULL, NULL );
	pElementText = new char[iTextLen + 1];
	memset ( ( void* ) pElementText, 0, sizeof ( char ) * ( iTextLen + 1 ) );
	::WideCharToMultiByte ( CP_ACP, 0, str.c_str(), -1, pElementText, iTextLen, NULL, NULL );
	string strText;
	strText = pElementText;
	delete[] pElementText;
	return strText;
}

string CharSetConvert::ANSIToUTF8 ( const string& str )
{
	return UnicodeToUTF8 ( ANSIToUnicode ( str ) );
}

string CharSetConvert::UTF8ToANSI ( const string& str )
{
	return UnicodeToANSI ( UTF8ToUnicode ( str ) );
}