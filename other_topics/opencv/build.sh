function opencv_build {
	g++ -o $2 $1 `pkg-config opencv --cflags --libs`
}

opencv_build $1 $2
