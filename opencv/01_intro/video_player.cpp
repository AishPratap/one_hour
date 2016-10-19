#include "opencv2/highgui.hpp"

int main(int argc, char** argv) {
	cvNamedWindow("Playback", CV_WINDOW_AUTOSIZE);
	CvCapture* video = cvCreateFileCapture(argv[1]);

	IplImage* frame;
	char c;
	while(1) {
		frame = cvQueryFrame(video);
		if (!frame) {
			break;
		}
		cvShowImage("Playback", frame);
		c = cvWaitKey(30);
		if (c == 27) {
			break;
		}
	}

	cvReleaseCapture(&video);
	cvDestroyWindow("Playback");
}
