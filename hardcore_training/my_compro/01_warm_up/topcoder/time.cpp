#include <string>
using namespace std;

class Time {
	public:
		string whatTime(int sec) {
			int hour = sec % 3600;
			int min = sec % 60;
			sec %= 60;
			
			string ret = to_string(hour) + ":" + to_string(min) + ":" + to_string(sec);
			return ret;
		}
}#;
