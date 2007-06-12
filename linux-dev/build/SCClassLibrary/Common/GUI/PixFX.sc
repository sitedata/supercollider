// these are all experimental and may be replaced.

PixFX {
	var <>bounds;
	layout { arg argBounds;
		bounds = argBounds;
	}
}

BWPix : PixFX {
	*new { arg bounds;
		^super.newCopyArgs(bounds);
	}
	draw {
		_BWPix_Draw
		^this.primitiveFailed;
	}
}

HFlipPix : PixFX {
	*new { arg bounds;
		^super.newCopyArgs(bounds);
	}
	draw {
		_HFlipPix_Draw
		^this.primitiveFailed;
	}
}

VFlipPix : PixFX {
	*new { arg bounds;
		^super.newCopyArgs(bounds);
	}
	draw {
		_VFlipPix_Draw
		^this.primitiveFailed;
	}
}

HMirrorPix : PixFX {
	*new { arg bounds;
		^super.newCopyArgs(bounds);
	}
	draw {
		_HMirrorPix_Draw
		^this.primitiveFailed;
	}
}

VMirrorPix : PixFX {
	*new { arg bounds;
		^super.newCopyArgs(bounds);
	}
	draw {
		_VMirrorPix_Draw
		^this.primitiveFailed;
	}
}

OffsetPix : PixFX {
	var <>x, <>y;
	
	*new { arg bounds, x, y;
		^super.newCopyArgs(bounds, x, y);
	}
	draw {
		_OffsetPix_Draw
		^this.primitiveFailed;
	}
}

ScramblePix : OffsetPix {
	draw {
		_ScramblePix_Draw
		^this.primitiveFailed;
	}
}

MosaicPix : OffsetPix {
	draw {
		_MosaicPix_Draw
		^this.primitiveFailed;
	}
}

MosaicBlurPix : OffsetPix {
	draw {
		_MosaicBlurPix_Draw
		^this.primitiveFailed;
	}
}

HRandOffsetPix : PixFX {
	var <>xoffset;
	
	*new { arg bounds, xoffset;
		^super.newCopyArgs(bounds, xoffset);
	}
	draw {
		_HRandOffsetPix_Draw
		^this.primitiveFailed;
	}
}

PosterizePix : PixFX {
	var <>levels, <>phase;
	
	*new { arg bounds, levels, phase;
		^super.newCopyArgs(bounds, levels, phase);
	}
	draw {
		_PosterizePix_Draw
		^this.primitiveFailed;
	}
}


ContrastBrightnessPix : PixFX {
	var <>contrast, <>brightness;
	
	*new { arg bounds, contrast, brightness;
		^super.newCopyArgs(bounds, contrast, brightness);
	}
	draw {
		_ContrastBrightnessPix_Draw
		^this.primitiveFailed;
	}
}

MultiScanPix : PixFX {
	var <>xscan, <>yscan, <>x, <>y;
	
	*new { arg bounds, xscan, yscan, x, y;
		^super.newCopyArgs(bounds, xscan, yscan, x, y);
	}
	draw {
		_MultiScanPix_Draw
		^this.primitiveFailed;
	}
}


MultiScan2Pix : PixFX {
	var <>xscan, <>yscan, <>x, <>y;
	
	*new { arg bounds, xscan, yscan, x, y;
		^super.newCopyArgs(bounds, xscan, yscan, x, y);
	}
	draw {
		_MultiScan2Pix_Draw
		^this.primitiveFailed;
	}
}

MultiScan3Pix : PixFX {
	var <>rate, <>x, <>y;
	
	*new { arg bounds, rate, x, y;
		^super.newCopyArgs(bounds, rate, x, y);
	}
	draw {
		_MultiScan3Pix_Draw
		^this.primitiveFailed;
	}
}

