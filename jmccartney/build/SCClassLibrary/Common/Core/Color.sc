{\rtf1\mac\ansicpg10000\cocoartf100
{\fonttbl\f0\fnil\fcharset77 Monaco;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue191;\red0\green115\blue0;\red191\green0\blue0;
}
\pard\tx560\tx1120\tx1680\tx2240\tx2800\tx3360\tx3920\tx4480\tx5040\tx5600\tx6160\tx6720\ql\qnatural

\f0\fs18 \cf2 Color\cf0  \{	\
	\cf2 var\cf0  <>red, <>green, <>blue, <>alpha;\
\
	*new \{ \cf2 arg\cf0  red=0.0, green=0.0, blue=0.0, alpha=1.0;\
		^\cf2 super\cf0 .newCopyArgs(red, green, blue, alpha);\
	\}\
	*fromArray \{ \cf2 arg\cf0  array;\
		^\cf2 this\cf0 .performList(\cf3 \\new\cf0 , array)\
	\}\
	*black \{ ^\cf2 Color\cf0 (0.0, 0.0, 0.0) \}\
	*white \{ ^\cf2 Color\cf0 (1.0, 1.0, 1.0) \}\
	*red \{ arg val = 1.0, alpha = 1.0; ^\cf2 Color\cf0 (val, 0.0, 0.0, alpha) \}\
	*green \{ arg val = 1.0, alpha = 1.0; ^\cf2 Color\cf0 (0.0, val, 0.0, alpha) \}\
	*yellow \{ arg val = 1.0, alpha = 1.0; ^\cf2 Color\cf0 (val, val, 0.0, alpha) \}\
	*blue \{ arg val = 1.0, alpha = 1.0; ^\cf2 Color\cf0 (0.0, 0.0, val, alpha) \}\
	*clear \{ ^\cf2 Color\cf0 (0.0, 0.0, 0.0, 0.0) \}\
	*grey \{ \cf2 arg\cf0  grey = 0.5, alpha = 1.0;\
		^\cf2 Color\cf0 (grey, grey, grey, alpha);\
	\}\
	*rand \{ arg lo=0.3,hi=0.9; ^Color(rrand(lo,hi),rrand(lo,hi),rrand(lo,hi)) \}\
\
	setStroke \{\
		\cf2 _Color_SetStroke\cf0 \
		^\cf2 this\cf0 .primitiveFailed\
	\}\
	setFill \{\
		\cf2 _Color_SetFill\cf0 \
		^\cf2 this\cf0 .primitiveFailed\
	\}\
	set \{\
		\cf2 this\cf0 .setStroke.setFill;\
	\}\
\
	scaleByAlpha \{\
		^\cf2 Color\cf0 (red * alpha, green * alpha, blue * alpha, 1.0)\
	\}\
	blend \{ \cf2 arg\cf0  that, blend;\
		^\cf2 Color\cf0 .fromArray(blend(\cf2 this\cf0 .asArray, that.asArray, blend));\
	\}\
	asArray \{ ^[red, green, blue, alpha] \}\
\}\
\
\cf4 /*	X-windows colors :\
\
IdentityDictionary[\
    'alice blue' -> rgb(240, 248, 255),\
    'AliceBlue' -> rgb(240, 248, 255),\
    'antique white' -> rgb(250, 235, 215),\
    'AntiqueWhite' -> rgb(250, 235, 215),\
    'AntiqueWhite1' -> rgb(255, 239, 219),\
    'AntiqueWhite2' -> rgb(238, 223, 204),\
    'AntiqueWhite3' -> rgb(205, 192, 176),\
    'AntiqueWhite4' -> rgb(139, 131, 120),\
    'aquamarine' -> rgb(127, 255, 212),\
    'aquamarine1' -> rgb(127, 255, 212),\
    'aquamarine2' -> rgb(118, 238, 198),\
    'aquamarine3' -> rgb(102, 205, 170),\
    'aquamarine4' -> rgb(69, 139, 116),\
    'azure' -> rgb(240, 255, 255),\
    'azure1' -> rgb(240, 255, 255),\
    'azure2' -> rgb(224, 238, 238),\
    'azure3' -> rgb(193, 205, 205),\
    'azure4' -> rgb(131, 139, 139),\
    'beige' -> rgb(245, 245, 220),\
    'bisque' -> rgb(255, 228, 196),\
    'bisque1' -> rgb(255, 228, 196),\
    'bisque2' -> rgb(238, 213, 183),\
    'bisque3' -> rgb(205, 183, 158),\
    'bisque4' -> rgb(139, 125, 107),\
    'black' -> rgb(0, 0, 0),\
    'blanched almond' -> rgb(255, 235, 205),\
    'BlanchedAlmond' -> rgb(255, 235, 205),\
    'blue' -> rgb(0, 0, 255),\
    'blue violet' -> rgb(138, 43, 226),\
    'blue1' -> rgb(0, 0, 255),\
    'blue2' -> rgb(0, 0, 238),\
    'blue3' -> rgb(0, 0, 205),\
    'blue4' -> rgb(0, 0, 139),\
    'BlueViolet' -> rgb(138, 43, 226),\
    'brown' -> rgb(165, 42, 42),\
    'brown1' -> rgb(255, 64, 64),\
    'brown2' -> rgb(238, 59, 59),\
    'brown3' -> rgb(205, 51, 51),\
    'brown4' -> rgb(139, 35, 35),\
    'burlywood' -> rgb(222, 184, 135),\
    'burlywood1' -> rgb(255, 211, 155),\
    'burlywood2' -> rgb(238, 197, 145),\
    'burlywood3' -> rgb(205, 170, 125),\
    'burlywood4' -> rgb(139, 115, 85),\
    'cadet blue' -> rgb(95, 158, 160),\
    'CadetBlue' -> rgb(95, 158, 160),\
    'CadetBlue1' -> rgb(152, 245, 255),\
    'CadetBlue2' -> rgb(142, 229, 238),\
    'CadetBlue3' -> rgb(122, 197, 205),\
    'CadetBlue4' -> rgb(83, 134, 139),\
    'chartreuse' -> rgb(127, 255, 0),\
    'chartreuse1' -> rgb(127, 255, 0),\
    'chartreuse2' -> rgb(118, 238, 0),\
    'chartreuse3' -> rgb(102, 205, 0),\
    'chartreuse4' -> rgb(69, 139, 0),\
    'chocolate' -> rgb(210, 105, 30),\
    'chocolate1' -> rgb(255, 127, 36),\
    'chocolate2' -> rgb(238, 118, 33),\
    'chocolate3' -> rgb(205, 102, 29),\
    'chocolate4' -> rgb(139, 69, 19),\
    'coral' -> rgb(255, 127, 80),\
    'coral1' -> rgb(255, 114, 86),\
    'coral2' -> rgb(238, 106, 80),\
    'coral3' -> rgb(205, 91, 69),\
    'coral4' -> rgb(139, 62, 47),\
    'cornflower blue' -> rgb(100, 149, 237),\
    'CornflowerBlue' -> rgb(100, 149, 237),\
    'cornsilk' -> rgb(255, 248, 220),\
    'cornsilk1' -> rgb(255, 248, 220),\
    'cornsilk2' -> rgb(238, 232, 205),\
    'cornsilk3' -> rgb(205, 200, 177),\
    'cornsilk4' -> rgb(139, 136, 120),\
    'cyan' -> rgb(0, 255, 255),\
    'cyan1' -> rgb(0, 255, 255),\
    'cyan2' -> rgb(0, 238, 238),\
    'cyan3' -> rgb(0, 205, 205),\
    'cyan4' -> rgb(0, 139, 139),\
    'dark goldenrod' -> rgb(184, 134, 11),\
    'dark green' -> rgb(0, 100, 0),\
    'dark khaki' -> rgb(189, 183, 107),\
    'dark olive green' -> rgb(85, 107, 47),\
    'dark orange' -> rgb(255, 140, 0),\
    'dark orchid' -> rgb(153, 50, 204),\
    'dark salmon' -> rgb(233, 150, 122),\
    'dark sea green' -> rgb(143, 188, 143),\
    'dark slate blue' -> rgb(72, 61, 139),\
    'dark slate gray' -> rgb(47, 79, 79),\
    'dark slate grey' -> rgb(47, 79, 79),\
    'dark turquoise' -> rgb(0, 206, 209),\
    'dark violet' -> rgb(148, 0, 211),\
    'DarkGoldenrod' -> rgb(184, 134, 11),\
    'DarkGoldenrod1' -> rgb(255, 185, 15),\
    'DarkGoldenrod2' -> rgb(238, 173, 14),\
    'DarkGoldenrod3' -> rgb(205, 149, 12),\
    'DarkGoldenrod4' -> rgb(139, 101, 8),\
    'DarkGreen' -> rgb(0, 100, 0),\
    'DarkKhaki' -> rgb(189, 183, 107),\
    'DarkOliveGreen' -> rgb(85, 107, 47),\
    'DarkOliveGreen1' -> rgb(202, 255, 112),\
    'DarkOliveGreen2' -> rgb(188, 238, 104),\
    'DarkOliveGreen3' -> rgb(162, 205, 90),\
    'DarkOliveGreen4' -> rgb(110, 139, 61),\
    'DarkOrange' -> rgb(255, 140, 0),\
    'DarkOrange1' -> rgb(255, 127, 0),\
    'DarkOrange2' -> rgb(238, 118, 0),\
    'DarkOrange3' -> rgb(205, 102, 0),\
    'DarkOrange4' -> rgb(139, 69, 0),\
    'DarkOrchid' -> rgb(153, 50, 204),\
    'DarkOrchid1' -> rgb(191, 62, 255),\
    'DarkOrchid2' -> rgb(178, 58, 238),\
    'DarkOrchid3' -> rgb(154, 50, 205),\
    'DarkOrchid4' -> rgb(104, 34, 139),\
    'DarkSalmon' -> rgb(233, 150, 122),\
    'DarkSeaGreen' -> rgb(143, 188, 143),\
    'DarkSeaGreen1' -> rgb(193, 255, 193),\
    'DarkSeaGreen2' -> rgb(180, 238, 180),\
    'DarkSeaGreen3' -> rgb(155, 205, 155),\
    'DarkSeaGreen4' -> rgb(105, 139, 105),\
    'DarkSlateBlue' -> rgb(72, 61, 139),\
    'DarkSlateGray' -> rgb(47, 79, 79),\
    'DarkSlateGray1' -> rgb(151, 255, 255),\
    'DarkSlateGray2' -> rgb(141, 238, 238),\
    'DarkSlateGray3' -> rgb(121, 205, 205),\
    'DarkSlateGray4' -> rgb(82, 139, 139),\
    'DarkSlateGrey' -> rgb(47, 79, 79),\
    'DarkTurquoise' -> rgb(0, 206, 209),\
    'DarkViolet' -> rgb(148, 0, 211),\
    'deep pink' -> rgb(255, 20, 147),\
    'deep sky blue' -> rgb(0, 191, 255),\
    'DeepPink' -> rgb(255, 20, 147),\
    'DeepPink1' -> rgb(255, 20, 147),\
    'DeepPink2' -> rgb(238, 18, 137),\
    'DeepPink3' -> rgb(205, 16, 118),\
    'DeepPink4' -> rgb(139, 10, 80),\
    'DeepSkyBlue' -> rgb(0, 191, 255),\
    'DeepSkyBlue1' -> rgb(0, 191, 255),\
    'DeepSkyBlue2' -> rgb(0, 178, 238),\
    'DeepSkyBlue3' -> rgb(0, 154, 205),\
    'DeepSkyBlue4' -> rgb(0, 104, 139),\
    'dim gray' -> rgb(105, 105, 105),\
    'dim grey' -> rgb(105, 105, 105),\
    'DimGray' -> rgb(105, 105, 105),\
    'DimGrey' -> rgb(105, 105, 105),\
    'dodger blue' -> rgb(30, 144, 255),\
    'DodgerBlue' -> rgb(30, 144, 255),\
    'DodgerBlue1' -> rgb(30, 144, 255),\
    'DodgerBlue2' -> rgb(28, 134, 238),\
    'DodgerBlue3' -> rgb(24, 116, 205),\
    'DodgerBlue4' -> rgb(16, 78, 139),\
    'firebrick' -> rgb(178, 34, 34),\
    'firebrick1' -> rgb(255, 48, 48),\
    'firebrick2' -> rgb(238, 44, 44),\
    'firebrick3' -> rgb(205, 38, 38),\
    'firebrick4' -> rgb(139, 26, 26),\
    'floral white' -> rgb(255, 250, 240),\
    'FloralWhite' -> rgb(255, 250, 240),\
    'forest green' -> rgb(34, 139, 34),\
    'ForestGreen' -> rgb(34, 139, 34),\
    'gainsboro' -> rgb(220, 220, 220),\
    'ghost white' -> rgb(248, 248, 255),\
    'GhostWhite' -> rgb(248, 248, 255),\
    'gold' -> rgb(255, 215, 0),\
    'gold1' -> rgb(255, 215, 0),\
    'gold2' -> rgb(238, 201, 0),\
    'gold3' -> rgb(205, 173, 0),\
    'gold4' -> rgb(139, 117, 0),\
    'goldenrod' -> rgb(218, 165, 32),\
    'goldenrod1' -> rgb(255, 193, 37),\
    'goldenrod2' -> rgb(238, 180, 34),\
    'goldenrod3' -> rgb(205, 155, 29),\
    'goldenrod4' -> rgb(139, 105, 20),\
    'gray' -> rgb(190, 190, 190),\
    'gray0' -> rgb(0, 0, 0),\
    'gray1' -> rgb(3, 3, 3),\
    'gray10' -> rgb(26, 26, 26),\
    'gray100' -> rgb(255, 255, 255),\
    'gray11' -> rgb(28, 28, 28),\
    'gray12' -> rgb(31, 31, 31),\
    'gray13' -> rgb(33, 33, 33),\
    'gray14' -> rgb(36, 36, 36),\
    'gray15' -> rgb(38, 38, 38),\
    'gray16' -> rgb(41, 41, 41),\
    'gray17' -> rgb(43, 43, 43),\
    'gray18' -> rgb(46, 46, 46),\
    'gray19' -> rgb(48, 48, 48),\
    'gray2' -> rgb(5, 5, 5),\
    'gray20' -> rgb(51, 51, 51),\
    'gray21' -> rgb(54, 54, 54),\
    'gray22' -> rgb(56, 56, 56),\
    'gray23' -> rgb(59, 59, 59),\
    'gray24' -> rgb(61, 61, 61),\
    'gray25' -> rgb(64, 64, 64),\
    'gray26' -> rgb(66, 66, 66),\
    'gray27' -> rgb(69, 69, 69),\
    'gray28' -> rgb(71, 71, 71),\
    'gray29' -> rgb(74, 74, 74),\
    'gray3' -> rgb(8, 8, 8),\
    'gray30' -> rgb(77, 77, 77),\
    'gray31' -> rgb(79, 79, 79),\
    'gray32' -> rgb(82, 82, 82),\
    'gray33' -> rgb(84, 84, 84),\
    'gray34' -> rgb(87, 87, 87),\
    'gray35' -> rgb(89, 89, 89),\
    'gray36' -> rgb(92, 92, 92),\
    'gray37' -> rgb(94, 94, 94),\
    'gray38' -> rgb(97, 97, 97),\
    'gray39' -> rgb(99, 99, 99),\
    'gray4' -> rgb(10, 10, 10),\
    'gray40' -> rgb(102, 102, 102),\
    'gray41' -> rgb(105, 105, 105),\
    'gray42' -> rgb(107, 107, 107),\
    'gray43' -> rgb(110, 110, 110),\
    'gray44' -> rgb(112, 112, 112),\
    'gray45' -> rgb(115, 115, 115),\
    'gray46' -> rgb(117, 117, 117),\
    'gray47' -> rgb(120, 120, 120),\
    'gray48' -> rgb(122, 122, 122),\
    'gray49' -> rgb(125, 125, 125),\
    'gray5' -> rgb(13, 13, 13),\
    'gray50' -> rgb(127, 127, 127),\
    'gray51' -> rgb(130, 130, 130),\
    'gray52' -> rgb(133, 133, 133),\
    'gray53' -> rgb(135, 135, 135),\
    'gray54' -> rgb(138, 138, 138),\
    'gray55' -> rgb(140, 140, 140),\
    'gray56' -> rgb(143, 143, 143),\
    'gray57' -> rgb(145, 145, 145),\
    'gray58' -> rgb(148, 148, 148),\
    'gray59' -> rgb(150, 150, 150),\
    'gray6' -> rgb(15, 15, 15),\
    'gray60' -> rgb(153, 153, 153),\
    'gray61' -> rgb(156, 156, 156),\
    'gray62' -> rgb(158, 158, 158),\
    'gray63' -> rgb(161, 161, 161),\
    'gray64' -> rgb(163, 163, 163),\
    'gray65' -> rgb(166, 166, 166),\
    'gray66' -> rgb(168, 168, 168),\
    'gray67' -> rgb(171, 171, 171),\
    'gray68' -> rgb(173, 173, 173),\
    'gray69' -> rgb(176, 176, 176),\
    'gray7' -> rgb(18, 18, 18),\
    'gray70' -> rgb(179, 179, 179),\
    'gray71' -> rgb(181, 181, 181),\
    'gray72' -> rgb(184, 184, 184),\
    'gray73' -> rgb(186, 186, 186),\
    'gray74' -> rgb(189, 189, 189),\
    'gray75' -> rgb(191, 191, 191),\
    'gray76' -> rgb(194, 194, 194),\
    'gray77' -> rgb(196, 196, 196),\
    'gray78' -> rgb(199, 199, 199),\
    'gray79' -> rgb(201, 201, 201),\
    'gray8' -> rgb(20, 20, 20),\
    'gray80' -> rgb(204, 204, 204),\
    'gray81' -> rgb(207, 207, 207),\
    'gray82' -> rgb(209, 209, 209),\
    'gray83' -> rgb(212, 212, 212),\
    'gray84' -> rgb(214, 214, 214),\
    'gray85' -> rgb(217, 217, 217),\
    'gray86' -> rgb(219, 219, 219),\
    'gray87' -> rgb(222, 222, 222),\
    'gray88' -> rgb(224, 224, 224),\
    'gray89' -> rgb(227, 227, 227),\
    'gray9' -> rgb(23, 23, 23),\
    'gray90' -> rgb(229, 229, 229),\
    'gray91' -> rgb(232, 232, 232),\
    'gray92' -> rgb(235, 235, 235),\
    'gray93' -> rgb(237, 237, 237),\
    'gray94' -> rgb(240, 240, 240),\
    'gray95' -> rgb(242, 242, 242),\
    'gray96' -> rgb(245, 245, 245),\
    'gray97' -> rgb(247, 247, 247),\
    'gray98' -> rgb(250, 250, 250),\
    'gray99' -> rgb(252, 252, 252),\
    'green' -> rgb(0, 255, 0),\
    'green yellow' -> rgb(173, 255, 47),\
    'green1' -> rgb(0, 255, 0),\
    'green2' -> rgb(0, 238, 0),\
    'green3' -> rgb(0, 205, 0),\
    'green4' -> rgb(0, 139, 0),\
    'GreenYellow' -> rgb(173, 255, 47),\
    'grey' -> rgb(190, 190, 190),\
    'grey0' -> rgb(0, 0, 0),\
    'grey1' -> rgb(3, 3, 3),\
    'grey10' -> rgb(26, 26, 26),\
    'grey100' -> rgb(255, 255, 255),\
    'grey11' -> rgb(28, 28, 28),\
    'grey12' -> rgb(31, 31, 31),\
    'grey13' -> rgb(33, 33, 33),\
    'grey14' -> rgb(36, 36, 36),\
    'grey15' -> rgb(38, 38, 38),\
    'grey16' -> rgb(41, 41, 41),\
    'grey17' -> rgb(43, 43, 43),\
    'grey18' -> rgb(46, 46, 46),\
    'grey19' -> rgb(48, 48, 48),\
    'grey2' -> rgb(5, 5, 5),\
    'grey20' -> rgb(51, 51, 51),\
    'grey21' -> rgb(54, 54, 54),\
    'grey22' -> rgb(56, 56, 56),\
    'grey23' -> rgb(59, 59, 59),\
    'grey24' -> rgb(61, 61, 61),\
    'grey25' -> rgb(64, 64, 64),\
    'grey26' -> rgb(66, 66, 66),\
    'grey27' -> rgb(69, 69, 69),\
    'grey28' -> rgb(71, 71, 71),\
    'grey29' -> rgb(74, 74, 74),\
    'grey3' -> rgb(8, 8, 8),\
    'grey30' -> rgb(77, 77, 77),\
    'grey31' -> rgb(79, 79, 79),\
    'grey32' -> rgb(82, 82, 82),\
    'grey33' -> rgb(84, 84, 84),\
    'grey34' -> rgb(87, 87, 87),\
    'grey35' -> rgb(89, 89, 89),\
    'grey36' -> rgb(92, 92, 92),\
    'grey37' -> rgb(94, 94, 94),\
    'grey38' -> rgb(97, 97, 97),\
    'grey39' -> rgb(99, 99, 99),\
    'grey4' -> rgb(10, 10, 10),\
    'grey40' -> rgb(102, 102, 102),\
    'grey41' -> rgb(105, 105, 105),\
    'grey42' -> rgb(107, 107, 107),\
    'grey43' -> rgb(110, 110, 110),\
    'grey44' -> rgb(112, 112, 112),\
    'grey45' -> rgb(115, 115, 115),\
    'grey46' -> rgb(117, 117, 117),\
    'grey47' -> rgb(120, 120, 120),\
    'grey48' -> rgb(122, 122, 122),\
    'grey49' -> rgb(125, 125, 125),\
    'grey5' -> rgb(13, 13, 13),\
    'grey50' -> rgb(127, 127, 127),\
    'grey51' -> rgb(130, 130, 130),\
    'grey52' -> rgb(133, 133, 133),\
    'grey53' -> rgb(135, 135, 135),\
    'grey54' -> rgb(138, 138, 138),\
    'grey55' -> rgb(140, 140, 140),\
    'grey56' -> rgb(143, 143, 143),\
    'grey57' -> rgb(145, 145, 145),\
    'grey58' -> rgb(148, 148, 148),\
    'grey59' -> rgb(150, 150, 150),\
    'grey6' -> rgb(15, 15, 15),\
    'grey60' -> rgb(153, 153, 153),\
    'grey61' -> rgb(156, 156, 156),\
    'grey62' -> rgb(158, 158, 158),\
    'grey63' -> rgb(161, 161, 161),\
    'grey64' -> rgb(163, 163, 163),\
    'grey65' -> rgb(166, 166, 166),\
    'grey66' -> rgb(168, 168, 168),\
    'grey67' -> rgb(171, 171, 171),\
    'grey68' -> rgb(173, 173, 173),\
    'grey69' -> rgb(176, 176, 176),\
    'grey7' -> rgb(18, 18, 18),\
    'grey70' -> rgb(179, 179, 179),\
    'grey71' -> rgb(181, 181, 181),\
    'grey72' -> rgb(184, 184, 184),\
    'grey73' -> rgb(186, 186, 186),\
    'grey74' -> rgb(189, 189, 189),\
    'grey75' -> rgb(191, 191, 191),\
    'grey76' -> rgb(194, 194, 194),\
    'grey77' -> rgb(196, 196, 196),\
    'grey78' -> rgb(199, 199, 199),\
    'grey79' -> rgb(201, 201, 201),\
    'grey8' -> rgb(20, 20, 20),\
    'grey80' -> rgb(204, 204, 204),\
    'grey81' -> rgb(207, 207, 207),\
    'grey82' -> rgb(209, 209, 209),\
    'grey83' -> rgb(212, 212, 212),\
    'grey84' -> rgb(214, 214, 214),\
    'grey85' -> rgb(217, 217, 217),\
    'grey86' -> rgb(219, 219, 219),\
    'grey87' -> rgb(222, 222, 222),\
    'grey88' -> rgb(224, 224, 224),\
    'grey89' -> rgb(227, 227, 227),\
    'grey9' -> rgb(23, 23, 23),\
    'grey90' -> rgb(229, 229, 229),\
    'grey91' -> rgb(232, 232, 232),\
    'grey92' -> rgb(235, 235, 235),\
    'grey93' -> rgb(237, 237, 237),\
    'grey94' -> rgb(240, 240, 240),\
    'grey95' -> rgb(242, 242, 242),\
    'grey96' -> rgb(245, 245, 245),\
    'grey97' -> rgb(247, 247, 247),\
    'grey98' -> rgb(250, 250, 250),\
    'grey99' -> rgb(252, 252, 252),\
    'honeydew' -> rgb(240, 255, 240),\
    'honeydew1' -> rgb(240, 255, 240),\
    'honeydew2' -> rgb(224, 238, 224),\
    'honeydew3' -> rgb(193, 205, 193),\
    'honeydew4' -> rgb(131, 139, 131),\
    'hot pink' -> rgb(255, 105, 180),\
    'HotPink' -> rgb(255, 105, 180),\
    'HotPink1' -> rgb(255, 110, 180),\
    'HotPink2' -> rgb(238, 106, 167),\
    'HotPink3' -> rgb(205, 96, 144),\
    'HotPink4' -> rgb(139, 58, 98),\
    'indian red' -> rgb(205, 92, 92),\
    'IndianRed' -> rgb(205, 92, 92),\
    'IndianRed1' -> rgb(255, 106, 106),\
    'IndianRed2' -> rgb(238, 99, 99),\
    'IndianRed3' -> rgb(205, 85, 85),\
    'IndianRed4' -> rgb(139, 58, 58),\
    'ivory' -> rgb(255, 255, 240),\
    'ivory1' -> rgb(255, 255, 240),\
    'ivory2' -> rgb(238, 238, 224),\
    'ivory3' -> rgb(205, 205, 193),\
    'ivory4' -> rgb(139, 139, 131),\
    'khaki' -> rgb(240, 230, 140),\
    'khaki1' -> rgb(255, 246, 143),\
    'khaki2' -> rgb(238, 230, 133),\
    'khaki3' -> rgb(205, 198, 115),\
    'khaki4' -> rgb(139, 134, 78),\
    'lavender' -> rgb(230, 230, 250),\
    'lavender blush' -> rgb(255, 240, 245),\
    'LavenderBlush' -> rgb(255, 240, 245),\
    'LavenderBlush1' -> rgb(255, 240, 245),\
    'LavenderBlush2' -> rgb(238, 224, 229),\
    'LavenderBlush3' -> rgb(205, 193, 197),\
    'LavenderBlush4' -> rgb(139, 131, 134),\
    'lawn green' -> rgb(124, 252, 0),\
    'LawnGreen' -> rgb(124, 252, 0),\
    'lemon chiffon' -> rgb(255, 250, 205),\
    'LemonChiffon' -> rgb(255, 250, 205),\
    'LemonChiffon1' -> rgb(255, 250, 205),\
    'LemonChiffon2' -> rgb(238, 233, 191),\
    'LemonChiffon3' -> rgb(205, 201, 165),\
    'LemonChiffon4' -> rgb(139, 137, 112),\
    'light blue' -> rgb(173, 216, 230),\
    'light coral' -> rgb(240, 128, 128),\
    'light cyan' -> rgb(224, 255, 255),\
    'light goldenrod' -> rgb(238, 221, 130),\
    'light goldenrod yellow' -> rgb(250, 250, 210),\
    'light gray' -> rgb(211, 211, 211),\
    'light grey' -> rgb(211, 211, 211),\
    'light pink' -> rgb(255, 182, 193),\
    'light salmon' -> rgb(255, 160, 122),\
    'light sea green' -> rgb(32, 178, 170),\
    'light sky blue' -> rgb(135, 206, 250),\
    'light slate blue' -> rgb(132, 112, 255),\
    'light slate gray' -> rgb(119, 136, 153),\
    'light slate grey' -> rgb(119, 136, 153),\
    'light steel blue' -> rgb(176, 196, 222),\
    'light yellow' -> rgb(255, 255, 224),\
    'LightBlue' -> rgb(173, 216, 230),\
    'LightBlue1' -> rgb(191, 239, 255),\
    'LightBlue2' -> rgb(178, 223, 238),\
    'LightBlue3' -> rgb(154, 192, 205),\
    'LightBlue4' -> rgb(104, 131, 139),\
    'LightCoral' -> rgb(240, 128, 128),\
    'LightCyan' -> rgb(224, 255, 255),\
    'LightCyan1' -> rgb(224, 255, 255),\
    'LightCyan2' -> rgb(209, 238, 238),\
    'LightCyan3' -> rgb(180, 205, 205),\
    'LightCyan4' -> rgb(122, 139, 139),\
    'LightGoldenrod' -> rgb(238, 221, 130),\
    'LightGoldenrod1' -> rgb(255, 236, 139),\
    'LightGoldenrod2' -> rgb(238, 220, 130),\
    'LightGoldenrod3' -> rgb(205, 190, 112),\
    'LightGoldenrod4' -> rgb(139, 129, 76),\
    'LightGoldenrodYellow' -> rgb(250, 250, 210),\
    'LightGray' -> rgb(211, 211, 211),\
    'LightGrey' -> rgb(211, 211, 211),\
    'LightPink' -> rgb(255, 182, 193),\
    'LightPink1' -> rgb(255, 174, 185),\
    'LightPink2' -> rgb(238, 162, 173),\
    'LightPink3' -> rgb(205, 140, 149),\
    'LightPink4' -> rgb(139, 95, 101),\
    'LightSalmon' -> rgb(255, 160, 122),\
    'LightSalmon1' -> rgb(255, 160, 122),\
    'LightSalmon2' -> rgb(238, 149, 114),\
    'LightSalmon3' -> rgb(205, 129, 98),\
    'LightSalmon4' -> rgb(139, 87, 66),\
    'LightSeaGreen' -> rgb(32, 178, 170),\
    'LightSkyBlue' -> rgb(135, 206, 250),\
    'LightSkyBlue1' -> rgb(176, 226, 255),\
    'LightSkyBlue2' -> rgb(164, 211, 238),\
    'LightSkyBlue3' -> rgb(141, 182, 205),\
    'LightSkyBlue4' -> rgb(96, 123, 139),\
    'LightSlateBlue' -> rgb(132, 112, 255),\
    'LightSlateGray' -> rgb(119, 136, 153),\
    'LightSlateGrey' -> rgb(119, 136, 153),\
    'LightSteelBlue' -> rgb(176, 196, 222),\
    'LightSteelBlue1' -> rgb(202, 225, 255),\
    'LightSteelBlue2' -> rgb(188, 210, 238),\
    'LightSteelBlue3' -> rgb(162, 181, 205),\
    'LightSteelBlue4' -> rgb(110, 123, 139),\
    'LightYellow' -> rgb(255, 255, 224),\
    'LightYellow1' -> rgb(255, 255, 224),\
    'LightYellow2' -> rgb(238, 238, 209),\
    'LightYellow3' -> rgb(205, 205, 180),\
    'LightYellow4' -> rgb(139, 139, 122),\
    'lime green' -> rgb(50, 205, 50),\
    'LimeGreen' -> rgb(50, 205, 50),\
    'linen' -> rgb(250, 240, 230),\
    'magenta' -> rgb(255, 0, 255),\
    'magenta1' -> rgb(255, 0, 255),\
    'magenta2' -> rgb(238, 0, 238),\
    'magenta3' -> rgb(205, 0, 205),\
    'magenta4' -> rgb(139, 0, 139),\
    'maroon' -> rgb(176, 48, 96),\
    'maroon1' -> rgb(255, 52, 179),\
    'maroon2' -> rgb(238, 48, 167),\
    'maroon3' -> rgb(205, 41, 144),\
    'maroon4' -> rgb(139, 28, 98),\
    'medium aquamarine' -> rgb(102, 205, 170),\
    'medium blue' -> rgb(0, 0, 205),\
    'medium orchid' -> rgb(186, 85, 211),\
    'medium purple' -> rgb(147, 112, 219),\
    'medium sea green' -> rgb(60, 179, 113),\
    'medium slate blue' -> rgb(123, 104, 238),\
    'medium spring green' -> rgb(0, 250, 154),\
    'medium turquoise' -> rgb(72, 209, 204),\
    'medium violet red' -> rgb(199, 21, 133),\
    'MediumAquamarine' -> rgb(102, 205, 170),\
    'MediumBlue' -> rgb(0, 0, 205),\
    'MediumOrchid' -> rgb(186, 85, 211),\
    'MediumOrchid1' -> rgb(224, 102, 255),\
    'MediumOrchid2' -> rgb(209, 95, 238),\
    'MediumOrchid3' -> rgb(180, 82, 205),\
    'MediumOrchid4' -> rgb(122, 55, 139),\
    'MediumPurple' -> rgb(147, 112, 219),\
    'MediumPurple1' -> rgb(171, 130, 255),\
    'MediumPurple2' -> rgb(159, 121, 238),\
    'MediumPurple3' -> rgb(137, 104, 205),\
    'MediumPurple4' -> rgb(93, 71, 139),\
    'MediumSeaGreen' -> rgb(60, 179, 113),\
    'MediumSlateBlue' -> rgb(123, 104, 238),\
    'MediumSpringGreen' -> rgb(0, 250, 154),\
    'MediumTurquoise' -> rgb(72, 209, 204),\
    'MediumVioletRed' -> rgb(199, 21, 133),\
    'midnight blue' -> rgb(25, 25, 112),\
    'MidnightBlue' -> rgb(25, 25, 112),\
    'mint cream' -> rgb(245, 255, 250),\
    'MintCream' -> rgb(245, 255, 250),\
    'misty rose' -> rgb(255, 228, 225),\
    'MistyRose' -> rgb(255, 228, 225),\
    'MistyRose1' -> rgb(255, 228, 225),\
    'MistyRose2' -> rgb(238, 213, 210),\
    'MistyRose3' -> rgb(205, 183, 181),\
    'MistyRose4' -> rgb(139, 125, 123),\
    'moccasin' -> rgb(255, 228, 181),\
    'navajo white' -> rgb(255, 222, 173),\
    'NavajoWhite' -> rgb(255, 222, 173),\
    'NavajoWhite1' -> rgb(255, 222, 173),\
    'NavajoWhite2' -> rgb(238, 207, 161),\
    'NavajoWhite3' -> rgb(205, 179, 139),\
    'NavajoWhite4' -> rgb(139, 121, 94),\
    'navy' -> rgb(0, 0, 128),\
    'navy blue' -> rgb(0, 0, 128),\
    'NavyBlue' -> rgb(0, 0, 128),\
    'old lace' -> rgb(253, 245, 230),\
    'OldLace' -> rgb(253, 245, 230),\
    'olive drab' -> rgb(107, 142, 35),\
    'OliveDrab' -> rgb(107, 142, 35),\
    'OliveDrab1' -> rgb(192, 255, 62),\
    'OliveDrab2' -> rgb(179, 238, 58),\
    'OliveDrab3' -> rgb(154, 205, 50),\
    'OliveDrab4' -> rgb(105, 139, 34),\
    'orange' -> rgb(255, 165, 0),\
    'orange red' -> rgb(255, 69, 0),\
    'orange1' -> rgb(255, 165, 0),\
    'orange2' -> rgb(238, 154, 0),\
    'orange3' -> rgb(205, 133, 0),\
    'orange4' -> rgb(139, 90, 0),\
    'OrangeRed' -> rgb(255, 69, 0),\
    'OrangeRed1' -> rgb(255, 69, 0),\
    'OrangeRed2' -> rgb(238, 64, 0),\
    'OrangeRed3' -> rgb(205, 55, 0),\
    'OrangeRed4' -> rgb(139, 37, 0),\
    'orchid' -> rgb(218, 112, 214),\
    'orchid1' -> rgb(255, 131, 250),\
    'orchid2' -> rgb(238, 122, 233),\
    'orchid3' -> rgb(205, 105, 201),\
    'orchid4' -> rgb(139, 71, 137),\
    'pale goldenrod' -> rgb(238, 232, 170),\
    'pale green' -> rgb(152, 251, 152),\
    'pale turquoise' -> rgb(175, 238, 238),\
    'pale violet red' -> rgb(219, 112, 147),\
    'PaleGoldenrod' -> rgb(238, 232, 170),\
    'PaleGreen' -> rgb(152, 251, 152),\
    'PaleGreen1' -> rgb(154, 255, 154),\
    'PaleGreen2' -> rgb(144, 238, 144),\
    'PaleGreen3' -> rgb(124, 205, 124),\
    'PaleGreen4' -> rgb(84, 139, 84),\
    'PaleTurquoise' -> rgb(175, 238, 238),\
    'PaleTurquoise1' -> rgb(187, 255, 255),\
    'PaleTurquoise2' -> rgb(174, 238, 238),\
    'PaleTurquoise3' -> rgb(150, 205, 205),\
    'PaleTurquoise4' -> rgb(102, 139, 139),\
    'PaleVioletRed' -> rgb(219, 112, 147),\
    'PaleVioletRed1' -> rgb(255, 130, 171),\
    'PaleVioletRed2' -> rgb(238, 121, 159),\
    'PaleVioletRed3' -> rgb(205, 104, 137),\
    'PaleVioletRed4' -> rgb(139, 71, 93),\
    'papaya whip' -> rgb(255, 239, 213),\
    'PapayaWhip' -> rgb(255, 239, 213),\
    'peach puff' -> rgb(255, 218, 185),\
    'PeachPuff' -> rgb(255, 218, 185),\
    'PeachPuff1' -> rgb(255, 218, 185),\
    'PeachPuff2' -> rgb(238, 203, 173),\
    'PeachPuff3' -> rgb(205, 175, 149),\
    'PeachPuff4' -> rgb(139, 119, 101),\
    'peru' -> rgb(205, 133, 63),\
    'pink' -> rgb(255, 192, 203),\
    'pink1' -> rgb(255, 181, 197),\
    'pink2' -> rgb(238, 169, 184),\
    'pink3' -> rgb(205, 145, 158),\
    'pink4' -> rgb(139, 99, 108),\
    'plum' -> rgb(221, 160, 221),\
    'plum1' -> rgb(255, 187, 255),\
    'plum2' -> rgb(238, 174, 238),\
    'plum3' -> rgb(205, 150, 205),\
    'plum4' -> rgb(139, 102, 139),\
    'powder blue' -> rgb(176, 224, 230),\
    'PowderBlue' -> rgb(176, 224, 230),\
    'purple' -> rgb(160, 32, 240),\
    'purple1' -> rgb(155, 48, 255),\
    'purple2' -> rgb(145, 44, 238),\
    'purple3' -> rgb(125, 38, 205),\
    'purple4' -> rgb(85, 26, 139),\
    'red' -> rgb(255, 0, 0),\
    'red1' -> rgb(255, 0, 0),\
    'red2' -> rgb(238, 0, 0),\
    'red3' -> rgb(205, 0, 0),\
    'red4' -> rgb(139, 0, 0),\
    'rosy brown' -> rgb(188, 143, 143),\
    'RosyBrown' -> rgb(188, 143, 143),\
    'RosyBrown1' -> rgb(255, 193, 193),\
    'RosyBrown2' -> rgb(238, 180, 180),\
    'RosyBrown3' -> rgb(205, 155, 155),\
    'RosyBrown4' -> rgb(139, 105, 105),\
    'royal blue' -> rgb(65, 105, 225),\
    'RoyalBlue' -> rgb(65, 105, 225),\
    'RoyalBlue1' -> rgb(72, 118, 255),\
    'RoyalBlue2' -> rgb(67, 110, 238),\
    'RoyalBlue3' -> rgb(58, 95, 205),\
    'RoyalBlue4' -> rgb(39, 64, 139),\
    'saddle brown' -> rgb(139, 69, 19),\
    'SaddleBrown' -> rgb(139, 69, 19),\
    'salmon' -> rgb(250, 128, 114),\
    'salmon1' -> rgb(255, 140, 105),\
    'salmon2' -> rgb(238, 130, 98),\
    'salmon3' -> rgb(205, 112, 84),\
    'salmon4' -> rgb(139, 76, 57),\
    'sandy brown' -> rgb(244, 164, 96),\
    'SandyBrown' -> rgb(244, 164, 96),\
    'sea green' -> rgb(46, 139, 87),\
    'SeaGreen' -> rgb(46, 139, 87),\
    'SeaGreen1' -> rgb(84, 255, 159),\
    'SeaGreen2' -> rgb(78, 238, 148),\
    'SeaGreen3' -> rgb(67, 205, 128),\
    'SeaGreen4' -> rgb(46, 139, 87),\
    'seashell' -> rgb(255, 245, 238),\
    'seashell1' -> rgb(255, 245, 238),\
    'seashell2' -> rgb(238, 229, 222),\
    'seashell3' -> rgb(205, 197, 191),\
    'seashell4' -> rgb(139, 134, 130),\
    'sienna' -> rgb(160, 82, 45),\
    'sienna1' -> rgb(255, 130, 71),\
    'sienna2' -> rgb(238, 121, 66),\
    'sienna3' -> rgb(205, 104, 57),\
    'sienna4' -> rgb(139, 71, 38),\
    'sky blue' -> rgb(135, 206, 235),\
    'SkyBlue' -> rgb(135, 206, 235),\
    'SkyBlue1' -> rgb(135, 206, 255),\
    'SkyBlue2' -> rgb(126, 192, 238),\
    'SkyBlue3' -> rgb(108, 166, 205),\
    'SkyBlue4' -> rgb(74, 112, 139),\
    'slate blue' -> rgb(106, 90, 205),\
    'slate gray' -> rgb(112, 128, 144),\
    'slate grey' -> rgb(112, 128, 144),\
    'SlateBlue' -> rgb(106, 90, 205),\
    'SlateBlue1' -> rgb(131, 111, 255),\
    'SlateBlue2' -> rgb(122, 103, 238),\
    'SlateBlue3' -> rgb(105, 89, 205),\
    'SlateBlue4' -> rgb(71, 60, 139),\
    'SlateGray' -> rgb(112, 128, 144),\
    'SlateGray1' -> rgb(198, 226, 255),\
    'SlateGray2' -> rgb(185, 211, 238),\
    'SlateGray3' -> rgb(159, 182, 205),\
    'SlateGray4' -> rgb(108, 123, 139),\
    'SlateGrey' -> rgb(112, 128, 144),\
    'snow' -> rgb(255, 250, 250),\
    'snow1' -> rgb(255, 250, 250),\
    'snow2' -> rgb(238, 233, 233),\
    'snow3' -> rgb(205, 201, 201),\
    'snow4' -> rgb(139, 137, 137),\
    'spring green' -> rgb(0, 255, 127),\
    'SpringGreen' -> rgb(0, 255, 127),\
    'SpringGreen1' -> rgb(0, 255, 127),\
    'SpringGreen2' -> rgb(0, 238, 118),\
    'SpringGreen3' -> rgb(0, 205, 102),\
    'SpringGreen4' -> rgb(0, 139, 69),\
    'steel blue' -> rgb(70, 130, 180),\
    'SteelBlue' -> rgb(70, 130, 180),\
    'SteelBlue1' -> rgb(99, 184, 255),\
    'SteelBlue2' -> rgb(92, 172, 238),\
    'SteelBlue3' -> rgb(79, 148, 205),\
    'SteelBlue4' -> rgb(54, 100, 139),\
    'tan' -> rgb(210, 180, 140),\
    'tan1' -> rgb(255, 165, 79),\
    'tan2' -> rgb(238, 154, 73),\
    'tan3' -> rgb(205, 133, 63),\
    'tan4' -> rgb(139, 90, 43),\
    'thistle' -> rgb(216, 191, 216),\
    'thistle1' -> rgb(255, 225, 255),\
    'thistle2' -> rgb(238, 210, 238),\
    'thistle3' -> rgb(205, 181, 205),\
    'thistle4' -> rgb(139, 123, 139),\
    'tomato' -> rgb(255, 99, 71),\
    'tomato1' -> rgb(255, 99, 71),\
    'tomato2' -> rgb(238, 92, 66),\
    'tomato3' -> rgb(205, 79, 57),\
    'tomato4' -> rgb(139, 54, 38),\
    'turquoise' -> rgb(64, 224, 208),\
    'turquoise1' -> rgb(0, 245, 255),\
    'turquoise2' -> rgb(0, 229, 238),\
    'turquoise3' -> rgb(0, 197, 205),\
    'turquoise4' -> rgb(0, 134, 139),\
    'violet' -> rgb(238, 130, 238),\
    'violet red' -> rgb(208, 32, 144),\
    'VioletRed' -> rgb(208, 32, 144),\
    'VioletRed1' -> rgb(255, 62, 150),\
    'VioletRed2' -> rgb(238, 58, 140),\
    'VioletRed3' -> rgb(205, 50, 120),\
    'VioletRed4' -> rgb(139, 34, 82),\
    'wheat' -> rgb(245, 222, 179),\
    'wheat1' -> rgb(255, 231, 186),\
    'wheat2' -> rgb(238, 216, 174),\
    'wheat3' -> rgb(205, 186, 150),\
    'wheat4' -> rgb(139, 126, 102),\
    'white' -> rgb(255, 255, 255),\
    'white smoke' -> rgb(245, 245, 245),\
    'WhiteSmoke' -> rgb(245, 245, 245),\
    'yellow' -> rgb(255, 255, 0),\
    'yellow green' -> rgb(154, 205, 50),\
    'yellow1' -> rgb(255, 255, 0),\
    'yellow2' -> rgb(238, 238, 0),\
    'yellow3' -> rgb(205, 205, 0),\
    'yellow4' -> rgb(139, 139, 0),\
    'YellowGreen' -> rgb(154, 205, 50)\
];\
\
*/\cf0 \
}