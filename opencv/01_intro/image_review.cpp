#include "opencv2/highgui.hpp"

int main(int argc, char** argv) {
	cvNamedWindow("ImageReview", CV_WINDOW_AUTOSIZE);
	IplImage* image = cvLoadImage(argv[1]);

	cvShowImage("ImageReview", image);
	cvWaitKey(0);
	
	cvReleaseImage(&image);
	cvDestroyWindow("ImageReview");
}
