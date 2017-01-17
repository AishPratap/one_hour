#include <bits/stdc++.h>

using namespace std;

class BinaryCode {
	public:
		vector<string> decode(string msg) {
			vector<string> ret;
			ret.reserve(2);
			
			ret.push_back(decodeMsg(msg, 0));
			ret.push_back(decodeMsg(msg, 1));
			
			return ret;
		}
		string decodeMsg(string msg, int init) {
			int vals[msg.size()];
			string ret = to_string(init);
			vals[0] = init;
			for (int i = 1; i < msg.size(); ++i) {
				int preVal = vals[i - 1];
				int prePreVal = i - 2 >= 0 ? vals[i - 2] : 0;
				int curMsgVal = msg[i] - '0';
				vals[i] = curMsgVal - prePreVal - preVal;
				ret += to_string(vals[i]);
			}
			
			return ret;
		}
};
