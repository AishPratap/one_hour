#include "opencv2/highgui.hpp"
#include "opencv/cv.h"

#define ESC_KEY 27

int			g_slider_position	= 0;
CvCapture*	g_capture			= NULL;

void onTrackBarSlide(int pos) {
	cvSetCaptureProperty(g_capture, CV_CAP_PROP_POS_FRAMES, pos);	
}

int main(int argc, char** argv) {
	cvNamedWindow("Playback", CV_WINDOW_AUTOSIZE);
	g_capture = cvCreateFileCapture(argv[1]);

	int frames = (int) cvGetCaptureProperty(
			g_capture,
			CV_CAP_PROP_FRAME_COUNT
	);

	if (frames != 0) {
		cvCreateTrackbar(
				"Slider",
				"Playback",
				&g_slider_position,
				frames,
				onTrackBarSlide
		);
	}

	IplImage*	frame	= NULL;
	char		c		= 0;

	while(1) {
		frame = cvQueryFrame(g_capture);
		if (!frame) {
			break;
		}
		cvShowImage("Playback", frame);
		cvSetTrackbarPos("Slider", "Playback", ++g_slider_position);
		c = cvWaitKey(33);
		if (c == ESC_KEY) {
			break;
		}
	}

	cvReleaseCapture(&g_capture);
	cvDestroyWindow("Playback");
}
