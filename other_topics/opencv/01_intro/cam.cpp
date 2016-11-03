#include "opencv2/highgui.hpp"
#include "opencv/cv.h"

int main(int argc, char** argv) {
	CvCapture* capture = cvCreateCameraCapture(0);	
	assert(capture != NULL);
	cvNamedWindow("Camera", CV_WINDOW_AUTOSIZE);

	IplImage* frame;
	char c;
	while (1) {
		frame = cvQueryFrame(capture);
		if (!frame) {
			break;
		}

		IplImage* smoothed = cvCreateImage(cvGetSize(frame), IPL_DEPTH_8U, 3);
		cvSmooth(frame, smoothed, CV_GAUSSIAN, 3, 3);
		cvShowImage("Camera", smoothed);
		cvReleaseImage(&smoothed);

		c = cvWaitKey(10);
		if (c == 'q') {
			break;
		}
	}

	cvDestroyWindow("Camera");
	cvReleaseCapture(&capture);
}
