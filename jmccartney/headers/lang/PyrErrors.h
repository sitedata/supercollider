/*
	SuperCollider real time audio synthesis system
    Copyright (c) 2002 James McCartney. All rights reserved.
	http://www.audiosynth.com

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
/*

virtual machine error codes.

*/

#ifndef _SCErrors_
#define _SCErrors_

enum { // primitive errors
	errReturn = -1,	// not really an error.. primitive executed a non-local return
	errNone,
	errFailed = 5000,
	errBadPrimitive,
	errWrongType,
	errIndexNotAnInteger,
	errIndexOutOfRange,
	errImmutableObject,
	errNotAnIndexableObject,
	errRateMismatch,
	errSpectrumMismatch,
	errOutOfMemory,
	errCantCallOS,
	errException,
	
	// fifo errors
        errMsgTooLong,
        errFifoTooFull,
        errFifoEmpty,

	errPropertyNotFound = 6000,
    
    errLastError
};

#endif
