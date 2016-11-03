def sum(num):
	result = 0
	for i in range(1, num + 1):
		for j in range(i + 1, num + 1):
			result += (i * j);
	return result * 2

print sum(100)