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

An object archiving system for SuperCollider.

*/

#ifndef _PyrDeepFreezer_
#define _PyrDeepFreezer_

#include "PyrObject.h"
#include "SC_AllocPool.h"
#include "PyrKernel.h"
#include "PyrPrimitive.h"
#include "VMGlobals.h"
#include "GC.h"

const int32 kDeepFreezerObjectArrayInitialCapacity = 32;

class PyrDeepFreezer
{
public:
	PyrDeepFreezer(VMGlobals *inG)
		: g(inG), objectArray(initialObjectArray), numObjects(0), 
			objectArrayCapacity( kDeepCopierObjectArrayInitialCapacity )
		{
		}
	
	~PyrDeepFreezer()
		{
			if (objectArrayCapacity > kDeepCopierObjectArrayInitialCapacity) {
				g->allocPool->Free(objectArray);
			}
		}
			
	long doDeepFreeze(PyrSlot *objectSlot)
		{
			long err = errNone;
				
			try {
				if (IsObj(objectSlot)) {
					constructObjectArray(objectSlot->uo);				
					for (int i=0; i<numObjects; ++i) {
						g->gc->BecomePermanent( objectArray[i] );
					}
				}
			} catch (std::exception &ex) {
				error(ex.what());
				err = errFailed;
			}
			return err;
		}
	
private:
			
	void recurse(PyrObject *obj, int n)
		{	
			PyrSlot *slot = obj->slots;
			for (int i=0; i<n; ++i, ++slot) {
				if (IsObj(slot)) constructObjectArray(slot->uo);
			}
		}

	void growObjectArray()
		{
			int32 newObjectArrayCapacity = objectArrayCapacity << 1;
			
			int32 newSize = newObjectArrayCapacity * sizeof(PyrObject*);
			PyrObject** newArray = (PyrObject**)g->allocPool->Alloc(newSize);
			memcpy(newArray, objectArray, numObjects * sizeof(PyrObject*));
			if (objectArrayCapacity > kDeepCopierObjectArrayInitialCapacity) {
				g->allocPool->Free(objectArray);
			}
			objectArrayCapacity = newObjectArrayCapacity;
			objectArray = newArray;
		}
		
	void putObject(PyrObject *obj)
		{
			obj->SetMark();
			obj->scratch1 = numObjects;
			
			// expand array if needed
			if (numObjects >= objectArrayCapacity) growObjectArray();
			
			// add to array
			objectArray[numObjects++] = obj;
		}

	void constructObjectArray(PyrObject *obj)
			{
				if (obj->IsPermanent()) return;
				
				if (!obj->IsMarked()) {
					if (isKindOf(obj, class_process)) {
						throw std::runtime_error("cannot freeze Process.\n");
					} else if (isKindOf(obj, s_interpreter->u.classobj)) {
						throw std::runtime_error("cannot freeze Interpreter.\n");
					} else if (isKindOf(obj, class_rawarray)) {
						putObject(obj);
					} else if (isKindOf(obj, class_array)) {
						putObject(obj);
						recurse(obj, obj->size);
					} else if (isKindOf(obj, class_func)) {
						if (NotNil(&((PyrClosure*)obj)->block.uoblk->context)) {
							throw std::runtime_error("open Function can not be frozen.\n");
						}
						putObject(obj);
						recurse(obj, obj->size);
					} else if (isKindOf(obj, class_method)) {
						throw std::runtime_error("cannot freeze Methods.\n");
					} else if (isKindOf(obj, class_thread)) {
						throw std::runtime_error("cannot freeze Threads.\n");
					} else if (isKindOf(obj, class_frame)) {
						throw std::runtime_error("cannot freeze Frames.\n");
					} else {
						putObject(obj);
						recurse(obj, obj->size);
					}
				}
			}
			
	VMGlobals *g;
		
	PyrObject **objectArray;
	int32 numObjects;
	int32 objectArrayCapacity;
		
	PyrObject *initialObjectArray[kDeepCopierObjectArrayInitialCapacity];
};

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

An object archiving system for SuperCollider.

*/



#endif

